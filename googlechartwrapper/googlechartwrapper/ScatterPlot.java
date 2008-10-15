package googlechartwrapper;

import googlechartwrapper.coder.DataScalingTextEncoder;
import googlechartwrapper.coder.AutoEncoder;
import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.color.ChartColors;
import googlechartwrapper.color.IChartColorable;
import googlechartwrapper.color.LinearGradient;
import googlechartwrapper.color.LinearStripes;
import googlechartwrapper.data.DataScalingSet;
import googlechartwrapper.data.IMultiDataScaleable;
import googlechartwrapper.data.ScatterPlotData;
import googlechartwrapper.data.ScatterPlotDataAppender;
import googlechartwrapper.interfaces.ILinearable;
import googlechartwrapper.interfaces.IMarkable;
import googlechartwrapper.label.AxisLabelAppender;
import googlechartwrapper.label.AxisLabelContainer;
import googlechartwrapper.label.ChartLegend;
import googlechartwrapper.label.ChartTitle;
import googlechartwrapper.label.IChartLegendable;
import googlechartwrapper.label.IChartTitleable;
import googlechartwrapper.style.GridLine;
import googlechartwrapper.style.RangeMarker;
import googlechartwrapper.style.ShapeMarker;
import googlechartwrapper.util.GenericAppender;
import googlechartwrapper.util.UpperLimitGenericAppender;
import googlechartwrapper.util.UpperLimitGenericAppender.UpperLimitReactions;

import java.awt.Dimension;
import java.util.List;

/** 
 * Specifies a scatter plot <a href="http://code.google.com/apis/chart/#scatter_plot">
 * http://code.google.com/apis/chart/#scatter_plot</a>
 * 
 * @author steffan
 *
 */
public class ScatterPlot extends AbstractChart implements ILinearable, IMarkable, IChartLegendable, IChartColorable, IChartTitleable, IMultiDataScaleable{

	protected UpperLimitGenericAppender<LinearGradient> linearGradientAppender = new UpperLimitGenericAppender<LinearGradient>(
			ChartTypeFeature.LinearGradient, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<LinearStripes> linearStripesAppender = new UpperLimitGenericAppender<LinearStripes>(
			ChartTypeFeature.LinearStripes, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<ChartTitle> chartTitleAppender = new UpperLimitGenericAppender<ChartTitle>(
			ChartTypeFeature.ChartTitle, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<ChartLegend> chartLegendAppender = new UpperLimitGenericAppender<ChartLegend>(
			ChartTypeFeature.ChartLegend, 1, UpperLimitReactions.RemoveFirst);	
	protected GenericAppender<ChartColors> chartColorAppender = new GenericAppender<ChartColors>(
			ChartTypeFeature.ChartColor, ",");
	protected UpperLimitGenericAppender<DataScalingSet> dataScalingAppender = new UpperLimitGenericAppender<DataScalingSet>(
			ChartTypeFeature.DataScaling, 1, UpperLimitReactions.RemoveFirst);
	protected GenericAppender<RangeMarker> rangeMarkerAppender = 
    	new GenericAppender<RangeMarker>(ChartTypeFeature.Marker);
    protected  GenericAppender<ShapeMarker> shapeMarkerAppender =
    	new GenericAppender<ShapeMarker>(ChartTypeFeature.Marker);
    protected UpperLimitGenericAppender<GridLine> gridLineAppender =
    	new UpperLimitGenericAppender<GridLine>(ChartTypeFeature.GridLine, 1,UpperLimitReactions.RemoveFirst);
    protected AxisLabelAppender axisLabelAppender = 
		new AxisLabelAppender();
    protected ScatterPlotDataAppender scatterPlotDataAppender = new ScatterPlotDataAppender();
	
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

		public DataScalingSet getDataScaling() {

			return this.dataScalingAppender.getList().size() > 0 ? this.dataScalingAppender
					.getList().get(0)
					: null;
		}

		public void setDataScaling(DataScalingSet ds) {	
				
			this.dataScalingAppender.add(ds);
			
			if(ds != null)
				this.scatterPlotDataAppender.setEncoder(new DataScalingTextEncoder());				

		}

		public LinearStripes getLinearStripes() {
			
			return this.linearStripesAppender.getList().size() > 0 ? this.linearStripesAppender.getList().get(0) : null;
		}

		public LinearGradient getLinearGradient() {
			
			return this.linearGradientAppender.getList().size() > 0 ? this.linearGradientAppender.getList().get(0) : null;
		}

		public void removeDataScaling() {
			
			this.dataScalingAppender.removeAll();
			
			this.scatterPlotDataAppender.setEncoder(new AutoEncoder());			
			
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
			
			return this.removeShapeMarker(index);
		}

		public boolean removeShapeMarker(ShapeMarker sm) {
			
			return this.shapeMarkerAppender.remove(sm);
		}

		public GridLine getGridLine() {
			
			return this.gridLineAppender.getList().size() > 0 ? this.gridLineAppender.getList().get(0) : null;
		}

		public void removeGridLine() {
			
			this.gridLineAppender.removeAll();
			
		}

		public void setGridLine(GridLine gl) {
				
			if(gl == null){				
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

}
