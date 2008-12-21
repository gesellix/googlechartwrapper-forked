package googlechartwrapper.coder;

/**
 * 
 * @author steffan
 *
 */
public class PercentageEncoder extends AbstractEncoder implements IEncoder {

	public PercentageEncoder() {
		super("");
		
	}

	@Override
	protected String collectionEncode(float[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String collectionEncode(int[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	public String encode(int[] values) {
		int sum = 0;
		for (int i = 0; i < values.length; i++){
			sum = sum+values[i];
		}
		StringBuffer bf = new StringBuffer(values.length*3+5);
		bf.append("chd=t:");
		for (int i = 0; i < values.length; i++){
			bf.append(Integer.toString((values[i]*100/sum)));
			bf.append(",");
		}
		return bf.substring(0, bf.length()-1);
	}

	public String encode(float[] values) {
		StringBuffer bf = new StringBuffer(values.length*3+5);
		bf.append("chd=t:");
		for (int i = 0; i < values.length; i++){
			bf.append((int)values[i]%100);
			bf.append(",");
		}
		return bf.substring(0, bf.length()-1);
		
	}

}
