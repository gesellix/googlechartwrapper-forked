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
	
}
