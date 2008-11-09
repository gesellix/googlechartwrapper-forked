package googlechartwrapper.label;

import googlechartwrapper.util.IFeatureAppender;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 
 * @author steffan
 * 
 */
public class ChartLegend implements IFeatureAppender {

	private List<String> label = new ArrayList<String>();
	private ChartLegendPosition chartLegendPosition = null;

	/**
	 * 
	 * @param label
	 * 
	 * @throws IllegalArgumentException
	 */
	public ChartLegend(List<String> label) {

		if (label == null)
			throw new IllegalArgumentException("label can not be null");

		this.label = label;

	}

	/**
	 * 
	 * @param labels
	 * @param chartLegendPosition
	 * 
	 * @throws IllegalArgumentException
	 */
	public ChartLegend(List<String> label,
			ChartLegendPosition chartLegendPosition) {

		if (label == null)
			throw new IllegalArgumentException("label can not be null");
		if (chartLegendPosition == null)
			throw new IllegalArgumentException("chartLegendPosition");

		this.label = label;
		this.chartLegendPosition = chartLegendPosition;

	}

	public String getAppendableString(
			List<? extends IFeatureAppender> otherAppenders) {

		StringBuilder builder = new StringBuilder();

		for (String currentLabel : this.label) {
			builder.append(currentLabel);
			builder.append('|');
		}

		// only if we have one or more elements
		if (this.label.size() > 0) {
			builder.deleteCharAt(builder.length() - 1);
		}

		if (this.chartLegendPosition != null) {
			builder.append("chdlp=");
			builder.append(this.chartLegendPosition.getPosition());
		}

		return builder.toString();
	}

	/**
	 * @return the label
	 */
	public List<String> getLabel() {
		return label;
	}

	/**
	 * @param label
	 *            the label to set
	 * 
	 * @throws IllegalArgumentException
	 *             if label is <code>null</code>
	 */
	public void setLabel(List<String> label) {
		if (label == null)
			throw new IllegalArgumentException("label can not be null");
		this.label = label;
	}

	/**
	 * @return the chartLegendPosition
	 */
	public ChartLegendPosition getChartLegendPosition() {
		return chartLegendPosition;
	}

	/**
	 * @param chartLegendPosition
	 *            the chartLegendPosition to set, default is right
	 * 
	 * @throws IllegalArgumentException
	 *             if label is <code>null</code>
	 */
	public void setChartLegendPosition(ChartLegendPosition chartLegendPosition) {
		if (label == null)
			throw new IllegalArgumentException("label can not be null");
		this.chartLegendPosition = chartLegendPosition;
	}

	/**
	 * 
	 * @author steffan
	 * 
	 */
	public enum ChartLegendPosition {

		Bottom('b'),

		Top('t'),

		Left('l'),

		Right('r');

		private char position;

		ChartLegendPosition(char position) {
			this.position = position;
		}

		public char getPosition() {
			return this.position;

		}
	}

}
