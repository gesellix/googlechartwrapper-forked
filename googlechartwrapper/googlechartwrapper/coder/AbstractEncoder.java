package googlechartwrapper.coder;

import java.util.List;

/**
 * Default baseclass for encoder, which basicly 
 * implements the collection/list-based encoding methods while using
 * the implementation of any single (array) based encoding method. Therefore
 * each array data is encoded invidually by the extending class by using the
 * {@link AbstractEncoder#collectionEncode(float[])} and 
 * {AbstractEncoder#collectionEncode(float[])} method. 
 * In the process, the individual encoded strings are concated with the respective
 * separator provided as an argument or by default. 
 * @author martin
 * @see AutoEncoder
 * @see SimpleEncoder
 * @see ExtendedEncoder
 * @author martin
 */
public abstract class AbstractEncoder implements IEncoder{
	
	/**
	 * Default separator for datasets (pipe symbol)
	 */
	public final String DEFAULT_SEPARATOR = "|";
	
	private final String prefix;
	
	public AbstractEncoder(String prefix){
		if (prefix == null){
			throw new IllegalArgumentException("prefix shall not be null");
		}
		this.prefix = prefix;
	}
	
	public AbstractEncoder(EncodingType type){
		this(type.getCompletePrefix());
	}
	

	/**
	 * Encodes the collection by calling the 
	 * {@link AbstractEncoder#collectionEncode(float[])}
	 * method for each value in the valueslist. Each dataset is seperated by
	 * the {@link #DEFAULT_SEPARATOR}.
	 * @param values value list (!= null) 
	 */
	public String encodeFloatCollection(List<float[]> values) {
		return encodeFloatCollection(values, DEFAULT_SEPARATOR);
	}

	/**
	 * Encodes the collection by calling the 
	 * {@link AbstractEncoder#collectionEncode(float[])}
	 * method for each value in the valueslist. Each dataset is seperated by
	 * the sep-parameter.
	 * @param values value list (!= null) 
	 * @param separator the separator separating each encoded single dataset array
	 */
	public String encodeFloatCollection(List<float[]> values, String separator) {
		
		StringBuilder bf = new StringBuilder(values.size()*10);
		bf.append(prefix);
		for (float current[]:values){
			bf.append(collectionEncode(current));
			bf.append(separator);
		}
		return bf.substring(0,bf.length()-1);
	}
	
	/**
	 * Encodes the value array and returns the encoded data without the encoder prefix.
	 * @param values data to encode
	 * @return encoded data without (full) encoder prefix
	 */
	protected abstract String collectionEncode (float[] values);
	
	/**
	 * Encodes the collection by calling the 
	 * {@link AbstractEncoder#collectionEncode(int[])}
	 * method for each value in the valueslist. Each dataset is seperated by
	 * the {@link #DEFAULT_SEPARATOR}.
	 * @param values value list (!= null) 
	 */
	public String encodeIntegerCollection(List<int[]> values) {
		return encodeIntegerCollection(values, DEFAULT_SEPARATOR);
	}
	
	/**
	 * Encodes the collection by calling the 
	 * {@link AbstractEncoder#collectionEncode(int[])}
	 * method for each value in the valueslist. Each dataset is seperated by
	 * the sep-parameter.
	 * @param values value list (!= null) 
	 * @param sep the separator separating each encoded single dataset array
	 */
	public String encodeIntegerCollection(List<int[]> values, String sep) {
		StringBuilder bf = new StringBuilder(values.size()*10);
		bf.append(prefix);
		for (int current[]:values){
			bf.append(collectionEncode(current));
			bf.append(sep);
		}
		return bf.substring(0,bf.length()-1);
	}
	
	/**
	 * Encodes the value array and returns the encoded data without the encoder prefix.
	 * @param values data to encode
	 * @return encoded data without (full) encoder prefix
	 */
	protected abstract String collectionEncode (int[] values);
		
}
