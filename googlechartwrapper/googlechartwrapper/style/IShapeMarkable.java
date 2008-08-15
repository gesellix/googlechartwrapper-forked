package googlechartwrapper.style;

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
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public ShapeMarker removeShapeMarker(int index);
	
	/**
	 * 
	 * @param rm
	 * @return
	 */
	public boolean removeShapeMarker(ShapeMarker sm);
	
	/**
	 * 
	 */
	public void removeAllShapeMarkers();	
	
	

}
