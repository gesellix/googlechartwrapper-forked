package googlechartwrapper.coder;

import java.util.Collection;

/**
 * The Interface for the Encoder. The Encoder defines the way how your data will be encoded.<br />
 * To receive more information about the encoding kinds study <a href="http://code.google.com/apis/chart/#text">http://code.google.com/apis/chart/#text</a>.
 * 
 * @author steffan
 *
 */
public interface IEncoder {
	
	/**
	 * Encodes the given argument.
	 * @param values array of integers to encode
	 * @return encoded string
	 */
	public String encode(int[] values);
	
	/**
	 * Encodes the given argument.
	 * @param values array of float to encode
	 * @return encoded string
	 */
	public String encode(float[] values);
	
	/**
	 * Encodes the given argument.
	 * @param values collection of integer arrays 
	 * @return encoded string
	 */
	public String encodeIntegerCollection(Collection<int[]> values);
	
	/**
	 * Encodes the given argument.
	 * @param values collection of float arrays
	 * @return encoded string
	 */
	public String encodeFloatCollection(Collection<float[]> values);	

}
