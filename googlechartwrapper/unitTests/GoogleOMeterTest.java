package unitTests;

import static org.junit.Assert.*;

import java.awt.Dimension;

import googlechartwrapper.GoogleOMeter;
import googlechartwrapper.data.DataScalingSet;
import googlechartwrapper.data.GoogleOMeterValue;

import org.junit.Test;

public class GoogleOMeterTest {

	@Test
	public void testSimpleExample (){		
		GoogleOMeter meter = new GoogleOMeter(new Dimension(225,125));
		meter.addGoogleOMeterValue(new GoogleOMeterValue("Hello",70));
		
		String actual = meter.getUrl();
		String expected = "http://chart.apis.google.com/chart?cht=gom&chs=225x125" +
				"&chd=t:70.0&chl=Hello";
	
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDataScalingExample (){
		GoogleOMeter meter = new GoogleOMeter(new Dimension(225,125));
		
		meter.addGoogleOMeterValue(new GoogleOMeterValue("Hello",225));
		meter.addGoogleOMeterValue(new GoogleOMeterValue("Hello Nr 2",370));
		
		meter.setDataScaling(new DataScalingSet(200,400));
		
		String actual = meter.getUrl();
		String expected = "http://chart.apis.google.com/chart?cht=gom&chs=225x125&" +
				"chds=200.0,400.0&chd=t:225.0,370.0&chl=Hello|Hello Nr 2";
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testNoLabels (){
		GoogleOMeter meter = new GoogleOMeter(new Dimension(225,125));
		meter.addGoogleOMeterValue(new GoogleOMeterValue(null,25));
		meter.addGoogleOMeterValue(new GoogleOMeterValue(null,55));
		
		String actual = meter.getUrl();
		String expected = "http://chart.apis.google.com/chart?cht=gom&chs=225x125" +
				"&chd=t:25.0,55.0";
	
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSomeLabelsEmpty (){
		GoogleOMeter meter = new GoogleOMeter(new Dimension(225,125));
		meter.addGoogleOMeterValue(new GoogleOMeterValue(null,25));
		meter.addGoogleOMeterValue(new GoogleOMeterValue("label filled",55));
		meter.addGoogleOMeterValue(new GoogleOMeterValue("label filled 2",70));
		meter.addGoogleOMeterValue(new GoogleOMeterValue(null,85));
		
		String actual = meter.getUrl();
		String expected = "http://chart.apis.google.com/chart?cht=gom&chs=225x125" +
				"&chd=t:25.0,55.0,70.0,85.0&chl=|label filled|label filled 2|";
	
		assertEquals(expected, actual);
	}
	
}
