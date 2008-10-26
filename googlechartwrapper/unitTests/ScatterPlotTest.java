package unitTests;

import googlechartwrapper.ScatterPlot;
import googlechartwrapper.data.DataScalingSet;
import googlechartwrapper.data.ScatterPlotData;
import googlechartwrapper.label.ChartTitle;
import googlechartwrapper.style.ShapeMarker;
import googlechartwrapper.style.ShapeMarker.MarkerTyp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

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
		
		s.setChartTitle(new ChartTitle("Titel",Color.GRAY,12));
		
		//s.setLinearStripes(new LinearStripes(LinearStripesDestination.Background,40,Color.BLUE,0.5f,Color.GREEN,1.0f));
		
		List<Point> p = new ArrayList<Point>();
		
		p.add(new Point(500,500));
		p.add(new Point(1500,450));
		
	
		s.addShapeMarker(new ShapeMarker(MarkerTyp.Cross,Color.BLACK,2,0.5f,20));
		
		
		s.setScatterPlotData(new ScatterPlotData(p));		
		
		
		System.out.println(s.getUrl());
		
		String target = "http://chart.apis.google.com/chart?chs=300x300&cht=qr&chl=Hello World&choe=UTF-8";
		
		Assert.assertEquals(" ", " ");
		
	}
	@Test
	public void example2(){
		
		ScatterPlot plot = new ScatterPlot(new Dimension(300,300));
		
		plot.setChartTitle(new ChartTitle("test"));
		
		
		DataScalingSet ds = new DataScalingSet(0.5d,10d);			
		
		//plot.setDataScaling(ds);
		
		List<Point> p = new ArrayList<Point>();
		
		p.add(new Point(500,500));
		p.add(new Point(1500,450));
		
		plot.setScatterPlotData(new ScatterPlotData(p));
		
		plot.addDataScalingSet(ds);
		
		System.out.println(plot.getUrl());
	}

}
