package googlechartwrapper.data;

import googlechartwrapper.AbstractPieChart;

import java.awt.Color;

/**
 * Slice for the {@link AbstractPieChart}.
 * 
 * 
 * @author steffan
 * @version 03/18/09
 * @see AbstractPieChart
 * @see PieChartSliceBuilder
 */
public class PieChartSlice {

	private int value;
	private Color color = null;
	private String label = null;

	/**
	 * Constructs a new PieChartSlice, use the {@link PieChartSliceBuilder} and the {@link PieChartSliceBuilder#build()} method.
	 * 
	 * @param builder the builder {@link PieChartSliceBuilder}
	 * 
	 * @throws IllegalArgumentException if builder is {@code null}
	 * 
	 * @see PieChartSliceBuilder
	 */
	public PieChartSlice(PieChartSliceBuilder builder) {

		if (builder == null) {
			throw new IllegalArgumentException("builder can not be null");
		}
		
		this.value = builder.value;
		this.color = builder.color;
		this.label = builder.label;
	}


	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}


	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}


	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}


	/**
	 * @param color the color to set
	 * 
	 * @throws IllegalArgumentException if color is {@code null}
	 */
	public void setColor(Color color) {
		
		if(color == null)
			throw new IllegalArgumentException("color can not be null");
		
		this.color = new Color(color.getRGB());
	}


	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}


	/**
	 * @param label the label to set
	 * 
	 * @throws IllegalArgumentException if label is {@code null}
	 */
	public void setLabel(String label) {
		
		if(label == null)
			throw new IllegalArgumentException("label can not be null");
		this.label = label;
	}


	public static class PieChartSliceBuilder {

		private int value;
		private Color color = null;
		private String label = null;

		public PieChartSliceBuilder(int value) {
			this.value = value;
		}
		
		/**
		 * Adds a color to the {@link PieChartSlice} object.
		 * 
		 * @param color
		 * @return {@link PieChartSliceBuilder}
		 * 
		 * @throws IllegalArgumentException if color is {@code null}
		 */
		public PieChartSliceBuilder color(Color color) {

			if (color == null)
				throw new IllegalArgumentException("color can not be null");

			this.color = new Color(color.getRGB());

			return this;
		}
		
		/**
		 * Adds a label to the {@link PieChartSlice} object.
		 * 
		 * @param label
		 * @return {@link PieChartSliceBuilder}
		 * 
		 * @throws IllegalArgumentException if label is {@code null}
		 */
		public PieChartSliceBuilder label(String label) {

			if (label == null)
				throw new IllegalArgumentException("label can not be null");

			this.label = label;

			return this;
		}
		/**
		 * Call this method to build the {@link PieChartSlice} object.
		 * 
		 * @return a {@link PieChartSlice} object
		 */
		public PieChartSlice build() {

			return new PieChartSlice(this);
		}

	}

}
