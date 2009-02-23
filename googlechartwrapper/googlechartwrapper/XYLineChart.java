/**
 * 
 */
package googlechartwrapper;

import googlechartwrapper.coder.DataScalingTextEncoder;
import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.data.DataScalingSet;
import googlechartwrapper.data.XYLineChartData;
import googlechartwrapper.data.XYLineChartDataAppender;

import java.awt.Dimension;
import java.util.List;

/**
 *  Specifies a line chart, especially with pairs of datasets <a href="http://code.google.com/apis/chart/types.html#line_charts">
 * http://code.google.com/apis/chart/types.html#line_charts</a>
 * 
 * @author steffan
 *
 */
public class XYLineChart extends AbstractLineChart{
	
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
	 * @param data - {@link XYLineChartData}
	 * 
	 * @throws IllegalArgumentException if data is {@code null}
	 */
	public void addXYLineChartData(XYLineChartData data){
		this.xyLineChartDataAppender.addXYLineChartData(data);
	}
	
	/**
	 * 
	 * @param data
	 * 
	 * @throws IllegalArgumentException if data is {@code null} and/or value is {@code null}
	 */
	public void addXYLineChartData(List<XYLineChartData> data){
		this.xyLineChartDataAppender.addXYLineChartData(data);
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
}
