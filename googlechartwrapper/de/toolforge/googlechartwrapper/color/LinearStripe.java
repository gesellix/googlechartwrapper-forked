package de.toolforge.googlechartwrapper.color;

import java.util.ArrayList;
import java.util.List;

import de.toolforge.googlechartwrapper.ChartTypeFeature;
import de.toolforge.googlechartwrapper.Color;
import de.toolforge.googlechartwrapper.util.AppendableFeature;
import de.toolforge.googlechartwrapper.util.IFeatureAppender;


/**
 * 
 * Specifies linear stripes <a
 * href="http://code.google.com/apis/chart/colors.html#linear_stripes">
 * http://code.google.com/apis/chart/colors.html#linear_stripes</a>
 * 
 * @author steffan
 * 
 */
public class LinearStripe implements IFeatureAppender {

	private LinearStripesDestination fillDestination;
	private int angle;
	private Color firstColor;
	private Color secondColor;
	private float firstWidth;
	private float secondWith;

	/**
	 * Constructs a LinearStripe
	 * 
	 * @param fillDestination
	 * @param angle
	 *            between 0 and 90
	 * @param firstColor
	 * @param firstWidth
	 *            between 0.0f and 1.0f
	 * @param secondColor
	 * @param secondWith
	 *            between 0.0f and 1.0f
	 * 
	 * @throws IllegalArgumentException
	 */
	public LinearStripe(LinearStripesDestination fillDestination, int angle,
			Color firstColor, float firstWidth, Color secondColor,
			float secondWith) {

		if (fillDestination == null)
			throw new IllegalArgumentException(
					"fillDestination can not be null");
		if (angle > 90 || angle < 0)
			throw new IllegalArgumentException("angle out of range");
		if (firstColor == null)
			throw new IllegalArgumentException("firstColor can not be null");
		if (secondColor == null)
			throw new IllegalArgumentException("secondColor can not be null");
		if (firstWidth > 1.0f || firstWidth < 0.0f)
			throw new IllegalArgumentException("firstWidth out of range");
		if (secondWith > 1.0f || secondWith < 0.0f)
			throw new IllegalArgumentException("secondWith out of range");

		this.fillDestination = fillDestination;
		this.angle = angle;
		this.firstColor = firstColor;
		this.secondColor = secondColor;
		this.firstWidth = firstWidth;
		this.secondWith = secondWith;
	}
	
	/**
	 * Constructs a LinearStripe
	 * 
	 * @param fillDestination
	 * @param angle
	 *            between 0 and 90
	 * @param awtFirstColor
	 * @param firstWidth
	 *            between 0.0f and 1.0f
	 * @param awtSecondColor
	 * @param secondWith
	 *            between 0.0f and 1.0f
	 * 
	 * @throws IllegalArgumentException
	 * @deprecated use
	 * {@link #LinearStripe(LinearStripesDestination, int, Color, float, Color, float)}
	 */
	@Deprecated
	public LinearStripe(LinearStripesDestination fillDestination, int angle,
			java.awt.Color awtFirstColor, float firstWidth, java.awt.Color awtSecondColor,
			float secondWith) {

		if (fillDestination == null)
			throw new IllegalArgumentException(
					"fillDestination can not be null");
		if (angle > 90 || angle < 0)
			throw new IllegalArgumentException("angle out of range");
		if (awtFirstColor == null)
			throw new IllegalArgumentException("firstColor can not be null");
		if (awtSecondColor == null)
			throw new IllegalArgumentException("secondColor can not be null");
		if (firstWidth > 1.0f || firstWidth < 0.0f)
			throw new IllegalArgumentException("firstWidth out of range");
		if (secondWith > 1.0f || secondWith < 0.0f)
			throw new IllegalArgumentException("secondWith out of range");

		this.fillDestination = fillDestination;
		this.angle = angle;
		this.firstColor = new Color(awtFirstColor);
		this.secondColor = new Color(awtSecondColor);
		this.firstWidth = firstWidth;
		this.secondWith = secondWith;
	}

