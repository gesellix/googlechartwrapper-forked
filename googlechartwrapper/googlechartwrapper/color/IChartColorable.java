package googlechartwrapper.color;

import java.util.List;

/**
 * 
 * @author steffan
 *
 */
public interface IChartColorable {
	
public void addChartColor(ChartColors cc);
	
	/**
	 * 
	 * @return
	 */
	public List<ChartColors> getChartColors();
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public ChartColors removeChartColors(int index);
	
	/**
	 * 
	 * @param cc
	 * @return
	 */
	public boolean removeChartColors(ChartColors cc);
	
	/**
	 * 
	 */
	public void removeAllChartColors();

}
