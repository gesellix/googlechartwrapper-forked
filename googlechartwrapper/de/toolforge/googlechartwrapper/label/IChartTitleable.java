package de.toolforge.googlechartwrapper.label;

/**
 * 
 * @author steffan
 *
 */
public interface IChartTitleable {

	/**
	 * 
	 * @param title
	 */
	public void setChartTitle (ChartTitle title);
	
	/**
	 * 
	 */
	public void removeChartTitle ();
	
	/**
	 * 
	 * @return
	 */
	public ChartTitle getChartTitle();
	
}
