package googlechartwrapper.color;

import java.util.List;

/**
 * 
 * @author steffan
 *
 */
public interface SolidFillable {
	
	/**
	 * 
	 * @param sf
	 */
	public void addSolidFill(SolidFill sf);
	
	/**
	 * 
	 * @return
	 */
	public List<SolidFill> getSolidFills();
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public SolidFill removeSolidFill(int index);
	
	/**
	 * 
	 * @param sf
	 * @return
	 */
	public boolean removeSolidFill(SolidFill sf);
	
	/**
	 * 
	 */
	public void removeAllSolidFills();

}
