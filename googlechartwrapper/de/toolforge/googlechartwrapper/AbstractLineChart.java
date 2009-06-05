package de.toolforge.googlechartwrapper;


import java.awt.Dimension;
import java.util.List;

import de.toolforge.googlechartwrapper.coder.IEncoder;
import de.toolforge.googlechartwrapper.color.ChartColor;
import de.toolforge.googlechartwrapper.color.FillArea;
import de.toolforge.googlechartwrapper.color.ISolidFillable;
import de.toolforge.googlechartwrapper.color.LinearGradient;
import de.toolforge.googlechartwrapper.color.LinearStripe;
import de.toolforge.googlechartwrapper.color.SolidFill;
import de.toolforge.googlechartwrapper.data.DataScalingSet;
import de.toolforge.googlechartwrapper.data.IMultiDataScaleable;
import de.toolforge.googlechartwrapper.interfaces.IColorable;
import de.toolforge.googlechartwrapper.interfaces.ILinearable;
import de.toolforge.googlechartwrapper.interfaces.IMarkable;
import de.toolforge.googlechartwrapper.interfaces.IStyleable;
import de.toolforge.googlechartwrapper.label.AxisLabelAppender;
import de.toolforge.googlechartwrapper.label.AxisLabelContainer;
import de.toolforge.googlechartwrapper.label.ChartLegend;
import de.toolforge.googlechartwrapper.label.ChartLegendPositionContainer;
import de.toolforge.googlechartwrapper.label.ChartTitle;
import de.toolforge.googlechartwrapper.label.DataPointLabel;
import de.toolforge.googlechartwrapper.label.IDataPointLabelable;
import de.toolforge.googlechartwrapper.style.ChartMargin;
import de.toolforge.googlechartwrapper.style.FinancialMarker;
import de.toolforge.googlechartwrapper.style.GridLine;
import de.toolforge.googlechartwrapper.style.IFinancialMarkable;
import de.toolforge.googlechartwrapper.style.IGridLineable;
import de.toolforge.googlechartwrapper.style.LineStyle;
import de.toolforge.googlechartwrapper.style.RangeMarker;
import de.toolforge.googlechartwrapper.style.ShapeMarker;
import de.toolforge.googlechartwrapper.util.GenericAppender;
import de.toolforge.googlechartwrapper.util.UpperLimitGenericAppender;
import de.toolforge.googlechartwrapper.util.UpperLimitGenericAppender.UpperLimitReactions;

/**
 * Specifies a abstract line chart <a
 * href="http://code.google.com/intl/de-DE/apis/chart/types.html#line_charts">
 * http://code.google.com/intl/de-DE/apis/chart/types.html#line_charts</a>
 * 
 * @author steffan
 * 
 * @see XYLineChart
 * @see LineChart
 * 
 */
