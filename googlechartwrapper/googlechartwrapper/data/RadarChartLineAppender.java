package googlechartwrapper.data;

import googlechartwrapper.ChartTypeFeature;
import googlechartwrapper.coder.AutoEncoder;
import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.util.AppendableFeature;
import googlechartwrapper.util.IExtendedFeatureAppender;
import googlechartwrapper.util.IFeatureAppender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * FeatureAppender for RadarChartLines which makes an feature string of color
 * and data. If no color was specified to any {@link RadarChartLine} in this
 * appender, the color part of the feature url is ommited. If a minimum of one
 * RadarChartLine has a specified chart color != null a string consisting of the
 * line values and colors is returned. Missing (unspecified) colors are marked
 * with ",".
 * 
 * @author martin
 * @author steffan
 * 
 */
public class RadarChartLineAppender implements IExtendedFeatureAppender {

	protected List<RadarChartLine> radarChartLines = new LinkedList<RadarChartLine>();
	protected IEncoder encoder = new AutoEncoder();

	/*
	 * public String getFeaturePrefix() { return
	 * ChartTypeFeature.ChartData.getPrefix(); }
	 */

	public List<AppendableFeature> getAppendableFeatures(
			List<? extends IFeatureAppender> otherAppenders) {
		
		/*
		// chco fuer colors of slices
		// chartdata vom encoder
		boolean colorUsed = false;
		String color = "chco=";
		List<int[]> toEncVal = new ArrayList<int[]>();
		for (RadarChartLine line : list) {
			if (line.getColor() != null) {
				color = MiscUtils.getSixCharacterHexValue(line.getColor())
						+ ",";
				colorUsed = true;
			} else {
				color = color + ",";
			}
			int[] valss = new int[line.getValues().size()];
			for (int i = 0; i < valss.length; i++) {
				valss[i] = line.getValues().get(i);
			}
			toEncVal.add(valss);
		}

		if (!colorUsed) {
			color = "";
		} else {
			color = color.substring(0, color.length() - 1);
		}
		String val = encoder.encodeIntegerCollection(toEncVal);

		// return val+"&"+color;
		// return new ArrayList<AppendableFeature>();
		// TODO
*/
		// the raw data
		List<int[]> data = new LinkedList<int[]>();

		for(RadarChartLine current : this.radarChartLines){
			
			int[] valss = new int[current.getValues().size()];
			for (int i = 0; i < valss.length; i++) {
				valss[i] = current.getValues().get(i);
			}
			data.add(valss);
		}
		
		List<AppendableFeature> feature = new ArrayList<AppendableFeature>();

		feature.add(new AppendableFeature(this.encoder.encodeIntegerCollection(data), ChartTypeFeature.ChartData));

		return feature;
	}

	/**
	 * 
	 * @param radarChartLine
	 * 
	 * @throws IllegalArgumentException if radarChartLine is {@code null}
	 */
	public void add(RadarChartLine radarChartLine) {
		
		if(radarChartLine == null)
			throw new IllegalArgumentException("radarChartLine can not be null");
		radarChartLines.add(radarChartLine);
	}
	
	/**
	 * 
	 * @param radarChartLines
	 * 
	 * @throws IllegalArgumentException if radarChartLines or member is {@code null}
	 */
	public void add(List<? extends RadarChartLine> radarChartLines){
		
		if(radarChartLines == null)
			throw new IllegalArgumentException("radarChartLines can not be null");
		
		List<? extends RadarChartLine> temp = Collections.unmodifiableList(radarChartLines);
		
		for (RadarChartLine current : temp) {
			if(current == null)
				throw new IllegalArgumentException("member can not be null");
		}
		this.radarChartLines.addAll(temp);
	}

	public boolean remove(RadarChartLine m) {
		return radarChartLines.remove(m);
	}

	public RadarChartLine remove(int index) {
		return radarChartLines.remove(index);
	}

	public void removeAll() {
		
		this.radarChartLines.clear();
	}

	/**
	 * Returns the list of all {@link RadarChartLine} elements added to this
	 * appender. It returns an unmodifiable view of the value list. Consequently
	 * "read-only" access is possible
	 * 
	 * @return unmodifiable view of the values
	 */
	public List<? extends RadarChartLine> getList() {
		return Collections.unmodifiableList(radarChartLines);
	}

	public void setEncoder(IEncoder encoder) {
		if (encoder == null) {
			throw new IllegalArgumentException("encoder cannot be null");
		}
		this.encoder = encoder;
	}

	public IEncoder getEncoder() {
		return encoder;
	}

}
