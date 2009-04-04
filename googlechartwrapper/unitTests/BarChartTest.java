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
<<<<<<< .mine
import googlechartwrapper.label.AxisLabel;
import googlechartwrapper.label.AxisLabelContainer;
import googlechartwrapper.label.AxisRange;
import googlechartwrapper.label.AxisType;
=======
import googlechartwrapper.label.AxisLabel;
import googlechartwrapper.label.AxisLabelContainer;
import googlechartwrapper.label.AxisRange;
import googlechartwrapper.label.AxisType;
import googlechartwrapper.label.ChartLegend;
>>>>>>> .r129
import googlechartwrapper.label.ChartTitle;
import googlechartwrapper.style.BarWidthAndSpacing;
import googlechartwrapper.style.LineAndBarChartLineStyle;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author steffan
 * @author martin
 *
 */
public class BarChartTest {
	
	@Test
	public void showCase(){
		
		BarChart bc = new BarChart(new Dimension(300,300),BarChartOrientation.Horizontal,BarChartStyle.Grouped);
		bc.setChartTitle(new ChartTitle("Heights of Black Cherry trees"));
		
		bc.setEncoder(EncoderFactory.getEncoder(EncodingType.TextEncoding));
		BarChartDataSerie s = new BarChartDataSerie.BarChartDataSerieBuilder(Arrays.asList(24,24,64,80,40,16)).color(Color.ORANGE).build();
		bc.addBarChartDataSerie(s);
				
		bc.addLineAndBarChartLineStyle(new LineAndBarChartLineStyle(new Color(255,122,89),0,LineAndBarChartLineStyle.DataPoint.newDrawEachPoint(),5));
		
		AxisLabelContainer x = new AxisLabelContainer(AxisType.XAxis); 
        x.setAxisRange(new AxisRange(60,90,5)); 
        bc.addAxisLabelContainer(x);
        
        AxisLabelContainer y = new AxisLabelContainer(AxisType.YAxis); 
        y.setAxisRange(new AxisRange(0,10,2)); 
        bc.addAxisLabelContainer(y);
        
        AxisLabelContainer xl  = new AxisLabelContainer(AxisType.XAxis);  
        AxisLabel label = new AxisLabel("Height (feet)"); 
        label.setPos(50); 
        xl.setUseLabelPositions(true); 
        xl.addLabel(label); 
        bc.addAxisLabelContainer(xl);
        
        AxisLabelContainer yl  = new AxisLabelContainer(AxisType.YAxis);  
        AxisLabel label2 = new AxisLabel("Frequency"); 
        label2.setPos(50); 
        yl.setUseLabelPositions(true); 
        yl.addLabel(label2); 
        bc.addAxisLabelContainer(yl);
		
		
		bc.setBarWidthAndSpacing(BarWidthAndSpacing.newAutomaticallyResize());
				
		String target = "http://chart.apis.google.com/chart?cht=bvg&chs=300x300&chbh=a&chco=ffc800&chd=t:24,24,64,80,40,16&chm=D,ff7a59,0,0,5&chtt=Heights+of+Black+Cherry+trees&chxl=2:|Height (feet)|3:|Frequency&chxp=2,50|3,50&chxr=0,60,90,5|1,0,10,2&chxt=x,y,x,y";
		
		Assert.assertEquals(target, bc.getUrl());
		
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
