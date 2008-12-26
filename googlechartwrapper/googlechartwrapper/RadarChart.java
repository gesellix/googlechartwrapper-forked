package googlechartwrapper;

import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.color.ChartColors;
import googlechartwrapper.color.FillArea;
import googlechartwrapper.color.IFillAreaable;
import googlechartwrapper.color.SolidFill;
import googlechartwrapper.data.RadarChartLine;
import googlechartwrapper.data.RadarChartLineAppender;
import googlechartwrapper.interfaces.IColorable;
import googlechartwrapper.interfaces.IMarkable;
import googlechartwrapper.label.AxisLabelAppender;
import googlechartwrapper.label.AxisLabelContainer;
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

/**
 * @author mart
 * @author steffan
 *
 */
public class RadarChart extends AbstractChart implements IGridLineable, IShapeMarkable, 
	IAxisLabelable, IFillAreaable, IChartTitleable, IMarkable, IColorable{
	
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
	protected GenericAppender<FillArea> fillAreas = 
		new GenericAppender<FillArea>(ChartTypeFeature.FillArea);
	protected GenericAppender<ChartTitle> title = 
		new UpperLimitGenericAppender<ChartTitle>(ChartTypeFeature.ChartTitle,
			1,UpperLimitReactions.RemoveAll);
	protected RadarChartLineAppender radarChartLineAppender = 
		new RadarChartLineAppender();
	
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
	
	/**
	 * Adds a {@link RadarChartLine} to the {@link RadarChartLineAppender}
	 * of this charts' instance.
	 * @param line line to add
	 * @see RadarChartLineAppender#add(RadarChartLine)
	 */
	public void addRadarChartLine (RadarChartLine line){
		radarChartLineAppender.add(line);
	}
	
	/**
	 * Removes a {@link RadarChartLine} of the {@link RadarChartLineAppender}
	 * of this charts' instance.
	 * @param line line to remove
	 * @see RadarChartLineAppender#remove(RadarChartLine)
	 */
	public boolean removeRadarChartLine (RadarChartLine m){
		return radarChartLineAppender.remove(m);
	}
	
	/**
	 * Removes a {@link RadarChartLine} of the {@link RadarChartLineAppender}
	 * of this charts' instance.
	 * @param index index to remove
	 * @see RadarChartLineAppender#remove(int)
	 */
	public RadarChartLine removeRadarChartLine (int index){
		return radarChartLineAppender.remove(index);
	}
	
	/**
	 * Removes all {@link RadarChartLine}s of this chart.
	 */
	public void removeAllRadarChartLines (){
		radarChartLineAppender.removeAll();
	}
	
	/**
	 * Returns the list of all {@link RadarChartLine} elements added to this chart. 
	 * It returns an unmodifiable view of the value list.
	 * Consequently "read-only" access is possible.
	 * @return unmodifiable view of the values
	 */
	public List<? extends RadarChartLine> getRadarChartLineList (){
		return radarChartLineAppender.getList();
	}

	/**
	 * Returns the encoder of the underlying {@link RadarChartLineAppender}.
	 */
	public IEncoder getEncoder() {
		return radarChartLineAppender.getEncoder();
	}
	
	/**
	 * Sets the {@link IEncoder} of the underlying {@link RadarChartLineAppender}.
	 * Note, that Points of value zero (0, A or AA depending on the type of encoding) 
	 * are drawn at the center while those with the maximum value for the encoding 
	 * used are drawn at the perimeter.
	 * @param encoder encoder to set.
	 */
	public void setEncoder (IEncoder encoder){		
		radarChartLineAppender.setEncoder(encoder);
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

	public void addAxisLabelSummary(AxisLabelContainer labelSummary) {
		axisLabels.addAxis(labelSummary);
	}

	public List<AxisLabelContainer> getAxisLabelSummaries() {
		return axisLabels.getList();
	}

	public void removeAllAxisLabelSummaries() {
		axisLabels.removeAll();
	}

	public AxisLabelContainer removeAxisLabelSummary(int index) {
		return axisLabels.removeAxis(index);
	}

	public boolean removeAxisLabelSummary(AxisLabelContainer labelSummary) {
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

	

	public GridLine getGridLine() {
		
		return this.gridLines.getList().size() > 0 ? this.gridLines.getList().get(0) : null;
	}

	public ChartTitle getChartTitle() {
		
		return this.title.getList().size() > 0 ? this.title.getList().get(0) : null;
	}

	public void addChartColor(ChartColors cc) {
		// TODO Auto-generated method stub
		
	}

	public List<ChartColors> getChartColors() {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeAllChartColors() {
		// TODO Auto-generated method stub
		
	}

	public ChartColors removeChartColors(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean removeChartColors(ChartColors cc) {
		// TODO Auto-generated method stub
		return false;
	}

	public void addSolidFill(SolidFill sf) {
		// TODO Auto-generated method stub
		
	}

	public List<SolidFill> getSolidFills() {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeAllSolidFills() {
		// TODO Auto-generated method stub
		
	}

	public SolidFill removeSolidFill(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean removeSolidFill(SolidFill sf) {
		// TODO Auto-generated method stub
		return false;
	}	

}
