package googlechartwrapper;

import googlechartwrapper.coder.DataScalingTextEncoder;
import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.data.DataScalingSet;
import googlechartwrapper.data.LineChartData;
import googlechartwrapper.data.LineChartDataAppender;

import java.awt.Dimension;
import java.util.List;

/**
 * Specifies a line chart <a href="http://code.google.com/apis/chart/types.html#line_charts">
 * http://code.google.com/apis/chart/types.html#line_charts</a>
 * 
 * @author steffan
 * 
 */
public class LineChart extends AbstractLineChart {

	protected LineChartDataAppender lineChartDataAppender = new LineChartDataAppender();

	private ChartType type = ChartType.LineChart;

	public LineChart(Dimension chartDimension) {
		super(chartDimension);
	}

	public void addLineChartData(LineChartData data) {
		this.lineChartDataAppender.addLineChartData(data);
	}

	public void addLineChartData(List<LineChartData> data) {
		this.lineChartDataAppender.addLineChartData(data);
	}

	public boolean isSparkline() {
		return (ChartType.SparkLine.equals(type));
	}

	public boolean isLineChart() {
		return (ChartType.LineChart.equals(type));
	}

	public void setLineChart() {
		this.type = ChartType.LineChart;
	}

	public void setSparkline() {
		this.type = ChartType.SparkLine;
	}

	@Override
	protected ChartType getChartType() {
		return type;

	}

	@Override
	protected String getUrlChartType() {

		return type.getPrefix();

	}

	@Override
	public IEncoder getEncoder() {
		
		return this.lineChartDataAppender.getEncoder();
	}
	
	@Override
	public void addDataScalingSet(DataScalingSet ds) {
		this.dataScalingAppender.add(ds);
		this.lineChartDataAppender.setEncoder(new DataScalingTextEncoder());
	}
	
	@Override
	public void removeAllDataScalings() {

		this.dataScalingAppender.removeAll();

		this.lineChartDataAppender.removeEncoder();
		
	}
	
}
