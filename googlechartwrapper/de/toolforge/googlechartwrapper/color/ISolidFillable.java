package de.toolforge.googlechartwrapper.color;

import java.util.List;

/**
 * The interface for chart types which supports SolidFill.
 * 
 * @author steffan
 *
 */
public interface ISolidFillable {
	
	/**
	 * Adds a new SolidFill to the Chart.
	 * 
	 * @param sf the new SolidFill object
	 * 
	 * @throws IllegalArgumentException if you try to add null
	 */
	public void addSolidFill(SolidFill sf);
	
	/**
	 * Returns a unmodifiable list of SolidFills
	 * 
	 * @return list of SolidFills, can be empty
	 */
	public List<SolidFill> getSolidFills();
	
	/**
	 * Removes SolidFill at the given position.
	 * 
	 * @param index
	 * 
	 * @return the removed SolidFill
	 * 
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public SolidFill removeSolidFill(int index);
	
	/**
	 * Removes an given SolidFill object. 
	 * 
	 * @param sf the SolidFill object in the list
	 * 
	 * @return true if the remove was successful
	 */
	public boolean removeSolidFill(SolidFill sf);
	
	/**
	 * Removes all SolidFillin the list.
	 * 
	 */
	public void removeAllSolidFills();

}
