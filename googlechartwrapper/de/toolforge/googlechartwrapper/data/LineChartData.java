package de.toolforge.googlechartwrapper.data;

import java.util.ArrayList;
import java.util.List;

import de.toolforge.googlechartwrapper.Color;
import de.toolforge.googlechartwrapper.LineChart;
import de.toolforge.googlechartwrapper.label.ChartLegend;
import de.toolforge.googlechartwrapper.style.LineStyle;

/**
 * 
 * @author steffan
 * 
 * @see LineChart
 * 
 */
public class LineChartData {

	private List<Float> dataSet = null;
	private Color color = null;
	private ChartLegend legend = null;
	private LineStyle style = null;

	/**
	 * Use the {@link LineChartDataBuilder} to build an {@link LineChartData} object.
	 * 
	 * @param builder {@link LineChartDataBuilder}
	 * 
	 * @throws IllegalArgumentException if builder is {@code null}
	 */
	public LineChartData(LineChartDataBuilder builder) {

		if (builder == null)
			throw new IllegalArgumentException("builder can not be null");

		this.dataSet = new ArrayList<Float>(builder.dataSet);
		this.color = builder.color;
		this.legend = builder.legend;
		this.style = builder.style;
	}

	/**
	 * 
	 * @author steffan
	 *
	 */
	public static class LineChartDataBuilder {

		private List<Float> dataSet = null;
		private Color color = null;
		private ChartLegend legend = null;
		private LineStyle style = null;

		/**
		 * 
		 * @param dataSet
		 * 
		 * @throws IllegalArgumentException
		 *             if dataSet is {@code null } or value is {@code null}
		 */
		public LineChartDataBuilder(List<Float> dataSet) {

			if (dataSet == null) {
				throw new IllegalArgumentException("dataSet can not be null");
			} else {
				for (Float temp : new ArrayList<Float>(dataSet)) {

					if (temp == null)
						throw new IllegalArgumentException(
								"integer can not be null");
				}
				this.dataSet = new ArrayList<Float>(dataSet);
			}
		}

		/**
		 * 
		 * @param color
		 * @return {@link LineChartDataBuilder}
		 * 
		 * @throws IllegalArgumentException if color is {@code null}
		 */
		public LineChartDataBuilder color(Color color) {

			if(color == null)
				throw new IllegalArgumentException("color can not be null");
			
			this.color = color;
			return this;

		}
		
		/**
		 * 
		 * @param color
		 * @return {@link LineChartDataBuilder}
		 * 
		 * @throws IllegalArgumentException if color is {@code null}
		 * @deprecated use {@link #color(Color)}
		 */
		public LineChartDataBuilder color(java.awt.Color color) {

			if(color == null)
				throw new IllegalArgumentException("color can not be null");
			
			this.color = new Color(color);
			return this;

		}

		/**
		 * 
		 * @param legend
		 * @return {@link LineChartDataBuilder}
		 * 
		 * @throws IllegalArgumentException if legend is {@code null}
		 */
		public LineChartDataBuilder legend(ChartLegend legend) {

			if(legend == null)
			throw new IllegalArgumentException("legend can not be null");
			
			this.legend = legend;
			return this;

		}
		/**
		 * 
		 * @param style
		 * @return {@link LineChartDataBuilder}
		 * 
		 * @throws IllegalArgumentException if style is {@code null}
		 */
		public LineChartDataBuilder lineStyle(LineStyle style){
			
			if(style == null)
				throw new IllegalArgumentException("style can not be null");
			this.style = style;
			return this;
		}
		/**
		 * 
		 * @return the new {@link LineChartData} instance.
		 */
		public LineChartData build() {
			return new LineChartData(this);
		}
	}

	/**
	 * @return the dataSet
	 */
	public List<Float> getDataSet() {
		return new ArrayList<Float>(dataSet);
	}

	/**
	 * @param dataSet the dataSet to set
	 * @throws IllegalArgumentException
	 *             if dataSet is {@code null } or value is {@code null}
	 */
	public void setDataSet(List<Float> dataSet) {
		
		if (dataSet == null) {
			throw new IllegalArgumentException("dataSet can not be null");
		} else {
			for (Float temp : new ArrayList<Float>(dataSet)) {

				if (temp == null)
					throw new IllegalArgumentException(
							"value can not be null");
			}
			this.dataSet = new ArrayList<Float>(dataSet);
		}		
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		
		if(color != null){
		return color;
		}
		return null;
	}

	/**
	 * @param color the color to set
	 * 
	 * @throws IllegalArgumentException if color is {@code null}
	 */
	public void setColor(Color color) {
		
		if(color == null)
			throw new IllegalArgumentException("color can not be null");
		this.color = color;
	}
	
	/**
	 * @param color the color to set
	 * 
	 * @throws IllegalArgumentException if color is {@code null}
	 * @deprecated use {@link #setColor(Color)}
	 */
	public void setColor(java.awt.Color color) {
		if(color == null)
			throw new IllegalArgumentException("color can not be null");
		this.setColor(new Color(color));
	}

	/**
	 * @return the legend
	 */
	public ChartLegend getLegend() {
		return legend;
	}

	/**
	 * @param legend the legend to set
	 * 
	 * @throws IllegalArgumentException if legend is {@code null}
	 */
	public void setLabel(ChartLegend legend) {
		
		if(legend == null)
			throw new IllegalArgumentException("legend can not be null");
		
		this.legend = legend;
	}

	/**
	 * @return the style
	 */
	public LineStyle getStyle() {
		return style;
	}

	/**
	 * @param style the style to set
	 * 
	 * @throws IllegalArgumentException if style is {@code null}
	 */
	public void setStyle(LineStyle style) {
		if(style == null)
			throw new IllegalArgumentException("style can not be null");
		this.style = style;
		
	}

}
