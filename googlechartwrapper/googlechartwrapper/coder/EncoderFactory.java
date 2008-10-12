package googlechartwrapper.coder;

import googlechartwrapper.util.ArrayUtils;

/**
 * A factory for default-encoders, also providing convenient method to determine 
 * the appropriate encoder based on the dataset range. 
 * @author martin
 *
 */
public class EncoderFactory {
	
	/**
	 * Determines the best matching encoder for a given dataset while aiming for 
	 * a short url. Based on the maximum value of the dataset the best matching encoder
	 * type is returned. 
	 * 
	 * <p>The method does not test on the possibility of scaling data.
	 * Example: dataset <i>24; 40; 78</i> <br>
	 * The dataset could be scaled/mutated to <i>12; 20; 39</i> without loosing 
	 * accuracy and additionally allowing the {@link EncodingType#SimpleEncoding} 
	 * (with a datarange between 0 and 62)
	 * to be used. <br>
	 * Nevertheless as no check is performed in regard to that, 
	 * {@link EncodingType#ExtendedEncoding} (for values greater 62) will be returned.
	 * </p>
	 * 
	 * <p>Note that the example does not necessarily reflect the true returned type.
	 * The minimum value in the dataset is currently ignored. Refer to the implementation
	 * of encoders to understand behaviour in regards to negative values etc.</p>
	 * @param values values to check
	 * @return the best matching type based on a simple analysis of the values
	 */
	public static EncodingType getSuggestedEncodingType (int[] values){
		int max = ArrayUtils.maxValue(values); 
		//to simple, should check for min value
		//further: check for scaling method without loosing accuracy and/or
		//a configurable ammount of accuracy loss. (martin)
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
	
	/**
	 * Determines the best matching encoder for a given dataset while aiming for 
	 * a short url. Based on the maximum value of the dataset the best matching encoder
	 * type is returned. 
	 * 
	 * <p>The method does not test on the possibility of scaling data.
	 * Example: dataset <i>24; 40; 78</i> <br>
	 * The dataset could be scaled/mutated to <i>12; 20; 39</i> without loosing 
	 * accuracy and additionally allowing the {@link EncodingType#SimpleEncoding} 
	 * (with a datarange between 0 and 62)
	 * to be used. <br>
	 * Nevertheless as no check is performed in regard to that, 
	 * {@link EncodingType#ExtendedEncoding} (for values greater 62) will be returned.
	 * </p>
	 * 
	 * <p>Note that the example does not necessarily reflect the true returned type.
	 * The minimum value in the dataset is currently ignored. Refer to the implementation
	 * of encoders to understand behaviour in regards to negative values etc.</p> 
	 * 
	 * @param values values to check
	 * @return the best matching type based on a simple analysis of the values
	 * @see #getSuggestedEncodingType(int[])
	 */
	public static EncodingType getSuggestedEncodingType (float[] values){
		float max = ArrayUtils.maxValue(values); 
		//to simple, should check for min value
		//further: check for scaling method without loosing accuracy and/or
		//a configurable ammount of accuracy loss. (martin)
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
	
	/**
	 * Returns the default encoder implementation for each {@link EncodingType}.
	 * @param type type of encoder
	 * @return matching type
	 * @throws IllegalArgumentException if type == null
	 */
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
