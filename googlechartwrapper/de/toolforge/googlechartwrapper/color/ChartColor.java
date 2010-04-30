package de.toolforge.googlechartwrapper.color;

import java.util.ArrayList;
import java.util.List;

import de.toolforge.googlechartwrapper.ChartTypeFeature;
import de.toolforge.googlechartwrapper.Color;
import de.toolforge.googlechartwrapper.util.AppendableFeature;
import de.toolforge.googlechartwrapper.util.IFeatureAppender;

/**
 * Specifies a ChartColor <a
 * href="http://code.google.com/apis/chart/colors.html#line_bar_pie_colors"
 * >http://code.google.com/apis/chart/colors.html#line_bar_pie_colors</a>
 * 
 * @author steffan, martin
 * 
 */
public class ChartColor implements IFeatureAppender {

	private Color color;

	/**
	 * Constructs an ChartColors object. 
	 * @param color color 
	 * @throws IllegalArgumentException
	 *             if color is null
	 */
	public ChartColor(Color color) {

		if (color == null)
			throw new IllegalArgumentException("color can not be null");

		this.color = color;
	}
	
	/**
	 * Constructing a ChartColor based on an AWT Color object.
	 * @param awtColor color
	 * @throws IllegalArgumentException
	 *             if color is null
	 */
	@Deprecated
	public ChartColor(java.awt.Color awtColor) {
		if (awtColor == null)
			throw new IllegalArgumentException("color can not be null");
		this.color = new Color(awtColor);
	}

	/**
	 * Returns the color.
	 * 
	 * @return the color
	 */
	public Color getColor() {

		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 * 
	 * @throws IllegalArgumentException
	 *             if color is <code>null</code>
	 */
	public void setColor(Color color) {
		if (color == null)
			throw new IllegalArgumentException("color can not be null");

		this.color = color;
	}

	public List<AppendableFeature> getAppendableFeatures(
			List<? extends IFeatureAppender> otherAppenders) {

		String c = color.getSixCharacterHexValue();

		List<AppendableFeature> feature = new ArrayList<AppendableFeature>();
		feature.add(new AppendableFeature(c,ChartTypeFeature.ChartColor));

		return feature;
	}

}
