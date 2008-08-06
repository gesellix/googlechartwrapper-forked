package googlechartwrapper.markers;

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
	public void addRangeMarker(RangeMarker hrm);
	
	/**
	 * 
	 * @return
	 */
	public List<RangeMarker> getRangeMarkers();

}
