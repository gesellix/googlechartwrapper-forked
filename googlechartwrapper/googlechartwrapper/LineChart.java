package googlechartwrapper;

import googlechartwrapper.data.LineChartData;
import googlechartwrapper.data.LineChartDataAppender;

import java.awt.Dimension;
import java.util.List;

/**
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
		return (ChartType.SparkLine.equals(type));
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
}
