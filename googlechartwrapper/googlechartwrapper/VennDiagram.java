package googlechartwrapper;

import googlechartwrapper.coder.DataScalingTextEncoder;
import googlechartwrapper.coder.Encoder;
import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.color.ChartColors;
import googlechartwrapper.color.IChartColorable;
import googlechartwrapper.color.LinearGradient;
import googlechartwrapper.color.LinearStripes;
import googlechartwrapper.data.DataScaling;
import googlechartwrapper.data.VennDiagramAppender;
import googlechartwrapper.data.VennDiagramData;
import googlechartwrapper.interfaces.ILinearable;
import googlechartwrapper.label.ChartLegend;
import googlechartwrapper.label.ChartTitle;
import googlechartwrapper.label.IChartLegendable;
import googlechartwrapper.util.GenericAppender;
import googlechartwrapper.util.UpperLimitGenericAppender;
import googlechartwrapper.util.UpperLimitGenericAppender.UpperLimitReactions;

import java.awt.Dimension;
import java.util.List;

/**
 * Specifies a venn diagram <a href="http://code.google.com/apis/chart/#venn">
 * http://code.google.com/apis/chart/#venn</a>
 * 
 * @author steffan
 * 
 */
public class VennDiagram extends AbstractChart implements ILinearable,
		IChartLegendable, IChartColorable {

	protected UpperLimitGenericAppender<LinearGradient> linearGradientAppender = new UpperLimitGenericAppender<LinearGradient>(
			ChartTypeFeature.LinearGradient, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<LinearStripes> linearStripesAppender = new UpperLimitGenericAppender<LinearStripes>(
			ChartTypeFeature.LinearStripes, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<ChartTitle> chartTitleAppender = new UpperLimitGenericAppender<ChartTitle>(
			ChartTypeFeature.ChartTitle, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<ChartLegend> chartLegendAppender = new UpperLimitGenericAppender<ChartLegend>(
			ChartTypeFeature.ChartLegend, 1, UpperLimitReactions.RemoveFirst);
	protected VennDiagramAppender vennDiagramAppender = new VennDiagramAppender();
	protected GenericAppender<ChartColors> chartColorAppender = new GenericAppender<ChartColors>(
			ChartTypeFeature.ChartColor, ",");
	protected UpperLimitGenericAppender<DataScaling> dataScalingAppender = new UpperLimitGenericAppender<DataScaling>(
			ChartTypeFeature.DataScaling, 1, UpperLimitReactions.RemoveFirst);

	/**
	 * Constructs a venn diagram
	 * 
	 * @param chartDimension
	 *            the size of the diagram
	 */
	public VennDiagram(Dimension chartDimension) {
		super(chartDimension);

	}

	@Override
	protected ChartType getChartType() {

		return ChartType.VennDiagram;
	}

	@Override
	protected String getUrlChartType() {

		return "v";
	}

	public void removeLinearGradient() {
		this.linearGradientAppender.removeAll();

	}

	public void setLinearGradient(LinearGradient lg) {
		this.linearGradientAppender.add(lg);

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

	public void removeLinearStripes() {
		this.linearStripesAppender.removeAll();

	}

	public void setLinearStripes(LinearStripes ls) {
		this.linearStripesAppender.add(ls);

	}

	public IEncoder getEncoder() {
		return this.vennDiagramAppender.getEncoder();
	}

	public ChartTitle getChartTitle() {

		if (this.chartTitleAppender.getList().size() > 0) {
			return this.chartTitleAppender.getList().get(0);
		} else {
			return null;
		}
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
		this.chartLegendAppender.add(legend);

	}

	public VennDiagramData getVennDiagramData() {

		return this.vennDiagramAppender.getVennDiagrammData();
	}

	public void setVennDiagramData(VennDiagramData data) {

		this.vennDiagramAppender.setVennDiagrammData(data);
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

	public DataScaling getDataScaling() {

		return this.dataScalingAppender.getList().size() > 0 ? this.dataScalingAppender
				.getList().get(0)
				: null;
	}

	public void setDataScaling(DataScaling ds) {	
			
		this.dataScalingAppender.add(ds);
		
		if(ds != null)
			this.vennDiagramAppender.setEncoder(new DataScalingTextEncoder());

	}

	public LinearStripes getLinearStripes() {
		
		return this.linearStripesAppender.getList().size() > 0 ? this.linearStripesAppender.getList().get(0) : null;
	}

	public LinearGradient getLinearGradient() {
		
		return this.linearGradientAppender.getList().size() > 0 ? this.linearGradientAppender.getList().get(0) : null;
	}

	public void removeDataScaling() {
		
		this.dataScalingAppender.removeAll();
		
		this.vennDiagramAppender.setEncoder(new Encoder());
		
	}

}
