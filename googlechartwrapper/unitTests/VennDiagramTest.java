package unitTests;

import googlechartwrapper.VennDiagram;
import googlechartwrapper.color.ChartColors;
import googlechartwrapper.color.LinearGradient;
import googlechartwrapper.color.LinearStripes;
import googlechartwrapper.color.LinearGradient.GradientFillDestination;
import googlechartwrapper.color.LinearStripes.LinearStripesDestination;
import googlechartwrapper.data.DataScalingSet;
import googlechartwrapper.data.VennDiagramData;
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
public class VennDiagramTest {

	@Test
	public void example1() {

		VennDiagram diagram = new VennDiagram(new Dimension(200, 200));

		diagram.setChartTitle(new ChartTitle("VennDiagramm"));

		diagram.setVennDiagramData(new VennDiagramData(100, 80, 60, 30, 30, 30,
				10));

		diagram.addChartColor(new ChartColors(Color.GREEN));
		diagram.addChartColor(new ChartColors(Color.BLUE));
		diagram.addChartColor(new ChartColors(Color.RED));
		
		List<String> l = new ArrayList<String>();
		l.add("A");
		l.add("C");
		l.add("V");

		diagram.setChartLegend(new ChartLegend(l));
		
		String target = "http://chart.apis.google.com/chart?cht=v&chs=200x200&chdl=A|C|V&chtt=VennDiagramm&chd=e:BkBQA8AeAeAeAK&chco=00ff00,0000ff,ff0000";
		
		Assert.assertEquals(target, diagram.getUrl());
	}
	
	@Test
	public void example2() {
		
		VennDiagram diagram = new VennDiagram(new Dimension(200, 200));

		diagram.setChartTitle(new ChartTitle("VennDiagramm"));

		diagram.setVennDiagramData(new VennDiagramData(100, 80, 60, 30, 30, 30,
				10));

		diagram.addChartColor(new ChartColors(Color.GREEN));
		diagram.addChartColor(new ChartColors(Color.BLUE));
		diagram.addChartColor(new ChartColors(Color.RED));

		diagram.setDataScaling(new DataScalingSet(10,50));

		diagram.setLinearGradient(new LinearGradient(
				GradientFillDestination.Background, 10, Color.BLACK, 0.5f,
				Color.RED, 1.0f));

		List<String> l = new ArrayList<String>();
		l.add("A");
		l.add("C");
		l.add("V");
		
		diagram.setChartLegend(new ChartLegend(l));

		//System.out.println(diagram.getUrl());
		String target = "http://chart.apis.google.com/chart?cht=v&chs=200x200&chdl=A|C|V&chf=bg,lg,10,000000,0.5,ff0000,1.0&chtt=VennDiagramm&chds=10.0,50.0&chd=t:100,80,60,30,30,30,1&chco=00ff00,0000ff,ff0000";

		
		Assert.assertEquals(target, diagram.getUrl());
	
	}
	
	@Test
	public void example3() {
		
		VennDiagram diagram = new VennDiagram(new Dimension(200, 200));

		diagram.setChartTitle(new ChartTitle("VennDiagramm"));

		diagram.setVennDiagramData(new VennDiagramData(90, 70, 20, 10, 5, 5,
				10));		

		List<String> l = new ArrayList<String>();
		l.add("A");
		l.add("C");
		l.add("V");

		diagram.setChartLegend(new ChartLegend(l));

		diagram.setLinearStripes(new LinearStripes(
				LinearStripesDestination.Background, 1, Color.CYAN, 0.5f,
				Color.LIGHT_GRAY, 1f));

		//System.out.println(diagram.getUrl());
		String target = "http://chart.apis.google.com/chart?cht=v&chs=200x200&chdl=A|C|V&chf=bg,ls,1,00ffff,0.5,c0c0c0,1.0&chtt=VennDiagramm&chd=e:BaBGAUAKAFAFAK";

		
		Assert.assertEquals(target, diagram.getUrl());
	}
	
	@Test
	public void example4() {
		
		VennDiagram diagram = new VennDiagram(new Dimension(200, 200));

		diagram.setChartTitle(new ChartTitle("VennDiagramm"));

		diagram.setVennDiagramData(new VennDiagramData(90, 70, 20, 10, 5, 5,
				10));
		
		diagram.setDataScaling(new DataScalingSet(10,50));
		
		diagram.setVennDiagramData(new VennDiagramData(100, 80, 60, 30, 30, 30,
				10));
		

		//System.out.println(diagram.getUrl());
		String target = "http://chart.apis.google.com/chart?cht=v&chs=200x200&chtt=VennDiagramm&chds=10.0,50.0&chd=t:100,80,60,30,30,30,1";
		
		Assert.assertEquals(target, diagram.getUrl());
	}

}
