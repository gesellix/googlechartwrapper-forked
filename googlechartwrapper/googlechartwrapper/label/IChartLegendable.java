package googlechartwrapper.label;

/**
 * The interface for chart types which supports a legend.
 * 
 * @author steffan
 *
 */
public interface IChartLegendable {
	
	/**
	 * 
	 * @param legend
	 */
	public void setChartLegend(ChartLegend legend);
	
	/**
	 * 
	 */
	public void removeChartLegend();
	
	/**
	 * 
	 * @return
	 */
	public ChartLegend getChartLegend();

}
