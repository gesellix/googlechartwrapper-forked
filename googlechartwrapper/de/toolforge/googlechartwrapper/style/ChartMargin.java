package de.toolforge.googlechartwrapper.style;

import java.util.ArrayList;
import java.util.List;

import de.toolforge.googlechartwrapper.ChartTypeFeature;
import de.toolforge.googlechartwrapper.util.AppendableFeature;
import de.toolforge.googlechartwrapper.util.IFeatureAppender;


/**
 * Specifies a ChartMargin <a href=
 * "http://code.google.com/intl/de-DE/apis/chart/styles.html#chart_margins"
 * >http://code.google.com/intl/de-DE/apis/chart/styles.html#chart_margins</a>
 * 
 * @author steffan
 * 
 */
public class ChartMargin implements IFeatureAppender {

	private int leftMargin;
	private int rightMargin;
	private int topMargin;
	private int bottomMargin;
	private int legendWidth;
	private int legendHeight;

	private boolean optionalEnabled = false;

	/**
	 * Constructs a ChartMargin.
	 * 
	 * @param leftMargin
	 *            value > 0
	 * @param rightMargin
	 *            value > 0
	 * @param topMargin
	 *            value > 0
	 * @param bottomMargin
	 *            value > 0
	 * 
	 * @throws IllegalArgumentException
	 *             if margin is out of range
	 */
	public ChartMargin(int leftMargin, int rightMargin, int topMargin,
			int bottomMargin) {

		if (leftMargin < 0)
			throw new IllegalArgumentException("leftMargin can not be < 0");
		if (rightMargin < 0)
			throw new IllegalArgumentException("rightMargin can not be < 0");
		if (topMargin < 0)
			throw new IllegalArgumentException("topMargin can not be < 0");
		if (bottomMargin < 0)
			throw new IllegalArgumentException("bottomMargin can not be < 0");

		this.leftMargin = leftMargin;
		this.rightMargin = rightMargin;
		this.topMargin = topMargin;
		this.bottomMargin = bottomMargin;
	}

	/**
	 * Constructs a ChartMargin with legendWidth and legendHeight.
	 * 
	 * @param leftMargin
	 *            value > 0
	 * @param rightMargin
	 *            value > 0
	 * @param topMargin
	 *            value > 0
	 * @param bottomMargin
	 *            value > 0
	 * @param legendWidth
	 *            value > 0
	 * @param legendHeight
	 *            value > 0
	 * 
	 * @throws IllegalArgumentException
	 *             if margin and/or width/height is out of range
	 */
	public ChartMargin(int leftMargin, int rightMargin, int topMargin,
			int bottomMargin, int legendWidth, int legendHeight) {

		if (leftMargin < 0)
			throw new IllegalArgumentException("leftMargin can not be < 0");
		if (rightMargin < 0)
			throw new IllegalArgumentException("rightMargin can not be < 0");
		if (topMargin < 0)
			throw new IllegalArgumentException("topMargin can not be < 0");
		if (bottomMargin < 0)
			throw new IllegalArgumentException("bottomMargin can not be < 0");
		if(legendWidth < 0)
			throw new IllegalArgumentException("legendWidth can not be < 0");
		if(legendHeight < 0)
			throw new IllegalArgumentException("legendHeight can not be < 0");

		this.leftMargin = leftMargin;
		this.rightMargin = rightMargin;
		this.topMargin = topMargin;
		this.bottomMargin = bottomMargin;

		this.legendHeight = legendHeight;
		this.legendWidth = legendWidth;

		this.optionalEnabled = true;
	}

	/**
	 * @return the leftMargin
	 */
	public int getLeftMargin() {
		return leftMargin;
	}

	/**
	 * @param leftMargin the leftMargin to set
	 * 
	 * @throws IllegalArgumentException if leftMargin < 0
	 */
	public void setLeftMargin(int leftMargin) {
		
		if (leftMargin < 0)
			throw new IllegalArgumentException("leftMargin can not be < 0");
		
		this.leftMargin = leftMargin;
	}

	/**
	 * @return the rightMargin
	 */
	public int getRightMargin() {
		return rightMargin;
	}

	/**
	 * @param rightMargin the rightMargin to set
	 * 
	 * @throws IllegalArgumentException if rightMargin < 0
	 */
	public void setRightMargin(int rightMargin) {
		
		if (rightMargin < 0)
			throw new IllegalArgumentException("rightMargin can not be < 0");
		
		this.rightMargin = rightMargin;
	}

	/**
	 * @return the topMargin
	 */
	public int getTopMargin() {
		return topMargin;
	}

	/**
	 * @param topMargin the topMargin to set
	 * 
	 * @throws IllegalArgumentException if topMargin is < 0
	 */
	public void setTopMargin(int topMargin) {
		
		if (topMargin < 0)
			throw new IllegalArgumentException("topMargin can not be < 0");
		
		this.topMargin = topMargin;
	}

	/**
	 * @return the bottomMargin
	 */
	public int getBottomMargin() {
		return bottomMargin;
	}

	/**
	 * @param bottomMargin the bottomMargin to set
	 * 
	 * @throws IllegalArgumentException if bottomMargin is < 0
	 */
	public void setBottomMargin(int bottomMargin) {
		
		if (bottomMargin < 0)
			throw new IllegalArgumentException("bottomMargin can not be < 0");
		
		this.bottomMargin = bottomMargin;
	}

	/**
	 * @return the legendWidth
	 */
	public int getLegendWidth() {
		return legendWidth;
	}

	/**
	 * @param legendWidth the legendWidth to set
	 * 
	 * @throws IllegalArgumentException if legendWidth is < 0
	 */
	public void setLegendWidth(int legendWidth) {
		
		if(legendWidth < 0)
			throw new IllegalArgumentException("legendWidth can not be < 0");
		
		this.legendWidth = legendWidth;
	}

	/**
	 * @return the legendHeight
	 */
	public int getLegendHeight() {
		return legendHeight;
	}

	/**
	 * @param legendHeight the legendHeight to set
	 * 
	 * @throws IllegalArgumentException if legendHeight is < 0
	 */
	public void setLegendHeight(int legendHeight) {
		
		if(legendHeight < 0)
			throw new IllegalArgumentException("legendHeight can not be < 0");
		
		this.legendHeight = legendHeight;
	}	

	public List<AppendableFeature> getAppendableFeatures(
			List<? extends IFeatureAppender> otherAppenders) {
		StringBuilder builder = new StringBuilder();

		builder.append(this.leftMargin);
		builder.append(',');
		builder.append(this.rightMargin);
		builder.append(',');
		builder.append(this.topMargin);
		builder.append(',');
		builder.append(this.bottomMargin);

		//the second ctor was used
		if (this.optionalEnabled) {
			builder.append('|');
			builder.append(this.legendWidth);
			builder.append(',');
			builder.append(this.legendHeight);
		}
List<AppendableFeature> feature = new ArrayList<AppendableFeature>(); 
		
        feature.add(new AppendableFeature(builder.toString(), 
                  ChartTypeFeature.ChartData)); 
        
		return feature;
	}

}
