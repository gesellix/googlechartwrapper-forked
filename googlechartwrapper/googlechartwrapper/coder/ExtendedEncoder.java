package googlechartwrapper.coder;

public class ExtendedEncoder extends AbstractEncoder implements IEncoder {
	
	private static final char[] extendedEncodingChars = { 'A', 'B', 'C', 'D',
		'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
		'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
		'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
		'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3',
		'4', '5', '6', '7', '8', '9', '-', '.' };

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

	public String encode(int[] values) {
		if (values == null || values.length == 0) {
			return "";
		}

		final StringBuilder encodedData = new StringBuilder();
		for (int current : values) {
			encodedData.append((current < 0 || current > (extendedEncoding.length - 1)) ? "_"
							: extendedEncoding[current]);
		}
		return encodedData.toString();
	}

	public String encode(float[] values) {
		if (values == null || values.length == 0) {
			return "";
		}

		final StringBuilder encodedData = new StringBuilder();
		for (float cur : values) {
			int current = Math.round(cur);
			encodedData.append((current < 0 || current > (extendedEncoding.length - 1)) ? "_"
							: extendedEncoding[current]);
		}
		return encodedData.toString();
	}

	public EncodingType getSuggestEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setEncoding(EncodingType econdingType) {
		// TODO Auto-generated method stub
		
	}
	
	

}
