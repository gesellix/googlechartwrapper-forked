package de.toolforge.googlechartwrapper.data;

import java.util.ArrayList;
import java.util.List;

import de.toolforge.googlechartwrapper.ChartTypeFeature;
import de.toolforge.googlechartwrapper.coder.AutoEncoder;
import de.toolforge.googlechartwrapper.coder.IEncoder;
import de.toolforge.googlechartwrapper.interfaces.IEncodeable;
import de.toolforge.googlechartwrapper.util.AppendableFeature;
import de.toolforge.googlechartwrapper.util.IExtendedFeatureAppender;
import de.toolforge.googlechartwrapper.util.IFeatureAppender;


/**
 * 
 * @author steffan
 *
 */
public class VennDiagramDataAppender implements IExtendedFeatureAppender, IEncodeable{
	
	private VennDiagramData data;
	private IEncoder encoder = new AutoEncoder();
	
	/**
	 * 
	 * @param data
	 * 
	 * @throws IllegalArgumentException if data is {@code null}
	 */
	public void setVennDiagrammData(VennDiagramData data) {		
		this.data = data;				
	}
	
	public VennDiagramData getVennDiagrammData() {
		
		return this.data;
	}
	public void removeVennDiagrammData(){
		this.data = null;
	}

	public List<AppendableFeature> getAppendableFeatures(
			List<? extends IFeatureAppender> otherAppenders) {
		
			
		if(this.data != null) {
			
			int [] values = new int[] {this.data.getCircleSizeA(),this.data.getCircleSizeB(),
					this.data.getCircleSizeC(),this.data.getAreaAB(),this.data.getAreaAC(),this.data.getAreaBC(),
					this.data.getAreaABC()
					};
			
			//return this.encoder.encode(values);
			List<AppendableFeature> feature = new ArrayList<AppendableFeature>(); 
			
	        feature.add(new AppendableFeature(this.encoder.encode(values), 
	                  ChartTypeFeature.ChartData)); 
	        
			return feature;
			
		}		
		return new ArrayList<AppendableFeature>();		
	}

	public IEncoder getEncoder() {
		
		return this.encoder;
	}

	public void setEncoder(IEncoder encoder) {
		
		this.encoder = encoder;
		
		if(encoder == null){
			this.encoder = new AutoEncoder();
		}	
	}
	/*
	public String getFeaturePrefix() {		
		return ChartTypeFeature.ChartData.getPrefix();
	}*/

	public void removeEncoder() {
		
		this.encoder = new AutoEncoder();
		
	}

}
