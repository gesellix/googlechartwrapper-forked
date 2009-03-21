package googlechartwrapper.coder;

import java.util.List;

/**
 * Default baseclass for encoder, which basicly implements the
 * collection/list-based encoding methods while using the implementation of any
 * single (array) based encoding method. Therefore each array data is encoded
 * invidually by the extending class by using the
 * {@link AbstractEncoder#collectionEncode(float[])} and
 * {AbstractEncoder#collectionEncode(float[])} method. In the process, the
 * individual encoded strings are concated with the respective separator
 * provided as an argument or by default.
 * 
 * @author martin
 * @author steffan
 * @see AutoEncoder
 * @see SimpleEncoder
 * @see ExtendedEncoder
 * 
 */
public abstract class AbstractEncoder implements IEncoder {

	/**
	 * Default separator for datasets (pipe symbol)
	 */
	public static final String DEFAULT_SEPARATOR = "|";

	/**
	 * encoder prefix which will be appended to encoded strings ("ahead")
	 */
	private final String prefix;

	private final String separator;

	/**
	 * Constructs an AbstractEncoder with the given prefix.
	 * 
	 * @param prefix
	 *            the prefix which will be appended to the encoded string
	 * @throws IllegalArgumentException
	 *             if prefix == null
	 */
	public AbstractEncoder(String prefix) {
		this(prefix, DEFAULT_SEPARATOR);
	}

	public AbstractEncoder(String prefix, String separator) {
		if (prefix == null) {
			throw new IllegalArgumentException("prefix shall not be null");
		}
		this.prefix = prefix;
		this.separator = separator;
	}

	/**
	 * Constructs an AbstractEncoder with the prefix which is associated with
	 * the type-parameter. The prefix is resolved by invoking the
	 * {@link EncodingType#getCompletePrefix()} method.
	 * 
	 * @param type
	 *            prefix for the encoder based on the type
	 */
	public AbstractEncoder(EncodingType type) {
		this(type.getCompletePrefix(), DEFAULT_SEPARATOR);
	}

	public AbstractEncoder(EncodingType type, String separator) {
		this(type.getCompletePrefix(), separator);
	}

	/**
	 * Encodes the collection by calling the
	 * {@link AbstractEncoder#collectionEncode(float[])} method for each value
	 * in the valueslist. The returned string contains the encoded data and the
	 * encoder prefix. Each dataset is seperated by the
	 * {@link #DEFAULT_SEPARATOR}.
	 * 
	 * @param values
	 *            value list (!= null)
	 */
	public String encodeFloatCollection(List<float[]> values) {
		return encodeFloatCollection(values, separator);
	}

	/**
	 * Encodes the collection by calling the
	 * {@link AbstractEncoder#collectionEncode(float[])} method for each value
	 * in the valueslist. The returned string contains the encoded data and the
	 * encoder prefix. Each dataset is seperated by the sep-parameter.
	 * 
	 * @param values
	 *            value list (!= null)
	 * @param separator
	 *            the separator separating each encoded single dataset array
	 */
	public String encodeFloatCollection(List<float[]> values, String separator) {

		StringBuilder builder = new StringBuilder(values.size() * 10);
		builder.append(prefix);
		for (float current[] : values) {
			builder.append(collectionEncode(current));
			builder.append(separator);
		}
		//check if something is in the builder, before we use substring
		if (builder.length() > 0) {
			return builder.substring(0, builder.length() - 1);
		}
		//no value was in the builder
		return "";
		
	}

	/**
	 * Encodes the value array and returns the encoded data without the encoder
	 * prefix.
	 * 
	 * @param values
	 *            data to encode
	 * @return encoded data without (full) encoder prefix
	 */
	protected abstract String collectionEncode(float[] values);

	/**
	 * Encodes the collection by calling the
	 * {@link AbstractEncoder#collectionEncode(int[])} method for each value in
	 * the valueslist. The returned string contains the encoded data and the
	 * encoder prefix. Each dataset is seperated by the
	 * {@link #DEFAULT_SEPARATOR}.
	 * 
	 * @param values
	 *            value list (!= null)
	 */
	public String encodeIntegerCollection(List<int[]> values) {
		return encodeIntegerCollection(values, separator);
	}

	/**
	 * Encodes the collection by calling the
	 * {@link AbstractEncoder#collectionEncode(int[])} method for each value in
	 * the valueslist. The returned string contains the encoded data and the
	 * encoder prefix. Each dataset is seperated by the sep-parameter.
	 * 
	 * @param values
	 *            value list (!= null)
	 * @param sep
	 *            the separator separating each encoded single dataset array
	 */
	public String encodeIntegerCollection(List<int[]> values, String sep) {
		StringBuilder builder = new StringBuilder(values.size() * 10);

		builder.append(prefix);
		for (int current[] : values) {
			builder.append(collectionEncode(current));
			builder.append(sep);
		}
		//check if something is in the builder, before we use substring
		if (builder.length() > 0) {
			return builder.substring(0, builder.length() - 1);
		}
		//no value was in the builder
		return "";
	}

	/**
	 * Encodes the value array and returns the encoded data without the encoder
	 * prefix.
	 * 
	 * @param values
	 *            data to encode
	 * @return encoded data without (full) encoder prefix
	 */
	protected abstract String collectionEncode(int[] values);

}
