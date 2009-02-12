package googlechartwrapper.style;

import java.util.List;

/**
 * 
 * @author steffan
 *
 */
public interface IFinancialMarkable {
	
	/**
	 * 
	 * 
	 * @param lineStyle
	 */
	public void addFinancialMarker(FinancialMarker fm);
	
	/**
	 * 
	 * @return
	 */
	public List<FinancialMarker> getFinancialMarkers();
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public FinancialMarker removeFinancialMarker(int index);
	
	/**
	 * 
	 * @param lineStyle
	 * @return
	 */
	public boolean removeFinancialMarker(FinancialMarker fm);
	
	/**
	 * 
	 */
	public void removeAllFinancialMarkers();	

}
