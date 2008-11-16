package googlechartwrapper.color;

import java.util.List;

/**
 * The interface for chart types which supports ChartColor.
 * 
 * @author steffan
 *
 */
public interface IChartColorable {
	
	/**
	 * Adds a new ChartColor to the Chart.
	 * 
	 * @param cc the new ChartColor object
	 * 
	 * @throws IllegalArgumentException if you try to add null
	 */
	public void addChartColor(ChartColors cc);
	
	/**
	 * Returns a unmodifiable list of ChartColors
	 * 
	 * @return list of ChartColors, can be empty
	 */
	public List<ChartColors> getChartColors();
	
	/**
	 * Removes ChartColor at the given position.
	 * 
	 * @param index
	 * 
	 * @return the removed ChartColor
	 * 
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public ChartColors removeChartColors(int index);
	
	/**
	 * Removes an given ChartColors object. 
	 * 
	 * @param rm the ChartColors object in the list
	 * 
	 * @return true if the remove was successful
	 */
	public boolean removeChartColors(ChartColors cc);
	
	/**
	 * Removes all ChartColors in the list.
	 * 
	 */
	public void removeAllChartColors();

}
