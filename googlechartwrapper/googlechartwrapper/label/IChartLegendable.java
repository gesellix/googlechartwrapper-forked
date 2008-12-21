package googlechartwrapper.label;

/**
 * The interface for chart types which supports a legend.
 * 
 * @author steffan
 *
 */
public interface IChartLegendable {
	
	/**If you set a new ChartLegendable the old one will be overwritten. <br />
	 * If you set <code> null </null> the ChartLegendable will be removed.
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
