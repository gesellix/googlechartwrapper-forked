package googlechartwrapper.coder;

import java.util.List;

abstract class AbstractEncoder implements IEncoder{
	
	public final String DEFAULT_SEPARATOR = "|";
	
	public String encodeFloatCollection(List<float[]> values) {
		return encodeFloatCollection(values, DEFAULT_SEPARATOR);
	}

	public String encodeFloatCollection(List<float[]> values, String sep) {
		
		StringBuilder bf = new StringBuilder(values.size()*10);
		for (float current[]:values){
			bf.append(encode(current));
			bf.append(sep);
		}
		return bf.substring(0,bf.length()-2);
	}
	
	public String encodeIntegerCollection(List<int[]> values) {
		return encodeIntegerCollection(values, DEFAULT_SEPARATOR);
	}
	
	public String encodeIntegerCollection(List<int[]> values, String sep) {
		StringBuilder bf = new StringBuilder(values.size()*10);
		for (int current[]:values){
			bf.append(encode(current));
			bf.append(sep);
		}
		return bf.substring(0,bf.length()-2);
	}
	
	
	
}
