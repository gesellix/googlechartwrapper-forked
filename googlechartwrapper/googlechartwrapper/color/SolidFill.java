package googlechartwrapper.color;

import googlechartwrapper.util.IFeatureAppender;
import googlechartwrapper.util.MiscUtils;

import java.awt.Color;
import java.util.List;

/**
 * Specifies a SolidFill <a
 * href="http://code.google.com/apis/chart/#solid_fill">
 * http://code.google.com/apis/chart/#solid_fill</a>
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
    	this.color = color;
    	
    }
   
    /**
     * 
     * @return the choosen destination
     */
    public ChartFillDestination getChartFillDestination(){
    	return this.fillDestination;
    }
    /**
     * 
     * @param destination 
     * 
     * @throws IllegalArgumentException if fillDestination is <code>null</code>
     */
    public void setChartFillDestination(ChartFillDestination fillDestination){
    	if(fillDestination == null)
    		throw new IllegalArgumentException("fillDestination can not be null");
    	this.fillDestination = fillDestination;
    }
    /**
     * 
     * @param color
     * 
     * @throws IllegalArgumentException if color is <code>null</code>
     */
    public void setColor(Color color){
    	if(color == null)
    		throw new IllegalArgumentException("color can not be null");
    	this.color = color;
    }
    /**
     * 
     * @return
     */
    public Color getColor(){
    	
    	return this.color;
    } 
   
     public String getAppendableString(List<? extends IFeatureAppender> otherAppenders) {
		
    	 StringBuilder builder = new StringBuilder();
    	 
    	 builder.append(this.fillDestination.getDestination());
    	 builder.append(',');
    	 //solid
    	 builder.append('s');
    	 builder.append(',');
    	 //color
    	 builder.append(MiscUtils.getSixCharacterHexValue(this.color));

		return builder.toString();
	}
    
    /**
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

	public String getDestination() {
		return this.destination;

	}

   }
   
}

