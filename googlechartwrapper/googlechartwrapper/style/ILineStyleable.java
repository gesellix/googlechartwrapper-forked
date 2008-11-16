package googlechartwrapper.style;

import java.util.List;

/**
 * 
 * Line and sparkline charts: specifying thickness and dash style (and color with data set colors)
 * Line, sparkline, and bar charts: specifying thickness, color, and priority
 * 
 * @author steffan
 *
 */
public interface ILineStyleable {
	
	/**
	 * 
	 * 
	 * @param lineStyle
	 */
	public void addLineStyle(LineStyle lineStyle);
	
	/**
	 * 
	 * @return
	 */
	public List<LineStyle> getLineStyles();
	
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
