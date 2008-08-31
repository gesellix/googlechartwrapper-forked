package googlechartwrapper;

public enum ChartTypeFeature {

	Marker("chm"),
	GridLine("chg"),
	ChartTitle("chtt"),
	ChartTitleStyle("chts"),
	LinearGradient("chf"),
	FillArea("chm"),
	SolidFill("chf"),
	AxisLabel("chxt"),
	LinearStripes("chf");
	
	private String prefix;
		
	ChartTypeFeature(String prefix) {
		this.prefix = prefix;
	}
	
	public String getPrefix(){
		return prefix;
	}
	
}
