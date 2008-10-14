package googlechartwrapper;

import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.color.FillArea;
import googlechartwrapper.color.IFillAreaable;
import googlechartwrapper.interfaces.IMarkable;
import googlechartwrapper.label.AxisLabelAppender;
import googlechartwrapper.label.AxisLabelSummary;
import googlechartwrapper.label.ChartTitle;
import googlechartwrapper.label.IAxisLabelable;
import googlechartwrapper.label.IChartTitleable;
import googlechartwrapper.style.GridLine;
import googlechartwrapper.style.IGridLineable;
import googlechartwrapper.style.IShapeMarkable;
import googlechartwrapper.style.RangeMarker;
import googlechartwrapper.style.ShapeMarker;
import googlechartwrapper.util.GenericAppender;
import googlechartwrapper.util.UpperLimitGenericAppender;
import googlechartwrapper.util.UpperLimitGenericAppender.UpperLimitReactions;

import java.awt.Dimension;
import java.util.List;

public class RadarChart extends AbstractChart implements IGridLineable, IShapeMarkable, 
	IAxisLabelable, IFillAreaable, IChartTitleable, IMarkable{
	
	private boolean curved;
	
	protected GenericAppender<GridLine> gridLines = 
		new UpperLimitGenericAppender<GridLine>(ChartTypeFeature.GridLine,
				1,UpperLimitReactions.RemoveAll);
	protected GenericAppender<RangeMarker> rangeMarker = 
		new GenericAppender<RangeMarker>(ChartTypeFeature.Marker);
	protected GenericAppender<ShapeMarker> shapeMarker = 
		new GenericAppender<ShapeMarker>(ChartTypeFeature.Marker);
	protected AxisLabelAppender axisLabels = 
		new AxisLabelAppender();
	protected GenericAppender<FillArea> fillAreas = new GenericAppender<FillArea>(ChartTypeFeature.FillArea);
	protected GenericAppender<ChartTitle> title = 
		new UpperLimitGenericAppender<ChartTitle>(ChartTypeFeature.ChartTitle,
			1,UpperLimitReactions.RemoveAll);
	
	public RadarChart(Dimension chartDimension, boolean curved) {
		super(chartDimension);
		this.curved= curved;
	}

	@Override
	protected ChartType getChartType() {
		return ChartType.RadarChartStraightLines;
	}

	@Override
	protected String getUrlChartType() {
		return curved ? ChartType.RadarChartStraightLines.getPrefix() : ChartType.RadarChartSplines.getPrefix();
	}

	public void setGridLine(GridLine gl) {
		if (gl == null){
			gridLines.removeAll();
		}
		else {
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

	public void addAxisLabelSummary(AxisLabelSummary labelSummary) {
		axisLabels.addAxis(labelSummary);
	}

	public List<AxisLabelSummary> getAxisLabelSummaries() {
		return axisLabels.getList();
	}

	public void removeAllAxisLabelSummaries() {
		axisLabels.removeAll();
	}

	public AxisLabelSummary removeAxisLabelSummary(int index) {
		return axisLabels.removeAxis(index);
	}

	public boolean removeAxisLabelSummary(AxisLabelSummary labelSummary) {
		return axisLabels.removeAxis(labelSummary);
	}

	public void addFillArea(FillArea fa) {
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
		if (title == null){
			this.title.removeAll();
		}
		else {
			this.title.add(title);
		}
	}

	public IEncoder getEncoder() {
		
		//TODO ka, wie das der radar chart so macht, siehe venndigramm
		
		return null;
	}

	public GridLine getGridLine() {
		
		return this.gridLines.getList().size() > 0 ? this.gridLines.getList().get(0) : null;
	}

	public ChartTitle getChartTitle() {
		
		return this.title.getList().size() > 0 ? this.title.getList().get(0) : null;
	}	

}
