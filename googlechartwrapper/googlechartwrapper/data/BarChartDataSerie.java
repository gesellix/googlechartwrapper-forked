package googlechartwrapper.data;

import googlechartwrapper.label.ChartLegend;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author steffan
 * 
 */
public class BarChartDataSerie {

	private List<Integer> dataSet;
	private Color color;
	private ChartLegend legend;

	public BarChartDataSerie(BarChartDataSerieBuilder builder) {
		
		if (builder == null)
			throw new IllegalArgumentException("builder can not be null");
		
		this.dataSet = builder.dataSet;
		this.color = builder.color;
		this.legend = builder.legend;

	}

	/**
	 * 
	 * @author steffan
	 * 
	 */
	public static class BarChartDataSerieBuilder {

		private List<Integer> dataSet = null;
		private Color color = null;
		private ChartLegend legend = null;

		/**
		 * 
		 * @param dataSet
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

		public BarChartDataSerieBuilder color(Color color) {

			if (color == null)
				throw new IllegalArgumentException("color can not be null");

			this.color = new Color(color.getRGB());
			return this;

		}

		public BarChartDataSerieBuilder legend(ChartLegend legend) {

			if (legend == null)
				throw new IllegalArgumentException("legend can not be null");

			this.legend = legend;

			return this;

		}

		public BarChartDataSerie build() {
			return new BarChartDataSerie(this);
		}
	}

	/**
	 * @return the data
	 */
	public List<Integer> getData() {
		return this.dataSet == null ? new ArrayList<Integer>() : Collections.unmodifiableList(this.dataSet);
	}

	/**
	 * @param data
	 *            the data to set
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
	 */
	public void setLegend(ChartLegend legend) {
		
		if(legend == null)
			throw new IllegalArgumentException("legend can not be null");
		this.legend = legend;
	}

}
