package googlechartwrapper.data;

import googlechartwrapper.coder.AutoEncoder;
import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.interfaces.IEncodeable;
import googlechartwrapper.style.DefaultValues;
import googlechartwrapper.util.AppendableFeature;
import googlechartwrapper.util.IExtendedFeatureAppender;
import googlechartwrapper.util.IFeatureAppender;
import googlechartwrapper.util.MiscUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import de.toolforge.googlechartwrapper.ChartTypeFeature;

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
public class RadarChartLineAppender implements IExtendedFeatureAppender, IEncodeable {

	protected List<RadarChartLine> radarChartLines = new LinkedList<RadarChartLine>();
	protected IEncoder encoder = new AutoEncoder();

	/*
	 * public String getFeaturePrefix() { return
	 * ChartTypeFeature.ChartData.getPrefix(); }
	 */

	public List<AppendableFeature> getAppendableFeatures(
			List<? extends IFeatureAppender> otherAppenders) {
			
		// the raw data
		List<int[]> data = new LinkedList<int[]>();

		for(RadarChartLine current : this.radarChartLines){
			
			int[] valss = new int[current.getValues().size()];
			for (int i = 0; i < valss.length; i++) {
				valss[i] = current.getValues().get(i);
			}
			data.add(valss);
		}
		
		boolean isColorUsed = false;

		// the color string
		StringBuilder color = new StringBuilder();
		
		for(RadarChartLine current : this.radarChartLines){
			
			//user set color
			if(current.getColor() != null){
				isColorUsed = true;
				color.append(MiscUtils.getMatchingColorHexValue(current.getColor()));
			}
			//no color was set
			else{
				color.append(MiscUtils
						.getMatchingColorHexValue(DefaultValues.DataColor));
			}
			
				color.append(",");
			
		}
		// otherwise we have a "," at the end
		if (color.length() > 0) {
			color.deleteCharAt(color.length()-1);
		}
				
		List<AppendableFeature> features = new ArrayList<AppendableFeature>();

		features.add(new AppendableFeature(this.encoder.encodeIntegerCollection(data), ChartTypeFeature.ChartData));
		
		// if the user set the color we have to add the string
		if (isColorUsed) {
			features.add(new AppendableFeature(color.toString(),
					ChartTypeFeature.ChartColor));
		}

		return features;
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

	public void removeEncoder() {
		this.encoder = new AutoEncoder();

	}

}
