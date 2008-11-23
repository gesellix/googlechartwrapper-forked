package googlechartwrapper.interfaces;

/**
 * The interface provides the {@link #setPercentageScaling(boolean)} method, implemented by every chart,
 * that is able to encode the data to percent. 
 * 
 * @author steffan
 *
 */
public interface IPercentageScaleable {

	/**
	 * If you enable the percentageSacaling every DataSet will be converted, until
	 * you enable dataScaling or disable PercentageScaling.
	 * 
	 * <h2>Note</h2>
	 * Thinks like datascaling will be removed, if you enable percentage scaling.
	 * 
	 * @param b
	 */
	public void setPercentageScaling(boolean b);
}
