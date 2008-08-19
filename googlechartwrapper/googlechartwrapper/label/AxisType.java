package googlechartwrapper.label;

/**
 * Available axes are: 
 * <ul>
 * <li>{@link #XAxis}is = bottom x-axis</li>
 * <li>{@link #TopAxis} = top x-axis</li> 
 * <li>{@link #YAxis} = left y-axis</li>
 * <li>{@link #RightAxis} = right y-axis</li> 
 * </ul>
 * For details see <a href="http://code.google.com/apis/chart/#axis_type">
 * http://code.google.com/apis/chart/#axis_type</a>
 * @author martin
 *
 */
public enum AxisType  {
	/**
	 * bottom x-axis
	 */
	XAxis("x"), 
	/**
	 * top x-axis
	 */
	TopAxis("t"), 
	/**
	 * left y-axis
	 */
	YAxis("y"), 
	/**
	 * right y-axis
	 */
	RightAxis("r");
	
	private String type;	
	
	AxisType(String type) {
		this.type = type;
	}
	
	/**
	 * Returns the type of the axis (short-value for URL)
	 * @return value for URL
	 */
	protected String getType (){
		return type;
	}
}
