package googlechartwrapper;

/**
 * 
 * @author steffan
 *
 */
public enum ChartType {
	
	  	LineChart("lc"),
	  	LineChartPair("lxy"),	  	
	  	SparkLine("ls"),
	    ScatterPlot("s"),
	    BarChartStackedH("bhs"),
	    BarChartStackedV("bvs"),
	    BarChartGroupedH("bhg"),
	    BarChartGroupedV("bvg"),	    
	    VennDiagram("v"),
	    PieChart("p"),
	    PieChart3d("p3"),
	    PieChartConcentric("pc"),
	    GoogleOMeter("gom"),
	    Map("t"),
	    RadarChartStraightLines("r"),
	    RadarChartSplines("rs"),
	    QRCode("qr");
	  	
	  	private final String prefix;
	  	
	  	private ChartType(String prefix) {
			this.prefix = prefix;
		}
	  	
	  	/**
	  	 * Prefix for every chart, scatterplot means 's'
	  	 * 
	  	 * @return
	  	 */
	  	public String getPrefix(){
	  		return this.prefix;
	  	}

}
