package googlechartwrapper.style;

import java.util.List;

/**
 * 
 * @author steffan
 *
 */
public interface ILineStyleable {
	
	/**
	 * 
	 * @param lineStyle
	 */
	public void addLineStyle(ILineStyle lineStyle);
	
	/**
	 * 
	 * @return
	 */
	public List<ILineStyle> getLineStyles();
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public LineStyle removeLineStyle(int index);
	
	/**
	 * 
	 * @param lineStyle
	 * @return
	 */
	public boolean removeLineStyle(LineStyle lineStyle);
	
	/**
	 * 
	 */
	public void removeAllLineStyles();	

}