	public List<AppendableFeature> getAppendableFeatures(
			List<? extends IFeatureAppender> otherAppenders) {

		StringBuilder builder = new StringBuilder();

		builder.append(this.fillDestination.getDestination());
		builder.append(',');
		builder.append("ls");
		builder.append(',');
		builder.append(this.angle);
		builder.append(',');
		builder.append(firstColor.getMatchingColorHexValue());
		builder.append(',');
		builder.append(this.firstWidth);
		builder.append(',');
		builder.append(secondColor.getMatchingColorHexValue());
		builder.append(',');
		builder.append(this.secondWith);

List<AppendableFeature> feature = new ArrayList<AppendableFeature>(); 
		
        feature.add(new AppendableFeature(builder.toString(), 
                  ChartTypeFeature.LinearStripes)); 
        
		return feature;
	}

	/**
	 * Returns the fillDestination
	 * 
	 * @return the fillDestination
	 */
	public LinearStripesDestination getFillDestination() {
		return fillDestination;
	}

	/**
	 * Sets the fillDestination.
	 * 
	 * @param fillDestination
	 *            the fillDestination to set
	 * 
	 * @throws IllegalArgumentException
	 *             if fillDestination is <code>null</code>
	 */
	public void setFillDestination(LinearStripesDestination fillDestination) {
		if (fillDestination == null)
			throw new IllegalArgumentException(
					"fillDestination can not be null");
		this.fillDestination = fillDestination;
	}

	/**
	 * Returns the angle.
	 * 
	 * @return the angle
	 */
	public int getAngle() {
		return angle;
	}

	/**
	 * Sets the angle.
	 * 
	 * @param angle
	 *            value between 0 and 90
	 * 
	 * @throws IllegalArgumentException
	 *             if angle is out of range
	 */
	public void setAngle(int angle) {
		if (angle > 90 || angle < 0)
			throw new IllegalArgumentException("angle out of range");
		this.angle = angle;
	}

	/**
	 * Returns the fisrtColor.
	 * 
	 * @return the firstColor
	 */
	public Color getFirstColor() {
		return firstColor;
	}

	/**
	 * Sets the firstColor.
	 * 
	 * @param firstColor
	 *            the firstColor to set
	 * 
	 * @throws IllegalArgumentException
	 *             if firstColor is <code>null</code>
	 */
	public void setFirstColor(Color firstColor) {
		if (firstColor == null)
			throw new IllegalArgumentException("firstColor can not be null");

		this.firstColor = firstColor;
	}

	/**
	 * Returns the secondColor.
	 * 
	 * @return the secondColor
	 */
	public Color getSecondColor() {
		return secondColor;
	}

	/**
	 * Sets the second Color.
	 * 
	 * @param secondColor
	 *            the secondColor to set
	 * 
	 * @throws IllegalArgumentException
	 *             if secondColor is <code>null</code>
	 */
	public void setSecondColor(Color secondColor) {
		if (secondColor == null)
			throw new IllegalArgumentException("secondColor can not be null");
		this.secondColor = secondColor;
	}

	/**
	 * Returns the fisrtWidth.
	 * 
	 * @return the firstWidth
	 */
	public float getFirstWidth() {
		return firstWidth;
	}

	/**
	 * Sets the firstWidth.
	 * 
	 * @param firstWidth
	 *            value between 0.0 and 1.0
	 * 
	 * @throws IllegalArgumentException
	 *             if firstWidth is out of range
	 */
	public void setFirstWidth(float firstWidth) {
		if (firstWidth > 1.0f || firstWidth < 0.0f)
			throw new IllegalArgumentException("firstWidth out of range");
		this.firstWidth = firstWidth;
	}

	/**
	 * Returns the secondWidth.
	 * 
	 * @return the secondWith
	 */
	public float getSecondWith() {
		return secondWith;
	}

	/**
	 * Sets the secondWith.
	 * 
	 * @param secondWith
	 *            value between 0.0 and 1.0
	 * 
	 * @throws IllegalArgumentException
	 *             if secondWidth is out of range
	 */
	public void setSecondWith(float secondWith) {
		if (secondWith > 1.0f || secondWith < 0.0f)
			throw new IllegalArgumentException("secondWith out of range");
		this.secondWith = secondWith;
	}

	/**
	 * The API provides background and chartarea destination for linearstripes.
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
		
		/**
		 * Returns the destination.
		 * 
		 * @return destination
		 */
		public String getDestination() {
			return this.destination;

		}

	}

}
