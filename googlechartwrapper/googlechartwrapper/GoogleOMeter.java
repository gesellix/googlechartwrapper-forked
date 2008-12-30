package googlechartwrapper;

import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.color.ChartColors;
import googlechartwrapper.color.ISolidFillable;
import googlechartwrapper.color.LinearGradient;
import googlechartwrapper.color.LinearStripes;
import googlechartwrapper.color.SolidFill;
import googlechartwrapper.color.LinearGradient.GradientFillDestination;
import googlechartwrapper.color.LinearStripes.LinearStripesDestination;
import googlechartwrapper.color.SolidFill.ChartFillDestination;
import googlechartwrapper.data.DataScalingSet;
import googlechartwrapper.data.GoogleOMeterValue;
import googlechartwrapper.data.GoogleOMeterValueAppender;
import googlechartwrapper.data.ISingleDataScaleable;
import googlechartwrapper.interfaces.IColorable;
import googlechartwrapper.interfaces.ILinearable;
import googlechartwrapper.label.ChartLegend;
import googlechartwrapper.label.ChartTitle;
import googlechartwrapper.label.IChartLegendable;
import googlechartwrapper.style.ChartMargin;
import googlechartwrapper.util.GenericAppender;
import googlechartwrapper.util.UpperLimitGenericAppender;
import googlechartwrapper.util.UpperLimitGenericAppender.UpperLimitReactions;

import java.awt.Dimension;
import java.util.List;

/**
 * Specifies a GoogleOMeter
 * 
 * @author mart
 * @author steffan
 * 
 */
public class GoogleOMeter extends AbstractChart implements ISolidFillable,
		ISingleDataScaleable, ILinearable, IChartLegendable, IColorable{

	protected GenericAppender<SolidFill> solidFillAppender = new GenericAppender<SolidFill>(
			ChartTypeFeature.SolidFill);
	protected GoogleOMeterValueAppender valueAppender = new GoogleOMeterValueAppender();
	protected UpperLimitGenericAppender<DataScalingSet> dataScalingAppender = new UpperLimitGenericAppender<DataScalingSet>(
			ChartTypeFeature.DataScaling, 1, UpperLimitReactions.RemoveAll, ",");
	protected UpperLimitGenericAppender<ChartTitle> chartTitleAppender = new UpperLimitGenericAppender<ChartTitle>(
			ChartTypeFeature.ChartTitle, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<ChartLegend> chartLegendAppender = new UpperLimitGenericAppender<ChartLegend>(
			ChartTypeFeature.ChartLegend, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<LinearGradient> linearGradientAppender = new UpperLimitGenericAppender<LinearGradient>(
			ChartTypeFeature.LinearGradient, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<LinearStripes> linearStripesAppender = new UpperLimitGenericAppender<LinearStripes>(
			ChartTypeFeature.LinearStripes, 1, UpperLimitReactions.RemoveFirst);
	protected GenericAppender<ChartColors> chartColorAppender = new GenericAppender<ChartColors>(
			ChartTypeFeature.ChartColor, ",");
	protected UpperLimitGenericAppender<ChartMargin> chartMarginAppender = new UpperLimitGenericAppender<ChartMargin>(
			ChartTypeFeature.ChartMargin, 1, UpperLimitReactions.RemoveFirst);
	
	public GoogleOMeter(Dimension chartDimension) {
		super(chartDimension);
	}

	@Override
	protected ChartType getChartType() {
		return ChartType.GoogleOMeter;
	}

	@Override
	protected String getUrlChartType() {
		return ChartType.GoogleOMeter.getPrefix();
	}

	public void addSolidFill(SolidFill sf) {
		if (!sf.getChartFillDestination().equals(
				ChartFillDestination.Background)) {
			throw new IllegalArgumentException("only SolidFill "
					+ "ChartFillDestination.Background allowed");
		}
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

	public void addGoogleOMeterValue(GoogleOMeterValue value) {
		valueAppender.add(value);
	}

	public List<GoogleOMeterValue> getGoogleOMeterValues() {
		return this.valueAppender.getList();
	}

	public void removeAllGoogleOMeterValues() {
		this.valueAppender.removeAll();
	}

	public GoogleOMeterValue removeGoogleOMeterValue(int index) {
		return this.valueAppender.remove(index);
	}

	public boolean removeGoogleOMeterValue(GoogleOMeterValue sf) {
		return this.valueAppender.remove(sf);
	}

	public DataScalingSet getDataScaling() {
		return dataScalingAppender.getListSize() > 0 ? dataScalingAppender
				.getList().get(0) : null;
	}

	public void removeDataScaling() {
		dataScalingAppender.removeAll();
	}

	public void setDataScaling(DataScalingSet ds) {
		if (ds == null) {
			dataScalingAppender.removeAll();
			return;
		}
		dataScalingAppender.add(ds);
	}

	public IEncoder getEncoder() {
		
		return this.valueAppender.getEncoder();
	}

	public LinearGradient getLinearGradient() {

		return this.linearGradientAppender.getList().size() > 0 ? this.linearGradientAppender
				.getList().get(0)
				: null;
	}

	public void removeLinearGradient() {
		this.linearGradientAppender.removeAll();

	}

	/**
	 * {@inheritDoc} The GoogleOMeter supports only Background as
	 * FillDestination.
	 */
	public void setLinearGradient(LinearGradient lg) {

		if (lg == null) {
			this.removeLinearGradient();
		} else {
			if (!lg.getFillDestination().equals(
					GradientFillDestination.Background))
				throw new IllegalArgumentException("only LinearGradient "
						+ "GradientFillDestination.Background allowed");

			this.linearGradientAppender.add(lg);
		}

	}

	public ChartTitle getChartTitle() {

		if (this.chartTitleAppender.getList().size() > 0) {
			return this.chartTitleAppender.getList().get(0);
		} else {
			return null;
		}
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

	public LinearStripes getLinearStripes() {

		return this.linearStripesAppender.getList().size() > 0 ? this.linearStripesAppender
				.getList().get(0)
				: null;
	}

	public void removeLinearStripes() {
		this.linearStripesAppender.removeAll();

	}

	/**
	 * {@inheritDoc}
	 * The GoogleOMeter supports only Background as
	 * FillDestination.
	 * 
	 */
	public void setLinearStripes(LinearStripes ls) {

		if (ls == null) {
			this.removeLinearStripes();
		} else {
			
			if (!ls.getFillDestination().equals(
					LinearStripesDestination.Background))
				throw new IllegalArgumentException("only Linearstripes "
						+ "LinearStripesDestination.Background allowed");

			this.linearStripesAppender.add(ls);
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
		
		if(legend == null){
			this.removeChartLegend();
		}
		this.chartLegendAppender.add(legend);

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
	public ChartMargin getChartMargin() {
		return this.chartMarginAppender.getList().size() > 0 ? this.chartMarginAppender
				.getList().get(0)
				: null;
	}

	public void removeChartMargin() {
		this.chartMarginAppender.removeAll();

	}

	public void setChartMargin(ChartMargin cm) {
		if (cm == null) {
			this.chartMarginAppender.removeAll();
		} else {
			this.chartMarginAppender.add(cm);
		}
	}
}