public abstract class AbstractLineChart extends AbstractChart implements
		IMarkable, ILinearable, IStyleable, IGridLineable, ISolidFillable,
		IMultiDataScaleable, IColorable, IFinancialMarkable, IDataPointLabelable{

	protected GenericAppender<RangeMarker> rangeMarkerAppender = new GenericAppender<RangeMarker>(
			ChartTypeFeature.Marker);
	protected GenericAppender<ShapeMarker> shapeMarkerAppender = new GenericAppender<ShapeMarker>(
			ChartTypeFeature.Marker);
	protected UpperLimitGenericAppender<GridLine> gridLineAppender = new UpperLimitGenericAppender<GridLine>(
			ChartTypeFeature.GridLine, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<LinearGradient> linearGradientAppender = new UpperLimitGenericAppender<LinearGradient>(
			ChartTypeFeature.LinearGradient, 1, UpperLimitReactions.RemoveFirst);
	protected GenericAppender<FillArea> fillAreaAppender = new GenericAppender<FillArea>(
			ChartTypeFeature.FillArea);
	protected GenericAppender<SolidFill> solidFillAppender = new GenericAppender<SolidFill>(
			ChartTypeFeature.SolidFill);
	protected UpperLimitGenericAppender<ChartTitle> chartTitleAppender = new UpperLimitGenericAppender<ChartTitle>(
			ChartTypeFeature.ChartTitle, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<ChartMargin> chartMarginAppender = new UpperLimitGenericAppender<ChartMargin>(
			ChartTypeFeature.ChartMargin, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<LinearStripe> linearStripesAppender = new UpperLimitGenericAppender<LinearStripe>(
			ChartTypeFeature.LinearStripes, 1, UpperLimitReactions.RemoveFirst);
	protected GenericAppender<ChartColor> chartColorAppender = new GenericAppender<ChartColor>(
			ChartTypeFeature.ChartColor, ",");
	protected GenericAppender<LineStyle> lineStyleAppender = new GenericAppender<LineStyle>(
			ChartTypeFeature.LineStyle, ",");
	protected GenericAppender<FinancialMarker> financialMarker = new GenericAppender<FinancialMarker>(
			ChartTypeFeature.Marker);
	protected UpperLimitGenericAppender<DataScalingSet> dataScalingAppender = new UpperLimitGenericAppender<DataScalingSet>(
			ChartTypeFeature.DataScaling, 1, UpperLimitReactions.RemoveFirst);
	protected GenericAppender<DataPointLabel> dataPointLabelAppender = new GenericAppender<DataPointLabel>(
			ChartTypeFeature.Marker);
	protected UpperLimitGenericAppender<ChartLegend> chartLegendAppender = new UpperLimitGenericAppender<ChartLegend>(
			ChartTypeFeature.ChartLegend, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<ChartLegendPositionContainer> chartLegendPositionAppender = new UpperLimitGenericAppender<ChartLegendPositionContainer>(
			ChartTypeFeature.ChartLegendPosition, 1, UpperLimitReactions.RemoveFirst);

	protected AxisLabelAppender axisLabelAppender = new AxisLabelAppender();

	/**
	 * Constructs a lineChart
	 * 
	 * @param chartDimension
	 *            the size of the diagram
	 * @param lineChartType
	 * 
	 * @throws IllegalArgumentException
	 */
	public AbstractLineChart(Dimension chartDimension) {
		super(chartDimension);

	}

	protected abstract ChartType getChartType();

	protected abstract String getUrlChartType();

	public void addRangeMarker(RangeMarker rm) {
		this.rangeMarkerAppender.add(rm);

	}

	public List<RangeMarker> getRangeMarkers() {
		return rangeMarkerAppender.getList();
	}

	public void addShapeMarker(ShapeMarker shapeMarker) {
		this.shapeMarkerAppender.add(shapeMarker);

	}

	public List<ShapeMarker> getShapeMarkers() {
		return shapeMarkerAppender.getList();
	}

	public void removeAllRangeMarkers() {
		this.rangeMarkerAppender.removeAll();

	}

	public RangeMarker removeRangeMarker(int index) {

		return this.rangeMarkerAppender.remove(index);
	}

	public boolean removeRangeMarker(RangeMarker rm) {

		return this.rangeMarkerAppender.remove(rm);
	}

	public void removeAllShapeMarkers() {
		this.shapeMarkerAppender.removeAll();

	}

	public ShapeMarker removeShapeMarker(int index) {

		return this.shapeMarkerAppender.remove(index);
	}

	public boolean removeShapeMarker(ShapeMarker sm) {

		return this.shapeMarkerAppender.remove(sm);
	}

	public void removeGridLine() {
		this.gridLineAppender.removeAll();

	}

	public void setGridLine(GridLine gl) {
		this.gridLineAppender.add(gl);

	}

	public void removeLinearGradient() {
		this.linearGradientAppender.removeAll();

	}

	public void addFillArea(FillArea fa) {
		this.fillAreaAppender.add(fa);

	}

	public List<FillArea> getFillAreas() {

		return this.fillAreaAppender.getList();
	}

	public void removeAllFillAreas() {
		this.fillAreaAppender.removeAll();

	}

	public FillArea removeFillArea(int index) {

		return this.fillAreaAppender.remove(index);
	}

	public boolean removeFillArea(FillArea fa) {

		return this.fillAreaAppender.remove(fa);
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

	public void addAxisLabelContainer(AxisLabelContainer labelSummary) {

		this.axisLabelAppender.addAxis(labelSummary);
	}

	public List<AxisLabelContainer> getAxisLabelContainer() {

		return this.axisLabelAppender.getList();
	}

	public void removeAllAxisLabelContainer() {
		this.axisLabelAppender.removeAll();

	}

	public AxisLabelContainer removeAxisLabelContainer(int index) {

		return this.axisLabelAppender.removeAxis(index);
	}

	public boolean removeAxisLabelContainer(AxisLabelContainer labelSummary) {

		return this.axisLabelAppender.removeAxis(labelSummary);
	}

	public void removeChartTitle() {
		this.chartTitleAppender.removeAll();

	}

	public void setChartTitle(ChartTitle title) {
		this.chartTitleAppender.add(title);

	}

	public GridLine getGridLine() {

		return this.gridLineAppender.getList().size() > 0 ? this.gridLineAppender
				.getList().get(0)
				: null;
	}

	public ChartTitle getChartTitle() {

		return this.chartTitleAppender.getList().size() > 0 ? this.chartTitleAppender
				.getList().get(0)
				: null;
	}

	public void setLinearGradient(LinearGradient lg) {
		if (lg == null) {
			linearGradientAppender.removeAll();
			return;
		} else {
			this.linearGradientAppender.add(lg);
		}
	}

	public LinearStripe getLinearStripes() {

		return this.linearStripesAppender.getList().size() > 0 ? this.linearStripesAppender
				.getList().get(0)
				: null;
	}

	public void removeLinearStripes() {
		linearStripesAppender.removeAll();
	}

	public void addLineStyle(LineStyle lineStyle) {
		this.lineStyleAppender.add(lineStyle);

	}

	public List<LineStyle> getLineStyles() {
		return this.lineStyleAppender.getList();
	}

	public void removeAllLineStyles() {
		this.lineStyleAppender.removeAll();

	}

	public LineStyle removeLineStyle(int index) {

		return this.lineStyleAppender.remove(index);
	}

	public boolean removeLineStyle(LineStyle lineStyle) {

		return this.lineStyleAppender.remove(lineStyle);
	}

	public abstract IEncoder getEncoder();

	public LinearGradient getLinearGradient() {

		return this.linearGradientAppender.getList().size() > 0 ? this.linearGradientAppender
				.getList().get(0)
				: null;
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

	public void setLinearStripes(LinearStripe ls) {
		if (ls == null) {
			linearStripesAppender.removeAll();
			return;
		} else {
			this.linearStripesAppender.add(ls);
		}
	}

	public void addFinancialMarker(FinancialMarker fm) {

		this.financialMarker.add(fm);

	}

	public List<FinancialMarker> getFinancialMarkers() {

		return this.financialMarker.getList();
	}

	public void removeAllFinancialMarkers() {

		this.financialMarker.removeAll();
	}

	public boolean removeFinancialMarker(FinancialMarker fm) {

		return this.financialMarker.remove(fm);
	}

	public FinancialMarker removeFinancialMarker(int index) {

		return this.financialMarker.remove(index);
	}

	public abstract void addDataScalingSet(DataScalingSet ds);

	public List<DataScalingSet> getDataScalings() {

		return this.dataScalingAppender.getList().size() > 0 ? this.dataScalingAppender
				.getList()
				: null;
	}

	/**
	 * Removes all datascalings and sets the default encoder.
	 * 
	 * @see ScatterPlot#getEncoder()
	 */
	public abstract void removeAllDataScalings();

	public DataScalingSet removeDataScalingSet(int index) {
		return this.dataScalingAppender.remove(index);
	}

	public boolean removeDataScalingSet(DataScalingSet set) {
		return this.dataScalingAppender.remove(set);
	}
	
	public void addDataPointLabel(DataPointLabel dpl) {
		this.dataPointLabelAppender.add(dpl);

	}

	public List<DataPointLabel> getDataPointLabels() {

		return this.dataPointLabelAppender.getList();
	}

	public DataPointLabel removeDataPointLabel(int index) {
		return this.dataPointLabelAppender.remove(index);
	}

	public boolean removeDataPointLabel(DataPointLabel dpl) {
		return this.dataPointLabelAppender.remove(dpl);
	}

	public void removeDataPointLabels() {
		this.dataPointLabelAppender.removeAll();

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

}
