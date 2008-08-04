package googlechartwrapper.chartLegend;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 
 * @author steffan
 *
 */
public class ChartLegend implements IChartLegendable{

	private List<String> legendList = new ArrayList<String>();
	
	public void AddChartLegend(String[] legend) {
		
		for(String currentLegend : legend){
			legendList.add(currentLegend);
		}
		
		
	}

	public void AddChartLegend(Collection<String> legend) {
		legendList.addAll(legend);
		
	}

}
