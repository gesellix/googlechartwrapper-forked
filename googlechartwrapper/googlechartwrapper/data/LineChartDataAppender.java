package googlechartwrapper.data;

import googlechartwrapper.ChartTypeFeature;
import googlechartwrapper.coder.AutoEncoder;
import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.interfaces.IEncodeable;
import googlechartwrapper.util.AppendableFeature;
import googlechartwrapper.util.IExtendedFeatureAppender;
import googlechartwrapper.util.IFeatureAppender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author steffan
 * 
 */
public class LineChartDataAppender implements IExtendedFeatureAppender,
		IEncodeable {

	private IEncoder encoder = new AutoEncoder();
	private List<LineChartData> data = new ArrayList<LineChartData>();

	public String getFeaturePrefix() {

		return ChartTypeFeature.ChartData.getPrefix();
	}

	/**
	 * 
	 * @param data
	 * 
	 * @throws IllegalArgumentException if data is {@code null}
	 */
	public void addLineChartData(LineChartData data) {		
		if(data == null)
			throw new IllegalArgumentException("data can not be nulll");
		this.data.add(data);				
	}
	
	/**
	 * 
	 * @param data
	 * 
	 * @throws IllegalArgumentException if collection is {@code null} or value is {@code null}
	 */
	public void addLineChartData(List<LineChartData> data){
		
		if(data == null){
			throw new IllegalArgumentException("data can not be null");
		}
		else{
		for(LineChartData temp : Collections.unmodifiableCollection(data)){
			if(temp == null)
				throw new IllegalArgumentException("value can not be null");
		}
		this.data.addAll(Collections.unmodifiableList(data));
		}
	}
	public List<AppendableFeature> getAppendableString(
			List<? extends IFeatureAppender> otherAppenders) {
		
		StringBuilder builder = new StringBuilder();
		
		//TODO
		List<int[]> data = new LinkedList<int[]>();
		
		for(int z = 0; z < this.data.size(); z++){
			
			int values[] = new int[this.data.get(z).getDataSet().size()]; 
			//copy elements
			for(int u = 0; u< this.data.get(z).getDataSet().size(); u++){
				values[u] = this.data.get(z).getDataSet().get(u);
			}
			data.add(values);
		}
		
		builder.append(this.encoder.encodeIntegerCollection(data,","));
		
List<AppendableFeature> feature = new ArrayList<AppendableFeature>(); 
		
        feature.add(new AppendableFeature(builder.toString(), 
                  ChartTypeFeature.ChartData)); 
        
		return feature;
	}

	public IEncoder getEncoder() {

		return this.encoder;
	}

	public void removeEncoder() {
		this.encoder = new AutoEncoder();

	}

	public void setEncoder(IEncoder encoder) {

		this.encoder = encoder;

		if (encoder == null) {
			this.encoder = new AutoEncoder();
		}

	}

}
