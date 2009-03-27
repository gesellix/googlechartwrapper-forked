package unitTests;

import googlechartwrapper.LineChart;
import googlechartwrapper.XYLineChart;
import googlechartwrapper.coder.EncoderFactory;
import googlechartwrapper.coder.EncodingType;
import googlechartwrapper.color.FillArea;
import googlechartwrapper.color.FillArea.DataSetKind;
import googlechartwrapper.data.LineChartData;
import googlechartwrapper.data.XYLineChartData;
import googlechartwrapper.label.ChartLegend;
import googlechartwrapper.label.ChartTitle;
import googlechartwrapper.label.DataPointLabel;
import googlechartwrapper.style.FinancialMarker;
import googlechartwrapper.style.LineStyle;
import googlechartwrapper.style.ShapeMarker;
import googlechartwrapper.style.FinancialMarker.Priority;
import googlechartwrapper.style.ShapeMarker.MarkerTyp;
import googlechartwrapper.util.Pair;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		
		l.addLineChartData(new LineChartData.LineChartDataBuilder(Arrays.asList(20f,30f,40f)).build());
		
		l.addLineChartData(new LineChartData.LineChartDataBuilder(Arrays.asList(40f,50f,60f)).build());
		
		l.addLineChartData(new LineChartData.LineChartDataBuilder(Arrays.asList(60f,40f,30f)).build());
		
		l.addLineChartData(new LineChartData.LineChartDataBuilder(Arrays.asList(40f,30f,10f)).build());
			
		l.addFinancialMarker(new FinancialMarker(0,FinancialMarker.DataPoint.newDrawEachPoint(),20,Priority.First));
				
		String target = "http://chart.apis.google.com/chart?cht=lc&chs=300x300&chd=s:Ueo,oy8,8oe,oeK&chm=F,,0,-1,20,1&chtt=linechart";
		
		Assert.assertEquals(target, l.getUrl());
		
	}	
	@Test
	public void example2(){
		
		XYLineChart chart = new XYLineChart(new Dimension(300,300));
		chart.setChartTitle(new ChartTitle("xyLinceChart"));
		chart.setEncoder(EncoderFactory.getEncoder(EncodingType.TextEncoding));
		Pair<List<Float>, List<Float>> values1 = new Pair<List<Float>, List<Float>>(Arrays.asList(10f,20f,30f),Arrays.asList(34f,12f,89f));
		Pair<List<Float>, List<Float>> values2 = new Pair<List<Float>, List<Float>>(new ArrayList<Float>(),Arrays.asList(25f,25f,25f));
		
		XYLineChartData data = new XYLineChartData.XYLineChartDataBuilder(values1).color(Color.BLACK).build();
		XYLineChartData data2 = new XYLineChartData.XYLineChartDataBuilder(values2).style(new LineStyle(5,2,2)).build();
		List<XYLineChartData> d = new ArrayList<XYLineChartData>();
		d.add(data);
		d.add(data2);
		
		//chart.addXYLineChartData(data);
		chart.addXYLineChartData(d);
		
		System.out.println(chart.getUrl());
		
	}
	@Test
	public void showCase(){
		
		LineChart l = new LineChart(new Dimension(600,350));
		l.setChartTitle(new ChartTitle("Dow Jones 89-09"));
		
		l.addLineChartData(new LineChartData.LineChartDataBuilder(Arrays.asList(2.168f,2.753f,2.633f,3.168f,3.301f,3.754f,3.834f,5.117f,6.448f,7.908f,9.181f,11.497f,10.787f,10.021f,8.341f,10.453f,10.783f,10.717f,12.463f,13.264f,8.776f)).legend(new ChartLegend("Dow Jones")).lineStyle(new LineStyle(5f,0f,0f)).build());
		//l.addLineChartData(new LineChartData.LineChartDataBuilder(Arrays.asList(10f,20f,30f)).color(Color.RED).build());
		//l.addLineChartData(new LineChartData.LineChartDataBuilder(Arrays.asList(1f,30f,10f)).lineStyle(new LineStyle(2.5f,1.0f,2.0f)).legend(new ChartLegend("tata",ChartLegendPosition.Top_Horizontal)).build());
		l.addShapeMarker(new ShapeMarker(MarkerTyp.Diamond,Color.BLUE,0,ShapeMarker.DataPoint.newDrawEachPoint(),10));
		//l.addSolidFill(new SolidFill(ChartFillDestination.Background,Color.BLACK));
		//l.addSolidFill(new SolidFill(ChartFillDestination.ChartArea,Color.LIGHT_GRAY));
		l.addFillArea(new FillArea(DataSetKind.Multi,Color.RED,0,0));
		/*
		AxisLabelContainer c = new AxisLabelContainer(AxisType.XAxis);	
		c.setAxisRange(new AxisRange(0,100));
		c.addLabel(new AxisLabel("text"));
		c.addLabel(new AxisLabel("text2"));
		c.addLabel(new AxisLabel("text3"));
		c.addLabel(new AxisLabel("text4"));
		l.addAxisLabelContainer(c);
		*/
		l.addDataPointLabel(new DataPointLabel(new DataPointLabel.FloatingPointNumberBuilder(4).build(),Color.BLACK,0,DataPointLabel.DataPoint.newDrawNPoint(5),10,googlechartwrapper.label.DataPointLabel.Priority.First));
		
		//System.out.println(l.getUrl());
		
	}
}

