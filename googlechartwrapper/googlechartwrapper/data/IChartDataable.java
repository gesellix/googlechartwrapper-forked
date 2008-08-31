package googlechartwrapper.data;


/**
 * 
 * @author steffan
 *
 */
public interface IChartDataable {
	
	public void setChartData(ChartData cd);
	
	public void removeChartData();
	
	public ChartData getChartData();

}
