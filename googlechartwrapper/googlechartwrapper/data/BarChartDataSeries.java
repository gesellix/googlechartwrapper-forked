package googlechartwrapper.data;

import java.awt.Color;
import java.util.Collection;
import java.util.List;

/**
 * 
 * @author steffan
 *
 */
public class BarChartDataSeries {
	
	private List<Integer> data;
	private Color color;
	private String label;
	
	public BarChartDataSeries(List<Integer> data, Color color, String label) {
		
		if(data == null)
			throw new IllegalArgumentException("data can not be null");
		if(color == null)
			throw new IllegalArgumentException("color can not be null");
		if(label == null)
			throw new IllegalArgumentException("label can not be null");
		
	}

	/**
	 * @return the data
	 */
	public List<Integer> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<Integer> data) {
		this.data = data;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

}
