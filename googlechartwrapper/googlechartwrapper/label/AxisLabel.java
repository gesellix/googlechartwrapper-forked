package googlechartwrapper.label;

/**
 * Specifies an label for an axis. 
 * @author martin
 *
 */
public class AxisLabel{
	
	protected String label;
	protected int pos;

	/**
	 * Constructs a label without a position.
	 * @param label label text
	 */
	public AxisLabel(String label) {
		super();
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getPos() {
		return pos;
	}

	/**
	 * Set positon for the label. 
	 * @param pos position
	 * @see AxisLabelContainer#setUseLabelPositions(boolean)
	 */
	public void setPos(int pos) {
		this.pos = pos;
	}
	
	


}
