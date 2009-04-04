package googlechartwrapper.label;

/**
 * Specifies a range for an axis. Note that the axis direction may be reversed for an
 * axis if the "lower" value is larger than the "upper" value.
 * @author martin
 *
 */
public class AxisRange {
	
	private int lower; 
	private int upper;
	private Integer interval;

	/**
	 * Constructs an axis range.
	 * @param lower start of range (e.g. the 0 on an y axis)
	 * @param upper end of range of an axis (e.g 1000 on an y axis)
	 */
	public AxisRange(int lower, int upper) {
		super();
		this.lower = lower;
		this.upper = upper;
	}
	
	public AxisRange(int lower, int upper, int interval) {
		super();
		this.lower = lower;
		this.upper = upper;
		this.interval = interval;
	}

	/**
	 * Returns the start of the range.
	 * @return start of range
	 */
	public int getLower() {
		return lower;
	}

	/**
	 * Sets start or range
	 * @param lower start of range
	 */
	public void setLower(int lower) {
		this.lower = lower;
	}

	/**
	 * Returns the end of range
	 * @return end of range
	 */
	public int getUpper() {
		return upper;
	}

	/**
	 * Sets end of range 
	 * @param upper end of range
	 */
	public void setUpper(int upper) {
		this.upper = upper;
	}

	public Integer getInterval() {
		return interval;
	}

	public void setInterval(Integer interval) {
		this.interval = interval;
	}

}
