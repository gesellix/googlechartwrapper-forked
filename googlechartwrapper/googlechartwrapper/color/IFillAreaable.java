package googlechartwrapper.color;

import java.util.List;

/**
 * 
 * @author steffan
 *
 */
public interface IFillAreaable {
	
	/**
	 * 
	 * @param fa
	 */
	public void addFillArea(FillArea fa);
	
	/**
	 * 
	 * @return
	 */
	public List<FillArea> getFillAreas();
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public FillArea removeFillArea(int index);
	
	/**
	 * 
	 * @param fa
	 * @return
	 */
	public boolean removeFillArea(FillArea fa);
	
	/**
	 * 
	 */
	public void removeAllFillAreas();
	

}
