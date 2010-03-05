package de.toolforge.googlechartwrapper;


import java.awt.Dimension;
import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import de.toolforge.googlechartwrapper.util.AppendableFeature;
import de.toolforge.googlechartwrapper.util.ArrayUtils;
import de.toolforge.googlechartwrapper.util.IExtendedFeatureAppender;

/**
 * The AbstractChart is the basechart for most charts and supports some basic
 * features as the dimension. Additionally the url generating part is done
 * by this class by using a reflection mechanism in {@link #collectUrlElements()} and 
 * {@link #collectUrlElements(List)}. Each implementing subclass shall use
 * {@link IExtendedFeatureAppender} to collect the chart parameters. These appenders 
 * are gathered by the reflection mechanism by default and added to the url, separated
 * by the default {@value #AMPERSAND_SEPARATOR}.
 * 
 * @author steffan
 * @author martin
 */
public abstract class AbstractChart implements IChart {

	/**
	 * Default Chart API's location of the google service.
	 */
	public static final String GOOGLE_API = "http://chart.apis.google.com/chart?";
	
	/**
	 * default separator for parameters.
	 */
	public static final String AMPERSAND_SEPARATOR = "&";
	/**
	 * queue with url elements which are added to the url string later on
	 */
	protected Queue<String> urlElements = new LinkedList<String>(); 
	//TODO martin: remove this instance variable and move into the methods
	
	/**
	 * height of the chart. If no height is specified the
	 * value must equal {@link Integer#MIN_VALUE}
	 */
	protected int height = Integer.MIN_VALUE;
	
	/**
	 * width of the chart. If no width is specified the
	 * value must equal {@link Integer#MIN_VALUE}
	 */
	protected int width = Integer.MIN_VALUE;
	
	/**
	 * Generates an AbstractChart with the given chartDimension.
	 * @param chartDimension size of the chart in pixel
	 * 
	 * @throws IllegalArgumentException if chartDimension is {@code null}
	 * @throws IllegalArgumentException if height &gt; 1000 and/or width &gt; 1000
	 * @throws IllegalArgumentException if area (height*width) is &gt; 300000
	 */
	public AbstractChart(Dimension chartDimension) {
		
		if(chartDimension == null)
			throw new IllegalArgumentException("chartDimension can not be null");
		if(chartDimension.getHeight() > 1000 || chartDimension.getWidth() > 1000)
			throw new IllegalArgumentException("height and/or width can not be > 1000");
		if((chartDimension.getHeight()*chartDimension.getWidth()) > 300000)
			throw new IllegalArgumentException("the largest possible area can not be > 300000");
		this.height = chartDimension.height;
		this.width = chartDimension.width;
	}
	
	/**
	 * Generates an AbstractChart with the given height.
	 * @param height height of the chart in pixels
	 * @throws IllegalArgumentException if height &gt; 1000 or height &lt;= 0
	 */
	public AbstractChart(int height){
		if(height > 1000){
			throw new IllegalArgumentException("height can not be > 1000");
		}
		if (height <= 0){
			throw new IllegalArgumentException("height can not be <= 0");
		}
		this.height = height;
	}
	
