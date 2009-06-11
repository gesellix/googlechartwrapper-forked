package de.toolforge.googlechartwrapper.style;

/**
 * Every Chart which supports GridLines implements this interface. <br />
 * You can set only one GridLine object for a Chart.
 * 
 * @author steffan
 *
 */
public interface IGridLineable {
	
	/**If you set a new GridLine the old one will be overwritten. <br />
	 * If you set <code> null </null> the GridLine will be removed.
	 * 
	 * @param gl the new GridLine
	 */
	public void setGridLine(GridLine gl);
	
	/**
	 * Removes the GridLine.
	 * 
	 */
	public void removeGridLine();
	
	/**
	 * Returns the GridLine, or null if this Chart contains no GrindLine.
	 * 
	 * @return the GridLine, or null if this Chart contains no GrindLine.
	 */
	public GridLine getGridLine();

}
