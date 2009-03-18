package googlechartwrapper;

import googlechartwrapper.coder.AutoEncoder;
import googlechartwrapper.coder.DataScalingTextEncoder;
import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.coder.PercentageEncoder;
import googlechartwrapper.color.ChartColor;
import googlechartwrapper.color.ISolidFillable;
import googlechartwrapper.color.LinearGradient;
import googlechartwrapper.color.LinearStripe;
import googlechartwrapper.color.SolidFill;
import googlechartwrapper.data.DataScalingSet;
import googlechartwrapper.data.IMultiDataScaleable;
import googlechartwrapper.data.ScatterPlotData;
import googlechartwrapper.data.ScatterPlotDataAppender;
import googlechartwrapper.interfaces.IColorable;
import googlechartwrapper.interfaces.IEncodeable;
import googlechartwrapper.interfaces.ILinearable;
import googlechartwrapper.interfaces.IMarkable;
import googlechartwrapper.interfaces.IPercentageScaleable;
import googlechartwrapper.label.AxisLabelAppender;
import googlechartwrapper.label.AxisLabelContainer;
import googlechartwrapper.label.ChartLegend;
import googlechartwrapper.label.ChartTitle;
import googlechartwrapper.label.DataPointLabel;
import googlechartwrapper.label.IChartLegendable;
import googlechartwrapper.label.IDataPointLabelable;
import googlechartwrapper.style.ChartMargin;
import googlechartwrapper.style.GridLine;
import googlechartwrapper.style.RangeMarker;
import googlechartwrapper.style.ShapeMarker;
import googlechartwrapper.util.GenericAppender;
import googlechartwrapper.util.UpperLimitGenericAppender;
import googlechartwrapper.util.UpperLimitGenericAppender.UpperLimitReactions;

import java.awt.Dimension;
import java.util.List;

/**
 * Specifies a scatter plot <a
 * href="http://code.google.com/apis/chart/types.html#scatter_plot">
 * http://code.google.com/apis/chart/types.html#scatter_plot</a>
 * 
 * @author steffan
 * 
 */
