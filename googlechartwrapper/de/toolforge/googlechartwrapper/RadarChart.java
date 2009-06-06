package de.toolforge.googlechartwrapper;


import java.awt.Dimension;
import java.util.List;

import de.toolforge.googlechartwrapper.coder.DataScalingTextEncoder;
import de.toolforge.googlechartwrapper.coder.IEncoder;
import de.toolforge.googlechartwrapper.color.ChartColor;
import de.toolforge.googlechartwrapper.color.FillArea;
import de.toolforge.googlechartwrapper.color.IFillAreaable;
import de.toolforge.googlechartwrapper.color.LinearGradient;
import de.toolforge.googlechartwrapper.color.LinearStripe;
import de.toolforge.googlechartwrapper.color.SolidFill;
import de.toolforge.googlechartwrapper.data.DataScalingSet;
import de.toolforge.googlechartwrapper.data.IMultiDataScaleable;
import de.toolforge.googlechartwrapper.data.RadarChartLine;
import de.toolforge.googlechartwrapper.data.RadarChartLineAppender;
import de.toolforge.googlechartwrapper.interfaces.IColorable;
import de.toolforge.googlechartwrapper.interfaces.IEncodeable;
import de.toolforge.googlechartwrapper.interfaces.ILinearable;
import de.toolforge.googlechartwrapper.interfaces.IMarkable;
import de.toolforge.googlechartwrapper.label.AxisLabelAppender;
import de.toolforge.googlechartwrapper.label.AxisLabelContainer;
import de.toolforge.googlechartwrapper.label.ChartLegend;
import de.toolforge.googlechartwrapper.label.ChartLegendPositionContainer;
import de.toolforge.googlechartwrapper.label.ChartTitle;
import de.toolforge.googlechartwrapper.label.DataPointLabel;
import de.toolforge.googlechartwrapper.label.IAxisLabelable;
import de.toolforge.googlechartwrapper.label.IChartTitleable;
import de.toolforge.googlechartwrapper.label.IDataPointLabelable;
import de.toolforge.googlechartwrapper.style.ChartMargin;
import de.toolforge.googlechartwrapper.style.GridLine;
import de.toolforge.googlechartwrapper.style.IGridLineable;
import de.toolforge.googlechartwrapper.style.ILineStyleable;
import de.toolforge.googlechartwrapper.style.IShapeMarkable;
import de.toolforge.googlechartwrapper.style.LineStyle;
import de.toolforge.googlechartwrapper.style.RangeMarker;
import de.toolforge.googlechartwrapper.style.ShapeMarker;
import de.toolforge.googlechartwrapper.util.GenericAppender;
import de.toolforge.googlechartwrapper.util.UpperLimitGenericAppender;
import de.toolforge.googlechartwrapper.util.UpperLimitGenericAppender.UpperLimitReactions;

/**
 * Specifies a radar chart<a
 * href="http://code.google.com/apis/chart/types.html#radar">
 * http://code.google.com/apis/chart/types.html#radar</a>
 * 
 * <p>
 * Here are some examples of how radar chart can be used:
 * <p>
 * <blockquote>
 * 
 * <pre>
 * RadarChart chart = new RadarChart(new Dimension(400,400));
 * 
 * chart.addRadarChartLine(new RadarChartLine(Color.GREEN,Arrays.asList(30,50,50,80,20,30)));
 * 
 * chart.addLineStyle(new LineStyle(3.5f,0f,0f));
 * </pre>
 * 
 * </blockquote>
 * <p>
 * @author mart
 * @author steffan
 * @version 03/22/09
 * @see RadarChartLine
 * 
 */
