package googlechartwrapper.data;

import googlechartwrapper.ChartTypeFeature;
import googlechartwrapper.coder.AutoEncoder;
import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.util.AppendableFeature;
import googlechartwrapper.util.IExtendedFeatureAppender;
import googlechartwrapper.util.IFeatureAppender;
import googlechartwrapper.util.MiscUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * FeatureAppender for RadarChartLines which makes an feature string of color and data.
 * If no color was specified to any {@link RadarChartLine} in this appender, 
 * the color part of the feature url is ommited. If a minimum of one RadarChartLine
 * has a specified chart color != null a string consisting of the line values
 * and colors is returned. Missing (unspecified) colors are marked with ",".
 * @author martin
 *
 */
public class RadarChartLineAppender implements IExtendedFeatureAppender {

	protected List<RadarChartLine> list= new LinkedList<RadarChartLine>();
	protected IEncoder encoder = new AutoEncoder();
	
	public String getFeaturePrefix() {		
		return ChartTypeFeature.ChartData.getPrefix();
	}

	public List<AppendableFeature> getAppendableFeatures(List<? extends IFeatureAppender> otherAppenders) {
		//chco fuer colors of slices
		//chartdata vom encoder
		boolean colorUsed= false;
		String color = "chco=";
		List<int[]> toEncVal = new ArrayList<int[]> ();
		for (RadarChartLine line : list){
			if (line.getColor()!= null){
				color = MiscUtils.getSixCharacterHexValue(line.getColor())+",";
				colorUsed = true;
			}
			else {
				color = color + ",";
			}
			int[] valss = new int[line.getValues().size()];
			for (int i = 0; i < valss.length;i++){
				valss[i] = line.getValues().get(i);
			}
			toEncVal.add(valss);
		}
		
		if (!colorUsed){
			color = "";
		}
		else {
			color = color.substring(0, color.length()-1 );
		}
		String val = encoder.encodeIntegerCollection(toEncVal);
				
		//return val+"&"+color;
		//return new ArrayList<AppendableFeature>();
		//TODO
		
List<AppendableFeature> feature = new ArrayList<AppendableFeature>(); 
		
        feature.add(new AppendableFeature(val, 
                  ChartTypeFeature.ChartData)); 
        
		return feature;
	}
	
	public void add (RadarChartLine m){
		list.add(m);
	}
	
	public boolean remove (RadarChartLine m){
		return list.remove(m);
	}
	
	public RadarChartLine remove (int index){
		return list.remove(index);
	}
	
	public void removeAll (){
		for (int i = 0; i < list.size();){
			list.remove(i);
		}
	}
	
	/**
	 * Returns the list of all {@link RadarChartLine} elements added to this appender. 
	 * It returns an unmodifiable view of the value list.
	 * Consequently "read-only" access is possible
	 * @return unmodifiable view of the values
	 */
	public List<? extends RadarChartLine> getList (){
		return Collections.unmodifiableList(list);
	}
	
	public void setEncoder (IEncoder encoder){
		if (encoder == null){
			throw new IllegalArgumentException("encoder cannot be null");
		}
		this.encoder = encoder;
	}
	
	public IEncoder getEncoder (){
		return encoder; 
	}

}