public class ScatterPlot extends AbstractChart implements ILinearable,
		IMarkable, IChartLegendable, IMultiDataScaleable, IPercentageScaleable,
		IEncodeable, ISolidFillable, IColorable, IDataPointLabelable {

	protected UpperLimitGenericAppender<LinearGradient> linearGradientAppender = new UpperLimitGenericAppender<LinearGradient>(
			ChartTypeFeature.LinearGradient, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<LinearStripe> linearStripesAppender = new UpperLimitGenericAppender<LinearStripe>(
			ChartTypeFeature.LinearStripes, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<ChartTitle> chartTitleAppender = new UpperLimitGenericAppender<ChartTitle>(
			ChartTypeFeature.ChartTitle, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<ChartLegend> chartLegendAppender = new UpperLimitGenericAppender<ChartLegend>(
			ChartTypeFeature.ChartLegend, 1, UpperLimitReactions.RemoveFirst);
	protected GenericAppender<ChartColor> chartColorAppender = new GenericAppender<ChartColor>(
			ChartTypeFeature.ChartColor, ",");
	protected UpperLimitGenericAppender<DataScalingSet> dataScalingAppender = new UpperLimitGenericAppender<DataScalingSet>(
			ChartTypeFeature.DataScaling, 1, UpperLimitReactions.RemoveFirst);
	protected GenericAppender<RangeMarker> rangeMarkerAppender = new GenericAppender<RangeMarker>(
			ChartTypeFeature.Marker);
	protected GenericAppender<ShapeMarker> shapeMarkerAppender = new GenericAppender<ShapeMarker>(
			ChartTypeFeature.Marker);
	protected UpperLimitGenericAppender<GridLine> gridLineAppender = new UpperLimitGenericAppender<GridLine>(
			ChartTypeFeature.GridLine, 1, UpperLimitReactions.RemoveFirst);
	protected AxisLabelAppender axisLabelAppender = new AxisLabelAppender();
	protected ScatterPlotDataAppender scatterPlotDataAppender = new ScatterPlotDataAppender();
	protected GenericAppender<SolidFill> solidFillAppender = new GenericAppender<SolidFill>(
			ChartTypeFeature.SolidFill);
	protected UpperLimitGenericAppender<ChartMargin> chartMarginAppender = new UpperLimitGenericAppender<ChartMargin>(
			ChartTypeFeature.ChartMargin, 1, UpperLimitReactions.RemoveFirst);
	protected GenericAppender<DataPointLabel> dataPointLabelAppender = new GenericAppender<DataPointLabel>(
			ChartTypeFeature.Marker);

	public ScatterPlot(Dimension chartDimension) {
		super(chartDimension);

	}

	@Override
	protected ChartType getChartType() {

		return ChartType.ScatterPlot;
	}

	@Override
	protected String getUrlChartType() {

		return ChartType.ScatterPlot.getPrefix();
	}

	public void removeLinearGradient() {
		this.linearGradientAppender.removeAll();

	}

	public void setLinearGradient(LinearGradient lg) {

		if (lg == null) {
			this.removeLinearGradient();
		} else {
			this.linearGradientAppender.add(lg);
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

	public void removeLinearStripes() {
		this.linearStripesAppender.removeAll();

	}

	public void setLinearStripes(LinearStripe ls) {
		this.linearStripesAppender.add(ls);

	}

	public IEncoder getEncoder() {

		return this.scatterPlotDataAppender.getEncoder();
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

	public void addRangeMarker(RangeMarker rm) {

		this.rangeMarkerAppender.add(rm);
	}

	public List<RangeMarker> getRangeMarkers() {

		return this.rangeMarkerAppender.getList();
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

	public void addShapeMarker(ShapeMarker shapeMarker) {

		this.shapeMarkerAppender.add(shapeMarker);
	}

	public List<ShapeMarker> getShapeMarkers() {

		return this.shapeMarkerAppender.getList();
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

	public GridLine getGridLine() {

		return this.gridLineAppender.getList().size() > 0 ? this.gridLineAppender
				.getList().get(0)
				: null;
	}

	public void removeGridLine() {

		this.gridLineAppender.removeAll();

	}

	public void setGridLine(GridLine gl) {

		if (gl == null) {
			this.gridLineAppender.removeAll();
			return;
		}
		this.gridLineAppender.add(gl);

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

	public void setScatterPlotData(ScatterPlotData data) {
		this.scatterPlotDataAppender.setScatterPlotData(data);
	}

	public ScatterPlotData getScatterPlotData() {

		return this.scatterPlotDataAppender.getScatterPlotData();
	}

	public void addDataScalingSet(DataScalingSet ds) {
		this.dataScalingAppender.add(ds);
		this.scatterPlotDataAppender.setEncoder(new DataScalingTextEncoder());
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

		this.scatterPlotDataAppender.removeEncoder();
		// this.scatterPlotDataAppender.setEncoder(new AutoEncoder());

	}

	public DataScalingSet removeDataScalingSet(int index) {
		return this.dataScalingAppender.remove(index);
	}

	public boolean removeDataScalingSet(DataScalingSet set) {
		return this.dataScalingAppender.remove(set);
	}

	public void setPercentageScaling(boolean b) {
		if (b) {
			this.scatterPlotDataAppender.setEncoder(new PercentageEncoder());
		} else {
			this.scatterPlotDataAppender.setEncoder(new AutoEncoder());
		}

		this.dataScalingAppender.removeAll();

	}

	public void removeEncoder() {
		this.scatterPlotDataAppender.removeEncoder();
	}

	public void setEncoder(IEncoder encoder) {
		this.scatterPlotDataAppender.setEncoder(encoder);
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
}
