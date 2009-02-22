package googlechartwrapper.data;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author steffan
 * 
 */
public class LineChartData {

	private List<Integer> dataSet = null;
	private Color color = null;
	private String label = null;

	public LineChartData(LineChartDataBuilder builder) {

		if (builder == null)
			throw new IllegalArgumentException("builder can not be null");

		this.dataSet = new ArrayList<Integer>(builder.dataSet);
		this.color = builder.color;
		this.label = builder.label;
	}

	/**
	 * 
	 * @author steffan
	 *
	 */
	public static class LineChartDataBuilder {

		private List<Integer> dataSet = null;
		private Color color = null;
		private String label = null;

		/**
		 * 
		 * @param dataSet
		 * 
		 * @throws IllegalArgumentException
		 *             if dataSet is {@code null } or value is {@code null}
		 */
		public LineChartDataBuilder(List<Integer> dataSet) {

			if (dataSet == null) {
				throw new IllegalArgumentException("dataSet can not be null");
			} else {
				for (Integer temp : new ArrayList<Integer>(dataSet)) {

					if (temp == null)
						throw new IllegalArgumentException(
								"integer can not be null");
				}
				this.dataSet = new ArrayList<Integer>(dataSet);
			}
		}

		/**
		 * 
		 * @param color
		 * @return
		 * 
		 * @throws IllegalArgumentException if color is {@code null}
		 */
		public LineChartDataBuilder color(Color color) {

			if(color == null)
				throw new IllegalArgumentException("color can not be null");
			
			this.color = new Color(color.getRGB());
			return this;

		}

		/**
		 * 
		 * @param label
		 * @return
		 * 
		 * @throws IllegalArgumentException if label is {@code null}
		 */
		public LineChartDataBuilder label(String label) {

			if(label == null)
			throw new IllegalArgumentException("label can not be null");
			
			this.label = label;
			return this;

		}
		/**
		 * 
		 * @return
		 */
		public LineChartData build() {
			return new LineChartData(this);
		}
	}

	/**
	 * @return the dataSet
	 */
	public List<Integer> getDataSet() {
		return new ArrayList<Integer>(dataSet);
	}

	/**
	 * @param dataSet the dataSet to set
	 * @throws IllegalArgumentException
	 *             if dataSet is {@code null } or value is {@code null}
	 */
	public void setDataSet(List<Integer> dataSet) {
		
		if (dataSet == null) {
			throw new IllegalArgumentException("dataSet can not be null");
		} else {
			for (Integer temp : new ArrayList<Integer>(dataSet)) {

				if (temp == null)
					throw new IllegalArgumentException(
							"value can not be null");
			}
			this.dataSet = new ArrayList<Integer>(dataSet);
		}		
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return new Color(color.getRGB());
	}

	/**
	 * @param color the color to set
	 * 
	 * @throws IllegalArgumentException if color ist {@code null}
	 */
	public void setColor(Color color) {
		
		if(color == null)
			throw new IllegalArgumentException("color can not be null");
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
	 * 
	 * @throws IllegalArgumentException if label is {@code null}
	 */
	public void setLabel(String label) {
		
		if(label == null)
			throw new IllegalArgumentException("label can not be null");
		
		this.label = label;
	}

}
