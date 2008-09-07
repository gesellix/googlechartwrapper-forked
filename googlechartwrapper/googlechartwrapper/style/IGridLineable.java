package googlechartwrapper.style;

/**
 * 
 * @author steffan
 *
 */
public interface IGridLineable {
	
	/**
	 * 
	 * @param gl
	 */
	public void setGridLine(GridLine gl);
	
	/**
	 * 
	 */
	public void removeGridLine();
	
	/**
	 * 
	 * @return
	 */
	public GridLine getGridLine();

}
