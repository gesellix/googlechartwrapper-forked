package googlechartwrapper.coder;

import java.util.Collection;

public class DataScalingTextEncoder implements IEncoder{

	/*
	 * Text encoding

	Specify text encoding with

	chd=t:<chart data string>

	Where <chart data string> consists of positive floating point numbers from 
	zero (0.0) to one hundred (100.0), minus one (-1), and the pipe character (|) 
	as a separator.

	Note:
	You can specify a missing value with minus one (-1).
	If you have more than one set of data, separate each set with a pipe character (|).

	For example: chd=t:10.0,58.0,95.0|30.0,8.0,63.0
	 */
	public String encode(int[] values) {
		return "t:"+internalEncode(values);
	}
	
	private String internalEncode (int[] values){
		StringBuffer bf = new StringBuffer(values.length*3);
		for (int t: values){
			bf.append(t);
			bf.append(",");
		}
		return bf.substring(0, bf.length()-2);
	}

	public String encode(float[] values) {
		return "t:"+internalEncode(values);
	}
	
	private String internalEncode(float[] values) {
		StringBuffer bf = new StringBuffer(values.length*3);
		for (float t: values){
			bf.append(t);
			bf.append(",");
		}
		return bf.substring(0, bf.length()-2);
	}

	public String encodeFloatCollection(Collection<float[]> values) {
		StringBuffer bf = new StringBuffer();
		for (float[] t: values){
			bf.append(internalEncode(t));
			bf.append("|");
		}
		return "t:"+bf.substring(0, bf.length()-2);
	}

	public String encodeIntegerCollection(Collection<int[]> values) {
		StringBuffer bf = new StringBuffer();
		for (int[] t: values){
			bf.append(internalEncode(t));
			bf.append("|");
		}
		return "t:"+bf.substring(0, bf.length()-2);
	}

}
