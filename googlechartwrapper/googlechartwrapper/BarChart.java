package googlechartwrapper;

import java.awt.Dimension;
import java.text.MessageFormat;

/**
 * Specifies a bar chart <a href="http://code.google.com/apis/chart/#bar_charts">
 * http://code.google.com/apis/chart/#bar_charts</a>
 * 
 * @author steffan
 *
 */
public class BarChart extends AbstractChart{

	private BarChartOrientation orientation;
    private BarChartStyle style;
    private int barWidth;
    
    /**
     * Constructs a bar cahrt
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
	@Override
	 protected  void collectUrlElements(){
		
		 super.collectUrlElements();
		 
         if (this.barWidth != 0)
         {
             super.urlElements.offer(MessageFormat.format("chbh={0}", this.barWidth));
         }
		 
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

}
