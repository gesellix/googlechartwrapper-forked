package googlechartwrapper.data;

import googlechartwrapper.coder.Encoder;
import googlechartwrapper.util.IFeatureAppender;

import java.util.Collection;
import java.util.List;

/**
 * 
 * @author steffan
 *
 */
public class ChartData implements IFeatureAppender{
	
	private Collection<Integer> chartData;
	
	public ChartData(Collection<Integer> chartData) {
		
		if(chartData == null)
			throw new IllegalArgumentException("chartData can not be null");
		
		this.chartData = chartData;
	}

	public String getAppendableString(
			List<? extends IFeatureAppender> otherAppenders) {
		
		Encoder en = new Encoder();
		StringBuilder builder = new StringBuilder();
		
		int a[] = new int[this.chartData.size()];
		
		for(int i = 0; i < this.chartData.size(); i++) {
			a[i] = (Integer) this.chartData.toArray()[i];
		}
					
		builder.append(en.encode(a));
			
		
		
		
		return builder.toString();
	}

}
