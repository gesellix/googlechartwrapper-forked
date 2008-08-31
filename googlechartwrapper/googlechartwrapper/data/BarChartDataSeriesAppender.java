package googlechartwrapper.data;

import googlechartwrapper.util.IExtendedFeatureAppender;
import googlechartwrapper.util.IFeatureAppender;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author steffan
 *
 */
public class BarChartDataSeriesAppender implements IExtendedFeatureAppender{

	protected List<BarChartDataSeries> list= new LinkedList<BarChartDataSeries>();
	
	
	public void add (BarChartDataSeries ds){
		list.add(ds);
	}
	
	public boolean remove (BarChartDataSeries ds){
		return list.remove(ds);
	}
	
	public BarChartDataSeries remove (int index){
		return list.remove(index);
	}
	
	public void removeAll (){
		for (int i = 0; i < list.size();){
			list.remove(i);
		}
	}
	public String getFeaturePrefix() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAppendableString(
			List<? extends IFeatureAppender> otherAppenders) {
		
		StringBuilder builder = new StringBuilder();
		//data
		for(int i = 0; i < this.getLongestDataSeriesSize(); i++){
			
			for(BarChartDataSeries currentSeries : this.list){
				
				if(currentSeries.getData().size() < i){
					
					builder.append(',');
					builder.append(currentSeries.getData().toArray()[i]);
				}
			}
		}
		
		
		return null;
	}
	private int getLongestDataSeriesSize(){
		
		int size = 0;
		
			for(BarChartDataSeries currentSeries : this.list){
			
				if(currentSeries.getData().size() > size){
					size = currentSeries.getData().size();
				}
		}
			
			return size;
	}

}
