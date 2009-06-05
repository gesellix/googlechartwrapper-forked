package de.toolforge.googlechartwrapper.label;

import java.awt.Color;

/**
 * Specify font size, color, and alignment for axis labels. The color is mandatory, 
 * whereas fontsize and alignment are optional values if a custom axis style is set.
 * The custom aligment requires a fontsize set. 
 * @author martin
 */
public class AxisStyle {
	
	public static final int LEFT_ALIGN = -1;
	public static final int CENTER_ALIGN = 0;
	public static final int RIGHT_ALIGN = 1;
	
	protected Color color;
	protected int fontSize = -1;
	protected int alignment = CENTER_ALIGN;
	protected boolean useAlignment = false;
	
	public AxisStyle(Color color) {
		if (color == null){
			throw new IllegalArgumentException("a color is required, " +
					"if a custom axis style is set.");
		}
		this.color = color;
	}
	
	/**
	 * Returns the custom alignment.
	 * @return alignment
	 */
	public int getAlignment() {
		return alignment;
	}
	
	/**
	 * Sets the alignment of axis labels. By default: x-axis labels are centered, 
	 * left y-axis labels are right aligned, right y-axis labels are left aligned.
	 * <p>If the alignment should be appended to the url, a custom fontsize must be set with
	 * {@link #setFontSize(int)}.</p>
	 * <p>A call of this methods sets {@link #isAlignmentUsed()} to true. If the custom
	 * alignment should be ignored use {@link #setAlignmentUsed(boolean)}.</p>
	 * @param alignment alignment of the axis labels
	 */
	public void setAlignment(int alignment) {
		if (alignment < -1 || alignment > 1){
			throw new IllegalArgumentException("alignment must be LEFT_ALIGN, CENTER_ALIGN or RIGHT_ALIGN");
		}
		setAlignmentUsed(true);
		this.alignment = alignment;
	}
	
	/**
	 * Returns the specified size in pixels. 
	 * @return fontSize, if none appended to the url &lt;=0
	 */
	public int getFontSize() {
		return fontSize;
	}
	
	/**
	 * Sets the fontsize of the axis-label. If fontSize is &lt;=0 the default v
	 * alue is used and no information for fontsize is appended to the chart-url.
	 * If used this specifies the size in pixels. 
	 * @param fontSize fontsize; if &lt;=0 default value used
	 */
	public void setFontSize(int fontSize) {
		/*if (fontSize < 1){
			throw new IllegalArgumentException("fontsize must be greater 0");
		}*/
		this.fontSize = fontSize;
	}
	
	/**
	 * Returns the color for the axis labels. 
	 * @return color for axis labels, if none set <code>null</code>
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Returns if the alignment set for this axis should be used in the url.
	 * @return <code>true</code> if appended to url; <code>false</code> otherwise.
	 */
	public boolean isAlignmentUsed() {
		return useAlignment;
	}
	
	/**
	 * Sets, if the alignment should be appended to the url. If useAlignment is true, 
	 * a custom fontSize and color is required.
	 * @param useAlignment
	 */
	public void setAlignmentUsed(boolean useAlignment) {
		this.useAlignment = useAlignment;
	}	
	
}
