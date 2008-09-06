package googlechartwrapper.data;
/**
 * 
 * @author steffan
 *
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
