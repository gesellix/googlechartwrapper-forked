package googlechartwrapper;

import googlechartwrapper.coder.AutoEncoder;
import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.coder.PercentageEncoder;
import googlechartwrapper.color.ChartColors;
import googlechartwrapper.color.ILinearGradientable;
import googlechartwrapper.color.ILinearStripeable;
import googlechartwrapper.color.ISolidFillable;
import googlechartwrapper.color.LinearGradient;
import googlechartwrapper.color.LinearStripes;
import googlechartwrapper.color.SolidFill;
import googlechartwrapper.color.LinearGradient.GradientFillDestination;
import googlechartwrapper.color.LinearStripes.LinearStripesDestination;
import googlechartwrapper.data.PieChartSlice;
import googlechartwrapper.data.PieChartSliceAppender;
import googlechartwrapper.interfaces.IColorable;
import googlechartwrapper.interfaces.IPercentageScaleable;
import googlechartwrapper.label.ChartLegend;
import googlechartwrapper.label.ChartTitle;
import googlechartwrapper.label.IChartLegendable;
import googlechartwrapper.label.IChartTitleable;
import googlechartwrapper.util.GenericAppender;
import googlechartwrapper.util.UpperLimitGenericAppender;
import googlechartwrapper.util.UpperLimitGenericAppender.UpperLimitReactions;

import java.awt.Dimension;
import java.util.List;

/**
 * Specifies a PieChart
 * @author martin
 * @author steffan
 *
 */
