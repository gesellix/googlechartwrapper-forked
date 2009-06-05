package de.toolforge.googlechartwrapper.color;

import java.util.List;

/**
 * Every method is for one data set, if one color is required use {@link IMultiDataSetChartColorable#addChartColor(ChartColor)}
 * , the color for every value in the data set will be interpolated.
 * Is a special color for every value in a data set necessary use {@link IMultiDataSetChartColorable#addChartColorSet(List)}, the list
 * must contain n colors, for n values.
 * 
 * @author steffan
 *
 */
public interface IMultiDataSetChartColorable{

	/**a
	 * Adds a new ChartColor List to the Chart.
	 * 
	 * @param ccl the new ChartColor List
	 * 
	 * @throws IllegalArgumentException if chartColorList or member is {@code null}
	 */
	public void addChartColorSet(List<ChartColor> ccl);
	
	/**
	 * Adds a single ChartColor.
	 * 
	 * @param cc
	 * 
	 * @throws IllegalArgumentException if chartColor is {@code null}
	 */
	public void addChartColor(ChartColor chartColor);
	
	
}
