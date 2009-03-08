/**
 * 
 */
package unitTests;

import java.awt.Color;
import java.awt.Dimension;

import googlechartwrapper.BarChart;
import googlechartwrapper.BarChart.BarChartOrientation;
import googlechartwrapper.BarChart.BarChartStyle;
import googlechartwrapper.color.ChartColor;
import googlechartwrapper.label.ChartTitle;
import googlechartwrapper.label.DataPointLabel;
import googlechartwrapper.label.DataPointLabel.FloatingPointNumberBuilder;
import googlechartwrapper.label.DataPointLabel.Priority;
import googlechartwrapper.style.BarWidthAndSpacing;

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
		bc.addChartColor(new ChartColor(Color.BLACK));
		bc.addChartColor(new ChartColor(Color.GREEN));
		//bc.addChartColor(new ChartColors(Color.BLUE));
		
		bc.setBarWidthAndSpacing(BarWidthAndSpacing.newRelativeResize(0.5f,0.1f));
		
		bc.addDataPointLabel(new DataPointLabel(new FloatingPointNumberBuilder(1).textBefore("x").build(),Color.BLACK,1,null,20,Priority.First));
		System.out.println(bc.getUrl());
		
	}

}
