package googlechartwrapper.label;

public enum AxisType  {
	
	XAxis("x"), TopAxis("t"), YAxis("y"), RightAxis("r");
	
	private String type;	
	
	AxisType(String type) {
		this.type = type;
	}
	
	public String getType (){
		return type;
	}
}
