package googlechartwrapper;

public enum ChartTypeFeature {

	Marker("chm"),
	GridLine("chg");
	
	private String prefix;
		
	ChartTypeFeature(String prefix) {
		this.prefix = prefix;
	}
	
	public String getPrefix(){
		return prefix;
	}
	
}
