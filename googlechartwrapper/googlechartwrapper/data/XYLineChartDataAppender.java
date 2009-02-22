package googlechartwrapper.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import googlechartwrapper.ChartTypeFeature;
import googlechartwrapper.coder.AutoEncoder;
import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.interfaces.IEncodeable;
import googlechartwrapper.util.IExtendedFeatureAppender;
import googlechartwrapper.util.IFeatureAppender;

/**
 * 
 * @author steffan
 * 
 */
public class XYLineChartDataAppender implements IExtendedFeatureAppender,
		IEncodeable {

	private IEncoder encoder = new AutoEncoder();
	private List<XYLineChartData> data = new ArrayList<XYLineChartData>();
	
	/**
	 * 
	 * @param data
	 * 
	 * @throws IllegalArgumentException if data is {@code null}
	 */
	public void addXYLineChartData(XYLineChartData data){
		
		if(data == null)
			throw new IllegalArgumentException("data can not be null");
		this.data.add(data);
	}
	
	/**
	 * 
	 * @param data
	 * 
	 * @throws IllegalArgumentException if data is {@code null} and/or value is {@code null}
	 */
	public void addXYLineChartData(List<XYLineChartData> data){
		
		if(data == null)
			throw new IllegalArgumentException("data can not be null");
		List<XYLineChartData> temp = (ArrayList<XYLineChartData>) Collections.unmodifiableCollection(data);
		
		for(XYLineChartData current : temp){
			if(current == null)
				throw new IllegalArgumentException("pair can not be null");
		}
		this.data.add((XYLineChartData) temp);
	}
	public String getFeaturePrefix() {

		return ChartTypeFeature.ChartData.getPrefix();
	}

	public String getAppendableString(
			List<? extends IFeatureAppender> otherAppenders) {
		// TODO Auto-generated method stub
		return null;
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
