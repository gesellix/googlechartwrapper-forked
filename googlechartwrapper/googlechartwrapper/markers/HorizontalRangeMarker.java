package googlechartwrapper.markers;

import googlechartwrapper.util.IFeatureAppender;

import java.awt.Color;
import java.util.List;

/**
 * 
 * @author steffan
 *
 */
public class HorizontalRangeMarker implements IFeatureAppender {
	
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
	
	public String getAppendableString(List<IFeatureAppender> otherAppenders) {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("chm=r,");
		
		//append color
		builder.append(Integer.toHexString(color.getRGB()).substring(2,8));
		//append non use value
		builder.append(",0");
		//startpoint
		builder.append("," + Integer.toString(this.startPoint));
		//endpoint
		builder.append(","+Integer.toBinaryString(this.endPoint)+"|");
		
		return builder.toString();
	}
}
