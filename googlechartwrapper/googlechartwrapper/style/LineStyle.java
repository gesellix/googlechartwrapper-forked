package googlechartwrapper.style;

import java.util.ArrayList;
import java.util.List;

import googlechartwrapper.ChartTypeFeature;
import googlechartwrapper.util.AppendableFeature;
import googlechartwrapper.util.IFeatureAppender;

/**
 * Specifies a GridLine <a href="http://code.google.com/apis/chart/styles.html#line_styles"> http://code.google.com/apis/chart/styles.html#line_styles</a> 
 * 
 * @author steffan
 *
 */
public class LineStyle implements IFeatureAppender{
	
	private float thickness;
	private float lengthOfLineSegment;
	private float lengthOfBlankSegment;
	
	/**
	 * Constructs a LineStyle
	 * 
	 * @param thickness
	 * @param lengthOfLineSegment
	 * @param lengthOfBlankSegment
	 */
	public LineStyle(float thickness,float lengthOfLineSegment, float lengthOfBlankSegment) {
		
		this.thickness = thickness;
		this.lengthOfBlankSegment = lengthOfBlankSegment;
		this.lengthOfLineSegment = lengthOfBlankSegment;
	}

	public List<AppendableFeature> getAppendableFeatures(List<? extends IFeatureAppender> otherAppenders) {
		
		StringBuilder builder = new StringBuilder();
		builder.append(this.thickness);
		builder.append(',');
		builder.append(this.lengthOfLineSegment);
		builder.append(',');
		builder.append(this.lengthOfBlankSegment);	
		
		List<AppendableFeature> feature = new ArrayList<AppendableFeature>(); 
		
        feature.add(new AppendableFeature(builder.toString(), 
                  ChartTypeFeature.LineStyle)); 
        
		return feature;
	}

	/**
	 * @return the thickness
	 */
	public float getthickness() {
		return thickness;
	}

	/**
	 * @param thickness the thickness to set
	 */
	public void setthickness(float thickness) {
		this.thickness = thickness;
	}

	/**
	 * @return the lengthOfLineSegment
	 */
	public float getLengthOfLineSegment() {
		return lengthOfLineSegment;
	}

	/**
	 * @param lengthOfLineSegment the lengthOfLineSegment to set
	 */
	public void setLengthOfLineSegment(float lengthOfLineSegment) {
		this.lengthOfLineSegment = lengthOfLineSegment;
	}

	/**
	 * @return the lengthOfBlankSegment
	 */
	public float getLengthOfBlankSegment() {
		return lengthOfBlankSegment;
	}

	/**
	 * @param lengthOfBlankSegment the lengthOfBlankSegment to set
	 */
	public void setLengthOfBlankSegment(float lengthOfBlankSegment) {
		this.lengthOfBlankSegment = lengthOfBlankSegment;
	}

}
