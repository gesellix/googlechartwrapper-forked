package de.toolforge.googlechartwrapper.coder;


public class DataScalingTextEncoder extends AbstractEncoder implements IEncoder{
	
	//private GenericAppender<DataScalingSet> scales;
	
	/**
	 * type of the encoder
	 */
	private static final EncodingType TYPE = EncodingType.TextEncodingWithDataScaling;
	
	/*public DataScalingTextEncoder (GenericAppender<DataScalingSet> scales){
		super(TYPE);
		this.scales = scales;
	}*/

	public DataScalingTextEncoder() {
		super(TYPE);
	}

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


	@Override
	protected String collectionEncode(float[] values) {
		if (values == null || values.length == 0) {
			return "";
		}
		
		StringBuffer bf = new StringBuffer();
		for (float t: values){
			bf.append((t));
			bf.append(",");
		}
		return bf.substring(0, bf.length()-1);
	}

	@Override
	protected String collectionEncode(int[] values) {
		if (values == null || values.length == 0) {
			return "";
		}
		
		StringBuffer bf = new StringBuffer();
		for (int t: values){
			bf.append((t));
			bf.append(",");
		}
		return bf.substring(0, bf.length()-1);
	}

	public String encode(int[] values) {
		if (values == null || values.length == 0) {
			return "";
		}
		return TYPE.getCompletePrefix()+collectionEncode(values);
	}

	public String encode(float[] values) {
		if (values == null || values.length == 0) {
			return "";
		}
		return TYPE.getCompletePrefix()+collectionEncode(values);
	}

	

}
