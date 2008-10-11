package googlechartwrapper.coder;

import java.util.List;

/**
 * The default encoder implementation
 * 
 * @author steffan
 * @author martin
 * 
 */
public class AutoEncoder extends AbstractEncoder implements IEncoder {	

	private EncodingType encodingType = null;
	private boolean isCollection = false;
	

	public String encode(int[] values) {
		if (encodingType == null){
			encodingType = EncoderFactory.getSuggestedEncodingType(values);	
		}
		IEncoder encoder = EncoderFactory.getEncoder(encodingType);
		
		if (!isCollection){
			encodingType = null;
		}
		return encoder.encode(values);
	}

	public String encode(float[] values) {
		//TODO mva
		return null;
	}

	@Override
	public String encodeFloatCollection(List<float[]> values, String sep) {
		//TODO mva
		return super.encodeFloatCollection(values, sep);
	}
	
	@Override
	public String encodeIntegerCollection(List<int[]> values, String sep) {
		EncodingType highest = EncodingType.SimpleEncoding;
		for (int i = 0; i < values.size(); i++){
			EncodingType temp = EncoderFactory.getSuggestedEncodingType(values.get(i));	
			if (temp.compareTo(highest)>0){
				highest = temp;
			}
		}
		encodingType = highest;
		isCollection = true;
		String s =  super.encodeIntegerCollection(values, sep);
		encodingType = null;
		isCollection = false;
		return s;
	}
}
