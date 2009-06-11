package de.toolforge.googlechartwrapper.data;


import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.toolforge.googlechartwrapper.RadarChart;

/**
 * Data for the {@link RadarChart} which consists of datapoints 
 * and an optional line color. For details concerning the handling of the optional
 * line color refer to the documentation of the used {@link RadarChartLineAppender}.
 * 
 * <p>Points of value zero (0, A or AA depending on the type 
 * of encoding) are drawn at the center while those with the maximum value for 
 * the encoding used are drawn at the perimeter
 * 
 * <p>The first and last point of the dataset are drawn between center and top of the 
 * chart. Remaining values are The remaining points 
 * are evenly spaced traveling clockwise around the chart.
 * (google api, fair use excerpt http://code.google.com/apis/chart/types.html#radar)
 * 
 */
public class RadarChartLine {
	
	private Color color;
	private List<Integer> values;
	
	/**
	 * Constructs a radar chart line with no line color (default by google api)
	 * and no values. Points of value zero (0, A or AA depending on the type 
	 * of encoding) are drawn at the center while those with the maximum value for 
	 * the encoding used are drawn at the perimeter.	
	 * @see RadarChartLineAppender
	 */
	public RadarChartLine(){
		values = new ArrayList<Integer>();
	}
	
	/**
	 * Constructs a radar chart line with the given line color and list as values.
	 * Points of value zero (0, A or AA depending on the type of encoding) are 
	 * drawn at the center while those with the maximum value for the encoding 
	 * used are drawn at the perimeter.
	 * @param color line color
	 * @param values values
	 * @see RadarChartLineAppender
	 */
	public RadarChartLine(Color color, List<Integer> values) {
		super();
		if (values == null){
			throw new IllegalArgumentException("ila");
		}
		this.color = color;
		this.values = values;
	}
	
	/**
	 * Constructs a radar chart line with no line color (default by google api)
	 * and list as values. Points of value zero (0, A or AA depending on the type 
	 * of encoding) are drawn at the center while those with the maximum value for 
	 * the encoding used are drawn at the perimeter.	
	 * @param values values
	 * @see RadarChartLineAppender
	 */
	public RadarChartLine(List<Integer> values) {
		super();
		if (values == null){
			throw new IllegalArgumentException("ila");
		}
		this.values = values;
	}

	
	/**
	 * Returns the line color of the radar chart line. 
	 * If none is specified null is returned.
	 * @return line color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Sets the color of the chart line. 
	 * @param color color or null; if none
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Returns the list of all {@link Integer} elements added to this line. 
	 * It returns an unmodifiable view of the value list.
	 * Consequently "read-only" access is possible
	 * @return unmodifiable view of the values
	 */
	public List<Integer> getValues() {
		return Collections.unmodifiableList(values);
	}
	
	/**
	 * Adds a value to the end of the line value list. The rendering of
	 * each point is determined by the encoder of the chart/chart data appender:
	 * Points of value zero (0, A or AA depending on the type 
	 * of encoding) are drawn at the center while those with the maximum value for 
	 * the encoding used are drawn at the perimeter.
	 * @param val value to add
	 * @see RadarChartLineAppender
	 */
	public void addValue (int val){
		values.add(val);
	}
	
	/**
	 * Adds a value at the index of the line value list. The rendering of
	 * each point is determined by the encoder of the chart/chart data appender:
	 * Points of value zero (0, A or AA depending on the type 
	 * of encoding) are drawn at the center while those with the maximum value for 
	 * the encoding used are drawn at the perimeter.
	 * @param val value to add
	 * @see RadarChartLineAppender
	 */
	public void addValue (int val, int index){
		values.add(index, val);
	}
	
	
	
	

}
