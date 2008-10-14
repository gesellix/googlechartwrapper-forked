package googlechartwrapper.data;

import googlechartwrapper.ChartTypeFeature;
import googlechartwrapper.coder.AutoEncoder;
import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.util.IExtendedFeatureAppender;
import googlechartwrapper.util.IFeatureAppender;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author steffan
 *
 */
public class ScatterPlotDataAppender implements IExtendedFeatureAppender, IEncodeable{
	
	private IEncoder encoder = new AutoEncoder();
	private ScatterPlotData data;

	public String getFeaturePrefix() {
		
		return ChartTypeFeature.ChartData.getPrefix();
	}
	public void setScatterPlotData(ScatterPlotData data) {		
		this.data = data;				
	}
	
	public ScatterPlotData getScatterPlotData() {
		
		return this.data;
	}

	public String getAppendableString(
			List<? extends IFeatureAppender> otherAppenders) {
		
		StringBuilder builder = new StringBuilder();	
		
		if(this.data != null){
			
			int [] valuesX = new int[data.getDataSet().size()];
			int [] valuesY = new int[data.getDataSet().size()];
			
			for(int i = 0; i < data.getDataSet().size(); i++){
				
				valuesX[i] = ((ArrayList<Point>) data.getDataSet()).get(i).x;
				valuesY[i] = ((ArrayList<Point>) data.getDataSet()).get(i).y;			
				
			}
			List<int[]> data = new LinkedList<int[]>();
			data.add(valuesX);
			data.add(valuesY);
			builder.append(this.encoder.encodeIntegerCollection(data,","));
			//builder.append(this.encoder.encode(valuesX));
			//builder.append(',');
			//HACK
			//builder.append(this.encoder.encode(valuesY).substring(2));
			
			return builder.toString();
			
		}
		
		return "";
		
	}

	public IEncoder getEncoder() {
		
		return this.encoder;
	}

	public void removeEncoder() {
		this.encoder = new AutoEncoder();
		
	}

	public void setEncoder(IEncoder encoder) {
		
		this.encoder = encoder;
		
		if(encoder == null){
			this.encoder = new AutoEncoder();
		}	
		
	}

}
