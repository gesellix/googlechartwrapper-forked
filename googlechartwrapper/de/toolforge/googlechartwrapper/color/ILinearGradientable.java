package de.toolforge.googlechartwrapper.color;

/**
 * Every Chart which supports LinearGradientimplements this interface. <br />
 * You can set only one LinearGradient object for a Chart.
 * 
 * @author steffan
 * 
 */
public interface ILinearGradientable {

	/**If you set a new LinearGradient the old one will be overwritten. <br />
	 * If you set <code> null </null> the LinearGradient will be removed.
	 * 
	 * @param lg the new LinearGradient
	 */
	public void setLinearGradient(LinearGradient lg);

	/**
	 * Removes the LinearGradient.
	 */
	public void removeLinearGradient();
	
	/**
	 * Returns the LinearGradient, or null if this Chart contains no LinearGradient.
	 * 
	 * @return the LinearGradient, or null if this Chart contains no LinearGradient.
	 */
	public LinearGradient getLinearGradient();

}
