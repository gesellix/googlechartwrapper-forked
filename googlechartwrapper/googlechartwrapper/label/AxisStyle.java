package googlechartwrapper.label;

import java.awt.Color;

public class AxisStyle {
	
	public static final int LEFT_ALIGN = -1;
	public static final int CENTER_ALIGN = 0;
	public static final int RIGHT_ALIGN = 1;
	
	protected Color color;
	protected int fontSize = 12;
	protected boolean useFontSize = false;
	protected int alignment = CENTER_ALIGN;
	protected boolean useAlignment = false;
	
	public AxisStyle(Color color) {
		super();
		this.color = color;
	}
	public int getAlignment() {
		return alignment;
	}
	public void setAlignment(int alignment) {
		if (alignment < -1 || alignment > 1){
			throw new IllegalArgumentException("alignment must be LEFT_ALIGN, CENTER_ALIGN or RIGHT_ALIGN");
		}
		this.alignment = alignment;
	}
	public int getFontSize() {
		return fontSize;
	}
	public void setFontSize(int fontSize) {
		if (fontSize < 1){
			throw new IllegalArgumentException("fontsize must be greater 0");
		}
		this.fontSize = fontSize;
	}
	public Color getColor() {
		return color;
	}
	public boolean isUseAlignment() {
		return useAlignment;
	}
	public void setUseAlignment(boolean useAlignment) {
		this.useAlignment = useAlignment;
	}
	public boolean isUseFontSize() {
		return useFontSize;
	}
	public void setUseFontSize(boolean useFontSize) {
		this.useFontSize = useFontSize;
	}
	
}
