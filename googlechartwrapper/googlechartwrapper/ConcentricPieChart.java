package googlechartwrapper;

import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.data.ConcentricPieChartAppender;
import googlechartwrapper.data.ConcentricPieChartSlice;
import googlechartwrapper.data.ConcentricPieChartSlice.ConcentricPieChartSliceBuilder;

import java.awt.Dimension;
import java.util.List;

/**
 * 
 * @author steffan
 * 
 * @see ConcentricPieChartSlice
 * @see ConcentricPieChartSliceBuilder
 * 
 */
public class ConcentricPieChart extends AbstractPieChart {

	protected ConcentricPieChartAppender concentricPieChartAppender = new ConcentricPieChartAppender();

	/**
	 * 
	 * @param chartDimension
	 */
	public ConcentricPieChart(Dimension chartDimension) {
		super(chartDimension);

	}

	/**
	 * 
	 * @param chartDimension
	 * @param concentricPieChartSlices
	 */
	public ConcentricPieChart(Dimension chartDimension,
			List<? extends ConcentricPieChartSlice> concentricPieChartSlices) {
		super(chartDimension);

		this.concentricPieChartAppender.add(concentricPieChartSlices);

	}

	/**
	 * 
	 * @param chartDimension
	 * @param concentricPieChartSlice
	 */
	public ConcentricPieChart(Dimension chartDimension,
			ConcentricPieChartSlice concentricPieChartSlice) {
		super(chartDimension);

		this.concentricPieChartAppender.add(concentricPieChartSlice);

	}

	/**
	 * 
	 * @param concentricPieChartSlices
	 */
	public void addConcentricPieChartSlice(
			List<? extends ConcentricPieChartSlice> concentricPieChartSlices) {

		this.concentricPieChartAppender.add(concentricPieChartSlices);
	}

	/**
	 * 
	 * @param concentricPieChartSlice
	 */
	public void addConcentricPieChartSlice(
			ConcentricPieChartSlice concentricPieChartSlice) {

		this.concentricPieChartAppender.add(concentricPieChartSlice);
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	public ConcentricPieChartSlice removeConcentricPieChartSlice(int index) {
		return this.concentricPieChartAppender
				.removeConcentricPieChartSlice(index);
	}

	/**
	 * 
	 * @param concentricPieChartSlice
	 * @return
	 */
	public boolean removeConcentricPieChartSlice(
			ConcentricPieChartSlice concentricPieChartSlice) {

		return this.concentricPieChartAppender
				.removeConcentricPieChartSlice(concentricPieChartSlice);
	}

	/**
	 * 
	 */
	public void removeAllPieChartSlices() {
		this.concentricPieChartAppender.removeAllConcentricPieChartSlice();
	}

	@Override
	protected String getUrlChartType() {

		return ChartType.PieChartConcentric.getPrefix();
	}

	@Override
	protected ChartType getChartType() {

		return ChartType.PieChartConcentric;
	}

	public void setPercentageScaling(boolean b) {
		// TODO Auto-generated method stub

	}

	public IEncoder getEncoder() {

		return this.concentricPieChartAppender.getEncoder();
	}

}
