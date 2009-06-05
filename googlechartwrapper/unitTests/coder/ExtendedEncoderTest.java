package unitTests.coder;

import static org.junit.Assert.assertEquals;
import googlechartwrapper.coder.ExtendedEncoder;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * Test for the {@link ExtendedEncoder}
 * @author martin
 *
 */
public class ExtendedEncoderTest {

	private ExtendedEncoder encoder;

	@Before
	public void setUp() throws Exception {
		encoder = new ExtendedEncoder();
	}
	
	@Test
	public void testEncodeIntArray() {
		//AA = 0, AZ = 25, Aa = 26, Az = 51, A0 = 52, A9 = 61, A- = 62, A. = 63
		//BA = 64, BZ = 89, Ba = 90, Bz = 115, B0 = 116, B9 = 125, B- = 126, B. = 127
		//.A = 4032, .Z = 4057, .a = 4058, .z = 4083, .0 = 4084, .9 = 4093, .- = 4094, 
		//.. = 4095.
		
		int[] val = new int[]{0,25,26,51,61};
		String actual = encoder.encode(val);
		String expected = "e:AAAZAaAzA9";
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
		float[] val = new float[]{0f,25f,26f,51f,61f};
		String actual = encoder.encode(val);
		String expected = "e:AAAZAaAzA9";
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
		float[] val = new float[]{0.49f,25.49f,26.49f,51.49f,61.49f};
		String actual = encoder.encode(val);
		String expected = "e:AAAZAaAzA9";
		assertEquals(expected, actual);
	}

	@Test
	public void testEncodeIntegerCollectionListOfint() {
		int[] valOne = new int[]{0,25,26,51,61};
		int[] valTwo = new int[]{0,25,26,51,61};
		ArrayList<int[]> values = new ArrayList<int[]>(2);
		values.add(valOne);
		values.add(valTwo);
		String actual = encoder.encodeIntegerCollection(values);
		String expected = "e:AAAZAaAzA9|AAAZAaAzA9";		
		assertEquals(expected, actual);	
	}

	@Test
	public void testEncodeIntegerCollectionListOfintString() {
		int[] valOne = new int[]{0,25,26,51,61};
		int[] valTwo = new int[]{0,25,26,51,61};
		ArrayList<int[]> values = new ArrayList<int[]>(2);
		values.add(valOne);
		values.add(valTwo);
		String actual = encoder.encodeIntegerCollection(values,",");
		String expected = "e:AAAZAaAzA9,AAAZAaAzA9";		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testEncodeFloatCollectionListOffloat() {
		float[] valOne = new float[]{0.49f,25.49f,26.49f,51.49f,61.49f};
		float[] valTwo = new float[]{0f,25f,26f,51f,61f};
		ArrayList<float[]> values = new ArrayList<float[]>(2);
		values.add(valOne);
		values.add(valTwo);
		String actual = encoder.encodeFloatCollection(values);
		String expected = "e:AAAZAaAzA9|AAAZAaAzA9";		
		assertEquals(expected, actual);
	}

	@Test
	public void testEncodeFloatCollectionListOffloatString() {
		float[] valOne = new float[]{0.49f,25.49f,26.49f,51.49f,61.49f};
		float[] valTwo = new float[]{0f,25f,26f,51f,61f};
		ArrayList<float[]> values = new ArrayList<float[]>(2);
		values.add(valOne);
		values.add(valTwo);
		String actual = encoder.encodeFloatCollection(values,",");
		String expected = "e:AAAZAaAzA9,AAAZAaAzA9";		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBasicChars(){
		int val[] = {0,1,2,3,4,5,6,7,8,9,10};
		String actual = encoder.encode(val);
		String expected = "e:AA" + //0
				"AB" + //1
				"AC" + //2
				"AD" + //3
				"AE" + //4
				"AF" + //5
				"AG" + //6
				"AH" + //7
				"AI" + //8
				"AJ" + //9
				"AK"; //10
		assertEquals(expected, actual);
	}
	
	public void testGoogleExampeChars(){
		int val[] = {0,25,26,51,52,61,62,63,64,89,90, 115, 116, 125, 126, 127, 
				4032, 4057, 4058, 4083, 4084, 4093, 4094, 4095};
		//		AA = 0, AZ = 25, Aa = 26, Az = 51, A0 = 52, A9 = 61, A- = 62, A. = 63
		//BA = 64, BZ = 89, Ba = 90, Bz = 115, B0 = 116, B9 = 125, B- = 126, B. = 127
		//.A = 4032, .Z = 4057, .a = 4058, .z = 4083, .0 = 4084, .9 = 4093, .- = 4094, 
		//.. = 4095.
		
		String actual = encoder.encode(val);
		String expected = "e:AAAZAaAzA0A9A-A.BABZBaBzB0B9B-B..A.Z.a.z.0.9.-..";
		assertEquals(expected, actual);
	}

}
