package de.toolforge.googlechartwrapper;


import java.awt.Dimension;
import java.util.List;

import de.toolforge.googlechartwrapper.coder.IEncoder;
import de.toolforge.googlechartwrapper.color.ChartColor;
import de.toolforge.googlechartwrapper.color.ISolidFillable;
import de.toolforge.googlechartwrapper.color.LinearGradient;
import de.toolforge.googlechartwrapper.color.LinearStripe;
import de.toolforge.googlechartwrapper.color.SolidFill;
import de.toolforge.googlechartwrapper.color.LinearGradient.GradientFillDestination;
import de.toolforge.googlechartwrapper.color.LinearStripe.LinearStripesDestination;
import de.toolforge.googlechartwrapper.color.SolidFill.ChartFillDestination;
import de.toolforge.googlechartwrapper.data.DataScalingSet;
import de.toolforge.googlechartwrapper.data.GoogleOMeterValue;
import de.toolforge.googlechartwrapper.data.GoogleOMeterValueAppender;
import de.toolforge.googlechartwrapper.data.ISingleDataScaleable;
import de.toolforge.googlechartwrapper.interfaces.IColorable;
import de.toolforge.googlechartwrapper.interfaces.ILinearable;
import de.toolforge.googlechartwrapper.label.ChartLegend;
import de.toolforge.googlechartwrapper.label.ChartLegendPositionContainer;
import de.toolforge.googlechartwrapper.label.ChartTitle;
import de.toolforge.googlechartwrapper.label.IChartLegendable;
import de.toolforge.googlechartwrapper.style.ChartMargin;
import de.toolforge.googlechartwrapper.util.GenericAppender;
import de.toolforge.googlechartwrapper.util.UpperLimitGenericAppender;
import de.toolforge.googlechartwrapper.util.UpperLimitGenericAppender.UpperLimitReactions;

/**
 * Specifies a GoogleOMeter <a
 * href="http://code.google.com/apis/chart/types.html#gom">
 * http://code.google.com/apis/chart/types.html#gom</a>
 * 
 * <p>
 * Here are some examples of how GoogleOMeter can be used:
 * <p>
 * <blockquote>
 * 
 * <pre>
 * GoogleOMeter meter = new GoogleOMeter(new Dimension(225, 125));
 * 
 * meter.addGoogleOMeterValue(new GoogleOMeterValue(&quot;Hello&quot;, 50));
 * </pre>
 * 
 * </blockquote>
 * <p>
 * 
 * @author mart
 * @author steffan
 * @version 03/18/09
 * @see GoogleOMeterValue
 * 
 */
public class GoogleOMeter extends AbstractChart implements ISolidFillable,
		ISingleDataScaleable, ILinearable, IChartLegendable, IColorable {

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
	protected UpperLimitGenericAppender<LinearStripe> linearStripesAppender = new UpperLimitGenericAppender<LinearStripe>(
			ChartTypeFeature.LinearStripes, 1, UpperLimitReactions.RemoveFirst);
	protected GenericAppender<ChartColor> chartColorAppender = new GenericAppender<ChartColor>(
			ChartTypeFeature.ChartColor, ",");
	protected UpperLimitGenericAppender<ChartMargin> chartMarginAppender = new UpperLimitGenericAppender<ChartMargin>(
			ChartTypeFeature.ChartMargin, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<ChartLegendPositionContainer> chartLegendPositionAppender = new UpperLimitGenericAppender<ChartLegendPositionContainer>(
			ChartTypeFeature.ChartLegendPosition, 1,
			UpperLimitReactions.RemoveFirst);

	/**
	 * Constructs a new GoogleOMeter.
	 * 
	 * @param chartDimension
	 */
	public GoogleOMeter(Dimension chartDimension) {
		super(chartDimension);
	}

	/**
	 * Constructs a new GoogleOMeter.
	 * 
	 * @param chartDimension
	 * 
	 * @throws IllegalArgumentException
	 *             if value is {@code null}
	 */
	public GoogleOMeter(Dimension chartDimension, GoogleOMeterValue value) {
		super(chartDimension);

		this.valueAppender.add(value);
	}

	@Override
	protected ChartType getChartType() {
		return ChartType.GoogleOMeter;
	}

	@Override
	protected String getUrlChartType() {
		return ChartType.GoogleOMeter.getPrefix();
	}

	/**
	 * {@inheritDoc} The GoogleOMeter supports only Background as
	 * ChartFillDestination.
	 * 
	 * @throws IllegalArgumentException
	 *             if ChartFillDestination is not background
	 */
	public void addSolidFill(SolidFill sf) {
		if (!sf.getChartFillDestination().equals(
				ChartFillDestination.Background)) {
			throw new IllegalArgumentException(
					"only ChartFillDestination.Background allowed");
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

	/**
	 * 
	 * @param value
	 * 
	 * @throws IllegalArgumentException
	 *             if value is {@code null}
	 */
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
	 * 
	 * @throws IllegalArgumentException
	 *             if FillDestination is not background
	 */
	public void setLinearGradient(LinearGradient lg) {

		if (lg == null) {
			this.removeLinearGradient();
		} else {
			if (!lg.getFillDestination().equals(
					GradientFillDestination.Background))
				throw new IllegalArgumentException(
						"GradientFillDestination.Background allowed");

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

	public LinearStripe getLinearStripes() {

		return this.linearStripesAppender.getList().size() > 0 ? this.linearStripesAppender
				.getList().get(0)
				: null;
	}

	public void removeLinearStripes() {
		this.linearStripesAppender.removeAll();

	}

	/**
	 * {@inheritDoc} The GoogleOMeter supports only Background as
	 * LinearStripesDestination.
	 * 
	 * @throws IllegalArgumentException
	 *             if LinearStripesDestination is not background
	 * 
	 */
	public void setLinearStripes(LinearStripe ls) {

		if (ls == null) {
			this.removeLinearStripes();
		} else {

			if (!ls.getFillDestination().equals(
					LinearStripesDestination.Background))
				throw new IllegalArgumentException(
						"only LinearStripesDestination.Background allowed");

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
	 * {@inheritDoc} You must add at least two colors, one for the left hand
	 * side and one for the right hand site.
	 */
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
