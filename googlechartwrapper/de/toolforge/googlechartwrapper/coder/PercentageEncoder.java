package de.toolforge.googlechartwrapper.coder;


import java.util.ArrayList;
import java.util.List;

import de.toolforge.googlechartwrapper.util.ArrayUtils;

/**
 * option 1: greatest value equals 100
 * starting point is 0, everything between scaled
 * @author martin
 *
 */

//nice to have:
//TODO starting point not default 0, but smallest value
//TODO define sets to decode as percentage (so e.g. set 1 and 2 are scaled together, 
//3 independent with his OWN max)
public class PercentageEncoder implements IEncoder {

	public String encodeIntegerCollection(List<int[]> values) {
		return encodeIntegerCollection(values,",");		
	}

	public String encodeIntegerCollection(List<int[]> values, String sep) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < values.size(); i++){
			int temp = ArrayUtils.maxValue(values.get(i));
			if (temp > max){
				max = temp;
			}
		}
		
		List<int[]> newValues = new ArrayList<int[]>(values.size());
		for (int i = 0; i < values.size(); i++){			
			newValues.add(scaleValues(max, values.get(i)));
		}
		ExtendedEncoder e = new ExtendedEncoder();
		return e.encodeIntegerCollection(newValues,sep);
	}
	
	private int[] scaleValues (int max, int[] values){
		int newValues[] = new int[values.length];
		
		for (int i = 0; i < newValues.length; i++){
			float multp = (float)values[i]/(float)max;
			int realValue = Math.round( (4095*multp));
			newValues[i] = realValue;
		}
		return newValues;
	}

	public String encode(int[] values) {		
		ExtendedEncoder e = new ExtendedEncoder();
		return e.encode(scaleValues(ArrayUtils.maxValue(values), values));
	}

	public String encode(float[] values) {
		return null;
		
	}

	public String encodeFloatCollection(List<float[]> values) {
		// TODO Auto-generated method stub
		return null;
	}

	public String encodeFloatCollection(List<float[]> values, String sep) {
		// TODO Auto-generated method stub
		return null;
	}

}
