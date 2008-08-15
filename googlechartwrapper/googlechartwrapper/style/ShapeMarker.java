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
	
	
	public ShapeMarker(MarkerTyp markerTyp, Color color, int dataSetIndex, float dataPoint, int size){
	
		if(dataSetIndex < 0)
			throw new IllegalArgumentException("dataSetIndex must be 0 or higher");
		
		this.markerTyp = markerTyp;
		this.color = color;
		this.dataPoint = dataPoint;
		this.size = size;
	
	}
	public ShapeMarker(MarkerTyp markerTyp, Color color, int dataSetIndex, float dataPoint, int size,Priority priority){
		
		if(dataSetIndex < 0)
			throw new IllegalArgumentException("dataSetIndex must be 0 or higher");
		
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
	public void setMarkerTyp(MarkerTyp markerTyp){
		this.markerTyp = markerTyp;
	}
	public MarkerTyp getMarkerTyp(){
		return this.markerTyp;
	}
	public int getSize(){
		return this.size;
	}
	public void setSize(int size){
		this.size = size;
	}
	public float getDataPoint(){
		return this.dataPoint;
	}
	public void setDataPoint(float dataPoint){
		this.dataPoint = dataPoint;
	}
	public int getDataSetIndex() {
		return dataSetIndex;
	}
	public void setDataSetIndex(int dataSetIndex) {
		this.dataSetIndex = dataSetIndex;
	}
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
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
