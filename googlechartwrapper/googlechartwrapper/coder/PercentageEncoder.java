package googlechartwrapper.coder;

import java.util.Collection;

/**
 * from 0..100 percent
 * @author mart
 *
 */
public class PercentageEncoder implements IEncoder{

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
		/*StringBuffer bf = new StringBuffer(values.length*3+5);
		bf.append("chd=t:");
		for (int i = 0; i < values.length; i++){
			bf.append((int)values[i]%100);
			bf.append(",");
		}
		return bf.substring(0, bf.length()-1);*/
		return null;
	}

	public String encodeFloatCollection(Collection<float[]> values) {
		return null;
	}

	public String encodeIntegerCollection(Collection<int[]> values) {
		
		return null;
	}
	
}
