package googlechartwrapper;

public enum ChartTypeFeature {

	Markers("chm");
	
	private String prefix;
		
	ChartTypeFeature(String prefix) {
		this.prefix = prefix;
	}
	
	public String getPrefix(){
		return prefix;
	}
	
}
