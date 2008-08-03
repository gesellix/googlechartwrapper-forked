package googlechartwrapper;

import java.awt.Dimension;
import java.text.MessageFormat;

public class BarChart extends Chart{

	BarChartOrientation orientation;
    BarChartStyle style;
    int barWidth;
    
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
	
	public void SetBarWidth(int width)
    {
        this.barWidth = width;
    }
	
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
