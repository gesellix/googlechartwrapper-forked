package googlechartwrapper;

import googlechartwrapper.coder.DataScalingTextEncoder;
import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.color.ChartColor;
import googlechartwrapper.color.FillArea;
import googlechartwrapper.color.ISolidFillable;
import googlechartwrapper.color.LinearGradient;
import googlechartwrapper.color.LinearStripe;
import googlechartwrapper.color.SolidFill;
import googlechartwrapper.data.BarChartDataSeriesAppender;
import googlechartwrapper.data.DataScalingSet;
import googlechartwrapper.data.IMultiDataScaleable;
import googlechartwrapper.interfaces.IColorable;
import googlechartwrapper.interfaces.ILinearable;
import googlechartwrapper.interfaces.IMarkable;
import googlechartwrapper.interfaces.IStyleable;
import googlechartwrapper.label.AxisLabelAppender;
import googlechartwrapper.label.AxisLabelContainer;
import googlechartwrapper.label.ChartLegend;
import googlechartwrapper.label.ChartTitle;
import googlechartwrapper.label.DataPointLabel;
import googlechartwrapper.label.IDataPointLabelable;
import googlechartwrapper.style.BarChartZeroLine;
import googlechartwrapper.style.BarWidthAndSpacing;
import googlechartwrapper.style.ChartMargin;
import googlechartwrapper.style.FinancialMarker;
import googlechartwrapper.style.GridLine;
import googlechartwrapper.style.IBarChartZeroLineable;
import googlechartwrapper.style.IBarWidthAndSpacingable;
import googlechartwrapper.style.IFinancialMarkable;
import googlechartwrapper.style.IGridLineable;
import googlechartwrapper.style.LineStyle;
import googlechartwrapper.style.RangeMarker;
import googlechartwrapper.style.ShapeMarker;
import googlechartwrapper.util.GenericAppender;
import googlechartwrapper.util.UpperLimitGenericAppender;
import googlechartwrapper.util.UpperLimitGenericAppender.UpperLimitReactions;

import java.awt.Dimension;
import java.text.MessageFormat;
import java.util.List;

/**
 * Specifies a bar chart <a
 * href="http://code.google.com/apis/chart/types.html#bar_charts">
 * http://code.google.com/apis/chart/types.html#bar_charts</a>
 * 
 * @author steffan
 * 
 */
