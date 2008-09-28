package googlechartwrapper;

import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.color.ISolidFillable;
import googlechartwrapper.color.SolidFill;
import googlechartwrapper.color.SolidFill.ChartFillDestination;
import googlechartwrapper.util.GenericAppender;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Collection;
import java.util.List;

/**
 * Specifies a map <a href="http://code.google.com/apis/chart/#map">
 * http://code.google.com/apis/chart/#map</a> with geographic areas found in 
 * @author martin
 *
 */
public class GeographicMap extends AbstractChart implements ISolidFillable{
	
	private GeographicalArea area;
	private Collection<String> coloredStates;
	protected GenericAppender<SolidFill> solidFill = 
		new GenericAppender<SolidFill>("chf");
	
	public enum GeographicalArea {
		AFRICA,
		ASIA,
		EUROPE,
		MIDDLE_EAST,
		SOUTH_AMERICA,
		USA,
		WORLD;
		
		public String getAreaCode (){
			return this.toString().toLowerCase();
		}
	}

	/**
	 * Constructs a new GeographicMap corresponding to 
	 * <a href="http://code.google.com/apis/chart/#map">
	 * http://code.google.com/apis/chart/#map</a>
	 * <p>The maximum size of the map is 440x220. If a greater value is given an 
	 * {@link IllegalArgumentException}
	 * will be thrown.</p>
	 * @param chartDimension dimension of the chart, maximum 440x220
	 * @throws IllegalArgumentException if dimension is wrong
	 */
	public GeographicMap(Dimension chartDimension, GeographicalArea area) {
		super(chartDimension);
		if (chartDimension.height > 220){
			throw new IllegalArgumentException("height must be <= 220");
		}
		if (chartDimension.width > 440){
			throw new IllegalArgumentException ("width must be <= 440");
		}
		this.area = area;
		
	}

	@Override
	protected ChartType getChartType() {
		return ChartType.Map;
	}

	@Override
	protected String getUrlChartType() {
		return "t"; //cht=t and chtm=<geographical area>
	}
	
	/**
	 * sets the main datacolor + gradients for countries. The first value
	 * is the default color for all countries not listed as coloredState. 
	 * The second and third colors specify a color gradient. If a fourth color is 
	 * specified
	 * color number 2 is gradient for 0%, number 3 for 50% and so on.
	 */
	public void setDataColors(Color[] dataColors) {
		super.setDataColors(dataColors);
	}
	
	public void setColoredStates (Collection<String> countries){
		coloredStates = countries;
	}
	
	@Override
	protected void collectUrlElements() {
		super.collectUrlElements();
		//TODO martin: use basic functionality of AbstractChart and add extended!
		/*urlElements.clear();
		urlElements.offer(MessageFormat.format("cht={0}", this.getUrlChartType()));
		//chart type (immer t)
   	 	urlElements.offer(MessageFormat.format("chs={0}x{1}", 
   	 			this.chartDimension.width, this.chartDimension.height));
   	 	//dimension (max 440x220)*/
   	 	if (values == null){
   	 		urlElements.offer("chd=s:_"); 
   	 	}
   	 	
        urlElements.offer("chtm="+area.getAreaCode()); //area code
        
       if (coloredStates!=null){
        	//chld=<list of codes for each country or state to be colored>
        	StringBuffer bf = new StringBuffer(coloredStates.size() * 2+5);
        	bf.append("chld=");
        	for (String c: coloredStates){
        		if (c.length()>2){
        			bf.append(c.substring(0,2));
        		}
        		else {
        			bf.append(c);
        		} 
        	}
        	urlElements.offer(bf.toString());
        }
	}

	/**
	 * Only supports {@link ChartFillDestination#Background}.
	 * @throws IllegalArgumentException if {@link SolidFill#getChartFillDestination()}
	 * does not equals ChartFillDestination#Background
	 */
	public void addSolidFill(SolidFill sf) {
		if (!sf.getChartFillDestination().equals(ChartFillDestination.Background)){
			throw new IllegalArgumentException
				("only ChartFillDestination.Background supported");
		}
		solidFill.add(sf);
	}

	public List<SolidFill> getSolidFills() {
		return solidFill.getList();
	}

	public void removeAllSolidFills() {
		solidFill.removeAll();
		
	}

	public SolidFill removeSolidFill(int index) {
		return solidFill.remove(index);
	}

	public boolean removeSolidFill(SolidFill sf) {
		return solidFill.remove(sf);
	}

	public IEncoder getEncoder() {
		// TODO Auto-generated method stub
		return null;
	}
}
