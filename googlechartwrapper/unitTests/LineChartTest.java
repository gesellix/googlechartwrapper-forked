package unitTests;

import googlechartwrapper.LineChart;
import googlechartwrapper.data.LineChartData;
import googlechartwrapper.label.ChartLegend;
import googlechartwrapper.label.ChartTitle;
import googlechartwrapper.label.ChartLegend.ChartLegendPosition;
import googlechartwrapper.style.FinancialMarker;
import googlechartwrapper.style.LineStyle;
import googlechartwrapper.style.ShapeMarker;
import googlechartwrapper.style.FinancialMarker.Priority;
import googlechartwrapper.style.ShapeMarker.MarkerTyp;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Arrays;

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
		
		LineChart l = new LineChart(new Dimension(300,300));
		l.setChartTitle(new ChartTitle("linechart"));
		
		l.addLineChartData(new LineChartData.LineChartDataBuilder(Arrays.asList(20,30,40)).build());
		
		l.addLineChartData(new LineChartData.LineChartDataBuilder(Arrays.asList(40,50,60)).build());
		
		l.addLineChartData(new LineChartData.LineChartDataBuilder(Arrays.asList(60,40,30)).build());
		
		l.addLineChartData(new LineChartData.LineChartDataBuilder(Arrays.asList(40,30,10)).build());
	
		//l.addShapeMarker(new ShapeMarker(MarkerTyp.Square,Color.black,1,ShapeMarker.DataPoint.drawEachPoint(),20));
		
		l.addFinancialMarker(new FinancialMarker(0,FinancialMarker.DataPoint.newDrawEachPoint(),20,Priority.First));
		
		System.out.println(l.getUrl());
		
		String target = "http://chart.apis.google.com/chart?cht=s&chs=300x300&chd=e:H0O2ISK8H0,DIO2GkNSH0&chg=30.0,15.0,12.0,12.0,25.0,25.0&chtt=Simple ScatterPlot&chts=808080,12";
		
		//Assert.assertEquals(target, l.getUrl());
		
	}
	@Test
	public void example2(){
		
		LineChart l = new LineChart(new Dimension(300,300));
		l.setChartTitle(new ChartTitle("linechart"));
		
		l.addLineChartData(new LineChartData.LineChartDataBuilder(Arrays.asList(20,30,40)).build());
		
		l.setSparkline();
		
		System.out.println(l.isLineChart());
		System.out.println(l.isSparkline());
		
		System.out.println(l.getUrl());
		
		String target = "http://chart.apis.google.com/chart?cht=s&chs=300x300&chd=e:H0O2ISK8H0,DIO2GkNSH0&chg=30.0,15.0,12.0,12.0,25.0,25.0&chtt=Simple ScatterPlot&chts=808080,12";
		
		//Assert.assertEquals(target, l.getUrl());
		
	}
	@Test
	public void example3(){
		
		LineChart l = new LineChart(new Dimension(300,300));
		l.setChartTitle(new ChartTitle("linechart"));
		
		l.addLineChartData(new LineChartData.LineChartDataBuilder(Arrays.asList(20,30,40)).build());
		l.addLineChartData(new LineChartData.LineChartDataBuilder(Arrays.asList(10,20,30)).color(Color.RED).build());
		//l.addLineChartData(new LineChartData.LineChartDataBuilder(Arrays.asList(1,30,10)).lineStyle(new LineStyle(2.5f,1.0f,2.0f)).legend(new ChartLegend("tata",ChartLegendPosition.Top_Horizontal)).build());
		
		l.setChartLegend(new ChartLegend("blaa",ChartLegendPosition.Top_Horizontal));
		
		System.out.println("tatat   "+l.getUrl());
		
	}
}

