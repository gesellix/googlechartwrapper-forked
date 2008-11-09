package googlechartwrapper.data;

import googlechartwrapper.ChartTypeFeature;
import googlechartwrapper.coder.AutoEncoder;
import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.interfaces.IEncodeable;
import googlechartwrapper.util.IExtendedFeatureAppender;
import googlechartwrapper.util.IFeatureAppender;

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
		
		//build to arrays, for x and y
		if(this.data != null){
			
			int [] valuesX = new int[data.getDataSet().size()];
			int [] valuesY = new int[data.getDataSet().size()];
			
			for(int i = 0; i < data.getDataSet().size(); i++){
				
				valuesX[i] = ((ArrayList<ScatterPlotPoint>) data.getDataSet()).get(i).getXCoordinate();
				valuesY[i] = ((ArrayList<ScatterPlotPoint>) data.getDataSet()).get(i).getYCoordinate();
				
			}
			
			
			int [] valuesSize = new int[data.getDataSet().size()];
			boolean isSizeGiven = false;
			//check if their is a least one point size given
			for(int i= 0; i < data.getDataSet().size(); i++){
				
				
				if(((ArrayList<ScatterPlotPoint>) data.getDataSet()).get(i).isSizeSet()){
					//we have at least one given size
					isSizeGiven = true;
				}
				valuesSize[i] = ((ArrayList<ScatterPlotPoint>) data.getDataSet()).get(i).getSize();
			}
			
			List<int[]> data = new LinkedList<int[]>();
			data.add(valuesX);
			data.add(valuesY);
			//and if the size is given we add the size array
			if(isSizeGiven){
				data.add(valuesSize);
			}
			builder.append(this.encoder.encodeIntegerCollection(data,"|"));
						
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
