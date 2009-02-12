package googlechartwrapper.style;


/**
 * 
 * @author steffan
 *
 */
public interface IBarChartZeroLineable {
	
	/**If you set a new BarChartZeroLine the old one will be overwritten. <br />
	 * If you set <code> null </null> the BarChartZeroLine will be removed.
	 * 
	 * @param bzl the new BarChartZeroLine
	 */
	public void setBarChartZeroLine(BarChartZeroLine bzl);
	
	/**
	 * Removes the BarChartZeroLine.
	 * 
	 */
	public void removeBarChartZeroLine();
	
	/**
	 * Returns the BarChartZeroLine, or null if this Chart contains no BarChartZeroLine.
	 * 
	 * @return the BarChartZeroLine, or null if this Chart contains no BarChartZeroLine.
	 */
	public BarChartZeroLine getBarChartZeroLine();

}