public class BarChart extends AbstractChart implements IMarkable, ILinearable,
		IStyleable, IGridLineable, ISolidFillable, IMultiDataScaleable,
		IColorable, IFinancialMarkable, IBarChartZeroLineable,
		IBarWidthAndSpacingable, IDataPointLabelable {

	private BarChartOrientation orientation;
	private BarChartStyle style;
	// private int barWidth;

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
	protected GenericAppender<FinancialMarker> financialMarker = new GenericAppender<FinancialMarker>(
			ChartTypeFeature.Marker);
	protected GenericAppender<ChartColor> chartColorAppender = new GenericAppender<ChartColor>(
			ChartTypeFeature.ChartColor, ",");
	protected UpperLimitGenericAppender<DataScalingSet> dataScalingAppender = new UpperLimitGenericAppender<DataScalingSet>(
			ChartTypeFeature.DataScaling, 1, UpperLimitReactions.RemoveFirst);
	protected GenericAppender<LineStyle> lineStyleAppender = new GenericAppender<LineStyle>(
			ChartTypeFeature.LineStyle, ",");
	protected AxisLabelAppender axisLabelAppender = new AxisLabelAppender();
	protected BarChartDataSeriesAppender barChartDataSeriesAppender = new BarChartDataSeriesAppender();
	protected UpperLimitGenericAppender<BarChartZeroLine> barChartZeroLineAppender = new UpperLimitGenericAppender<BarChartZeroLine>(
			ChartTypeFeature.BarChartZeroLine, 1,
			UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<BarWidthAndSpacing> barWidthAndSpacingAppender = new UpperLimitGenericAppender<BarWidthAndSpacing>(
			ChartTypeFeature.BarWidthAndSpacing, 1,
			UpperLimitReactions.RemoveFirst);
	protected GenericAppender<DataPointLabel> dataPointLabelAppender = new GenericAppender<DataPointLabel>(
			ChartTypeFeature.Marker);
	protected UpperLimitGenericAppender<ChartLegend> chartLegendAppender = new UpperLimitGenericAppender<ChartLegend>(
			ChartTypeFeature.ChartLegend, 1, UpperLimitReactions.RemoveFirst);

	/**
	 * Constructs a bar chart
	 * 
	 * @param chartDimension
	 *            the size of the diagram
	 * @param orientation
	 *            the orientation
	 * @param style
	 *            the style
	 * 
	 * @throws IllegalArgumentException
	 */
	public BarChart(Dimension chartDimension, BarChartOrientation orientation,
			BarChartStyle style) {
		super(chartDimension);

		if (chartDimension == null)
			throw new IllegalArgumentException("chartDimension can not be null");
		if (orientation == null)
			throw new IllegalArgumentException("orientation can not be null");
		if (style == null)
			throw new IllegalArgumentException("style can not be null");

		this.orientation = orientation;
		this.style = style;
	}

	@Override
	protected ChartType getChartType() {
		return null; // TODO svo: fill!
		// return ChartType.BarChart;
	}

	@Override
	protected String getUrlChartType() {

		char orientationChar = this.orientation == BarChartOrientation.Horizontal ? 'v'
				: 'h';
		char styleChar = this.style == BarChartStyle.Stacked ? 's' : 'g';

		return MessageFormat.format("b{0}{1}", orientationChar, styleChar);
	}

	/*
	 * / Specify the bar size
	 * 
	 * @param width the size of every single bar
	 * 
	 * public void SetBarWidth(int width) { this.barWidth = width; }
	 */
	/**
	 * 
	 * 
	 * @author steffan
	 * 
	 */
	public enum BarChartOrientation {

		Vertical,

		Horizontal
	}

	/**
	 * 
	 * @author steffan
	 * 
	 */
	public enum BarChartStyle {

		Stacked,

		Grouped
	}

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

	public void addAxisLabelSummary(AxisLabelContainer labelSummary) {

		this.axisLabelAppender.addAxis(labelSummary);
	}

	public List<AxisLabelContainer> getAxisLabelSummaries() {

		return this.axisLabelAppender.getList();
	}

	public void removeAllAxisLabelSummaries() {
		this.axisLabelAppender.removeAll();

	}

	public AxisLabelContainer removeAxisLabelSummary(int index) {

		return this.axisLabelAppender.removeAxis(index);
	}

	public boolean removeAxisLabelSummary(AxisLabelContainer labelSummary) {

		return this.axisLabelAppender.removeAxis(labelSummary);
	}

	public void removeChartTitle() {
		this.chartTitleAppender.removeAll();

	}

	public void setChartTitle(ChartTitle title) {
		this.chartTitleAppender.add(title);

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

	public IEncoder getEncoder() {

		return this.barChartDataSeriesAppender.getEncoder();
	}

	public GridLine getGridLine() {

		return this.gridLineAppender.getList().size() > 0 ? this.gridLineAppender
				.getList().get(0)
				: null;
	}

	public LinearGradient getLinearGradient() {

		return this.linearGradientAppender.getList().size() > 0 ? this.linearGradientAppender
				.getList().get(0)
				: null;
	}

	public ChartTitle getChartTitle() {

		return this.chartTitleAppender.getList().size() > 0 ? this.chartTitleAppender
				.getList().get(0)
				: null;
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

	public void addDataScalingSet(DataScalingSet ds) {
		this.dataScalingAppender.add(ds);
		this.barChartDataSeriesAppender
				.setEncoder(new DataScalingTextEncoder());
	}

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
	public void removeAllDataScalings() {

		this.dataScalingAppender.removeAll();

		this.barChartDataSeriesAppender.removeEncoder();

	}

	public DataScalingSet removeDataScalingSet(int index) {
		return this.dataScalingAppender.remove(index);
	}

	public boolean removeDataScalingSet(DataScalingSet set) {
		return this.dataScalingAppender.remove(set);
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

	public ChartColor removeChartColors(int index) {

		return this.chartColorAppender.remove(index);
	}

	public boolean removeChartColors(ChartColor cc) {

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

	public BarChartZeroLine getBarChartZeroLine() {
		return this.barChartZeroLineAppender.getList().size() > 0 ? this.barChartZeroLineAppender
				.getList().get(0)
				: null;

	}

	public void removeBarChartZeroLine() {

		this.barChartZeroLineAppender.removeAll();

	}

	public void setBarChartZeroLine(BarChartZeroLine bzl) {

		this.barChartZeroLineAppender.add(bzl);

	}

	public BarWidthAndSpacing getBarWidthAndSpacing() {
		return this.barWidthAndSpacingAppender.getList().size() > 0 ? this.barWidthAndSpacingAppender
				.getList().get(0)
				: null;
	}

	public void removeBarWidthAndSpacing() {

		this.barWidthAndSpacingAppender.removeAll();

	}

	public void setBarWidthAndSpacing(BarWidthAndSpacing ws) {
		this.barWidthAndSpacingAppender.add(ws);

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

	}

	public void setChartLegend(ChartLegend legend) {
		this.chartLegendAppender.add(legend);

	}

}
