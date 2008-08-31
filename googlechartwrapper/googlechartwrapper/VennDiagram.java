package googlechartwrapper;

import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.color.LinearGradient;
import googlechartwrapper.color.LinearStripes;
import googlechartwrapper.data.ChartData;
import googlechartwrapper.data.IChartDataable;
import googlechartwrapper.interfaces.ILinearable;
import googlechartwrapper.label.ChartLegend;
import googlechartwrapper.label.ChartTitle;
import googlechartwrapper.label.IChartLegendable;
import googlechartwrapper.util.UpperLimitGenericAppender;
import googlechartwrapper.util.UpperLimitGenericAppender.UpperLimitReactions;

import java.awt.Dimension;

/**
 * Specifies a venn diagram <a href="http://code.google.com/apis/chart/#venn">
 * http://code.google.com/apis/chart/#venn</a>
 * 
 * @author steffan
 * 
 */
public class VennDiagram extends AbstractChart implements ILinearable, IChartLegendable, IChartDataable {

	protected UpperLimitGenericAppender<LinearGradient> linearGradientAppender = new UpperLimitGenericAppender<LinearGradient>(
			ChartTypeFeature.LinearGradient, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<LinearStripes> linearStripesAppender = new UpperLimitGenericAppender<LinearStripes>(
			ChartTypeFeature.LinearStripes, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<ChartTitle> chartTitleAppender = new UpperLimitGenericAppender<ChartTitle>(
			ChartTypeFeature.ChartTitle, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<ChartLegend> chartLegendAppender = new UpperLimitGenericAppender<ChartLegend>(
			ChartTypeFeature.ChartLegend, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<ChartData> chartDataAppender = new UpperLimitGenericAppender<ChartData>(
			ChartTypeFeature.ChartData, 1, UpperLimitReactions.RemoveFirst);

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
		// TODO Auto-generated method stub
		return null;
	}

	public ChartTitle getChartTitle() {

		if (this.chartTitleAppender.getList().size() > 0) {
			return this.chartTitleAppender.getList().get(0);
		} else {
			return null;
		}
	}

	public ChartLegend getChartLegend() {
		
		if(this.chartLegendAppender.getList().size() > 0){
		return this.chartLegendAppender.getList().get(0);
		}
		else{
			return null;
		}
	}

	public void removeChartLegend() {
		this.chartLegendAppender.removeAll();
		
	}

	public void setChartLegend(ChartLegend legend) {
		this.chartLegendAppender.add(legend);
		
	}

	public ChartData getChartData() {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeChartData() {
		// TODO Auto-generated method stub
		
	}

	public void setChartData(ChartData cd) {
		
		this.chartDataAppender.add(cd);
		
	}

}
