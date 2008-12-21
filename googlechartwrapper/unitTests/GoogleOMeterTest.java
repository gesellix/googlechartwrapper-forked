package unitTests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Dimension;

import googlechartwrapper.GoogleOMeter;
import googlechartwrapper.color.LinearGradient;
import googlechartwrapper.color.LinearStripes;
import googlechartwrapper.color.SolidFill;
import googlechartwrapper.color.LinearGradient.GradientFillDestination;
import googlechartwrapper.color.LinearStripes.LinearStripesDestination;
import googlechartwrapper.color.SolidFill.ChartFillDestination;
import googlechartwrapper.data.DataScalingSet;
import googlechartwrapper.data.GoogleOMeterValue;
import googlechartwrapper.label.ChartTitle;

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
		String expected = "http://chart.apis.google.com/chart?cht=gom&chs=225x125&chd=t:225.0,370.0&chl=Hello|Hello Nr 2&chds=200.0,400.0";
		
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
	
	@Test
	public void example1(){
		
		GoogleOMeter meter = new GoogleOMeter(new Dimension(225,125));
		meter.setChartTitle(new ChartTitle("title"));		
		
		meter.setLinearStripes(new LinearStripes(LinearStripesDestination.Background,45,Color.BLUE,0.1f,Color.GRAY,0.3f));
		meter.addGoogleOMeterValue(new GoogleOMeterValue("Hello",70));		
		meter.setDataScaling(new DataScalingSet(10d,110d));
		
		
		String actual = meter.getUrl();
		String expected = "http://chart.apis.google.com/chart?cht=gom&chs=225x125&chd=t:70.0&chl=Hello&chds=10.0,110.0&chf=bg,ls,45,0000ff,0.1,808080,0.3&chtt=title";

	
		assertEquals(expected, actual);
		
		
	}
	@Test
	public void example2(){
		
		GoogleOMeter meter = new GoogleOMeter(new Dimension(225,125));
		meter.setChartTitle(new ChartTitle("title"));
		
		meter.setLinearGradient(new LinearGradient(GradientFillDestination.Background,45,Color.BLACK,0.1f,Color.RED,0.7f));
		
		meter.addGoogleOMeterValue(new GoogleOMeterValue("Hello",50));		
		meter.setDataScaling(new DataScalingSet(10d,110d));
				
		String actual = meter.getUrl();
		String expected = "http://chart.apis.google.com/chart?cht=gom&chs=225x125&chd=t:50.0&chl=Hello&chds=10.0,110.0&chf=bg,lg,45,000000,0.1,ff0000,0.7&chtt=title";
	
		assertEquals(expected, actual);
		
		
	}
	
}
