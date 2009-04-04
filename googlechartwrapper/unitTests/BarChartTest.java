/**
 * 
 */
package unitTests;

import googlechartwrapper.BarChart;
import googlechartwrapper.BarChart.BarChartOrientation;
import googlechartwrapper.BarChart.BarChartStyle;
import googlechartwrapper.coder.EncoderFactory;
import googlechartwrapper.coder.EncodingType;
import googlechartwrapper.data.BarChartDataSerie;
import googlechartwrapper.label.AxisLabel;
import googlechartwrapper.label.AxisLabelContainer;
import googlechartwrapper.label.AxisRange;
import googlechartwrapper.label.AxisType;
import googlechartwrapper.label.ChartLegend;
import googlechartwrapper.label.ChartTitle;
import googlechartwrapper.label.DataPointLabel;
import googlechartwrapper.label.DataPointLabel.DataPoint;
import googlechartwrapper.label.DataPointLabel.LabelType;
import googlechartwrapper.label.DataPointLabel.Priority;
import googlechartwrapper.style.BarWidthAndSpacing;
import googlechartwrapper.style.LineAndBarChartLineStyle;
import googlechartwrapper.style.ShapeMarker;
import googlechartwrapper.style.ShapeMarker.MarkerTyp;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Arrays;

import org.junit.Test;

/**
 * @author steffan
 *
 */
public class BarChartTest {
	
	@Test
	public void example(){
		
		BarChart bc = new BarChart(new Dimension(300,300),BarChartOrientation.Horizontal,BarChartStyle.Grouped);
		bc.setChartTitle(new ChartTitle("bar chart"));
		
		
		BarChartDataSerie s = new BarChartDataSerie.BarChartDataSerieBuilder(Arrays.asList(10,50,60,80,40)).color(Color.BLACK).legend(new ChartLegend("test")).build();
		bc.addBarChartDataSerie(s);
		bc.addBarChartDataSerie(new BarChartDataSerie.BarChartDataSerieBuilder(Arrays.asList(34,23,56,34,12)).legend(new ChartLegend("2ter")).build());
		
		bc.setBarWidthAndSpacing(BarWidthAndSpacing.newRelativeResize(0.5f,0.1f));
		
		//bc.addDataPointLabel(new DataPointLabel(new DataPointLabel.CurrencyValueNumberBuilder(1,"USD").textBefore("x").build(),Color.BLACK,1,DataPoint.newDrawEachPoint(),20,Priority.First));
		bc.addDataPointLabel(new DataPointLabel(LabelType.PlainText,"hallo",Color.RED,0,DataPoint.newDrawNPoint(2),30,Priority.First));
		
		bc.addShapeMarker(new ShapeMarker(MarkerTyp.Diamond,Color.RED,0,ShapeMarker.DataPoint.newDrawEachPoint(),10));
		bc.addLineAndBarChartLineStyle(new LineAndBarChartLineStyle(Color.BLUE,0,LineAndBarChartLineStyle.DataPoint.newDrawEachPoint(),10));
		
		bc.setEncoder(EncoderFactory.getEncoder(EncodingType.TextEncoding));
		//bc.setAutoResizing(true);
		bc.setBarWidthAndSpacing(BarWidthAndSpacing.newAutomaticallyResize());
		
		System.out.println(bc.getUrl());
		
	}
	
	@Test
	public void test (){
		BarChart bc = new BarChart(new Dimension(300,300),BarChartOrientation.Horizontal,BarChartStyle.Grouped);
		  bc.setChartTitle(new ChartTitle("Heights of Black Cherry trees"));
		  
		  bc.setEncoder(EncoderFactory.getEncoder(EncodingType.TextEncoding));
		  BarChartDataSerie s = new BarChartDataSerie.BarChartDataSerieBuilder(Arrays.asList(24,24,64,80,40,16)).color(Color.BLACK).build();
		  bc.addBarChartDataSerie(s);
		  //bc.addBarChartDataSerie(new BarChartDataSerie.BarChartDataSerieBuilder(Arrays.asList(34,23,56,34,12)).legend(new ChartLegend("2ter")).build());
		  
		  //bc.setBarWidthAndSpacing(BarWidthAndSpacing.newRelativeResize(0.5f,0.1f));
		  
		  //bc.addDataPointLabel(new DataPointLabel(new DataPointLabel.CurrencyValueNumberBuilder(1,"USD").textBefore("x").build(),Color.BLACK,1,DataPoint.newDrawEachPoint(),20,Priority.First));
		  //bc.addDataPointLabel(new DataPointLabel(LabelType.PlainText,"hallo",Color.RED,0,DataPoint.newDrawNPoint(2),30,Priority.First));
		  
		  //bc.addShapeMarker(new ShapeMarker(MarkerTyp.Diamond,Color.RED,0,ShapeMarker.DataPoint.newDrawEachPoint(),10));
		  bc.addLineAndBarChartLineStyle(new LineAndBarChartLineStyle(Color.BLUE,0,LineAndBarChartLineStyle.DataPoint.newDrawEachPoint(),10));
		  
		  AxisLabelContainer c = new AxisLabelContainer(AxisType.XAxis); 
		  c.setAxisRange(new AxisRange(60,90,5)); 
		  bc.addAxisLabelContainer(c);
		  
		  c = new AxisLabelContainer(AxisType.XAxis); 
		  AxisLabel label = new AxisLabel("Height (feet)");
		  label.setPos(50);
		  c.setUseLabelPositions(true); //important for centered label
		  c.addLabel(label);
		  bc.addAxisLabelContainer(c);
		  
		  //bc.setAutoResizing(true);
		  bc.setBarWidthAndSpacing(BarWidthAndSpacing.newAutomaticallyResize());
		  
		  System.out.println(bc.getUrl());
	}

}
