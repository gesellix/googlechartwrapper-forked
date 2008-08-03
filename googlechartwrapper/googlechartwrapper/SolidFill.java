package googlechartwrapper;

/**
 * 
 * @author steffan
 *
 */
public class SolidFill
{
    private ChartFillDestination fillDestination;
    private String color;
    
    /**
     * Constructs an solidfill
     * 
     * @param fillDestination define the destination layer
     * @param color the layers color
     */
    public SolidFill(ChartFillDestination fillDestination, String color){
    	
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
     */
    public void setChartFillDestination(ChartFillDestination destination){
    	this.fillDestination = destination;
    }
    /**
     * 
     * @param color
     */
    public void setColor(String color){
    	this.color = color;
    }
    /**
     * 
     * @return
     */
    public String getColor(){
    	
    	return this.color;
    }
  
    /**
     * 
     * @return
     */
    private String getTypeUrlChar()
    {
       if(fillDestination.equals(ChartFillDestination.ChartArea)){
    	   return "c";
       }
       else{   
       return "bg";
       }
              
        
    }
    /**
     * 
     * @return
     */
    public String getUrlString()
    {
    	StringBuilder url = new StringBuilder();
        url.append((this.getTypeUrlChar()+","));
       url.append("s");
       url.append(this.color);
       
       return url.toString();
       
    }
    /**
     * 
     * @author steffan
     *
     */
    public enum ChartFillDestination {
    	
   	 Background,

   	 ChartArea

   }
}

