package googlechartwrapper.markers;

import java.awt.Color;

/**
 * 
 * @author steffan
 *
 */
public class HorizontalRangeMarker {
	
	private Color color;
	private int startPoint;
	private int endPoint;
	
	/**
	 * Constructs the horizontal range marker
	 * 
	 * @param color the color of the range
	 * @param startPoint
	 * @param endPoint
	 */
	public HorizontalRangeMarker(Color color, int startPoint,int endPoint){
		
		this.color = color;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		
	}
	/**
	 * 
	 * @param color the color of the range
	 */ 
	public void setColor(Color color){
		
		this.color = color;
	}
	/**
	 * 
	 * @param startPoint
	 * @param endPoint
	 */
	public void setRange(int startPoint, int endPoint){
		
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		
	}
	/**
	 * 
	 * @return the color of the range
	 */
	public Color getColor(){
		
		return this.color;
	}
	/**
	 * 
	 * @return
	 */
	public int getStartPoint(){
		return this.startPoint;
	}
	/**
	 * 
	 * @return
	 */
	public int getStopPoint(){
		return this.endPoint;
	}
}
