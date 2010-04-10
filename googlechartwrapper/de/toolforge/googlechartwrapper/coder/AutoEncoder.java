package de.toolforge.googlechartwrapper.coder;

import java.util.List;

/**
 * The default encoder implementation switching between the different 
 * encoder variants (for example {@link SimpleEncoder}, {@link ExtendedEncoder}) 
 * based on the recommendation of {@link EncoderFactory#getSuggestedEncodingType(int[])}.
 * As a result the length of the datastring in the url is usually minimized by
 * this encoder. In regards to the implementation of the transformation of 
 * data into an encoded string the documentation of these encoders
 * should be consulted. 
 * @author steffan
 * @author martin
 * @see EncoderFactory
 */
public class AutoEncoder extends AbstractEncoder implements IEncoder {	

	/**
	 * The recommended encodingtype (lowest possible) by the {@link EncoderFactory}
	 */
	private EncodingType encodingType = null;
	/**
	 * is a single value array encoded or more datasets (-> list)
	 */
	private boolean isCollection = false;
	
	/**
	 * Constructs a new AutoEncoder with no specific encoder prefix.
	 */
	public AutoEncoder(){
		super("");
	}

	public String encode(int[] values) {
		if (encodingType == null){
			encodingType = EncoderFactory.getSuggestedEncodingType(values);	
		}
		
		IEncoder encoder = EncoderFactory.getEncoder(encodingType);	
		String result = encoder.encode(values);
				
		if (!isCollection){
			encodingType = null;
		}
		return result;
	}

	public String encode(float[] values) {
		if (encodingType == null){
			encodingType = EncoderFactory.getSuggestedEncodingType(values);	
		}
		
		IEncoder encoder = EncoderFactory.getEncoder(encodingType);	
		String result = encoder.encode(values);
		
		if (!isCollection){
			encodingType = null;
		}
		return result;
	}

	@Override
	public String encodeFloatCollection(List<float[]> values, String sep) {
		EncodingType highest = EncodingType.SimpleEncoding;
		for (int i = 0; i < values.size(); i++){
			EncodingType temp = EncoderFactory.getSuggestedEncodingType(values.get(i));	
			if(temp.getRank() > highest.getRank()){
				highest = temp;
			}			
		}
		encodingType = highest;
		isCollection = true;
		
		final IEncoder encoder = EncoderFactory.getEncoder(encodingType);
		final String s = encoder.encodeFloatCollection(values);
		
		encodingType = null;
		isCollection = false;
		return s;
	}
	
	@Override
	public String encodeIntegerCollection(List<int[]> values, String sep) {
		EncodingType highest = EncodingType.SimpleEncoding;
		for (int i = 0; i < values.size(); i++){
			EncodingType temp = EncoderFactory.getSuggestedEncodingType(values.get(i));	
			if(temp.getRank() > highest.getRank()){
				highest = temp;
			}	
		}
		encodingType = highest;
		isCollection = true;
		
		final IEncoder encoder = EncoderFactory.getEncoder(encodingType);
		final String s = encoder.encodeIntegerCollection(values);
		
		encodingType = null;
		isCollection = false;
		return  s;
	}

	@Override
	protected String collectionEncode(float[] values) {
		String s = encode(values);
		if (s.length()>=encodingType.getCompletePrefix().length()){
			return s.substring(encodingType.getCompletePrefix().length());
		}
		else {
			return s;
		}
	}

	@Override
	protected String collectionEncode(int[] values) {
		IEncoder encoder = EncoderFactory.getEncoder(encodingType);
		if ((encoder instanceof AbstractEncoder)){ 
			//Maintainability: should we discourage that? 
			return ((AbstractEncoder)encoder).collectionEncode(values);
		}
		else {
			String s = encode(values);
			if (s.length()>=encodingType.getCompletePrefix().length()){
				return s.substring(encodingType.getCompletePrefix().length());
			}
			else {
				return s;
			}
		}
		
	}
}
