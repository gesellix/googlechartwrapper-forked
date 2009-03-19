package googlechartwrapper.data;

import googlechartwrapper.ConcentricPieChart;
import googlechartwrapper.data.PieChartSlice.PieChartSliceBuilder;

import java.awt.Color;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author steffan
 * 
 * @see ConcentricPieChart
 * @see ConcentricPieChartSliceBuilder
 * @see PieChartSlice
 * @see PieChartSliceBuilder
 *
 */
public class ConcentricPieChartSlice {
	
	private List<? extends PieChartSlice> pieChartSlices;
	private Color color = null;
	
	
	/**
	 * 
	 * @param builder
	 * 
	 * @throws IllegalArgumentException if builder is {@code null}
	 */
	public ConcentricPieChartSlice(final ConcentricPieChartSliceBuilder builder) {
		
		if(builder == null)
			throw new IllegalArgumentException("builder can not be null");
		
		this.pieChartSlices = builder.pieChartSlices;
		this.color = builder.color;
	}
	
	/**
	 * @return the pieChartSlices
	 */
	public List<? extends PieChartSlice> getPieChartSlices() {
		return pieChartSlices;
	}

	/**
	 * @param pieChartSlices the pieChartSlices to set
	 */
	public void setPieChartSlices(List<? extends PieChartSlice> pieChartSlices) {
		this.pieChartSlices = pieChartSlices;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		
		return color == null ? null : new Color(color.getRGB());		
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
	 * 
	 * @author steffan
	 * @see ConcentricPieChartSlice
	 * @see ConcentricPieChart
	 * @see PieChartSlice
	 * @see PieChartSliceBuilder
	 *
	 */
	public static class ConcentricPieChartSliceBuilder{
		
		private List<? extends PieChartSlice> pieChartSlices;
		private Color color = null;
		
		public ConcentricPieChartSliceBuilder(final List<? extends PieChartSlice> pieChartSlices) {
			
			if(pieChartSlices == null)
				throw new IllegalArgumentException("pieChartSlice can not be null");
			
			List<PieChartSlice> temp = Collections.unmodifiableList(pieChartSlices);
			
			for(PieChartSlice current : temp){
				
				if(current == null)
					throw new IllegalArgumentException("member can not be null");
			}
			this.pieChartSlices = temp;
		}
		/**
		 * Ads a color for the hole ring, all the colors from the {@link PieChartSlice} will be overwritten.
		 * 
		 * @param color
		 * @return {@link ConcentricPieChartSlice}
		 * 
		 * @throws IllegalArgumentException if color is {@code null}
		 */
		public ConcentricPieChartSliceBuilder color(final Color color){
			
			if(color == null)
				throw new IllegalArgumentException("color can not be null");
			
			this.color = new Color(color.getRed());
			
			return this;
			
		}
		/**
		 * 
		 * @return
		 */
		public ConcentricPieChartSlice build(){
			
			return new ConcentricPieChartSlice(this);
		}
		
	}

}
