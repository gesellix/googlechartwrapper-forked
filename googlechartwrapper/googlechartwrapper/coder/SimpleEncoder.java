package googlechartwrapper.coder;

/**
 * Simple encoding uses the alphanumeric characters (A to Z, a to z, and 0 to 9) 
 * where A represents 0, B represents 1, and so on up to 9 which represents 61,
 * to provide a resolution of 62 different values. Allowing five pixels per data point, 
 * this is sufficient for line and bar charts up to about 300 pixels. This type 
 * of encoding results in the shortest URL for a given data set. 
 * (google api summary; fair use)
 * @author martin
 * @author steffan
 *
 */
public class SimpleEncoder extends AbstractEncoder implements IEncoder{
	
	/**
	 * all characters for simple encoding
	 */
	private static final char[] simpleEncodingChars = { 'A', 'B', 'C', 'D',
		'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
		'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
		'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
		'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3',
		'4', '5', '6', '7', '8', '9' };

	/**
	 * Encodes the given argument. If an empty array or null is 
	 * used, the resulting datastring will be an empty string "".
	 * A value out of range (so &lt; 0 or &gt; 61) is marked as
	 * a missing value (underscore in the string).
	 * @param values array of integers to encode
	 * @return encoded string
	 */
	public String encode(int[] values) {
		if (values == null || values.length == 0) {
			return "";
		}

		final StringBuilder encodedData = new StringBuilder();
		for (int current : values) {
			encodedData.append((current < 0 || current > (simpleEncodingChars.length - 1)) ? "_"
							: simpleEncodingChars[current]);
		}
		return encodedData.toString();
	}

	/**
	 * Encodes the given argument. If an empty array or null is 
	 * used, the resulting datastring will be an empty string "".
	 * A value out of range (so &lt; 0 or &gt; 61) is marked as
	 * a missing value (underscore in the string).
	 * @param values array of float to encode (dataset)
	 * @return encoded string
	 */
	public String encode(float[] values) {
		if (values == null || values.length == 0) {
			return "";
		}

		final StringBuilder encodedData = new StringBuilder();
		for (float cur : values) {
			int current = Math.round(cur);
			encodedData.append((current < 0 || current > (simpleEncodingChars.length - 1)) ? "_"
							: simpleEncodingChars[current]);
		}
		return encodedData.toString();
	}

}
