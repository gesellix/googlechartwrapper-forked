package googlechartwrapper.style;

import googlechartwrapper.util.IFeatureAppender;

import java.awt.Color;
import java.util.List;

/**
 * Specifies a RangeMarker <a href="http://code.google.com/apis/chart/#shape_markers2">http://code.google.com/apis/chart/#shape_markers2</a> 
 * @author steffan
 *
 */
public class ShapeMarker implements IFeatureAppender {
	
	private MarkerTyp markerTyp;
	private Color color;
	private int dataSetIndex;	
	private float dataPoint;
	private int size;
	private Priority priority;
	
	
	/**
	 * Constructs a shapemaker
	 * 
	 * @param markerTyp
	 * @param color
	 * @param dataSetIndex
	 * @param dataPoint
	 * @param size
	 * 
	 * @throws IllegalArgumentException
	 */
	public ShapeMarker(MarkerTyp markerTyp, Color color, int dataSetIndex, float dataPoint, int size){
	
		if(markerTyp == null)
			throw new IllegalArgumentException("markerTyp can not be null");		
		if(color == null)
			throw new IllegalArgumentException("color can not be null");
		if(dataSetIndex < 0)
			throw new IllegalArgumentException("dataSetIndex must be 0 or higher");
		if(size < 0)
			throw new IllegalArgumentException("size out of range");
		
		this.markerTyp = markerTyp;
		this.color = color;
		this.dataPoint = dataPoint;
		this.size = size;
	
	}
	/**
	 * Constructs a shapemarker
	 * 
	 * @param markerTyp
	 * @param color
	 * @param dataSetIndex
	 * @param dataPoint
	 * @param size
	 * @param priority
	 * 
	 * @throws IllegalArgumentException
	 */
	public ShapeMarker(MarkerTyp markerTyp, Color color, int dataSetIndex, float dataPoint, int size,Priority priority){
		
		if(dataSetIndex < 0)
			throw new IllegalArgumentException("dataSetIndex must be 0 or higher");
		if(markerTyp == null)
			throw new IllegalArgumentException("markerTyp can not be null");		
		if(color == null)
			throw new IllegalArgumentException("color can not be null");
		if(dataSetIndex < 0)
			throw new IllegalArgumentException("dataSetIndex must be 0 or higher");
		if(size < 0)
			throw new IllegalArgumentException("size out of range");
		
		this.markerTyp = markerTyp;
		this.color = color;
		this.dataPoint = dataPoint;
		this.size = size;
		this.priority = priority;
	
	}
	/**
	 * 
	 * @param color
	 */
	public void setColor(Color color){
		this.color = color;
	}
	/**
	 * 
	 * @return
	 */
	public Color getColor(){
		return this.color;
	}
	/**
	 * 
	 * @param markerTyp
	 * 
	 * @throws IllegalArgumentException if markerTyp <code>null</code>
	 */
	public void setMarkerTyp(MarkerTyp markerTyp){
		if(markerTyp == null)
			throw new IllegalArgumentException("markerTyp can not be null");	
		this.markerTyp = markerTyp;
	}
	/**
	 * 
	 * @return
	 */
	public MarkerTyp getMarkerTyp(){
		return this.markerTyp;
	}
	/**
	 * 
	 * @return
	 * 
	 * 
	 */
	public int getSize(){
		return this.size;
	}
	/**
	 * 
	 * @param size
	 * 
	 * @throws IllegalArgumentException if index out of range
	 */
	public void setSize(int size){
		if(size < 0)
			throw new IllegalArgumentException("size out of range");
		this.size = size;
	}
	public float getDataPoint(){
		return this.dataPoint;
	}
	
	/**
	 * 
	 * @param dataPoint
	 */
	public void setDataPoint(float dataPoint){
		this.dataPoint = dataPoint;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getDataSetIndex() {
		return dataSetIndex;
	}
	
	/**
	 * 
	 * @param dataSetIndex
	 * 
	 * @throws IllegalArgumentException if dataSetIndex < 0
	 */
	public void setDataSetIndex(int dataSetIndex) {

		if(dataSetIndex < 0)
			throw new IllegalArgumentException("dataSetIndex must be 0 or higher");
		if(markerTyp == null)
		this.dataSetIndex = dataSetIndex;
	}
	
	/**
	 * 
	 * @return
	 */
	public Priority getPriority() {
		return priority;
	}
	
	/**
	 * 
	 * @param priority
	 * 
	 * @throws IllegalArgumentException if markerTyp <code>null</code>
	 */
	public void setPriority(Priority priority) {
		if(markerTyp == null)
			throw new IllegalArgumentException("markerTyp can not be null");
		this.priority = priority;
	}

	public String getAppendableString(List<? extends IFeatureAppender> otherAppenders) {
		StringBuilder builder = new StringBuilder();
		
		
			builder.append(this.markerTyp.getMarkerChar());			
			builder.append(',');			
			builder.append(Integer.toHexString(this.color.getRGB()).substring(2,8));
			builder.append(',');
			builder.append(this.dataSetIndex);
			builder.append(',');
			builder.append(this.dataPoint);
			builder.append(',');
			builder.append(this.size);
			
			if(this.priority != null){
				builder.append(',');
				builder.append(this.priority.getPriority());
			}		
		
		return builder.toString();
	}
	/**
	 * 
	 * @author steffan
	 *
	 */
	public enum MarkerTyp{
		
		Arrow('a'),
		Cross('c'),
		Diamond('d'),
		Circle('o'),
		Square('s'),
		Text('t'),
		/**
		 * represents a vertical line from the x-axis to the data point.
		 */
		VerticalLineFrom('v'),
		VerticalLineTo('V'),
		HorizontalLine('h'),
		XShape('x');
		
		
		
		private char markerChar;
			
		MarkerTyp(char markerChar) {
			this.markerChar = markerChar;
		}
		
		public char getMarkerChar(){
			return this.markerChar;
		}		
	}
	
	/**
	 * 
	 * @author steffan
	 *
	 */
	public enum Priority{
		
		First(1),
		Default(0),
		Last(-1);
		
		private int priority;
		
		Priority(int priority) {
			this.priority = priority;
		}
		
		public int getPriority() {
			return this.priority;
		}
		
	
		
		
	}

}
