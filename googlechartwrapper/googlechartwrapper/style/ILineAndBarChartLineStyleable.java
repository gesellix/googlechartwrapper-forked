package googlechartwrapper.style;

import java.util.List;

/**
 * 
 * @author steffan
 * 
 * @see LineAndBarChartLineStyle
 *
 */
public interface ILineAndBarChartLineStyleable {
	
	/**
	 * Adds a {@link LineAndBarChartLineStyle} to the chart.
	 * 
	 * @param lineStyle the {@link LineAndBarChartLineStyle} to add
	 */
	public void addLineAndBarChartLineStyle(LineAndBarChartLineStyle lineStyle);
	
	/**
	 * Returns a unmodifiable list of {@link LineAndBarChartLineStyle}.
	 * 
	 * @return unmodifiable list or empty list if nothing was set
	 */
	public List<LineAndBarChartLineStyle> getAllLineAndBarChartLineStyles();
	
	/**
	 * Removes a {@link LineAndBarChartLineStyle} at the given index
	 * 
	 * @param index
	 * @return the removed {@link LineAndBarChartLineStyle}
	 * 
	 * @throws IndexOutOfBoundsException if index is out of bounds
	 */
	public LineAndBarChartLineStyle removeLineAndBarChartLineStyle(int index);
	
	/**
	 * REmoves a given {@link LineAndBarChartLineStyle}.
	 * @param lineStyle
	 * @return {@code true} if success
	 */
	public boolean removeLineAndBarChartLineStyle(LineAndBarChartLineStyle lineStyle);
	
	/**
	 * Removes all {@link LineAndBarChartLineStyle}.
	 */
	public void removeAllLineAndBarChartLineStyles();	

}
