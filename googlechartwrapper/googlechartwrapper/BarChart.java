package googlechartwrapper;

import java.awt.Dimension;
import java.text.MessageFormat;

/**
 * 
 * @author steffan
 *
 */
public class BarChart extends AbstractChart{

	BarChartOrientation orientation;
    BarChartStyle style;
    int barWidth;
    
    /**
     * Constructs 
     * 
     * @param chartDimension
     * @param orientation
     * @param style
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
	 * @author steffan
	 *
	 */
	public enum BarChartOrientation
    {
        /// <summary>
        /// Bars will be positioned vertically
        /// </summary>
        Vertical,

        /// <summary>
        /// Bars will be positioned horizontally
        /// </summary>
        Horizontal
    }
	/**
	 * 
	 * @author steffan
	 *
	 */
	 public enum BarChartStyle
	    {
	        /// <summary>
	        /// Multiple data sets will be stacked.
	        /// </summary>
	        Stacked,

	        /// <summary>
	        /// Multiple data sets will be grouped.
	        /// </summary>
	        Grouped
	    }

}
