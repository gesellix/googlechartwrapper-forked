package googlechartwrapper;

import googlechartwrapper.coder.Encoder;
import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.util.ArrayUtils;
import googlechartwrapper.util.GenericAppender;
import googlechartwrapper.util.IExtendedFeatureAppender;

import java.awt.Color;
import java.awt.Dimension;
import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
	
	protected List<IExtendedFeatureAppender> getAllAppenders(){
		List<IExtendedFeatureAppender> allExtendedFeatureAppenders = 
			new ArrayList<IExtendedFeatureAppender>(5); 
		
		Field[] fields = this.getClass().getDeclaredFields(); 
		for (Field f: fields){
			if (ArrayUtils.linearSearch(f.getType().getInterfaces(), IExtendedFeatureAppender.class)>=0){
				try {
					allExtendedFeatureAppenders.add((IExtendedFeatureAppender)f.get(this));
										
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
		collectUrlElements();
		Map<String, FeatureAppender<IExtendedFeatureAppender>> m = new HashMap<String, FeatureAppender<IExtendedFeatureAppender>>();

		for (IExtendedFeatureAppender ap : appenders) {
			if (m.containsKey(ap.getFeaturePrefix())) {
				m.get(ap.getFeaturePrefix()).add(ap);
			} else {
				FeatureAppender<IExtendedFeatureAppender> fa = new FeatureAppender<IExtendedFeatureAppender>(
						ap.getFeaturePrefix());
				fa.add(ap);
				m.put(ap.getFeaturePrefix(), fa);
			}
		}
		
		List<FeatureAppender<IExtendedFeatureAppender>> values = new ArrayList<FeatureAppender<IExtendedFeatureAppender>>(
				m.values());
		for (FeatureAppender<IExtendedFeatureAppender> ap : values) {
			urlElements.offer(ap.getAppendableString(values));
		}
		// for (IExtendedFeatureAppender ap : appenders){
		// urlElements.offer(ap.getAppendableString(appenders));
	}

	protected String generateUrlString() {
		StringBuilder url = new StringBuilder();
		url.append(googleAPI);
		url.append(urlElements.poll());

		while (urlElements.size() > 0) {
			url.append("&" + urlElements.poll());
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
		public String getAppendableString(List otherAppenders) {
			return getFeaturePrefix() + "="
					+ super.getAppendableString(otherAppenders);
		}
	}
}
