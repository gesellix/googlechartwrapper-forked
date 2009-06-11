package de.toolforge.googlechartwrapper.data;
/**
 * 
 * @author steffan
 * @deprecated unused
 */
public interface IChartDataable {
	
	/**
	 * 
	 * @param cd
	 */
	public void setChartData(ChartData cd);
	
	/**
	 * 
	 */
	public void removeChartData();
	
	/**
	 * 
	 * @return the {@link ChartData}
	 */
	public ChartData getChartData();

}
