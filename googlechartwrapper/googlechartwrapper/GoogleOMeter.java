package googlechartwrapper;

import googlechartwrapper.coder.IEncoder;

import java.awt.Dimension;
import java.util.Collection;

public class GoogleOMeter extends AbstractChart{
	
	private String labelTexts[];
	
	//TODO martin: add data scaling
	
	public GoogleOMeter(Dimension chartDimension) {
		super(chartDimension);
	}

	public String[] getLabelTexts() {
		return labelTexts;
	}

	public void setLabelTexts(String[] labelTexts) {
		this.labelTexts = labelTexts;
	}	

	@Override
	protected ChartType getChartType() {		
		return ChartType.GoogleOMeter;
	}

	@Override
	protected String getUrlChartType() {
		return "gom";
	}	
	
	public void setPercentageValues(int[] values) {
		this.values = new PercentageEncoder().encode(values);
	}	
	
	public void setPercentageValues(float[] values) {
		this.values = new PercentageEncoder().encode(values);
	}
	
	@Override
	protected void collectUrlElements() {
		super.collectUrlElements();
		if (labelTexts!= null && labelTexts.length >0){
			StringBuffer bf = new StringBuffer(labelTexts.length*8);
			bf.append("chl=");
			for (String s: labelTexts){
				bf.append(s);
				bf.append("|");
			}
			urlElements.add(bf.substring(0,bf.length()-1));
		}
	}
	
	
	
	/**
	 * from 0..100 percent
	 * @author mart
	 *
	 */
	public class PercentageEncoder implements IEncoder{

		public String encode(int[] values) {
			StringBuffer bf = new StringBuffer(values.length*3+5);
			bf.append("chd=t:");
			for (int i = 0; i < values.length; i++){
				bf.append(Integer.toString((values[i]%100)));
				bf.append(",");
			}
			return bf.substring(0, bf.length()-1);
		}

		public String encode(float[] values) {
			StringBuffer bf = new StringBuffer(values.length*3+5);
			bf.append("chd=t:");
			for (int i = 0; i < values.length; i++){
				bf.append((int)values[i]%100);
				bf.append(",");
			}
			return bf.substring(0, bf.length()-1);
		}

		public String encodeFloatCollection(Collection<float[]> values) {
			return null;
		}

		public String encodeIntegerCollection(Collection<int[]> values) {
			
			return null;
		}
		
	}

}
