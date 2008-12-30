package unitTests;

import googlechartwrapper.ScatterPlot;
import googlechartwrapper.color.LinearGradient;
import googlechartwrapper.color.SolidFill;
import googlechartwrapper.color.LinearGradient.GradientFillDestination;
import googlechartwrapper.color.SolidFill.ChartFillDestination;
import googlechartwrapper.data.DataScalingSet;
import googlechartwrapper.data.ScatterPlotData;
import googlechartwrapper.data.ScatterPlotPoint;
import googlechartwrapper.label.ChartLegend;
import googlechartwrapper.label.ChartTitle;

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
		
		s.setChartTitle(new ChartTitle("Simple ScatterPlot",Color.GRAY,12));
		
		List<ScatterPlotPoint> p = new ArrayList<ScatterPlotPoint>();
		
		p.add(new ScatterPlotPoint(500,200));
		p.add(new ScatterPlotPoint(950,950));
		p.add(new ScatterPlotPoint(530,420));
		p.add(new ScatterPlotPoint(700,850));
		p.add(new ScatterPlotPoint(500,500));
					
		
		s.setScatterPlotData(new ScatterPlotData(p));		
		
		
		String target = "http://chart.apis.google.com/chart?cht=s&chs=300x300&chd=e:H0O2ISK8H0,DIO2GkNSH0&chtt=Simple ScatterPlot&chts=808080,12";
		
		Assert.assertEquals(target, s.getUrl());
		
	}
	@Test
	public void example2(){
		
		ScatterPlot plot = new ScatterPlot(new Dimension(600,450));
		
		plot.setChartTitle(new ChartTitle("ScatterPlot",Color.WHITE,12));
		
		
		DataScalingSet ds = new DataScalingSet(0,200);			
		
						
		List<ScatterPlotPoint> p = new ArrayList<ScatterPlotPoint>();
		
		p.add(new ScatterPlotPoint(100,100));
		p.add(new ScatterPlotPoint(200,200,100));
		p.add(new ScatterPlotPoint(100,200,3000));
		p.add(new ScatterPlotPoint(150,50,240));
		p.add(new ScatterPlotPoint(140,50,230));
		p.add(new ScatterPlotPoint(130,50,220));
		p.add(new ScatterPlotPoint(120,50,210));
		p.add(new ScatterPlotPoint(110,50,200));
		
		
		plot.addDataScalingSet(ds);
		
		plot.setScatterPlotData(new ScatterPlotData(p));	
		
		ArrayList<String> legends = new ArrayList<String>();
		legends.add("first");
		legends.add("second");
		
		plot.setChartLegend(new ChartLegend(legends));
		
		plot.addSolidFill(new SolidFill(ChartFillDestination.Background,Color.BLACK));
		plot.setLinearGradient(new LinearGradient(GradientFillDestination.ChartArea,12,Color.BLUE,0.1f,Color.ORANGE,0.7f));
			
			
		String target = "http://chart.apis.google.com/chart?cht=s&chs=600x450&chd=t:100,200,100,150,140,130,120,110|100,200,200,50,50,50,50,50|200,100,3000,240,230,220,210,200&chdl=first|second&chds=0.0,200.0&chf=c,lg,12,0000ff,0.1,ffc800,0.7|bg,s,000000&chtt=ScatterPlot&chts=ffffff,12";
		
		Assert.assertEquals(target, plot.getUrl());
	}	

}
