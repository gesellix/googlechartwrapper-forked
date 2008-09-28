package googlechartwrapper.data;

/**
 * 
 * @author steffan
 *
 */
public interface ISingleDataScaleable {
	
	/**
	 * 
	 * @param ds
	 */
	public void setDataScaling(DataScalingSet ds);
	
	/**
	 * 
	 * @return
	 */
	public DataScalingSet getDataScaling();
	
	/**
	 * 
	 */
	public void removeDataScaling();

}
