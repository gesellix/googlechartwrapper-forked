package googlechartwrapper.markers;

import java.util.List;

/**
 * 
 * @author steffan
 *
 */
public interface IShapeMarkable {
	
	/**
	 * 
	 * @param shapeMarker
	 */
	public void addShapeMarker(ShapeMarker shapeMarker);
	
	/**
	 * 
	 * @return
	 */
	public List<ShapeMarker> getShapeMarkers();

}
