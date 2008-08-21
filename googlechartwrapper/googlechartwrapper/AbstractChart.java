package googlechartwrapper;

import googlechartwrapper.coder.Encoder;
import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.util.ArrayUtils;
import googlechartwrapper.util.GenericAppender;
import googlechartwrapper.util.IExtendedFeatureAppender;
import googlechartwrapper.util.IFeatureAppender;

import java.awt.Color;
import java.awt.Dimension;
import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * @author steffan, martin
 * 
 * base class for every chart
 * 
 */
abstract class AbstractChart implements Chart {

	private static final String googleAPI = "http://chart.apis.google.com/chart?";
	//TODO mva: googleAPI string austauschbar machen?
	protected Queue<String> urlElements = new LinkedList<String>();
	protected String values;
	private IEncoder encoder = new Encoder();
	protected Dimension chartDimension;
	// private String newLine = System.getProperty("line.separator");
	protected Color[] dataColors;

	public AbstractChart(Dimension chartDimension) {
		this.chartDimension = chartDimension;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see googlechartwrapper.Chart#setValues(int[])
	 */
	public void setValues(int[] values) {
		this.values = this.encoder.encode(values);
	}

	/**
	 * 
	 * @param values
	 */
	public void setValues(Collection<int[]> values) {
		this.values = this.encoder.encodeIntegerCollection(values);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see googlechartwrapper.Chart#setValues(float[])
	 */
	public void setValues(float[] values) {

		this.values = this.encoder.encode(values);
	}

	public void setEncoder(IEncoder newEncoder) {

		this.encoder = newEncoder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see googlechartwrapper.Chart#getEncoder()
	 */
	public IEncoder getEncoder() {
		return this.encoder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see googlechartwrapper.Chart#getUrl()
	 */
	public String getUrl(){
		collectUrlElements(getAllAppenders());
		return generateUrlString();
	}

	/*
	 * { collectUrlElements();
	 * 
	 * return generateUrlString(); }
	 */

	protected abstract String getUrlChartType();

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
		
		Field[] fields = this.getClass().getDeclaredFields(); //alle Felder
		for (Field f: fields){
			if (ArrayUtils.linearSearch(f.getType().getInterfaces(), IExtendedFeatureAppender.class)>=0){
				//if field implements the IExtendedFeatureAppender - so e.g. a genericAppender
				try { 
					
					allExtendedFeatureAppenders.add((IExtendedFeatureAppender)f.get(this));
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

	protected void collectUrlElements() {
		urlElements.clear();
		urlElements.offer(MessageFormat.format("cht={0}", this
				.getUrlChartType()));
		urlElements.offer(MessageFormat.format("chs={0}x{1}",
				this.chartDimension.width, this.chartDimension.height));
		if (values != null) {
			urlElements.offer(this.values);
		}
		// converts the color objects into an hex equivalent for google
		if (dataColors != null && dataColors.length > 0) {
			StringBuffer bf = new StringBuffer(dataColors.length * 8 + 5);
			bf.append("chco=");
			for (Color c : dataColors) {
				bf.append(Integer.toHexString(c.getRGB()).substring(2, 8));
				bf.append(",");
			}
			urlElements.offer(bf.toString().substring(0,
					bf.toString().length() - 1));
		}
	}

	protected void collectUrlElements(List<IExtendedFeatureAppender> appenders) {
		collectUrlElements(); //alle Grundelemente laden
		Map<String, FeatureAppender<IExtendedFeatureAppender>> m = 
			new HashMap<String, FeatureAppender<IExtendedFeatureAppender>>();
		//map fuer key=featureprefixstring (z.b. chm) 
		//value=Appender für alle von diesem Typen
		
		for (IExtendedFeatureAppender ap : appenders) {
			if (m.containsKey(ap.getFeaturePrefix())) { //wenn schon appender vorhanden
				m.get(ap.getFeaturePrefix()).add(ap); //einfach hinzufügen
			} else { 
				//ansonsten muss neuer appender für diesen feature typ angelegt werden
				FeatureAppender<IExtendedFeatureAppender> fa = new FeatureAppender<IExtendedFeatureAppender>(
						ap.getFeaturePrefix());
				fa.add(ap);
				m.put(ap.getFeaturePrefix(), fa);
			}
		}
		
		List<FeatureAppender<IExtendedFeatureAppender>> values = 
			new ArrayList<FeatureAppender<IExtendedFeatureAppender>>(m.values());
		for (FeatureAppender<IExtendedFeatureAppender> ap : values) {
			//alle appender durchlaufen und der url hinzufügen
			urlElements.offer(ap.getAppendableString(values));
		}
		// for (IExtendedFeatureAppender ap : appenders){
		// urlElements.offer(ap.getAppendableString(appenders));
	}

	protected String generateUrlString() {
		StringBuilder url = new StringBuilder();
		url.append(googleAPI); //Standardpfad zur API
		url.append(urlElements.poll());//charttype anhängen

		while (urlElements.size() > 0) {
			//solange noch etwas drin, an die url mit dem Trennzeichen & anhängen
			url.append("&" + urlElements.poll()); //TODO mva: & auslagern
		}
		return url.toString();
	}

	public void setDataColors(Color[] dataColors) {
		this.dataColors = dataColors;
	}

	private class FeatureAppender<T extends IExtendedFeatureAppender> extends
			GenericAppender<T> {

		public FeatureAppender(String stm) {
			super(stm);
		}

		@Override
		public String getAppendableString(List<? extends IFeatureAppender> otherAppenders) {
			return getFeaturePrefix() + "="
					+ super.getAppendableString(otherAppenders);
		}
	}
}
