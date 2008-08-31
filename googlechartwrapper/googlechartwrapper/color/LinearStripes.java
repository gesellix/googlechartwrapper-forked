package googlechartwrapper.color;

import java.awt.Color;
import java.util.List;

import googlechartwrapper.util.IFeatureAppender;
import googlechartwrapper.util.MiscUtils;

/**
 * 
 * Specifies linear stripes <a href="http://code.google.com/apis/chart/#linear_stripes">
 * http://code.google.com/apis/chart/#linear_stripes</a>
 * 
 * @author steffan
 *
 */
public class LinearStripes implements IFeatureAppender {
	
	private LinearStripesDestination fillDestination;
	private int angle;
	private Color firstColor;
	private Color secondColor;
	private float firstWidth;
	private float secondWith;
	
	/**
	 * 
	 * @param fillDestination
	 * @param angle
	 * @param firstColor
	 * @param firstWidth
	 * @param secondColor
	 * @param secondWith
	 * 
	 * @throws IllegalArgumentException
	 */
	public LinearStripes(LinearStripesDestination fillDestination, int angle, Color firstColor,
			float firstWidth, Color secondColor, float secondWith) {
		
			if(fillDestination == null)
				throw new IllegalArgumentException("fillDestination can not be null");
			if(angle > 90 || angle < 0)
				throw new IllegalArgumentException("angle out of range");
			if(firstColor == null)
				throw new IllegalArgumentException("firstColor can not be null");
			if(secondColor == null)
				throw new IllegalArgumentException("secondColor can not be null");
			if(firstWidth > 1.0f || firstWidth < 0.0f)
				throw new IllegalArgumentException("firstWidth out of range");
			if(secondWith > 1.0f || secondWith < 0.0f)
				throw new IllegalArgumentException("secondWith out of range");
			
			this.fillDestination = fillDestination;
			this.angle = angle;
			this.firstColor = firstColor;
			this.secondColor = secondColor;
			this.firstWidth = firstWidth;
			this.secondWith = secondWith;
	}

	public String getAppendableString(
			List<? extends IFeatureAppender> otherAppenders) {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append(this.fillDestination.getDestination());
		builder.append(',');
		builder.append("ls");
		builder.append(',');
		builder.append(this.angle);
		builder.append(',');
		builder.append(MiscUtils.getSixCharacterHexValue(this.firstColor));
		builder.append(',');
		builder.append(this.firstWidth);
		builder.append(',');
		builder.append(MiscUtils.getSixCharacterHexValue(this.secondColor));
		builder.append(',');
		builder.append(this.secondWith);
		
		return builder.toString();
	}

	/**
	 * @return the fillDestination
	 */
	public LinearStripesDestination getFillDestination() {
		return fillDestination;
	}

	/**
	 * @param fillDestination the fillDestination to set
	 * 
	 * @throws IllegalArgumentException if fillDestination is <code>null</code>
	 */
	public void setFillDestination(LinearStripesDestination fillDestination) {
		if(fillDestination == null)
			throw new IllegalArgumentException("fillDestination can not be null");
		this.fillDestination = fillDestination;
	}

	/**
	 * @return the angle
	 */
	public int getAngle() {
		return angle;
	}

	/**
	 * @param angle value between 0 and 90
	 * 
	 * @throws IllegalArgumentException if angle is out of range 
	 */
	public void setAngle(int angle) {
		if(angle > 90 || angle < 0)
			throw new IllegalArgumentException("angle out of range");
		this.angle = angle;
	}

	/**
	 * @return the firstColor
	 */
	public Color getFirstColor() {
		return firstColor;
	}

	/**
	 * @param firstColor the firstColor to set
	 * 
	 * @throws IllegalArgumentException if firstColor is <code>null</code>
	 */
	public void setFirstColor(Color firstColor) {
		if(firstColor == null)
			throw new IllegalArgumentException("firstColor can not be null");
		this.firstColor = firstColor;
	}

	/**
	 * @return the secondColor
	 */
	public Color getSecondColor() {
		return secondColor;
	}

	/**
	 * @param secondColor the secondColor to set
	 * 
	 * @throws IllegalArgumentException if secondColor is <code>null</code>
	 */
	public void setSecondColor(Color secondColor) {
		if(secondColor == null)
			throw new IllegalArgumentException("secondColor can not be null");
		this.secondColor = secondColor;
	}

	/**
	 * @return the firstWidth
	 */
	public float getFirstWidth() {
		return firstWidth;
	}

	/**
	 * @param firstWidth value between 0.0 and 1.0
	 * 
	 * @throws IllegalArgumentException if firstWidth is out of range
	 */
	public void setFirstWidth(float firstWidth) {
		if(firstWidth > 1.0f || firstWidth < 0.0f)
			throw new IllegalArgumentException("firstWidth out of range");
		this.firstWidth = firstWidth;
	}

	/**
	 * @return the secondWith
	 */
	public float getSecondWith() {
		return secondWith;
	}

	/**
	 * @param secondWith value between 0.0 and 1.0
	 * 
	 * @throws IllegalArgumentException if secondWidth is out of range
	 */
	public void setSecondWith(float secondWith) {
		if(secondWith > 1.0f || secondWith < 0.0f)
			throw new IllegalArgumentException("secondWith out of range");
		this.secondWith = secondWith;
	}

	/**
	 * 
	 * @author steffan
	 *
	 */
	public enum LinearStripesDestination {
    	/**
    	 * for background fill
    	 */
   	 Background("bg"),

   	 /**
   	  * for chart area fill
   	  */
   	 ChartArea("c");
   	 
   	
   	private String destination;

    LinearStripesDestination(String destination) {
		this.destination = destination;
	}

	public String getDestination() {
		return this.destination;

	}

	}

}
