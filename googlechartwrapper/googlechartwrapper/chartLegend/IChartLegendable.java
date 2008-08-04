package googlechartwrapper.chartLegend;

import java.util.Collection;

/**
 * The interface for chart types which supports a legend.
 * 
 * @author steffan
 *
 */
public interface IChartLegendable {
	
	/**
	 * Adds an array of strings for the legend.
	 * @param legend array of string
	 */
	public void AddChartLegend(String[] legend);
	
	/**
	 * Adds a collection of strings for the legend.
	 * @param legend collection of string
	 */
	public void AddChartLegend(Collection<String> legend);

}
