package googlechartwrapper.style;

import java.util.List;

/**
 * The interface for chart types which supports horizontal range markers
 *  @author steffan
 *
 */
public interface IRangeMarkable {
	
	/**
	 * 
	 * @param hrm
	 */
	public void addRangeMarker(RangeMarker rm);
	
	/**
	 * 
	 * @return
	 */
	public List<RangeMarker> getRangeMarkers();
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public RangeMarker removeRangeMarker(int index);
	
	/**
	 * 
	 * @param rm
	 * @return
	 */
	public boolean removeRangeMarker(RangeMarker rm);
	
	/**
	 * 
	 */
	public void removeAllRangeMarkers();
	
	

}
