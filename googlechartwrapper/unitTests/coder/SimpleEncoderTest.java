package unitTests.coder;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import de.toolforge.googlechartwrapper.coder.SimpleEncoder;

/**
 * Test for the {@link SimpleEncoder}
 * @author martin
 *
 */
public class SimpleEncoderTest {
	
	private SimpleEncoder encoder;

	@Before
	public void setUp() throws Exception {
		encoder = new SimpleEncoder();
	}
	
	@Test
	public void testEncodeIntArray() {
		//s:ATb19
		//A represents 0, T represents 19, b represents 27, 1 represents 53, 
		//and 9 represents 61.
		
		int[] val = new int[]{0,19,27,53,61};
		String actual = encoder.encode(val);
		String expected = "s:ATb19";
		assertEquals(expected, actual);
	}

	@Test
	public void testEncodeEmptyIntArray() {		
		int[] val = new int[0];
		String actual = encoder.encode(val);
		String expected = "";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testEncodeFloatArray() {
		float[] val = new float[]{0f,19f,27f,53f,61f};
		String actual = encoder.encode(val);
		String expected = "s:ATb19";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testEncodeEmptyFloatArray() {
		float[] val = new float[0];
		String actual = encoder.encode(val);
		String expected = "";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testEncodeRoundedFloatArray() {
		float[] val = new float[]{0.49f,19.49f,27.49f,53.49f,61.49f};
		String actual = encoder.encode(val);
		String expected = "s:ATb19";
		assertEquals(expected, actual);
	}

	@Test
	public void testEncodeIntegerCollectionListOfint() {
		int[] valOne = new int[]{0,1,2};
		int[] valTwo = new int[]{0,1,2};
		ArrayList<int[]> values = new ArrayList<int[]>(2);
		values.add(valOne);
		values.add(valTwo);
		String actual = encoder.encodeIntegerCollection(values);
		String expected = "s:ABC|ABC";		
		assertEquals(expected, actual);
	}

	@Test
	public void testEncodeIntegerCollectionListOfintString() {
		int[] valOne = new int[]{0,1,2};
		int[] valTwo = new int[]{0,1,2};
		ArrayList<int[]> values = new ArrayList<int[]>(2);
		values.add(valOne);
		values.add(valTwo);
		String actual = encoder.encodeIntegerCollection(values,",");
		String expected = "s:ABC,ABC";		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testEncodeFloatCollectionListOffloat() {
		float[] valOne = new float[]{0.49f,1f,2f};
		float[] valTwo = new float[]{0f,1f,2f};
		ArrayList<float[]> values = new ArrayList<float[]>(2);
		values.add(valOne);
		values.add(valTwo);
		String actual = encoder.encodeFloatCollection(values);
		String expected = "s:ABC|ABC";		
		assertEquals(expected, actual);
	}

	@Test
	public void testEncodeFloatCollectionListOffloatString() {
		float[] valOne = new float[]{0.49f,1f,2f};
		float[] valTwo = new float[]{0f,1f,2f};
		ArrayList<float[]> values = new ArrayList<float[]>(2);
		values.add(valOne);
		values.add(valTwo);
		String actual = encoder.encodeFloatCollection(values,",");
		String expected = "s:ABC,ABC";		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testAllChars(){
		int[] values = new int[62];
		for (int i = 0 ; i < 62; i++){
			values[i] = i;
		}
		String actual = encoder.encode(values);
		String expected = "s:ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
				"abcdefghijklmnopqrstuvwxyz" +
				"0123456789";
		assertEquals(expected, actual);
	}

}
