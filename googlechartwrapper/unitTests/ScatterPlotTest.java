package unitTests;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;

import googlechartwrapper.ScatterPlot;
import googlechartwrapper.color.LinearStripes;
import googlechartwrapper.color.LinearStripes.LinearStripesDestination;
import googlechartwrapper.data.ScatterPlotData;
import googlechartwrapper.label.ChartTitle;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author steffan
 *
 */
public class ScatterPlotTest {
	
	@Test
	public void example(){
		
		ScatterPlot s = new ScatterPlot(new Dimension(300,300));
		
		s.setChartTitle(new ChartTitle("dasdads",Color.GRAY,12));
		
		s.setLinearStripes(new LinearStripes(LinearStripesDestination.Background,40,Color.BLUE,0.5f,Color.GREEN,1.0f));
		
		Collection<Point> p = new ArrayList<Point>();
		
		p.add(new Point(5,5));
		p.add(new Point(15,45));
		
		

		
		
		s.setScatterPlotData(new ScatterPlotData(p));
		
		//System.out.println(s.getUrl());
		
		String target = "http://chart.apis.google.com/chart?chs=300x300&cht=qr&chl=Hello World&choe=UTF-8";
		
		Assert.assertEquals(" ", " ");
		
	}

}
