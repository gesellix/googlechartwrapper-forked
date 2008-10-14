package googlechartwrapper.coder;

import java.util.List;

/**
 * The Interface for the Encoder. The Encoder defines the way how your data will 
 * be encoded.<br />
 * To receive more information about the encoding kinds 
 * study 
 * <a href="http://code.google.com/apis/chart/#text">http://code.google.com/apis/chart/#text</a>.
 * 
 * @author steffan
 * @author martin
 *
 */
public interface IEncoder {
	
	/**
	 * Encodes the given argument. If an empty array or null is 
	 * used, the resulting datastring will be an empty string "".
	 * The returned string must contain the 
	 * {@link EncodingType#getCompletePrefix()} and the encoded data.
	 * @param values array of integers to encode
	 * @return encoded string
	 */
	public String encode(int[] values);
	
	/**
	 * Encodes the given argument. If an empty array or null is 
	 * used, the resulting datastring will be an empty string "".
	 * The returned string must contain the 
	 * {@link EncodingType#getCompletePrefix()} and the encoded data.
	 * @param values array of float to encode
	 * @return encoded string
	 */
	public String encode(float[] values);
	
	/**
	 * Encodes the given argument.
	 * The returned string must contain the 
	 * {@link EncodingType#getCompletePrefix()} and the encoded data.
	 * @param values collection of integer arrays 
	 * @return encoded string
	 */
	public String encodeIntegerCollection(List<int[]> values);
	
	/**
	 * Encodes the given list of int values, separating each dataset string 
	 * ("array") with the given sep value.
	 * The returned string must contain the 
	 * {@link EncodingType#getCompletePrefix()} and the encoded data.
	 * @param values list of values to encode
	 * @param sep separator between each dataset
	 * @return encoded string
	 */
	public String encodeIntegerCollection(List<int[]> values, String sep);
	
	/**
	 * Encodes the given argument.
	 * The returned string must contain the 
	 * {@link EncodingType#getCompletePrefix()} and the encoded data.
	 * @param values collection of float arrays
	 * @return encoded string
	 */
	public String encodeFloatCollection(List<float[]> values);
	
	/**
	 * Encodes the given list of int values, separating each dataset string 
	 * ("array") with the given sep value.
	 * The returned string must contain the 
	 * {@link EncodingType#getCompletePrefix()} and the encoded data.
	 * @param values list of values to encode
	 * @param sep separator between each dataset
	 * @return encoded string
	 */
	public String encodeFloatCollection(List<float[]> values, String sep);
		

}
