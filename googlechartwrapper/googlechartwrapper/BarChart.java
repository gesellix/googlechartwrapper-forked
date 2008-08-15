package googlechartwrapper;

import googlechartwrapper.style.GridLine;
import googlechartwrapper.style.IGridLineable;
import googlechartwrapper.style.IMarkable;
import googlechartwrapper.style.RangeMarker;
import googlechartwrapper.style.ShapeMarker;
import googlechartwrapper.util.GenericAppender;
import googlechartwrapper.util.UpperLimitGenericAppender;
import googlechartwrapper.util.UpperLimitGenericAppender.UpperLimitReactions;

import java.awt.Dimension;
import java.text.MessageFormat;
import java.util.List;

/**
 * Specifies a bar chart <a href="http://code.google.com/apis/chart/#bar_charts">
 * http://code.google.com/apis/chart/#bar_charts</a>
 * 
 * @author steffan
 *
 */
public class BarChart extends AbstractChart implements IMarkable, IGridLineable{

	private BarChartOrientation orientation;
    private BarChartStyle style;
    private int barWidth;
    
    protected GenericAppender<RangeMarker> rangeMarkerAppender = 
    	new GenericAppender<RangeMarker>(ChartTypeFeature.Marker);
    protected  GenericAppender<ShapeMarker> shapeMarkerAppender =
    	new GenericAppender<ShapeMarker>(ChartTypeFeature.Marker);
    protected UpperLimitGenericAppender<GridLine> gridLineAppender =
    	new UpperLimitGenericAppender<GridLine>(ChartTypeFeature.GridLine, 1,UpperLimitReactions.RemoveFirst);
    
    /**
     * Constructs a bar chart
     * 
     * @param chartDimension the size of the diagram
     * @param orientation the orientation
     * @param style the style
     */
	public BarChart(Dimension chartDimension, BarChartOrientation orientation, BarChartStyle style) {
		super(chartDimension);
		
		 this.orientation = orientation;
         this.style = style;
	}

	@Override
	protected ChartType getChartType() {
		
		return ChartType.BarChart;
	}

	@Override
	protected String getUrlChartType() {
		
		  char orientationChar = this.orientation == BarChartOrientation.Horizontal ? 'v' : 'h';
          char styleChar = this.style == BarChartStyle.Stacked ? 's' : 'g';

          return MessageFormat.format("b{0}{1}", orientationChar, styleChar);
	}
	
	/**
	 * Specify the bar size
	 * 
	 * @param width the size of every single bar
	 */
	public void SetBarWidth(int width)
    {
        this.barWidth = width;
    }
	/**
	 * 
	 * 
	 * @author steffan
	 *
	 */
	public enum BarChartOrientation
    {
        
        Vertical,

       
        Horizontal
    }
	/**
	 * 
	 * @author steffan
	 *
	 */
	 public enum BarChartStyle
	    {
	       
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

	
}
