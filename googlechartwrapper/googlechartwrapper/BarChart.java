package googlechartwrapper;

import googlechartwrapper.style.IMarkable;
import googlechartwrapper.style.RangeMarker;
import googlechartwrapper.style.ShapeMarker;
import googlechartwrapper.util.GenericAppender;
import googlechartwrapper.util.IExtendedFeatureAppender;
import googlechartwrapper.util.IFeatureAppender;

import java.awt.Dimension;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Specifies a bar chart <a href="http://code.google.com/apis/chart/#bar_charts">
 * http://code.google.com/apis/chart/#bar_charts</a>
 * 
 * @author steffan
 *
 */
public class BarChart extends AbstractChart implements IMarkable{

	private BarChartOrientation orientation;
    private BarChartStyle style;
    private int barWidth;
    
    private GenericAppender<RangeMarker> rangeMarkerAppender = 
    	new GenericAppender<RangeMarker>(ChartTypeFeature.Markers);
    
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
		
		  char orientationChar = this.orientation == BarChartOrientation.Horizontal ? 'h' : 'v';
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
		// TODO Auto-generated method stub
		
	}

	public List<ShapeMarker> getShapeMarkers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUrl() {
		collectUrlElements(getAllAppenders());
		return generateUrlString();
	}
	
	private List<IExtendedFeatureAppender> getAllAppenders(){
		List<IExtendedFeatureAppender> all = new ArrayList<IExtendedFeatureAppender>();
		all.add(rangeMarkerAppender);
		//to fill
		return all;
	}

}
