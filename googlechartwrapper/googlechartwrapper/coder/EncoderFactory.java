package googlechartwrapper.coder;

import googlechartwrapper.util.ArrayUtils;

public class EncoderFactory {
	
	public static EncodingType getSuggestedEncodingType (int[] values){
		int max = ArrayUtils.maxValue(values);
		if (max < 62){
			return EncodingType.SimpleEncoding;
		}
		else if (max < 4096){
			return EncodingType.ExtendedEncoding;
		}
		else {
			return EncodingType.TextEncoding;
		}
	}
	
	public static IEncoder getEncoder (EncodingType type){
		if (type == null){
			throw new IllegalArgumentException("type must not be null");
		}
		switch (type){
		case SimpleEncoding: return new SimpleEncoder();
		case ExtendedEncoding: return new ExtendedEncoder();
		default: return new DataScalingTextEncoder();
		}
	}

}
