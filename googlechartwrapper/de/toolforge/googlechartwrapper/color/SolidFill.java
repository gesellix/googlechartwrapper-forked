package de.toolforge.googlechartwrapper.color;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import de.toolforge.googlechartwrapper.ChartTypeFeature;
import de.toolforge.googlechartwrapper.util.AppendableFeature;
import de.toolforge.googlechartwrapper.util.IFeatureAppender;
import de.toolforge.googlechartwrapper.util.MiscUtils;

/**
 * Specifies a SolidFill <a
 * href="http://code.google.com/apis/chart/colors.html#solid_fill">
 * http://code.google.com/apis/chart/colors.html#solid_fill</a>
 * <br />
 * <br /> 
 * <b>Note</b> <br />
 * You can specify: <br />
 *	background, chart area fill, and transparency for line charts, sparklines, and scatter plots. <br />
 *	background fill and transparency for bar charts, pie charts, and Venn diagrams. <br />	
 *	background fill for maps and radar charts.
 * 
 * @author steffan
 *
 */
public class SolidFill implements IFeatureAppender
{
    private ChartFillDestination fillDestination;
    private Color color;
    
    /**
     * Constructs an solidfill
     * 
     * @param fillDestination define the destination layer
     * @param color the layers color
     * 
     * @throws IllegalArgumentException if color and/or fillDestination <code>null</code>
     */
    public SolidFill(ChartFillDestination fillDestination, Color color){
    	
    	if(color == null)
    		throw new IllegalArgumentException("color can not be null");
    	if(fillDestination == null)
    		throw new IllegalArgumentException("fillDestination can not be null");
    	
    	this.fillDestination = fillDestination;
    	this.color = new Color(color.getRGB());
    	
    }
   
    /**
     * Returns the chartFillDestination.
     * 
     * @return the chosen destination
     */
    public ChartFillDestination getChartFillDestination(){
    	return this.fillDestination;
    }
    /**
     * Sets the ChartFillDestination.
     * 
     * @param fillDestination 
     * 
     * @throws IllegalArgumentException if fillDestination is <code>null</code>
     */
    public void setChartFillDestination(ChartFillDestination fillDestination){
    	if(fillDestination == null)
    		throw new IllegalArgumentException("fillDestination can not be null");
    	this.fillDestination = fillDestination;
    }
    /**
     * Sets the color.
     * 
     * @param color
     * 
     * @throws IllegalArgumentException if color is <code>null</code>
     */
    public void setColor(Color color){
    	if(color == null)
    		throw new IllegalArgumentException("color can not be null");
    	this.color = new Color(color.getRGB());
    }
    /**
     * Returns the Color.
     * 
     * @return color
     */
    public Color getColor(){
    	
    	return new Color(this.color.getRGB());
    } 
   
     public List<AppendableFeature> getAppendableFeatures(List<? extends IFeatureAppender> otherAppenders) {
		
    	 StringBuilder builder = new StringBuilder();
    	 
    	 builder.append(this.fillDestination.getDestination());
    	 builder.append(',');
    	 //solid
    	 builder.append('s');
    	 builder.append(',');
    	 //color
    	 builder.append(MiscUtils.getMatchingColorHexValue(this.color));

    	 List<AppendableFeature> feature = new ArrayList<AppendableFeature>(); 
 		
         feature.add(new AppendableFeature(builder.toString(), 
                   ChartTypeFeature.SolidFill)); 
         
 		return feature;
	}
    
    /**
     * The API provides background, chartarea and transparency for as chartfill destinations.
     * 
     * @author steffan
     *
     */
    public enum ChartFillDestination {
    	/**
    	 * for background fill
    	 */
   	 Background("bg"),

   	 /**
   	  * for chart area fill
   	  */
   	 ChartArea("c"),
   	 /**
   	  * to apply transparency to the whole chart
   	  */
   	Transparency("a");
   	
   	private String destination;

   	ChartFillDestination(String destination) {
		this.destination = destination;
	}

   	/**
   	 * Returns the destination.
   	 * 
   	 * @return destination
   	 */
	public String getDestination() {
		return this.destination;

	}

   }
   
}

