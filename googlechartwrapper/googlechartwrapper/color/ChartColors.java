package googlechartwrapper.color;

import googlechartwrapper.util.AppendableFeature;
import googlechartwrapper.util.IFeatureAppender;

import java.awt.Color;
import java.util.List;

/**
 * Specifies a CharColor <a href="http://code.google.com/apis/chart/colors.html#line_bar_pie_colors">http://code.google.com/apis/chart/colors.html#line_bar_pie_colors</a> 
 * 
 * @author steffan
 * 
 */
public class ChartColors implements IFeatureAppender {

	private Color color;

	/**
	 * Constructs an ChartColors object.
	 * 
	 * @param color
	 * 
	 * @throws IllegalArgumentException if color is null
	 */
	public ChartColors(Color color) {

		if (color == null)
			throw new IllegalArgumentException("color can not be null");

		this.color = new Color(color.getRGB());
	}

	/**
	 * Rreturns the color.
	 * 
	 * @return the color
	 */
	public Color getColor() {
		
		return new Color(color.getRGB());
	}

	/**
	 * @param color the color to set
	 * 
	 * @throws IllegalArgumentException if color is <code>null</code>
	 */
	public void setColor(Color color) {
		if (color == null)
			throw new IllegalArgumentException("color can not be null");
		
		this.color = new Color(color.getRGB());
	}

	public List<AppendableFeature> getAppendableString(
			List<? extends IFeatureAppender> otherAppenders) {

		StringBuilder builder = new StringBuilder();

		builder.append(Integer.toHexString(color.getRGB()).substring(2, 8));
		return builder.toString();
	}

}
