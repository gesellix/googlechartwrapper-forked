package de.toolforge.googlechartwrapper.data;


import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.toolforge.googlechartwrapper.ConcentricPieChart;
import de.toolforge.googlechartwrapper.data.PieChartSlice.PieChartSliceBuilder;

/**
 *  <p>
 * Here are some examples of how ConcentricPieChartSlice can be used:
 * <p><blockquote><pre>
 *     List<PieChartSlice> list = new ArrayList<PieChartSlice>();
 *      		
 *     list.add(new PieChartSlice.PieChartSliceBuilder(80).label("USA").color(Color.BLUE).build());
 *     list.add(new PieChartSlice.PieChartSliceBuilder(20).label("Canada").build());
 *		
 *     ConcentricPieChartSlice cslice = new ConcentricPieChartSlice.ConcentricPieChartSliceBuilder(list).build();
 * </pre></blockquote>
 * <p>
 * 
 * @author steffan
 * @version 03/20/09 
 * @see ConcentricPieChart
 * @see ConcentricPieChartSliceBuilder
 * @see PieChartSlice
 * @see PieChartSliceBuilder
 *
 */
public class ConcentricPieChartSlice {
	
	private List<? extends PieChartSlice> pieChartSlices = new ArrayList<PieChartSlice>();
	private Color color = null;
	
	
	/**
	 * Use the {@link ConcentricPieChartSliceBuilder} to build a new {@link ConcentricPieChartSlice}.
	 * 
	 * @param builder {@link ConcentricPieChartSliceBuilder}
	 * 
	 * @throws IllegalArgumentException if builder is {@code null}
	 * 
	 * @see ConcentricPieChartSliceBuilder
	 */
	public ConcentricPieChartSlice(final ConcentricPieChartSliceBuilder builder) {
		
		if(builder == null)
			throw new IllegalArgumentException("builder can not be null");
		
		this.pieChartSlices = builder.pieChartSlices;
		this.color = builder.color;
	}
	
	/**
	 * Returns a unmodifiable list. The list will be empty if nothing was added.
	 * 
	 * @return the pieChartSlices
	 */
	public List<? extends PieChartSlice> getPieChartSlices() {
		return Collections.unmodifiableList(pieChartSlices);
	}

	/**
	 * @param pieChartSlices the pieChartSlices to add
	 */
	public void setPieChartSlices(List<? extends PieChartSlice> pieChartSlices) {
		
		if(pieChartSlices == null)
			throw new IllegalArgumentException("pieCharSlices can not be null");
		
		List<? extends PieChartSlice> temp = Collections.unmodifiableList(pieChartSlices);
		
		for (PieChartSlice current : temp) {
			
			if(current == null)
				throw new IllegalArgumentException("member can not be null");
		}		
		this.pieChartSlices = temp;
		
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
	 * The builder for {@link ConcentricPieChartSlice#ConcentricPieChartSlice(ConcentricPieChartSliceBuilder)}.
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
		
		/**
		 * 
		 * @param pieChartSlices
		 * 
		 * @throws IllegalArgumentException if pieChartSlices or member is {@code null}
		 */
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
			
			this.color = new Color(color.getRGB());
			
			return this;
			
		}
		/**
		 * Build the {@link ConcentricPieChartSlice}
		 * 
		 * @return {@link ConcentricPieChartSlice}
		 */
		public ConcentricPieChartSlice build(){
			
			return new ConcentricPieChartSlice(this);
		}
		
	}

}
