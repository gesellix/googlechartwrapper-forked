package de.toolforge.googlechartwrapper.style;

import java.util.List;

/**
 * The interface for chart types which supports RangeMarkers.
 * 
 *  @author steffan
 *
 */
public interface IRangeMarkable {
	
	/**
	 * Adds an new RangeMarker to the Chart.
	 * 
	 * @param rm the new RangeMarker
	 * 
	 * @throws IllegalArgumentException if you try to add <code>null</code>
	 */
	public void addRangeMarker(RangeMarker rm);
	
	/**
	 * Returns a unmodifiable list of RangeMarkers.
	 * 
	 * @return list of RangeMarker, can be empty
	 */
	public List<RangeMarker> getRangeMarkers();
	
	/**
	 * Removes an RangeMarker at the given position.
	 * 
	 * @param index
	 * 
	 * @return the removed RangeMarker
	 * 
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public RangeMarker removeRangeMarker(int index);
	
	/**
	 * Removes an given RangeMarker object. 
	 * 
	 * @param rm the RAngeMarker object in the lsit
	 * 
	 * @return true if the remove was successful
	 */
	public boolean removeRangeMarker(RangeMarker rm);
	
	/**
	 * Removes all RangeMarkers in the list.
	 * 
	 */
	public void removeAllRangeMarkers();
	
	

}
