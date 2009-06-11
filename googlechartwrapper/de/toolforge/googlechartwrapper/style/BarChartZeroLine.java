package de.toolforge.googlechartwrapper.style;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import de.toolforge.googlechartwrapper.ChartTypeFeature;
import de.toolforge.googlechartwrapper.coder.DataScalingTextEncoder;
import de.toolforge.googlechartwrapper.data.DataScalingSet;
import de.toolforge.googlechartwrapper.util.AppendableFeature;
import de.toolforge.googlechartwrapper.util.IFeatureAppender;


/**
 * <a href= "http://code.google.com/intl/de-DE/apis/chart/styles.html#zero_line"
 * >http://code.google.com/intl/de-DE/apis/chart/styles.html#zero_line</a> <br />
 * <b>Note</b> <br />
 * Alternatively, you can set a zero line by using the data scaling
 * {@link DataScalingSet} in combination with {@link DataScalingTextEncoder}.
 * 
 * 
 * @author steffan
 */
public class BarChartZeroLine implements IFeatureAppender {

	private List<Float> dataSets = new LinkedList<Float>();

	/**
	 * Constructs a new barChartZeroLine. <br />
	 * Use this constructor if only one dataSet is used, otherwise use
	 * {@link BarChartZeroLine #BarChartZeroLine(List)}
	 * 
	 * @param zeroLine
	 *            value between 0 and 1
	 * 
	 * @throws IllegalArgumentException
	 *             if zeroLine is out of range
	 */
	public BarChartZeroLine(float zeroLine) {

		if (zeroLine < 0 || zeroLine > 1)
			throw new IllegalArgumentException(
					"zeroLine can not be < 0 and/or > 1");

		this.dataSets.add(zeroLine);
	}

	/**
	 * Constructs a new BarChartZeroLine for multiple dataSets.
	 * 
	 * @param zeroLine
	 *            list with float values between 0 and 1
	 * 
	 * @throws IllegalArgumentException
	 *             if zeroLine is {@code null} or empty or member is out of
	 *             range
	 */
	public BarChartZeroLine(List<Float> zeroLine) {

		if (zeroLine == null)
			throw new IllegalArgumentException("zeroLine can not be null");
		if (zeroLine.isEmpty())
			throw new IllegalArgumentException("zeroLine can not be empty");
		for (Float temp : zeroLine) {

			if (temp < 0 || temp > 1)
				throw new IllegalArgumentException(
						"zeroLine can not be < 0 and/or > 1");
		}

		this.dataSets = new LinkedList<Float>(zeroLine);
	}

	/**
	 * Returns the list of all zeroLine parameters.
	 * 
	 * @return the dataSets
	 */
	public List<Float> getDataSets() {
		return new LinkedList<Float>(dataSets);
	}

	/**
	 * Sets the list of zeroLine parameters.
	 * 
	 * @param zeroLine
	 *            the zeroLine to set
	 * 
	 * @throws IllegalArgumentException
	 *             if zeroLine is {@code null} or empty or member is out of
	 *             range
	 */
	public void setDataSets(List<Float> zeroLine) {
		if (zeroLine == null)
			throw new IllegalArgumentException("zeroLine can not be null");
		if (zeroLine.isEmpty())
			throw new IllegalArgumentException("zeroLine can not be empty");
		for (Float temp : zeroLine) {

			if (temp < 0 || temp > 1)
				throw new IllegalArgumentException(
						"zeroLine can not be < 0 and/or > 1");
		}
		this.dataSets = zeroLine;
	}

	public List<AppendableFeature> getAppendableFeatures(
			List<? extends IFeatureAppender> otherAppenders) {

		// this should not be
		if (this.dataSets.isEmpty()) {
			return new ArrayList<AppendableFeature>();
		}

		StringBuilder builder = new StringBuilder();

		for (Float temp : this.dataSets) {

			builder.append(temp);
			builder.append(",");
		}

		List<AppendableFeature> feature = new ArrayList<AppendableFeature>();

		feature.add(new AppendableFeature(builder.substring(0,
				builder.length() - 1), ChartTypeFeature.ChartData));

		return feature;

	}

}
