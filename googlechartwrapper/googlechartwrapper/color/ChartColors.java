package googlechartwrapper.color;

import googlechartwrapper.util.IFeatureAppender;

import java.awt.Color;
import java.util.List;

/**
 * 
 * @author steffan
 * 
 */
public class ChartColors implements IFeatureAppender {

	private Color color;

	public ChartColors(Color color) {

		if (color == null)
			throw new IllegalArgumentException("color can not be null");

		this.color = color;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 * 
	 * @throws IllegalArgumentException if color <code>null</code>
	 */
	public void setColor(Color color) {
		if (color == null)
			throw new IllegalArgumentException("color can not be null");
		this.color = color;
	}

	public String getAppendableString(
			List<? extends IFeatureAppender> otherAppenders) {

		StringBuilder builder = new StringBuilder();

		builder.append(Integer.toHexString(color.getRGB()).substring(2, 8));
		return builder.toString();
	}

}
