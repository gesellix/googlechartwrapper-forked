package googlechartwrapper.label;

import googlechartwrapper.ChartTypeFeature;
import googlechartwrapper.util.IExtendedFeatureAppender;
import googlechartwrapper.util.IFeatureAppender;
import googlechartwrapper.util.MiscUtils;

import java.awt.Color;
import java.util.List;

/**
 * Specifies a chart title and optionally title style (fontsize and color of title)
 * @author martin
 *
 */
public class ChartTitle implements IExtendedFeatureAppender{

	private String title;
	private Color color;
	private int fontsize = -1;

	/**
	 * Constructs a ChartTitle. Specify a space with a plus sign (+). 
	 * Use a pipe character (|) to force a line break. 
	 * Classic space characters " " are converted to a +.
	 * @param title title to set != null
	 * @throws IllegalArgumentException if title == null
	 */
	public ChartTitle(String title) {
		setTitle(title);
	}

	/**
	 * Returns chart title.
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set a ChartTitle. Specify a space with a plus sign (+). 
	 * Use a pipe character (|) to force a line break. 
	 * Classic space characters " " are converted to a +.
	 * @param title title to set != null
	 * @throws IllegalArgumentException if title == null
	 */
	public void setTitle(String title) {
		if (title == null){
			throw new IllegalArgumentException("title cannot be null");
		}
		this.title = title.replaceAll(" ", "+");
	}

	/*
	 * (non-Javadoc)
	 * @see googlechartwrapper.util.IExtendedFeatureAppender#getFeaturePrefix()
	 */
	public String getFeaturePrefix() {
		return ChartTypeFeature.ChartTitle.getPrefix();
	}

	/*
	 * (non-Javadoc)
	 * @see googlechartwrapper.util.IFeatureAppender#getAppendableString(java.util.List)
	 */
	public String getAppendableString(List<? extends IFeatureAppender> otherAppenders) {
		StringBuffer ret = new StringBuffer(title.length()+15);
		ret.append(ChartTypeFeature.ChartTitle.getPrefix());
		ret.append("=");
		ret.append(title);
		if (color != null){
			ret.append("&");
			ret.append(ChartTypeFeature.ChartTitleStyle.getPrefix());
			ret.append("=");
			ret.append(MiscUtils.getSixCharacterHexValue(color));
			ret.append(color);
			ret.append(",");
			ret.append(fontsize);
		}
		return ret.toString();
	}


	/**
	 * Returns the color of the title or null, if none set
	 * @return color of title, <code>null</code> if none set.
	 * @see #setStyle(Color, int)
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Set the optional style of the chart title. If no style should be used,
	 * the color must be null. If color is not null the fontsize is requiered and
	 * must be greater or equal 0.
	 * The chart is clipped (only partially visible) if the fontsize specified  
	 * is too small.
	 * @param color color to set, if no style null
	 * @param fontsize fontsize of the title, if color != null must be >= 0
	 * @throws IllegalArgumentException color != null && fontsize < 0
	 */
	public void setStyle(Color color, int fontsize) {
		if (color != null){ //wenn color gesetzt, dann ist auch eine size nötig
			if (fontsize<0){
				throw new IllegalArgumentException
					("if a color is set, fontsize must be >= 0");
			}
		}
		this.color = color;
		this.fontsize = fontsize;
	}

	/**
	 * Returns the fontsize of the title. Default value is -1.
	 * @return fontsize
	 * @see #setStyle(Color, int)
	 */
	public int getFontsize() {
		return fontsize;
	}
	
}
