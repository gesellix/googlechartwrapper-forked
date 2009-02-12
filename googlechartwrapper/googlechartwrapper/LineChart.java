package googlechartwrapper;

import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.color.ChartColors;
import googlechartwrapper.color.FillArea;
import googlechartwrapper.color.ISolidFillable;
import googlechartwrapper.color.LinearGradient;
import googlechartwrapper.color.LinearStripes;
import googlechartwrapper.color.SolidFill;
import googlechartwrapper.data.DataScalingSet;
import googlechartwrapper.data.IMultiDataScaleable;
import googlechartwrapper.interfaces.IColorable;
import googlechartwrapper.interfaces.ILinearable;
import googlechartwrapper.interfaces.IMarkable;
import googlechartwrapper.interfaces.IStyleable;
import googlechartwrapper.label.AxisLabelAppender;
import googlechartwrapper.label.AxisLabelContainer;
import googlechartwrapper.label.ChartTitle;
import googlechartwrapper.style.ChartMargin;
import googlechartwrapper.style.GridLine;
import googlechartwrapper.style.IGridLineable;
import googlechartwrapper.style.LineStyle;
import googlechartwrapper.style.RangeMarker;
import googlechartwrapper.style.ShapeMarker;
import googlechartwrapper.util.GenericAppender;
import googlechartwrapper.util.UpperLimitGenericAppender;
import googlechartwrapper.util.UpperLimitGenericAppender.UpperLimitReactions;

import java.awt.Dimension;
import java.util.List;

/**
 * Specifies a line chart <a
 * href="http://code.google.com/intl/de-DE/apis/chart/types.html#line_charts">
 * http://code.google.com/intl/de-DE/apis/chart/types.html#line_charts</a>
 * 
 * @author steffan
 * 
 */
public class LineChart extends AbstractChart implements IMarkable, ILinearable,
		IStyleable, IGridLineable, ISolidFillable, IMultiDataScaleable,
		IColorable {

	private LineChartType lineChartType;

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
	protected UpperLimitGenericAppender<LinearStripes> linearStripesAppender = new UpperLimitGenericAppender<LinearStripes>(
			ChartTypeFeature.LinearStripes, 1, UpperLimitReactions.RemoveFirst);
	protected GenericAppender<ChartColors> chartColorAppender = new GenericAppender<ChartColors>(
			ChartTypeFeature.ChartColor, ",");
	protected GenericAppender<LineStyle> lineStyleAppender = new GenericAppender<LineStyle>(
			ChartTypeFeature.LineStyle, ",");

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
	public LineChart(Dimension chartDimension, LineChartType lineChartType) {
		super(chartDimension);

		if (lineChartType == null)
			throw new IllegalArgumentException("lineChartType can not be null");

		this.lineChartType = lineChartType;
	}

	@Override
	protected ChartType getChartType() {

		switch (lineChartType) {
		case LineChart:
			return ChartType.LineChart;
		case SparkLine:
			return ChartType.SparkLine;

		case LineChartPair:
			return ChartType.LineChartPair;
		default:
			return null;

		}

	}

	@Override
	protected String getUrlChartType() {
		
		return lineChartType.getPrefix();
		
	}

	/**
	 * 
	 * 
	 * @author steffan
	 * 
	 */
	public enum LineChartType {
		LineChart("lc"), LineChartPair("lxy"), SparkLine("ls");

		private final String prefix;

		private LineChartType(String prefix) {
			this.prefix = prefix;
		}

		/**
		 * Prefix for every chart, scatterplot means 's'
		 * 
		 * @return
		 */
		public String getPrefix() {
			return this.prefix;
		}

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

		return this.removeRangeMarker(index);
	}

	public boolean removeRangeMarker(RangeMarker rm) {

		return this.removeRangeMarker(rm);
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

	public LinearStripes getLinearStripes() {

		return this.linearStripesAppender.getList().size() > 0 ? this.linearStripesAppender
				.getList().get(0)
				: null;
	}

	public void removeLinearStripes() {
		linearStripesAppender.removeAll();
	}

	public DataScalingSet getDataScaling() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDataScaling(DataScalingSet ds) {
		// TODO Auto-generated method stub

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

	public IEncoder getEncoder() {
		// TODO Auto-generated method stub
		return null;
	}

	public LinearGradient getLinearGradient() {

		return this.linearGradientAppender.getList().size() > 0 ? this.linearGradientAppender
				.getList().get(0)
				: null;
	}

	public void removeDataScaling() {
		// TODO Auto-generated method stub

	}

	public void addDataScalingSet(DataScalingSet ds) {
		// TODO Auto-generated method stub

	}

	public List<DataScalingSet> getDataScalings() {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeAllDataScalings() {
		// TODO Auto-generated method stub

	}

	public DataScalingSet removeDataScalingSet(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean removeDataScalingSet(DataScalingSet set) {
		// TODO Auto-generated method stub
		return false;
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

	public void setLinearStripes(LinearStripes ls) {
		if (ls == null) {
			linearStripesAppender.removeAll();
			return;
		} else {
			this.linearStripesAppender.add(ls);
		}
	}

}
