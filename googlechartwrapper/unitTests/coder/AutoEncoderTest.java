package unitTests.coder;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;


import org.junit.Before;
import org.junit.Test;

import de.toolforge.googlechartwrapper.coder.AutoEncoder;

public class AutoEncoderTest {
	
	private AutoEncoder encoder;

	@Before
	public void setUp() throws Exception {
		encoder = new AutoEncoder();
	}
	
	@Test
	public void testEncodeIntArraySimple(){
		int[] val = new int[]{0,19,27,53,61};
		String actual = encoder.encode(val);
		String expected = "s:ATb19";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testEncodeIntArrayExtended(){
		int[] val = new int[]{0,25,26,51,61,63};
		String actual = encoder.encode(val);
		String expected = "e:AAAZAaAzA9A.";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testEncodeFloatArraySimple(){
		float[] val = new float[]{0f,19f,27f,53f,61f};
		String actual = encoder.encode(val);
		String expected = "s:ATb19";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testEncodeFloatArrayExtended(){
		float[] val = new float[]{0f,25f,26f,51f,61f,63f};
		String actual = encoder.encode(val);
		String expected = "e:AAAZAaAzA9A.";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testEncodeIntArraySimpleTwoSets(){
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
	public void testEncodeIntArrayExtendedTwoSets(){
		int[] valOne = new int[]{0,25,26,51,61,63};
		int[] valTwo = new int[]{0,25,26,51,61,63};
		ArrayList<int[]> values = new ArrayList<int[]>(2);
		values.add(valOne);
		values.add(valTwo);
		String actual = encoder.encodeIntegerCollection(values);
		String expected = "e:AAAZAaAzA9A.,AAAZAaAzA9A.";		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testEncodeIntArrayExtendedTwoSetsSpecial1 (){
		int[] valOne = new int[]{0,25,26,51,61}; //Set 1 -> needs min Simple
		int[] valTwo = new int[]{0,25,26,51,61,63}; //Set 2 -> needs min Extended
		ArrayList<int[]> values = new ArrayList<int[]>(2);
		values.add(valOne);
		values.add(valTwo);
		String actual = encoder.encodeIntegerCollection(values);
		String expected = "e:AAAZAaAzA9,AAAZAaAzA9A."; //max(Simple,Extended) -> Extended
		assertEquals(expected, actual);
	}
	
	@Test
	public void testEncodeIntArrayExtendedTwoSetsSpecial2 (){
		int[] valOne = new int[]{0,25,26,51,61, 63}; //Set 1 -> needs min Extended
		int[] valTwo = new int[]{0,25,26,51,61 }; //Set 2 -> needs min Simple
		ArrayList<int[]> values = new ArrayList<int[]>(2);
		values.add(valOne);
		values.add(valTwo);
		String actual = encoder.encodeIntegerCollection(values);
		String expected = "e:AAAZAaAzA9A.,AAAZAaAzA9"; //max(Simple,Extended) -> Extended
		assertEquals(expected, actual);
	}

}
