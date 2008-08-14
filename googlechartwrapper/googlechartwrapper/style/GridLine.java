package googlechartwrapper.style;

import java.util.List;

import googlechartwrapper.util.IFeatureAppender;

/**
 * 
 * @author steffan
 *
 */
public class GridLine implements IFeatureAppender {
	
	private float xAxisStepSize;
	private float yAxisStepSize;
	private float lengthLineSegment; 
	private float lengthBlankSegment = 0f;
	private boolean isStepSizeDefined = false;
	
	/**
	 * Constructs the grid line. <br />
	 * Note parameters can have only a single decimal place.
	 * 
	 * @param xAxisStepSize
	 * @param yAxisStepSize
	 */
	public GridLine(float xAxisStepSize, float yAxisStepSize){
		this.xAxisStepSize = xAxisStepSize;
		this.yAxisStepSize = yAxisStepSize;
		
	}
	/**
	 * Constructs the grid line. <br />
	 * Note parameters can have only a single decimal place.
	 * 
	 * @param xAxisStepSize
	 * @param yAxisStepSize
	 * @param lengthLineSegment
	 * @param lengthBlankSegment zero means solid, default is zero
	 */
	public GridLine(float xAxisStepSize, float yAxisStepSize, float lengthLineSegment,float lengthBlankSegment){
		
		this.isStepSizeDefined = true;
		
		this.xAxisStepSize = xAxisStepSize;
		this.yAxisStepSize = yAxisStepSize;
		
		this.lengthLineSegment = lengthLineSegment;
		this.lengthBlankSegment = lengthBlankSegment;
	}
	
	/**
	 * @return the xAxisStepSize
	 */
	public float getXAxisStepSize() {
		return xAxisStepSize;
	}
	/**
	 * @param axisStepSize the xAxisStepSize to set
	 */
	public void setXAxisStepSize(float axisStepSize) {
		xAxisStepSize = axisStepSize;
	}
	/**
	 * @return the yAxisStepSize
	 */
	public float getYAxisStepSize() {
		return yAxisStepSize;
	}
	/**
	 * @param axisStepSize the yAxisStepSize to set
	 */
	public void setYAxisStepSize(float axisStepSize) {
		yAxisStepSize = axisStepSize;
	}
	/**
	 * @return the lengthLineSegment
	 */
	public float getLengthLineSegment() {
		return lengthLineSegment;
	}
	/**
	 * @param lengthLineSegment the lengthLineSegment to set
	 */
	public void setLengthLineSegment(float lengthLineSegment) {
		this.lengthLineSegment = lengthLineSegment;
		
		this.isStepSizeDefined = true;
	}
	/**
	 * @return the lengthBlankSegment
	 */
	public float getLengthBlankSegment() {
		return lengthBlankSegment;
	}
	/**
	 * @param lengthBlankSegment the lengthBlankSegment to set
	 */
	public void setLengthBlankSegment(float lengthBlankSegment) {
		this.lengthBlankSegment = lengthBlankSegment;
	}
	
	public String getAppendableString(List<? extends IFeatureAppender> otherAppenders) {
		
			StringBuilder builder = new StringBuilder();
									
			builder.append(this.CutNumber(xAxisStepSize));
			builder.append(',');
			builder.append(this.CutNumber(yAxisStepSize));
			
			if(isStepSizeDefined){
				
				builder.append(',');
				builder.append(this.CutNumber(lengthLineSegment));
				builder.append(',');
				builder.append(this.CutNumber(lengthLineSegment));
				
			}
			
		return builder.toString();
	}
	/**
	 * 
	 * @param number
	 * @return
	 */
	private String CutNumber(float number){
		
		String s = Float.toString(number);
		
		int i = s.indexOf(".");
		
		//nachkommastelle abschneiden
		if(s.length() > i){
			return s.substring(0, i+1);
		}
		return s;
	}

}
