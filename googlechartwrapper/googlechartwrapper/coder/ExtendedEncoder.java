package googlechartwrapper.coder;

/**
 * Class implementing the encoding of data which provide a 
 * resolution of 4096 different values (between 0 and 4095). 
 * It uses a pair of characters specified in the google api, where
 * AA represents 0, AB 1 and so on.
 * This type of encoding results in a URL twice the length of simple 
 * encoding {@link SimpleEncoder} for a given data set.
 * 
 * If a value below 0 or greater 4095 exists in the dataset, this value is
 * ignored and marked as a missing value (google api terms).
 * @author martin
 *
 */
public class ExtendedEncoder extends AbstractEncoder implements IEncoder {
	
	/**
	 * all possible chars for the extended encoding
	 */
	private static final char[] extendedEncodingChars = { 'A', 'B', 'C', 'D',
		'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
		'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
		'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
		'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3',
		'4', '5', '6', '7', '8', '9', '-', '.' };

	/**
	 * resulting pairs of characters for each value between 0 and 4095
	 */
	private static final String[] extendedEncoding = new String[4096];	

	static { // Fill the encoding arrays in static block.
		int cnt = 0;
		for (int i = 0; i < extendedEncodingChars.length; i++) {
			for (int j = 0; j < extendedEncodingChars.length; j++) {
				extendedEncoding[cnt++] = extendedEncodingChars[i] + ""
						+ extendedEncodingChars[j];
			}
		}
	}

	/**
	 * Encodes the given argument. If an empty array or null is 
	 * used, the resulting datastring will be an empty string "".
	 * A value out of range (so &lt; 0 or &gt; 4095) is marked as
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
			encodedData.append((current < 0 || current > 
				(extendedEncoding.length - 1)) ? "_"
							: extendedEncoding[current]);
		}
		return encodedData.toString();
	}	
		

	/**
	 * Encodes the given argument. If an empty array or null is 
	 * used, the resulting datastring will be an empty string "".
	 * A value out of range (so &lt; 0 or &gt; 4095) is marked as
	 * a missing value (underscore in the string).
	 * @param values array of float data to encode
	 * @return encoded string
	 */
	public String encode(float[] values) {
		if (values == null || values.length == 0) {
			return "";
		}

		final StringBuilder encodedData = new StringBuilder();
		for (float cur : values) {
			int current = Math.round(cur);
			encodedData.append((current < 0 || current > 
				(extendedEncoding.length - 1)) ? "_"
							: extendedEncoding[current]);
		}
		return encodedData.toString();
	}	

}
