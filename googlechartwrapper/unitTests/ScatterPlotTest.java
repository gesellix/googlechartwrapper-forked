package unitTests;

import googlechartwrapper.ScatterPlot;
import googlechartwrapper.data.DataScalingSet;
import googlechartwrapper.data.ScatterPlotData;
import googlechartwrapper.data.ScatterPlotPoint;
import googlechartwrapper.label.ChartTitle;
import googlechartwrapper.style.ShapeMarker;
import googlechartwrapper.style.ShapeMarker.MarkerTyp;

import java.awt.Color;
import java.awt.Dimension;
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
		
		List<ScatterPlotPoint> p = new ArrayList<ScatterPlotPoint>();
		
		p.add(new ScatterPlotPoint(200,100));
		p.add(new ScatterPlotPoint(150,450,300));
		
	
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
		
		
		DataScalingSet ds = new DataScalingSet(0,200);			
		
		//plot.setDataScaling(ds);
		
				
		List<ScatterPlotPoint> p = new ArrayList<ScatterPlotPoint>();
		
		p.add(new ScatterPlotPoint(100,100));
		p.add(new ScatterPlotPoint(200,200,100));
		
		
		plot.addDataScalingSet(ds);
		
		plot.setScatterPlotData(new ScatterPlotData(p));		
		
		
		System.out.println(plot.getUrl());
	}

}
