package googlechartwrapper.coder;

import java.util.Collection;

public class SimpleEncoder extends AbstractEncoder implements IEncoder{
	
	private static final char[] simpleEncodingChars = { 'A', 'B', 'C', 'D',
		'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
		'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
		'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
		'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3',
		'4', '5', '6', '7', '8', '9' };
	/*private static final String[] simpleEncoding = new String[62]; //does anyone find some sense?
	
	static {
		int cnt = 0;
		for (int i = 0; i < simpleEncodingChars.length; i++) {
			simpleEncoding[cnt++] = simpleEncodingChars[i] + "";
		}
	}*/

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

	public EncodingType getSuggestEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setEncoding(EncodingType econdingType) {
		// TODO Auto-generated method stub
		
	}


}