public class PieChart extends AbstractChart implements ISolidFillable,
		ILinearGradientable, ILinearStripeable, IChartTitleable, IPercentageScaleable, IColorable, IChartLegendable{

	private boolean threeD;
	protected PieChartSliceAppender dataAppender = new PieChartSliceAppender();
	protected GenericAppender<SolidFill> solidFillAppender = new GenericAppender<SolidFill>(
			ChartTypeFeature.SolidFill);
	protected UpperLimitGenericAppender<LinearGradient> linearGradientAppender = new UpperLimitGenericAppender<LinearGradient>(
			ChartTypeFeature.LinearGradient, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<LinearStripes> linearStripesAppender = new UpperLimitGenericAppender<LinearStripes>(
			ChartTypeFeature.LinearStripes, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<ChartTitle> chartTitleAppender = new UpperLimitGenericAppender<ChartTitle>(
			ChartTypeFeature.ChartTitle, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<ChartLegend> chartLegendAppender = new UpperLimitGenericAppender<ChartLegend>(
			ChartTypeFeature.ChartLegend, 1, UpperLimitReactions.RemoveFirst);
	protected GenericAppender<ChartColors> chartColorAppender = new GenericAppender<ChartColors>(
			ChartTypeFeature.ChartColor, ",");

	public PieChart(Dimension chartDimension, boolean threeD) {
		super(chartDimension);
		this.threeD = threeD;
	}

	@Override
	protected ChartType getChartType() {
		return ChartType.PieChart;
	}

	@Override
	protected String getUrlChartType() {
		return threeD ? "p3" : "p";
	}

	/**
	 * Returns if the chart is displayed 3-dimensional or 2-dimensional.
	 * 
	 * @return <code>true</code> if chart is displayed 3-dimensional;
	 *         <code>false</code> otherwise
	 */
	public boolean isThreeD() {
		return threeD;
	}

	/**
	 * Sets whether the chart is displayed 3-dimensional or not.
	 * 
	 * @param threeD
	 *            <code>true</code> if chart is displayed 3-dimensional;
	 *            <code>false</code> otherwise
	 */
	public void setThreeD(boolean threeD) {
		this.threeD = threeD;
	}

	/**
	 * Adds a slice to the chart. The data values are transformed into
	 * percentages by the API. If some slices have a color set and others don't,
	 * the color of the slices is interpolated.
	 * 
	 * @param slice
	 */
	public void addPieChartSlice(PieChartSlice slice) {
		dataAppender.add(slice);
	}

	public boolean removePieChartSlice(PieChartSlice slice) {
		return dataAppender.remove(slice);
	}

	public PieChartSlice removePieChartSlice(int index) {
		return dataAppender.remove(index);
	}

	public void removeAllPieChartSlices() {
		dataAppender.removeAll();
	}

	public List<? extends PieChartSlice> getAllPieChartSlices() {
		return dataAppender.getList();
	}

	public IEncoder getEncoder() {
		return dataAppender.getEncoder();
	}

	public void setEncoder(IEncoder encoder) {
		dataAppender.setEncoder(encoder);
	}

	public void addSolidFill(SolidFill sf) {
		this.solidFillAppender.add(sf);

	}

	public List<SolidFill> getSolidFills() {

		return this.solidFillAppender.getList();
	}

	public void removeAllSolidFills() {
		this.solidFillAppender.removeAll();

	}

	public SolidFill removeSolidFill(int index) {
		return this.solidFillAppender.remove(index);
	}

	public boolean removeSolidFill(SolidFill sf) {
		return this.solidFillAppender.remove(sf);
	}

	public void removeLinearGradient() {
		linearGradientAppender.removeAll();
	}

	public void setLinearGradient(LinearGradient lg) {
		if (lg == null) {
			linearGradientAppender.removeAll();
			return;
		}
		if (!lg.getFillDestination().equals(GradientFillDestination.Background)) {
			throw new IllegalArgumentException("only GradientFillDestination"
					+ ".Background supported");
		}
		this.linearGradientAppender.add(lg);
	}

	public void removeLinearStripes() {
		linearStripesAppender.removeAll();
	}

	public void setLinearStripes(LinearStripes ls) {
		if (ls == null) {
			linearStripesAppender.removeAll();
			return;
		}
		if (!ls.getFillDestination()
				.equals(LinearStripesDestination.Background)) {
			throw new IllegalArgumentException("only LinearStripesDestination"
					+ ".Background supported");
		}
		this.linearStripesAppender.add(ls);
	}

	public void removeChartTitle() {
		this.chartTitleAppender.removeAll();

	}

	public void setChartTitle(ChartTitle title) {
		if (title == null) {
			removeChartTitle();
			return;
		}
		this.chartTitleAppender.add(title);

	}

	public ChartTitle getChartTitle() {

		if (this.chartTitleAppender.getList().size() > 0) {
			return this.chartTitleAppender.getList().get(0);

		} else {
			return null;
		}

	}
	
	public LinearStripes getLinearStripes() {

		return this.linearStripesAppender.getList().size() > 0 ? this.linearStripesAppender.getList().get(0) : null;
	}

	public LinearGradient getLinearGradient() {
		
		return this.linearGradientAppender.getList().size() > 0 ? this.linearGradientAppender.getList().get(0) : null;
	}
	
	public void setPercentageScaling(boolean b) {

		if (b) {
			this.dataAppender.setEncoder(new PercentageEncoder());
		} else {
			this.dataAppender.setEncoder(new AutoEncoder());
		}
		
	}

	public void addChartColor(ChartColors cc) {

		this.chartColorAppender.add(cc);
	}

	public List<ChartColors> getChartColors() {

		return this.chartColorAppender.getList().size() > 0 ? this.chartColorAppender
				.getList()
				: null;
	}

	public void removeAllChartColors() {
		this.chartColorAppender.removeAll();

	}

	public ChartColors removeChartColors(int index) {

		return this.chartColorAppender.remove(index);
	}

	public boolean removeChartColors(ChartColors cc) {

		return this.chartColorAppender.remove(cc);
	}

	public ChartLegend getChartLegend() {

		if (this.chartLegendAppender.getList().size() > 0) {
			return this.chartLegendAppender.getList().get(0);
		} else {
			return null;
		}
	}

	public void removeChartLegend() {
		this.chartLegendAppender.removeAll();

	}

	public void setChartLegend(ChartLegend legend) {
		
		if(legend == null){
			this.removeChartLegend();
		}
		this.chartLegendAppender.add(legend);

	}

}
