package de.toolforge.googlechartwrapper.style;

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
	 * @param fm
	 */
	public void addFinancialMarker(FinancialMarker fm);
	
	/**
	 * 
	 * @return list of {@link FinancialMarker}
	 */
	public List<FinancialMarker> getFinancialMarkers();
	
	/**
	 * 
	 * @param index
	 * @return the removed {@link FinancialMarker}
	 */
	public FinancialMarker removeFinancialMarker(int index);
	
	/**
	 * 
	 * @param fm
	 * @return {@code true} if success
	 */
	public boolean removeFinancialMarker(FinancialMarker fm);
	
	/**
	 * 
	 */
	public void removeAllFinancialMarkers();	

}
