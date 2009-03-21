package googlechartwrapper;

import googlechartwrapper.coder.AutoEncoder;
import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.coder.PercentageEncoder;
import googlechartwrapper.color.ChartColor;
import googlechartwrapper.data.PieChartSlice;
import googlechartwrapper.data.PieChartSliceAppender;
import googlechartwrapper.interfaces.IColorable;
import googlechartwrapper.util.GenericAppender;

import java.awt.Dimension;
import java.util.List;

/**
 * Specifies a PieChart <a
 * href="http://code.google.com/apis/chart/types.html#pie_charts">
 * http://code.google.com/apis/chart/types.html#pie_charts</a> <br />
 * For Concentric pie chart see {@link ConcentricPieChart}.
 * 
 * <p>
 * Here are some examples of how pie chart can be used:
 * <p>
 * <blockquote>
 * 
 * <pre>
 * PieChart chart = new PieChart(new Dimension(400, 180));
 * 
 * chart.setChartTitle(new ChartTitle(&quot;GDP of the world(nominal)&quot;));
 * 
 * chart.addPieChartSlice(new PieChartSlice.PieChartSliceBuilder(80).label(&quot;USA&quot;)
 * 		.color(Color.BLUE).build());
 * </pre>
 * 
 * </blockquote>
 * <p>
 * 
 * @author steffan
 * @version 03/18/09
 * @see PieChartSlice
 * @see ConcentricPieChart
 * @see AbstractPieChart
 * 
 */
public class PieChart extends AbstractPieChart implements IColorable{

	private ChartType type = ChartType.PieChart;

	protected PieChartSliceAppender pieChartSliceAppender = new PieChartSliceAppender();
	protected GenericAppender<ChartColor> chartColorAppender = new GenericAppender<ChartColor>(
			ChartTypeFeature.ChartColor, ",");

	/**
	 * Constructs a new pie chart.
	 * 
	 * @param chartDimension
	 */
	public PieChart(Dimension chartDimension) {
		super(chartDimension);
	}

	/**
	 * Constructs a new pie chart.
	 * 
	 * @param chartDimension
	 * @param pieChartSlices
	 *            a list of {@link PieChartSlice}
	 * 
	 * @throws IllegalArgumentException
	 *             if pieChatSlices is {@code null} or member
	 */
	public PieChart(Dimension chartDimension,
			List<? extends PieChartSlice> pieChartSlices) {
		super(chartDimension);

		this.pieChartSliceAppender.add(pieChartSlices);
	}

	/**
	 * Constructs a new pie chart with single slice.
	 * 
	 * @param pieChartSlice
	 *            a single slice {@link PieChartSlice}
	 * 
	 * @throws IllegalArgumentException
	 *             if pieChartSlice is {@code null}
	 */
	public PieChart(Dimension chartDimension, PieChartSlice pieChartSlice) {
		super(chartDimension);

		this.pieChartSliceAppender.add(pieChartSlice);
	}
	/**
	 * Adds a {@link PieChartSlice} to the {@link PieChart}.
	 * @param pieChartSlice
	 * 
	 * @throws IllegalArgumentException if pieChartSlice is {@code null}
	 */
	public void addPieChartSlice(PieChartSlice pieChartSlice) {
		this.pieChartSliceAppender.add(pieChartSlice);
	}
	
	/**
	 * Adds a list of {@link PieChartSlice} to the {@link PieChart}
	 * @param pieChartSlices
	 * 
	 * @throws IllegalArgumentException if list oder member is {@code null}
	 */
	public void addPieChartSlice(List<? extends PieChartSlice> pieChartSlices) {
		this.pieChartSliceAppender.add(pieChartSlices);
	}
	/**
	 * Removes a {@link PieChartSlice} at the given position.
	 * @param index
	 * @return the removed {@link PieChartSlice}
	 * 
	 * @throws IndexOutOfBoundsException if index is out of range
	 */
	public PieChartSlice removePieChartSlice(int index) {
		return this.pieChartSliceAppender.remove(index);
	}
	/**
	 * Removes a {@link PieChartSlice} object and returns the status
	 * @param pieChartSlice {@link PieChartSlice}
	 * 
	 * @return {@code true} if success
	 */
	public boolean removePieChartSlice(PieChartSlice pieChartSlice) {

		return this.pieChartSliceAppender.remove(pieChartSlice);
	}
	/**
	 * Removes all {@link PieChartSlice} from the {@link PieChart}
	 */
	public void removeAllPieChartSlices() {
		this.pieChartSliceAppender.removeAll();
	}
	/**
	 * Returns a unmodifiable list of all {@link PieChartSlice}.
	 * @return unmodifiable list, empty if nothing was set
	 */
	public List<? extends PieChartSlice> getAllPieChartSlices() {
		return this.pieChartSliceAppender.getList();
	}

	@Override
	protected ChartType getChartType() {

		return this.type;
	}

	@Override
	protected String getUrlChartType() {

		return this.type.getPrefix();
	}
	/**
	 * Returns the {@link PieChart} status, if it is three dimensional pie chart or not
	 * 
	 * @return {@code true} if 3d
	 */
	public boolean is3D() {
		return (ChartType.PieChart3d.equals(type));
	}
	/**
	 * Returns the {@link PieChart} status, if it is three dimensional pie chart or not
	 * 
	 * @return {@code true} if not 3d
	 */
	public boolean isDefault() {
		return (ChartType.PieChart.equals(type));
	}
	/**
	 * Enable the 3d status.
	 */
	public void set3D() {
		this.type = ChartType.PieChart3d;

	}
	/**
	 * Enable the default status.
	 */
	public void setDefault() {
		this.type = ChartType.PieChart;
	}
	/**
	 * Encode the values as percentages before, the api calculates the values. This can decrease the url length.
	 * DEFAULT is true.
	 */
	public void setPercentageScaling(boolean b) {

		if (b) {
			this.pieChartSliceAppender.setEncoder(new PercentageEncoder());
		} else {
			this.pieChartSliceAppender.setEncoder(new AutoEncoder());
		}

	}

	public IEncoder getEncoder() {

		return this.pieChartSliceAppender.getEncoder();
	}
	
	public void addChartColor(ChartColor cc) {

		this.chartColorAppender.add(cc);
	}

	public List<ChartColor> getChartColors() {

		return this.chartColorAppender.getList().size() > 0 ? this.chartColorAppender
				.getList()
				: null;
	}

	public void removeAllChartColors() {
		this.chartColorAppender.removeAll();

	}

	public ChartColor removeChartColor(int index) {

		return this.chartColorAppender.remove(index);
	}

	public boolean removeChartColor(ChartColor cc) {

		return this.chartColorAppender.remove(cc);
	}

}
