/**
 * 
 */
package googlechartwrapper.style;

/**
 * @author steffan
 * 
 * @see BarWidthAndSpacing
 *
 */
public interface IBarWidthAndSpacingable {
	
	/**If you set a new BarWidthAndSpacing the old one will be overwritten. <br />
	 * If you set <code> null </null> the BarWidthAndSpacing will be removed.
	 * 
	 * @param ws the new {@link BarWidthAndSpacing}
	 */
	public void setBarWidthAndSpacing(BarWidthAndSpacing ws);
	
	/**
	 * Removes the {@link BarWidthAndSpacing}.
	 * 
	 */
	public void removeBarWidthAndSpacing();
	
	/**
	 * Returns the {@link BarWidthAndSpacing}, or null if this Chart contains no {@link BarWidthAndSpacing}.
	 * 
	 * @return the {@link BarWidthAndSpacing}, or null if this Chart contains no {@link BarWidthAndSpacing}.
	 */
	public BarWidthAndSpacing getBarWidthAndSpacing();

}
