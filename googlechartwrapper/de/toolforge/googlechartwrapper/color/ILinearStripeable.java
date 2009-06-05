package de.toolforge.googlechartwrapper.color;

/**
 * Every Chart which supports LinearStripes implements this interface. <br />
 * You can set only one LinearStripes object for a Chart.
 * 
 * @author steffan
 *
 */
public interface ILinearStripeable {
	
	/**If you set a new LinearStripes the old one will be overwritten. <br />
	 * If you set <code> null </null> the LinearStripes will be removed.
	 * 
	 * @param ls the new GridLine
	 */
	public void setLinearStripes(LinearStripe ls);

	/**
	 * Removes the LinearStripes.
	 */
	public void removeLinearStripes();
	
	/**
	 * Returns the LinearStripes, or null if this Chart contains no LinearStripes
	 * 
	 * @return the LinearStripes, or null if this Chart contains no LinearStripes.
	 */
	public LinearStripe getLinearStripes();

}
