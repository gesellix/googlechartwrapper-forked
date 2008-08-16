package googlechartwrapper.label;

public class AxisRange {
	
	private int lower; private int upper;

	public AxisRange(int lower, int upper) {
		super();
		this.lower = lower;
		this.upper = upper;
	}

	public int getLower() {
		return lower;
	}

	public void setLower(int lower) {
		this.lower = lower;
	}

	public int getUpper() {
		return upper;
	}

	public void setUpper(int upper) {
		this.upper = upper;
	}

}
