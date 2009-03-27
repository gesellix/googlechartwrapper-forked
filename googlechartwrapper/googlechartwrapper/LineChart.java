package googlechartwrapper;

import googlechartwrapper.coder.DataScalingTextEncoder;
import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.data.DataScalingSet;
import googlechartwrapper.data.LineChartData;
import googlechartwrapper.data.LineChartDataAppender;
import googlechartwrapper.interfaces.IEncodeable;

import java.awt.Dimension;
import java.util.List;

/**
 * Specifies a line chart <a href="http://code.google.com/apis/chart/types.html#line_charts">
 * http://code.google.com/apis/chart/types.html#line_charts</a>
 * 
 *  <p>
 * Here are some examples of how line chart can be used:
 * <p>
 * <blockquote>
 * 
 * <pre>
 * LineChart lineChart = new LineChart(new Dimension(300,300));
 * 
 * lineChart.addLineChartData(new LineChartData.LineChartDataBuilder(Arrays.asList(20f,30f,40f)).build());
 * 
 * lineChart.addShapeMarker(new ShapeMarker(MarkerTyp.Diamond,Color.BLUE,0,ShapeMarker.DataPoint.newDrawEachPoint(),10));
 * 		
 * </pre>
 * 
 * </blockquote>
 * <p>
 * @author steffan
 * @version 03/24/09
 * @see LineChartData
 * @see XYLineChart
 * @see AbstractLineChart
 * 
 */
public class LineChart extends AbstractLineChart implements IEncodeable {

	protected LineChartDataAppender lineChartDataAppender = new LineChartDataAppender();

	private ChartType type = ChartType.LineChart;

	/**
	 * Constructs a new {@link LineChart}
	 * 
	 * @param chartDimension
	 */
	public LineChart(Dimension chartDimension) {
		super(chartDimension);
	}
	/**
	 * Constructs a new {@link LineChart} with a single line.
	 * 
	 * @param chartDimension
	 * @param lineChartData {@link LineChartData}
	 * 
	 * @throws IllegalArgumentException if lineChartData is {@code null}
	 */
	public LineChart(Dimension chartDimension, LineChartData lineChartData) {
		super(chartDimension);
		
		this.lineChartDataAppender.addLineChartData(lineChartData);
	}
	
	/**
	 * Constructs a new {@link LineChart} with a list of {@link LineChartData}
	 * 
	 * @param chartDimension
	 * @param lineChartData
	 * 
	 * @throws IllegalArgumentException if lineChartData or member is {@code null}
	 */
	public LineChart(Dimension chartDimension, List<? extends LineChartData> lineChartData) {
		super(chartDimension);
	}

	/**
	 * Adds a new {@link LineChartData} to the list.
	 * 
	 * @param lineChartData
	 * 
	 * @throws IllegalArgumentException if lineChartData is {@code null}
	 */
	public void addLineChartData(LineChartData lineChartData) {
		this.lineChartDataAppender.addLineChartData(lineChartData);
	}

	/**
	 * Adds a list of {@link LineChartData} to the list.
	 * @param linechartData
	 * 
	 * @throws IllegalArgumentException if lineChartData or member is {@code null}
	 */
	public void addLineChartData(List<? extends LineChartData> lineChartData) {
		this.lineChartDataAppender.addLineChartData(lineChartData);
	}
	
	/**
	 * Removes a {@link LineChartData} at the given index.
	 * 
	 * @param index the list index
	 * @return the removed {@link LineChartData}
	 * 
	 * @throws IndexOutOfBoundsException if index is out of bound
	 */
	public LineChartData removeLineChartData(int index) {
		return this.lineChartDataAppender.removeLineChartData(index);
	}
	
	/**
	 * Removes a given {@link LineChartData} and returns the status.
	 * 
	 * @param lineChartData
	 * @return {@code true} if success
	 */
	public boolean removeLineChartData(LineChartData lineChartData) {

		return this.lineChartDataAppender.removeLineChartData(lineChartData);
	}
	
	/**
	 * Removes all {@link LineChartData}
	 */
	public void removeAllLineChartData() {
		this.lineChartDataAppender.removeAllLineChartData();
	}
	/**
	 * Returns a unmodifiable list of all {@link LineChartData}.
	 * 
	 * @return unmodifiable list, empty if nothing was set
	 */
	public List<? extends LineChartData> getAllLineChartData() {
		return this.lineChartDataAppender.getList();
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
	
	public void removeEncoder() {
		this.lineChartDataAppender.removeEncoder();
		
	}

	public void setEncoder(IEncoder encoder) {
		this.lineChartDataAppender.setEncoder(encoder);
		
	}
	
	
}
