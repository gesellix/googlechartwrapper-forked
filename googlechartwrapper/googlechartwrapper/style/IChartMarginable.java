package googlechartwrapper.style;

/**
 * 
 * @author steffan
 *
 */
public interface IChartMarginable {

	/**If you set a new ChartMargin the old one will be overwritten. <br />
	 * If you set <code> null </null> the ChartMargin will be removed.
	 * 
	 * @param cm the new ChartMargin
	 */
	public void setChartMargin(ChartMargin cm);
	
	/**
	 * Removes the ChartMargin.
	 * 
	 */
	public void removeChartMargin();
	
	/**
	 * Returns the ChartMargin, or null if this Chart contains no ChartMargin.
	 * 
	 * @return the ChartMargin, or null if this Chart contains no ChartMargin.
	 */
	public ChartMargin getChartMargin();
}
