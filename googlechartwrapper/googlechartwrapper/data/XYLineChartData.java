/**
 * 
 */
package googlechartwrapper.data;

import googlechartwrapper.util.Pair;

import java.awt.Color;
import java.util.List;

/**
 * @author steffan
 *
 */
public class XYLineChartData {
	//TODO LineStyle
	private Pair<List<Integer>, List<Integer>> dataSet = null;
	private Color color = null;
	private String label = null;
	
	/**
	 * 
	 * @param builder
	 * 
	 * @throws IllegalArgumentException if builder is {@code null}
	 */
	public XYLineChartData(XYLineChartDataBuilder builder) {
		
		if(builder == null)
			throw new IllegalArgumentException("builder can not be null");
		
		dataSet = builder.dataSet;
		color = builder.color;
		label = builder.label;
	}
	
	/**
	 * 
	 * @author steffan
	 *
	 */
	public static class XYLineChartDataBuilder {
		
		private Pair<List<Integer>, List<Integer>> dataSet = null;
		private Color color = null;
		private String label = null;
		
		/**
		 * 
		 * @param dataSet
		 * 
		 * @throws IllegalArgumentException if dataSet is {@code null}
		 */
		public XYLineChartDataBuilder(Pair<List<Integer>, List<Integer>> dataSet) {
			
			if(dataSet == null)
				throw new IllegalArgumentException("dataSet can not be null");
		}
		/**
		 * 
		 * @param color
		 * @return
		 * 
		 * @throws IllegalArgumentException if color is {@code null}
		 */
		public XYLineChartDataBuilder color(Color color) {

			if(color == null)
				throw new IllegalArgumentException("color can not be null");
			
			this.color = color;
			return this;

		}
		/**
		 * 
		 * @param label
		 * @return
		 * 
		 * @throws IllegalArgumentException if label is {@code null}
		 */
		public XYLineChartDataBuilder label(String label) {

			if(label == null)
				throw new IllegalArgumentException("label can not be null");
			
			this.label = label;
			return this;

		}

		/**
		 * 
		 * @return
		 */
		public XYLineChartData build() {
			return new XYLineChartData(this);
		}
		
	}

	/**
	 * @return the dataSet
	 */
	public Pair<List<Integer>, List<Integer>> getDataSet() {
		return dataSet;
	}

	/**
	 * 
	 * @param dataSet the dataSet to set
	 * 
	 * @throws IllegalArgumentException if dataSet is {@code null}
	 */
	public void setDataSet(Pair<List<Integer>, List<Integer>> dataSet) {
		
		//TODO
		if(dataSet == null)
			throw new IllegalArgumentException("dataSet can not be null");
		
		this.dataSet = dataSet;
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
	 * @throws IllegalArgumentException if label if {@code null}
	 */
	public void setLabel(String label) {
		
		if(label == null)
			throw new IllegalArgumentException("label can not be null");
		this.label = label;
	}

}
