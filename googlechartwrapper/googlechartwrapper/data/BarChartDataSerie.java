package googlechartwrapper.data;

import googlechartwrapper.label.ChartLegend;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * <p>
 * Here are some examples of how BarChartDataSerie can be used:
 * <p>
 * <blockquote>
 * 
 * <pre>
 * BarChartDataSerie series = new BarChartDataSerie.BarChartDataSerieBuilder(Arrays.asList(10,50,60,80,40)).color(Color.BLACK).legend(new ChartLegend("legend")).build();
 * 
 * 
 * </pre>
 * 
 * </blockquote>
 * <p>
 * 
 * @author steffan
 * 
 */
public class BarChartDataSerie {

	private List<Integer> dataSet;
	private Color color;
	private ChartLegend legend;

	/**
	 * Constructs a new {@link BarChartDataSerie}
	 * @param builder
	 * @see BarChartDataSerieBuilder
	 * 
	 * @throws IllegalArgumentException if builder is {@code null}
	 */
	public BarChartDataSerie(BarChartDataSerieBuilder builder) {
		
		if (builder == null)
			throw new IllegalArgumentException("builder can not be null");
		
		this.dataSet = builder.dataSet;
		this.color = builder.color;
		this.legend = builder.legend;

	}

	/**
	 * The builder for the {@link BarChartDataSerie#BarChartDataSerie(BarChartDataSerieBuilder)} constructor.
	 * Use the {@link BarChartDataSerieBuilder#build()} method to build the object.
	 * 
	 * @author steffan
	 * 
	 */
	public static class BarChartDataSerieBuilder {

		private List<Integer> dataSet = null;
		private Color color = null;
		private ChartLegend legend = null;

		/**
		 * Constructs a new {@link BarChartDataSerieBuilder}.
		 * 
		 * @param dataSet the values 
		 * 
		 * @throws IllegalArgumentException
		 *             if dataSet or member is {@code null}
		 */
		public BarChartDataSerieBuilder(List<Integer> dataSet) {

			if (dataSet == null)
				throw new IllegalArgumentException("dataSet can not be null");
			List<Integer> temp = Collections.unmodifiableList(dataSet);

			for (Integer current : temp) {
				if (current == null)
					throw new IllegalArgumentException("member can not be null");
			}
			this.dataSet = temp;
		}

		/**
		 * Adds color to the chart
		 * @param color
		 * @return {@link BarChartDataSerieBuilder}
		 * 
		 * @throws IllegalArgumentException if the color is {@code null}
		 */
		public BarChartDataSerieBuilder color(Color color) {

			if (color == null)
				throw new IllegalArgumentException("color can not be null");

			this.color = new Color(color.getRGB());
			return this;

		}
		
		/**
		 * Adds a {@link ChartLegend} to the chart.
		 * 
		 * @param legend
		 * @return {@link BarChartDataSerieBuilder}
		 * 
		 * @throws IllegalArgumentException if legend is {@code null}
		 */
		public BarChartDataSerieBuilder legend(ChartLegend legend) {

			if (legend == null)
				throw new IllegalArgumentException("legend can not be null");

			this.legend = legend;

			return this;

		}
		/**
		 * Constructs the {@link BarChartDataSerie} object for the {@link BarChartDataSerie#BarChartDataSerie(BarChartDataSerieBuilder)} constructor.
		 * @return {@link BarChartDataSerie}
		 */
		public BarChartDataSerie build() {
			return new BarChartDataSerie(this);
		}
	}

	/**
	 * Returns a unmodifiable view of the list.
	 * @return the data
	 */
	public List<Integer> getData() {
		return this.dataSet == null ? new ArrayList<Integer>() : Collections.unmodifiableList(this.dataSet);
	}

	/**
	 * @param data
	 *            the data to set
	 *            
	 *@throws IllegalArgumentException if dataSet or member is {@code null}
	 */
	public void setData(List<Integer> dataSet) {
		if (dataSet == null)
			throw new IllegalArgumentException("dataSet can not be null");
		List<Integer> temp = Collections.unmodifiableList(dataSet);

		for (Integer current : temp) {
			if (current == null)
				throw new IllegalArgumentException("member can not be null");
		}
		this.dataSet = temp;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return this.color == null ? null : new Color(this.color.getRGB());
	}

	/**
	 * @param color
	 *            the color to set
	 *            
	 * @throws IllegalArgumentException if color is {@code null}
	 */
	public void setColor(Color color) {
		
		if(color == null)
			throw new IllegalArgumentException("color can not be null");
		this.color = color;
	}

	/**
	 * @return the label
	 */
	public ChartLegend getLegend() {
		return this.legend;
	}

	/**
	 * @param label
	 *            the label to set
	 *            
	 * @throws IllegalArgumentException if legend is {@code null}
	 */
	public void setLegend(ChartLegend legend) {
		
		if(legend == null)
			throw new IllegalArgumentException("legend can not be null");
		this.legend = legend;
	}

}
