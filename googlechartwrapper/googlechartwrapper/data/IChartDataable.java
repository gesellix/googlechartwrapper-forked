package googlechartwrapper.data;
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
	 * @return
	 */
	public ChartData getChartData();

}
