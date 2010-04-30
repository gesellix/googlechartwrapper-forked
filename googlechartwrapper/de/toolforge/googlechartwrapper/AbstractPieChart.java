package de.toolforge.googlechartwrapper;



import java.util.List;

import de.toolforge.googlechartwrapper.color.ISolidFillable;
import de.toolforge.googlechartwrapper.color.LinearGradient;
import de.toolforge.googlechartwrapper.color.LinearStripe;
import de.toolforge.googlechartwrapper.color.SolidFill;
import de.toolforge.googlechartwrapper.color.LinearGradient.GradientFillDestination;
import de.toolforge.googlechartwrapper.color.LinearStripe.LinearStripesDestination;
import de.toolforge.googlechartwrapper.data.PieChartSlice;
import de.toolforge.googlechartwrapper.interfaces.ILinearable;
import de.toolforge.googlechartwrapper.interfaces.IPercentageScaleable;
import de.toolforge.googlechartwrapper.label.ChartLegend;
import de.toolforge.googlechartwrapper.label.ChartLegendPositionContainer;
import de.toolforge.googlechartwrapper.label.ChartTitle;
import de.toolforge.googlechartwrapper.label.IChartLegendable;
import de.toolforge.googlechartwrapper.style.ChartMargin;
import de.toolforge.googlechartwrapper.util.GenericAppender;
import de.toolforge.googlechartwrapper.util.PrimitivesAppender;
import de.toolforge.googlechartwrapper.util.UpperLimitGenericAppender;
import de.toolforge.googlechartwrapper.util.UpperLimitGenericAppender.UpperLimitReactions;

/**
 * Specifies a abstract class for the PieChart <a
 * href="http://code.google.com/intl/de-DE/apis/chart/types.html#pie_charts">
 * http://code.google.com/intl/de-DE/apis/chart/types.html#pie_charts</a>
 * 
 * 
 * @author martin
 * @author steffan
 * @version 03/18/09
 * @see PieChartSlice
 * @see PieChart
 * @see ConcentricPieChart
 * 
 */
public abstract class AbstractPieChart extends AbstractChart implements
		ISolidFillable, IPercentageScaleable, IChartLegendable,
		ILinearable {

	protected GenericAppender<SolidFill> solidFillAppender = new GenericAppender<SolidFill>(
			ChartTypeFeature.SolidFill);
	protected UpperLimitGenericAppender<LinearGradient> linearGradientAppender = new UpperLimitGenericAppender<LinearGradient>(
			ChartTypeFeature.LinearGradient, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<LinearStripe> linearStripesAppender = new UpperLimitGenericAppender<LinearStripe>(
			ChartTypeFeature.LinearStripes, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<ChartTitle> chartTitleAppender = new UpperLimitGenericAppender<ChartTitle>(
			ChartTypeFeature.ChartTitle, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<ChartLegend> chartLegendAppender = new UpperLimitGenericAppender<ChartLegend>(
			ChartTypeFeature.ChartLegend, 1, UpperLimitReactions.RemoveFirst);	
	protected UpperLimitGenericAppender<ChartMargin> chartMarginAppender = new UpperLimitGenericAppender<ChartMargin>(
			ChartTypeFeature.ChartMargin, 1, UpperLimitReactions.RemoveFirst);
	protected PrimitivesAppender<Float> pieChartOrientationAppender = new PrimitivesAppender<Float>(
			ChartTypeFeature.PieChartOrientation);
	protected UpperLimitGenericAppender<ChartLegendPositionContainer> chartLegendPositionAppender = new UpperLimitGenericAppender<ChartLegendPositionContainer>(
			ChartTypeFeature.ChartLegendPosition, 1, UpperLimitReactions.RemoveFirst);

	/**
	 * Constructs a new PieChart.
	 * 
	 * @param chartDimension
	 * 
	 * @deprecated use {@link #AbstractPieChart(Dimension)}
	 */
	@Deprecated
	public AbstractPieChart(java.awt.Dimension awtChartDimension) {
		super(awtChartDimension);

	}
	
	/**
	 * Constructs a new PieChart.
	 * 
	 * @param chartDimension
	 */
	public AbstractPieChart(Dimension chartDimension) {
		super(chartDimension);

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

	/**
	 * {@inheritDoc}
	 * 
	 * @throws IllegalArgumentException
	 *             if GradientFillDestination is not background
	 */
	public void setLinearGradient(LinearGradient lg) {
		if (lg == null) {
			linearGradientAppender.removeAll();
			return;
		}
		if (!lg.getFillDestination().equals(GradientFillDestination.Background)) {
			throw new IllegalArgumentException(
					"GradientFillDestination Background supported");
		}
		this.linearGradientAppender.add(lg);
	}

	public void removeLinearStripes() {
		linearStripesAppender.removeAll();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws IllegalArgumentException if LinearStripesDestination is not background
	 */
	public void setLinearStripes(LinearStripe ls) {
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

	public LinearStripe getLinearStripes() {

		return this.linearStripesAppender.getList().size() > 0 ? this.linearStripesAppender
				.getList().get(0)
				: null;
	}

	public LinearGradient getLinearGradient() {

		return this.linearGradientAppender.getList().size() > 0 ? this.linearGradientAppender
				.getList().get(0)
				: null;
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
		this.chartLegendPositionAppender.removeAll();

	}

	public void setChartLegend(ChartLegend legend) {

		if (legend == null) {
			this.removeChartLegend();
		} else {
			this.chartLegendAppender.add(legend);
			if (new ChartLegendPositionContainer(legend
					.getChartLegendPosition()) != null) {
				this.chartLegendPositionAppender
						.add(new ChartLegendPositionContainer(legend
								.getChartLegendPosition()));
			}
		}
	}

	/**
	 * Sets the pie chart orientation.
	 * 
	 * @param angle
	 *            number as radian
	 */
	public void setPieChartOrientation(float angle) {

		this.pieChartOrientationAppender.set(angle);
	}

	/**
	 * Removes the pie chart orientation.
	 */
	public void removePieChartOrientation() {
		this.pieChartOrientationAppender.removeAll();
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