	/**
	 * Generates an AbstractChart with an chart size
	 * determined by the google api. Some charts may not
	 * work without an explicit height. Thus the developer
	 * may use this constructor with caution.
	 */
	public AbstractChart(){
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see googlechartwrapper.Chart#getUrl()
	 */
	public String getUrl(){
		collectUrlElements(getAllAppenders());
		return generateUrlString(GOOGLE_API);
	}
	
	/**
	 * Returns the generated chart url with the given Chart API's location. 
	 * The base URL is simply added ahead of the generated chart parameters
	 * by the {@link IExtendedFeatureAppender}. 
	 * <p>The following format is used:
	 * &lt;base URL&gt;&lt;other url parameters&gt;. <br>
	 * For example: 
	 * http://chart.apis.google.com/chart?cht=s&chs=300x300&chd=e:DICW|BkHC|DIEs <br>
	 * where http://chart.apis.google.com/chart? is the apiLocation.
	 * @param apiLocation the Chart API's location 
	 * @return generated chart string
	 * @see #GOOGLE_API
	 */
	public String getUrl (String apiLocation){
		collectUrlElements(getAllAppenders());
		return generateUrlString(apiLocation);
	}
	
	/**
	 * Returns the height of the chart. If no height is specified,
	 * the returned value equals {@link Integer#MIN_VALUE}. If no
	 * height is specified the chart api of google may calculate the height.
	 * @return height of the chart
	 */
	protected int getHeight() {
		return height;
	}

	/**
	 * Returns the width of the chart. If no width is specified,
	 * the returned value equals {@link Integer#MIN_VALUE}. If that is the case
	 * the chart api of google may calculate the width.
	 * @return width of the chart
	 */
	protected int getWidth() {
		return width;
	}
	
	/**
	 * Returns the chart type which is appended to the URL. 
	 * @return representing string for a chart type  
	 */
	protected abstract String getUrlChartType();

	/**
	 * Returns the chart type of the chart.
	 * @return chart type of the chart.
	 */
	protected abstract ChartType getChartType();
	
	/**
	 * Returns all appenders from the extending class, but not inherited fields. It
	 * requires that these appenders implement {@link IExtendedFeatureAppender} and
	 * the fields are public or protected. If subclass fields are necessary this method
	 * must be overwritten. 
	 * 
	 * It's recommended that this method is overwritten as it uses reflection which may
	 * not be safe in all environments.
	 * @return list of all appenders
	 */ 
	protected List<IExtendedFeatureAppender> getAllAppenders(){
		List<IExtendedFeatureAppender> allExtendedFeatureAppenders = 
			new ArrayList<IExtendedFeatureAppender>(5); 
		
		List<Field> fields = new ArrayList<Field>(); //every field (appenders)
		fields.addAll(Arrays.asList(this.getClass().getDeclaredFields()));
		Class<?> current = this.getClass().getSuperclass(); //to deal with inheritance
		while (current.getSuperclass()!= null){
			fields.addAll(Arrays.asList(current.getDeclaredFields()));
			current = current.getSuperclass();
		}
		//Field[] fields = this.getClass().getDeclaredFields(); //alle Felder
		
		for (Field f: fields){
			if (ArrayUtils.linearSearch(f.getType().getInterfaces(), 
					IExtendedFeatureAppender.class)>=0){
				//if field implements the IExtendedFeatureAppender - so e.g. a 
				//genericAppender
				try { 
					
					allExtendedFeatureAppenders.add((
							IExtendedFeatureAppender)f.get(this));
					//der Liste hinzufügen, und zwar das feld aus der aktuellen instanz					
				} 
				catch (IllegalArgumentException e) {
					throw new RuntimeException(e); //todo mva: think about this!
				} 
				catch (IllegalAccessException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return allExtendedFeatureAppenders;
	}

	/**
	 * Collects all base url elements: chart type and chart dimension.
	 */
	protected void collectUrlElements() {
		urlElements.clear();
		urlElements.offer(MessageFormat.format("cht={0}", this
				.getUrlChartType()));
		if (height != Integer.MIN_VALUE && width == Integer.MIN_VALUE){
			//only height specified
			urlElements.offer(MessageFormat.format("chs={0}",
					height));
		}
		else if (height != Integer.MIN_VALUE && width != Integer.MIN_VALUE){
			//height and width specified
			urlElements.offer(MessageFormat.format("chs={0}x{1}",
					width, height));
		}
		//implicit else: no dimension specified (chart size calculated by api)
		
				
	}

	/**
	 * <p>The method collects all {@link AppendableFeature}s of the implementing classes. 
	 * These features are grouped according to their feature prefix returned by 
	 * {@link AppendableFeature#getPrefix()}. </p>
	 * 
	 * <p>After sorting the grouped features (prefix based) all features are appended to 
	 * the  final url string. </p>
	 * 
	 * <p>Example: if 2 {@link FeatureAppender} return a feature with the same prefix 
	 * each these two feature strings are appended together to the string. Format will 
	 * be &ltprefix&gt=&ltstring1&gt&ltstring2&gt...&ltstringn&gt</p>
	 * @param appenders List of all {@link IExtendedFeatureAppender} in the implementing 
	 * class which features should be appended to the chart url
	 */
	protected void collectUrlElements(List<IExtendedFeatureAppender> appenders) {
		/*
		 * Die Methode sammelt alle appendable Features der einzelnen FeatureAppender der
		 * implementierenden Subklassen. Diese werden dann nach dem jeweiligen feature 
		 * prefix groupiert und letztendlich nach einer Sortierung nach prefix der 
		 * URL angehangen.
		 * 
		 * Wenn also 2 FeatureAppender ein Feature mit dem selben Prefix enthalten, 
		 * werden diese beiden Werte in der URL zusammen appended.
		 */
		collectUrlElements(); //alle Grundelemente laden
		//TODO martin: move base elements collecting this to another method
		
		Map<String, FeatureAppender> m = 
			new HashMap<String, FeatureAppender>();
			//new HashMap<String, FeatureAppender<IExtendedFeatureAppender>>();
		//map fuer key=featureprefixstring (z.b. chm) 
		//value=Appender für alle von diesem Typen
		
		for (IExtendedFeatureAppender ap : appenders) {
			List<AppendableFeature> ft = ap.getAppendableFeatures(appenders);
			for (AppendableFeature feature : ft){
				if (m.containsKey(feature.getPrefix())){ 
					//if a feature with the same prefix existed before, add the
					//new feature to this container for Features with the same prefix
					m.get(feature.getPrefix()).add(feature);
				}
				else { 
					//ansonsten muss neuer appender für diesen feature typ angelegt werden
					//if none existed, create a new container for Features 
					//with the same prefix
					FeatureAppender fa = new FeatureAppender(
							feature.getPrefix());
					fa.add(feature);
					m.put(fa.getPrefix(),fa);
				}
			}			
		}
		
		List<FeatureAppender> values = new ArrayList<FeatureAppender>(m.values());
		
		Collections.sort(values, new Comparator<FeatureAppender>(){
			public int compare(FeatureAppender arg0, 
					FeatureAppender arg1) {
				return arg0.prefix.compareTo(arg1.prefix);
			}			
		}); 
		/*sorting the features to guarantee a url string which is equal on each system
		 (and not based on the implementation of reflection mechanisms)
		  e.g. for unittests */
		
		for (FeatureAppender ap : values) {			
			urlElements.offer(ap.getUrlString());
		}
	}

	/**
	 * Generates the final url string based on the elements in the {@link #urlElements}
	 * queue. In front of the url string a base url is appended. Each unique url element
	 * of the queue is separated by the default {@link #AMPERSAND_SEPARATOR}.
	 * 
	 * @param baseUrl string which is in front of the url elements
	 * @return final url containing the base url and each feature string
	 */
	protected String generateUrlString(String baseUrl) {
		StringBuilder url = new StringBuilder();
		url.append(baseUrl); //Standardpfad zur API
		url.append(urlElements.poll());//charttype anhängen

		while (urlElements.size() > 0) {
			//solange noch etwas drin, an die url mit dem Trennzeichen & anhängen
			String urlElem = urlElements.poll();
			if (urlElem.length()>0){
				url.append(AMPERSAND_SEPARATOR + urlElem);
			}			 
		}
		return url.toString();
	}

	/**
	 * Container for {@link AppendableFeature}s with the same prefix. 
	 * The AppendableFeature url strings are appendded to the final
	 * url string (separator between each pair).
	 * @author martin
	 *
	 */
	private static class FeatureAppender{

		/**
		 * list of elements/features
		 */
		protected List<AppendableFeature> list;
		/**
		 * type of the parameter: &lt;type&gt;=&lt;parameter data&gt;, e.g
		 * chs=250x100
		 */
		protected String prefix;
		/**
		 * separator for each single feature, e.g. the pipe symbol or a comma
		 */
		protected String separator;
		
		public FeatureAppender(String stm) {
			this(stm,"|");
		}
		
		public FeatureAppender (String m, String separator){
			if (separator == null){
				throw new IllegalArgumentException("sep cannot be null");
			}
			list = new ArrayList<AppendableFeature>();
			prefix = m;
			this.separator = separator;
		}
		
		public String getPrefix (){
			return prefix;
		}
		
		/**
		 * <p>Returns a string containing each data string of a feature appender. The
		 * individual data strings are separated by the {@link #separator} of the
		 * container class.</p>
		 * <p>If the features did not contain any data an empty string is returned. If
		 * the prefix was not a string with length 0 the returned string contains 
		 * the prefix with an = in front of the collected data strings. 
		 * If the prefix equals "" (empty string with length 0) the = is ommited.</p>
		 * @return <code>if</code> all data strings were empty: 
		 * 		empty string with length 0 ("");
		 * <br><code>if</code> prefix equals "": 
		 * 		string containing all data strings sep. by the separator;
		 * <br><code>otherwise</code> string with prefix and = in front of all data strings 
		 * 		separated by the separator
		 */
		public String getUrlString (){
			 List<AppendableFeature> features = list;
			 StringBuilder bf = new StringBuilder();
			 for (AppendableFeature f:features){
				 bf.append(f.getData());
				 bf.append(separator);
			 }
			 if (bf.length() > 0){
				 if (prefix.equals("")){
					 return  bf.substring(0,bf.length()-1);
				 }
				 else {
					 return prefix +"="+ bf.substring(0,bf.length()-1);
				 }
			 }
			return "";
		}
		
		public void add (AppendableFeature m){
			list.add(m);
		}
	}

}
