package googlechartwrapper.util;

public class ArrayUtils {

	public static int linearSearch(Object[] array, Object searched){
		if (array == null) return -1;
		for (int i = 0; i < array.length; i++){
			if (array[i] != null && array[i].equals(searched)){
				return i;
			}
		}
		return -1;
	}
	
	public static int maxValue(int[] values){
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < values.length; i++){
			if (values[i]>max) max = values[i];
		}
		return max;
	}
	
	public static int minValue(int[] values){
		int max = Integer.MAX_VALUE;
		for (int i = 0; i < values.length; i++){
			if (values[i]<max) max = values[i];
		}
		return max;
	}
	 
}
