package googlechartwrapper.data;

import googlechartwrapper.PieChart;

import java.awt.Color;

/**
 * Slice of {@link PieChart}. 
 * If the number of colors specified is less than the number of slices, 
 * then colors are interpolated.
 * @see PieChart
 */
public class PieChartSlice{
	
	private int data;
	private Color color;
	private String label;	
	
	/**
	 * Constructs a new PieChartSlice with the given data. 
	 * @param data value, is transformed to percentages by the google api
	 */
	public PieChartSlice(int data) {
		super();
		if (data <0){
			throw new IllegalArgumentException("data cannot be <0");
		}
		this.data = data;
	}
	
	/**
	 * Returns the color of the slice. If the number of colors specified is less 
	 * than the number of slices, then colors are interpolated.
	 * @return color or null, if none set (interpolated)
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Sets the color of the slice.
	 * If the number of colors specified is less than the number of slices, 
	 * then colors are interpolated.
	 * @param color color of the slice, if none set <code>null</code>
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		if (data <0){
			throw new IllegalArgumentException("data cannot be <0");
		}
		this.data = data;
	}
	/**
	 * Returns the label text for the slice.
	 * @return label text, <code>null</code> if none set and displayed
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * Sets the label text for the slice.
	 * @param label text, <code>null</code> if none set and displayed
	 */
	public void setLabel(String label) {
		this.label = label;
	}

}

