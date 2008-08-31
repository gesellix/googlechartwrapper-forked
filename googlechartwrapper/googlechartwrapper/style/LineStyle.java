package googlechartwrapper.style;

import java.util.List;

import googlechartwrapper.util.IFeatureAppender;

/**
 * 
 * @author steffan
 *
 */
public class LineStyle implements IFeatureAppender, ILineStyle{
	
	private float thickniss;
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
		
		this.thickniss = thickness;
		this.lengthOfBlankSegment = lengthOfBlankSegment;
		this.lengthOfLineSegment = lengthOfBlankSegment;
	}

	public String getAppendableString(List<? extends IFeatureAppender> otherAppenders) {
		
		StringBuilder builder = new StringBuilder();
		builder.append(this.thickniss);
		builder.append(',');
		builder.append(this.lengthOfLineSegment);
		builder.append(',');
		builder.append(this.lengthOfBlankSegment);	
		
		return builder.toString();
	}

	/**
	 * @return the thickniss
	 */
	public float getThickniss() {
		return thickniss;
	}

	/**
	 * @param thickniss the thickniss to set
	 */
	public void setThickniss(float thickniss) {
		this.thickniss = thickniss;
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