public class RadarChart extends AbstractChart implements IGridLineable,
		IShapeMarkable, IAxisLabelable, IFillAreaable, IChartTitleable,
		IMarkable, IColorable, ILinearable, ILineStyleable, IDataPointLabelable, IMultiDataScaleable, IEncodeable {

	private boolean isCurved = true;

	protected GenericAppender<GridLine> gridLines = new UpperLimitGenericAppender<GridLine>(
			ChartTypeFeature.GridLine, 1, UpperLimitReactions.RemoveAll);
	protected GenericAppender<RangeMarker> rangeMarker = new GenericAppender<RangeMarker>(
			ChartTypeFeature.Marker);
	protected GenericAppender<ShapeMarker> shapeMarker = new GenericAppender<ShapeMarker>(
			ChartTypeFeature.Marker);
	protected AxisLabelAppender axisLabels = new AxisLabelAppender();
	protected GenericAppender<FillArea> fillAreas = new GenericAppender<FillArea>(
			ChartTypeFeature.FillArea);
	protected GenericAppender<ChartTitle> title = new UpperLimitGenericAppender<ChartTitle>(
			ChartTypeFeature.ChartTitle, 1, UpperLimitReactions.RemoveAll);
	protected RadarChartLineAppender radarChartLineAppender = new RadarChartLineAppender();
	protected GenericAppender<SolidFill> solidFillAppender = new GenericAppender<SolidFill>(
			ChartTypeFeature.SolidFill);
	protected GenericAppender<ChartColor> chartColorAppender = new GenericAppender<ChartColor>(
			ChartTypeFeature.ChartColor, ",");
	protected UpperLimitGenericAppender<ChartMargin> chartMarginAppender = new UpperLimitGenericAppender<ChartMargin>(
			ChartTypeFeature.ChartMargin, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<LinearStripe> linearStripesAppender = new UpperLimitGenericAppender<LinearStripe>(
			ChartTypeFeature.LinearStripes, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<LinearGradient> linearGradientAppender = new UpperLimitGenericAppender<LinearGradient>(
			ChartTypeFeature.LinearGradient, 1, UpperLimitReactions.RemoveFirst);
	protected GenericAppender<LineStyle> lineStyleAppender = new GenericAppender<LineStyle>(
			ChartTypeFeature.LineStyle, ",");
	protected GenericAppender<DataPointLabel> dataPointLabelAppender = new GenericAppender<DataPointLabel>(
			ChartTypeFeature.Marker);
	protected UpperLimitGenericAppender<ChartLegend> chartLegendAppender = new UpperLimitGenericAppender<ChartLegend>(
			ChartTypeFeature.ChartLegend, 1, UpperLimitReactions.RemoveFirst);	
	protected GenericAppender<DataScalingSet> dataScalingAppender = new GenericAppender<DataScalingSet>(
			ChartTypeFeature.DataScaling);
	protected UpperLimitGenericAppender<ChartLegendPositionContainer> chartLegendPositionAppender = new UpperLimitGenericAppender<ChartLegendPositionContainer>(
			ChartTypeFeature.ChartLegendPosition, 1, UpperLimitReactions.RemoveFirst);
	
	/**
	 * Constructs a new {@link RadarChart}
	 * 
	 * @param chartDimension
	 */
	public RadarChart(Dimension chartDimension) {
		super(chartDimension);

	}
	/**
	 * Constructs a new {@link RadarChart}, with a list of lines.
	 * 
	 * @param chartDimension
	 * 
	 * @throws IllegalArgumentException if radarChartLines or member is {@code null}
	 */
	public RadarChart(Dimension chartDimension, List<RadarChartLine> radarChartLines) {
		super(chartDimension);
		
		this.radarChartLineAppender.add(radarChartLines);

	}
	/**
	 * Constructs a new {@link RadarChart}, with a single line.
	 * 
	 * @param chartDimension
	 * 
	 * @throws IllegalArgumentException if radarChartLine is {@code null}
	 */
	public RadarChart(Dimension chartDimension, RadarChartLine radarChartLine) {
		super(chartDimension);
		
		this.radarChartLineAppender.add(radarChartLine);

	}

	@Override
	protected ChartType getChartType() {
		return ChartType.RadarChartStraightLines;
	}

	@Override
	protected String getUrlChartType() {
		return isCurved ? ChartType.RadarChartSplines.getPrefix()
				: ChartType.RadarChartStraightLines.getPrefix();
	}
	
	/**
	 * Enable curved.
	 * 
	 * @see {@link #setDefault()}
	 */
	public void setCurved() {
		this.isCurved = true;
	}

	/**
	 * Set curved to false.
	 * 
	 * @see {@link #setCurved()}
	 */
	public void setDefault() {
		this.isCurved = false;
	}

	/**
	 * Returns if the chart was set to curved or not. DEFAULT is {@code true}.
	 * 
	 * @return {@code null} if {@code true}
	 */
	public boolean isCurved() {
		return this.isCurved;
	}

	/**
	 * Adds a {@link RadarChartLine} to the {@link RadarChartLineAppender} of
	 * this charts' instance.
	 * 
	 * @param radarChartLine
	 *            line to add
	 * 
	 * @throws IllegalArgumentException if radarChartLine is {@code null}
	 */
	public void addRadarChartLine(RadarChartLine radarChartLine) {
		radarChartLineAppender.add(radarChartLine);
	}

	/**
	 * Adds a list of {@link RadarChartLine} to the chart,
	 * @param radarChartLines {@link RadarChartLine}
	 * 
	 * @throws IllegalArgumentException if radarChartLine or member is {@code null}
	 */
	public void addRadarChartLine(List<? extends RadarChartLine> radarChartLines){
		this.radarChartLineAppender.add(radarChartLines);
	}
	/**
	 * Removes a {@link RadarChartLine} of the {@link RadarChartLineAppender} of
	 * this charts' instance.
	 * 
	 * @param line
	 *            line to remove
	 * @see RadarChartLineAppender#remove(RadarChartLine)
	 */
	public boolean removeRadarChartLine(RadarChartLine line) {
		return radarChartLineAppender.remove(line);
	}

	/**
	 * Removes a {@link RadarChartLine} of the {@link RadarChartLineAppender} of
	 * this charts' instance.
	 * 
	 * @param index
	 *            index to remove
	 * @see RadarChartLineAppender#remove(int)
	 */
	public RadarChartLine removeRadarChartLine(int index) {
		return radarChartLineAppender.remove(index);
	}

	/**
	 * Removes all {@link RadarChartLine}s of this chart.
	 */
	public void removeAllRadarChartLines() {
		radarChartLineAppender.removeAll();
	}

	/**
	 * Returns the list of all {@link RadarChartLine} elements added to this
	 * chart. It returns an unmodifiable view of the value list. Consequently
	 * "read-only" access is possible.
	 * 
	 * @return unmodifiable view of the values
	 */
	public List<? extends RadarChartLine> getRadarChartLineList() {
		return radarChartLineAppender.getList();
	}

	/**
	 * Returns the encoder of the underlying {@link RadarChartLineAppender}.
	 */
	public IEncoder getEncoder() {
		return radarChartLineAppender.getEncoder();
	}

	/**
	 * Sets the {@link IEncoder} of the underlying
	 * {@link RadarChartLineAppender}. Note, that Points of value zero (0, A or
	 * AA depending on the type of encoding) are drawn at the center while those
	 * with the maximum value for the encoding used are drawn at the perimeter.
	 * 
	 * @param encoder
	 *            encoder to set.
	 */
	public void setEncoder(IEncoder encoder) {
		radarChartLineAppender.setEncoder(encoder);
	}

	public void setGridLine(GridLine gl) {
		if (gl == null) {
			gridLines.removeAll();
		} else {
			gridLines.add(gl);
		}
	}

	public void removeGridLine() {
		gridLines.removeAll();
	}

	public void addRangeMarker(RangeMarker rm) {
		rangeMarker.add(rm);
	}

	public List<RangeMarker> getRangeMarkers() {
		return rangeMarker.getList();
	}

	public void removeAllRangeMarkers() {
		rangeMarker.removeAll();
	}

	public RangeMarker removeRangeMarker(int index) {
		return rangeMarker.remove(index);
	}

	public boolean removeRangeMarker(RangeMarker rm) {
		return rangeMarker.remove(rm);
	}

	public void addShapeMarker(ShapeMarker shapeMarker) {
		this.shapeMarker.add(shapeMarker);
	}

	public List<ShapeMarker> getShapeMarkers() {
		return shapeMarker.getList();
	}

	public void removeAllShapeMarkers() {
		shapeMarker.removeAll();
	}

	public ShapeMarker removeShapeMarker(int index) {
		return shapeMarker.remove(index);
	}

	public boolean removeShapeMarker(ShapeMarker sm) {
		return shapeMarker.remove(sm);
	}

	public void addAxisLabelContainer(AxisLabelContainer labelSummary) {
		axisLabels.addAxis(labelSummary);
	}

	public List<AxisLabelContainer> getAxisLabelContainer() {
		return axisLabels.getList();
	}

	public void removeAllAxisLabelContainer() {
		axisLabels.removeAll();
	}

	public AxisLabelContainer removeAxisLabelContainer(int index) {
		return axisLabels.removeAxis(index);
	}

	public boolean removeAxisLabelContainer(AxisLabelContainer labelSummary) {
		return axisLabels.removeAxis(labelSummary);
	}

	/**
	 * 
	 * @throws IllegalArgumentException if DataSetKind is not Multi
	 */
	public void addFillArea(FillArea fa) {
		
		if(!fa.getDataSetKind().equals(FillArea.DataSetKind.Multi))
			throw new IllegalArgumentException("only FillArea.DataSetKind.Multi allowed");
		
		fillAreas.add(fa);
	}

	public List<FillArea> getFillAreas() {
		return fillAreas.getList();
	}

	public void removeAllFillAreas() {
		fillAreas.removeAll();
	}

	public FillArea removeFillArea(int index) {
		return fillAreas.remove(index);
	}

	public boolean removeFillArea(FillArea fa) {
		return fillAreas.remove(fa);
	}

	public void removeChartTitle() {
		title.removeAll();
	}

	public void setChartTitle(ChartTitle title) {
		if (title == null) {
			this.title.removeAll();
		} else {
			this.title.add(title);
		}
	}

	public GridLine getGridLine() {

		return this.gridLines.getList().size() > 0 ? this.gridLines.getList()
				.get(0) : null;
	}

	public ChartTitle getChartTitle() {

		return this.title.getList().size() > 0 ? this.title.getList().get(0)
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

	public LinearGradient getLinearGradient() {

		return this.linearGradientAppender.getList().size() > 0 ? this.linearGradientAppender
				.getList().get(0)
				: null;
	}

	public void removeLinearGradient() {
		linearGradientAppender.removeAll();
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

	public void setLinearStripes(LinearStripe ls) {
		if (ls == null) {
			linearStripesAppender.removeAll();
			return;
		}

		this.linearStripesAppender.add(ls);
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
	
	public void addDataScalingSet(DataScalingSet ds) {
		this.dataScalingAppender.add(ds);
		this.radarChartLineAppender.setEncoder(new DataScalingTextEncoder());
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

		this.radarChartLineAppender.removeEncoder();
		

	}

	public DataScalingSet removeDataScalingSet(int index) {
		return this.dataScalingAppender.remove(index);
	}

	public boolean removeDataScalingSet(DataScalingSet set) {
		return this.dataScalingAppender.remove(set);
	}
	public void removeEncoder() {
		this.radarChartLineAppender.removeEncoder();
	}

}
