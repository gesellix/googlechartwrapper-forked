package googlechartwrapper;

import googlechartwrapper.coder.DataScalingTextEncoder;
import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.data.DataScalingSet;
import googlechartwrapper.data.XYLineChartData;
import googlechartwrapper.data.XYLineChartDataAppender;
import googlechartwrapper.interfaces.IEncodeable;

import java.awt.Dimension;
import java.util.List;

/**
 * Specifies a line chart, especially with pairs of datasets <a
 * href="http://code.google.com/apis/chart/types.html#line_charts">
 * http://code.google.com/apis/chart/types.html#line_charts</a>
 * 
 * <p>
 * Here are some examples of how xyline chart can be used:
 * <p>
 * <blockquote>
 * 
 * <pre>
 * LineChart lineChart = new LineChart(new Dimension(300, 300));
 * 
 * lineChart.addLineChartData(new LineChartData.LineChartDataBuilder(Arrays
 * 		.asList(20f, 30f, 40f)).build());
 * 
 * lineChart.addShapeMarker(new ShapeMarker(MarkerTyp.Diamond, Color.BLUE, 0,
 * 		ShapeMarker.DataPoint.newDrawEachPoint(), 10));
 * 
 * </pre>
 * 
 * </blockquote>
 * <p>
 * 
 * @author steffan
 * @version 03/25/09
 * @see XYLineChartData
 * @see LineChart
 * @see AbstractLineChart
 * 
 */
public class XYLineChart extends AbstractLineChart implements IEncodeable {

	protected XYLineChartDataAppender xyLineChartDataAppender = new XYLineChartDataAppender();

	/**
	 * Constructs a new XYLineChart.
	 * 
	 * @param chartDimension
	 */
	public XYLineChart(Dimension chartDimension) {
		super(chartDimension);

	}

	/**
	 * Adds a {@link XYLineChartData}.
	 * 
	 * @param data
	 *            - {@link XYLineChartData}
	 * 
	 * @throws IllegalArgumentException
	 *             if data is {@code null}
	 */
	public void addXYLineChartData(XYLineChartData data) {
		this.xyLineChartDataAppender.addXYLineChartData(data);
	}

	/**
	 * Adds a list of {@link XYLineChartData}.
	 * 
	 * @param data
	 * 
	 * @throws IllegalArgumentException
	 *             if data is {@code null} and/or value is {@code null}
	 */
	public void addXYLineChartData(List<? extends XYLineChartData> data) {
		this.xyLineChartDataAppender.addXYLineChartData(data);
	}

	/**
	 * Removes a {@link XYLineChartData} at the given position.
	 * 
	 * @param index
	 * @return
	 * 
	 * @throws IndexOutOfBoundsException
	 *             if index is out of bound
	 */
	public XYLineChartData removeXYLineChartData(int index) {
		return this.xyLineChartDataAppender.removeXYLineChartData(index);
	}

	/**
	 * Removes a given {@link XYLineChartData} and returns the status.
	 * 
	 * @param XYLineChartData
	 * @return {@code true} if success
	 */
	public boolean removeXYLineChartData(XYLineChartData xyLineChartData) {

		return this.xyLineChartDataAppender
				.removeXYLineChartData(xyLineChartData);
	}

	/**
	 * Removes all {@link XYLineChartData}
	 */
	public void removeAllXYLineChartData() {
		this.xyLineChartDataAppender.removeAllXYLineChartData();
	}

	@Override
	protected ChartType getChartType() {

		return ChartType.LineChartPair;
	}

	@Override
	protected String getUrlChartType() {

		return ChartType.LineChartPair.getPrefix();
	}

	@Override
	public IEncoder getEncoder() {

		return this.xyLineChartDataAppender.getEncoder();
	}

	@Override
	public void addDataScalingSet(DataScalingSet ds) {
		this.dataScalingAppender.add(ds);
		this.xyLineChartDataAppender.setEncoder(new DataScalingTextEncoder());
	}

	@Override
	public void removeAllDataScalings() {

		this.dataScalingAppender.removeAll();

		this.xyLineChartDataAppender.removeEncoder();

	}

	public void removeEncoder() {
		this.xyLineChartDataAppender.removeEncoder();

	}

	public void setEncoder(IEncoder encoder) {
		this.xyLineChartDataAppender.setEncoder(encoder);

	}
}
