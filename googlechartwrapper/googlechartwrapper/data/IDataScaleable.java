package googlechartwrapper.data;

/**
 * 
 * @author steffan
 *
 */
public interface IDataScaleable {
	
	/**
	 * 
	 * @param ds
	 */
	public void setDataScaling(DataScaling ds);
	
	/**
	 * 
	 * @return
	 */
	public DataScaling getDataScaling();
	
	/**
	 * 
	 */
	public void removeDataScaling();

}
