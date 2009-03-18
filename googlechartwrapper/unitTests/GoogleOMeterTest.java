package unitTests;

import static org.junit.Assert.assertEquals;
import googlechartwrapper.GoogleOMeter;
import googlechartwrapper.color.ChartColor;
import googlechartwrapper.color.LinearGradient;
import googlechartwrapper.color.LinearStripe;
import googlechartwrapper.color.LinearGradient.GradientFillDestination;
import googlechartwrapper.color.LinearStripe.LinearStripesDestination;
import googlechartwrapper.data.DataScalingSet;
import googlechartwrapper.data.GoogleOMeterValue;
import googlechartwrapper.label.ChartLegend;
import googlechartwrapper.label.ChartTitle;
import googlechartwrapper.label.ChartLegend.ChartLegendPosition;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Arrays;

import org.junit.Test;

public class GoogleOMeterTest {

	@Test
	public void testSimpleExample() {
		GoogleOMeter meter = new GoogleOMeter(new Dimension(225, 125));
		meter.addGoogleOMeterValue(new GoogleOMeterValue("Hello", 70));

		System.out.println(meter.getUrl());
		String actual = meter.getUrl();
		String expected = "http://chart.apis.google.com/chart?cht=gom&chs=225x125"
				+ "&chd=t:70.0&chl=Hello";

		assertEquals(expected, actual);
	}

	@Test
	public void testDataScalingExample() {
		GoogleOMeter meter = new GoogleOMeter(new Dimension(225, 125));

		meter.addGoogleOMeterValue(new GoogleOMeterValue("Hello", 225));
		meter.addGoogleOMeterValue(new GoogleOMeterValue("Hello Nr 2", 370));

		meter.setDataScaling(new DataScalingSet(200, 400));

		String actual = meter.getUrl();
		String expected = "http://chart.apis.google.com/chart?cht=gom&chs=225x125&chd=t:225.0,370.0&chds=200.0,400.0&chl=Hello|Hello Nr 2";

		assertEquals(expected, actual);
	}

	@Test
	public void example1() {

		GoogleOMeter meter = new GoogleOMeter(new Dimension(225, 125));
		meter.setChartTitle(new ChartTitle("title"));

		meter.setLinearStripes(new LinearStripe(
				LinearStripesDestination.Background, 45, Color.BLUE, 0.1f,
				Color.GRAY, 0.3f));
		meter.addGoogleOMeterValue(new GoogleOMeterValue("Hello", 70));
		meter.setDataScaling(new DataScalingSet(10d, 110d));

		String actual = meter.getUrl();
		String expected = "http://chart.apis.google.com/chart?cht=gom&chs=225x125&chd=t:70.0&chds=10.0,110.0&chf=bg,ls,45,0000ff,0.1,808080,0.3&chl=Hello&chtt=title";

		assertEquals(expected, actual);

	}

	@Test
	public void example2() {

		GoogleOMeter meter = new GoogleOMeter(new Dimension(225, 125));
		meter.setChartTitle(new ChartTitle("title"));

		meter.setLinearGradient(new LinearGradient(
				GradientFillDestination.Background, 45, Color.BLACK, 0.1f,
				Color.RED, 0.7f));

		meter.addGoogleOMeterValue(new GoogleOMeterValue("Hello", 50));
		meter.setDataScaling(new DataScalingSet(10d, 110d));

		String actual = meter.getUrl();
		String expected = "http://chart.apis.google.com/chart?cht=gom&chs=225x125&chd=t:50.0&chds=10.0,110.0&chf=bg,lg,45,000000,0.1,ff0000,0.7&chl=Hello&chtt=title";

		assertEquals(expected, actual);
	}
	@Test
	public void example3(){
		
		//TODO check ChartLenendPosition
		GoogleOMeter meter = new GoogleOMeter(new Dimension(200,200));
		
		meter.addGoogleOMeterValue(new GoogleOMeterValue("first", 20));
		meter.addGoogleOMeterValue(new GoogleOMeterValue("second", 80));
		
		meter.setChartLegend(new ChartLegend(Arrays.asList("first","second"),ChartLegendPosition.Left_Vertival));
		meter.addChartColor(new ChartColor(Color.GRAY));
		meter.addChartColor(new ChartColor(Color.RED));
		
		meter.addGoogleOMeterValue(new GoogleOMeterValue("first",20));
		meter.addGoogleOMeterValue(new GoogleOMeterValue("second",80));
		
		//System.out.println(meter.getUrl());
		
	}

}
