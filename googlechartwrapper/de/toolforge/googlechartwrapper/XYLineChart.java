package de.toolforge.googlechartwrapper;



import java.util.List;

import de.toolforge.googlechartwrapper.coder.DataScalingTextEncoder;
import de.toolforge.googlechartwrapper.coder.IEncoder;
import de.toolforge.googlechartwrapper.data.DataScalingSet;
import de.toolforge.googlechartwrapper.data.XYLineChartData;
import de.toolforge.googlechartwrapper.data.XYLineChartDataAppender;
import de.toolforge.googlechartwrapper.interfaces.IEncodeable;

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
 * XYLineChart chart = new XYLineChart(new Dimension(300,300));
 * 
 * Pair<List<Float>, List<Float>> values1 = new Pair<List<Float>, List<Float>>(Arrays.asList(10f,20f,30f),Arrays.asList(34f,12f,89f));
 * 		
 * XYLineChartData data = new XYLineChartData.XYLineChartDataBuilder(values1).color(Color.BLACK).build();
 * 
 * chart.addXYLineChartData(data);
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
	 * 
	 * @deprecated use {@link #XYLineChart(Dimension)}
	 */
	@Deprecated
	public XYLineChart(java.awt.Dimension awtChartDimension) {
		super(awtChartDimension);

	}
	
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
	 * @return removed line chart data object at the given index
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
	 * @param xyLineChartData line chart data to remove
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
