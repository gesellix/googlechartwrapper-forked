package googlechartwrapper.data;

import java.util.List;

import googlechartwrapper.ChartTypeFeature;
import googlechartwrapper.coder.Encoder;
import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.util.IExtendedFeatureAppender;
import googlechartwrapper.util.IFeatureAppender;

/**
 * 
 * @author steffan
 *
 */
public class VennDiagramAppender implements IExtendedFeatureAppender, IEncodeable{
	
	private VennDiagramData data;
	private IEncoder encoder;
	
	public void setVennDiagrammData(VennDiagramData data) {
		
		this.data = data;
		
		this.encoder = new Encoder();
	}
	
	public VennDiagramData getVennDiagrammData() {
		
		return this.data;
	}

	public String getAppendableString(
			List<? extends IFeatureAppender> otherAppenders) {
		
			
		if(this.data != null) {
			
			int [] values = new int[] {this.data.getCircleSizeA(),this.data.getCircleSizeB(),
					this.data.getCircleSizeC(),this.data.getAreaAB(),this.data.getAreaAC(),this.data.getAreaBC(),
					this.data.getAreaABC()
					};
			
			return this.encoder.encode(values);
			
		}		
		return "";			
	}

	public IEncoder getEncoder() {
		
		return this.encoder;
	}

	public void setEncoder(IEncoder encoder) {
		this.encoder = encoder;		
	}

	public String getFeaturePrefix() {
		// TODO Auto-generated method stub
		return ChartTypeFeature.ChartData.getPrefix();
	}

	public void removeEncoder() {
		
		this.encoder = new Encoder();
		
	}

}
