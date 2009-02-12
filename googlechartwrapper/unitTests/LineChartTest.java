package unitTests;

import googlechartwrapper.LineChart;
import googlechartwrapper.LineChart.LineChartType;
import googlechartwrapper.label.ChartTitle;

import java.awt.Dimension;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author steffan
 *
 */
public class LineChartTest {

	@Test
	public void example(){
		
		LineChart l = new LineChart(new Dimension(300,300),LineChartType.LineChart);
		l.setChartTitle(new ChartTitle("linechart"));
		
		
		
		System.out.println(l.getUrl());
		
String target = "http://chart.apis.google.com/chart?cht=s&chs=300x300&chd=e:H0O2ISK8H0,DIO2GkNSH0&chg=30.0,15.0,12.0,12.0,25.0,25.0&chtt=Simple ScatterPlot&chts=808080,12";
		
		Assert.assertEquals(target, l.getUrl());
		
	}
}
