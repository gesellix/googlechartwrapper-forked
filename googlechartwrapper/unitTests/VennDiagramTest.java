package unitTests;


import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import de.toolforge.googlechartwrapper.VennDiagram;
import de.toolforge.googlechartwrapper.color.ChartColor;
import de.toolforge.googlechartwrapper.color.LinearGradient;
import de.toolforge.googlechartwrapper.color.LinearStripe;
import de.toolforge.googlechartwrapper.color.LinearGradient.GradientFillDestination;
import de.toolforge.googlechartwrapper.color.LinearStripe.LinearStripesDestination;
import de.toolforge.googlechartwrapper.data.DataScalingSet;
import de.toolforge.googlechartwrapper.data.VennDiagramData;
import de.toolforge.googlechartwrapper.label.ChartLegend;
import de.toolforge.googlechartwrapper.label.ChartTitle;

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

		diagram.addChartColor(new ChartColor(Color.GREEN));
		diagram.addChartColor(new ChartColor(Color.BLUE));
		diagram.addChartColor(new ChartColor(Color.RED));
		
		List<String> l = new ArrayList<String>();
		l.add("A");
		l.add("C");
		l.add("V");

		diagram.setChartLegend(new ChartLegend(l));
		
		String target = "http://chart.apis.google.com/chart?cht=v&chs=200x200&chco=00ff00,0000ff,ff0000&chd=e:BkBQA8AeAeAeAK&chdl=A|C|V&chdlp=r&chtt=VennDiagramm";
		
		Assert.assertEquals(target, diagram.getUrl());
	}
	
	@Test
	public void example2() {
		
		VennDiagram diagram = new VennDiagram(new Dimension(200, 200));

		diagram.setChartTitle(new ChartTitle("VennDiagramm"));

		diagram.setVennDiagramData(new VennDiagramData(100, 80, 60, 30, 30, 30,
				10));

		diagram.addChartColor(new ChartColor(Color.GREEN));
		diagram.addChartColor(new ChartColor(Color.BLUE));
		diagram.addChartColor(new ChartColor(Color.RED));

		diagram.setDataScaling(new DataScalingSet(10,50));

		diagram.setLinearGradient(new LinearGradient(
				GradientFillDestination.Background, 10, Color.BLACK, 0.5f,
				Color.RED, 1.0f));

		List<String> l = new ArrayList<String>();
		l.add("A");
		l.add("C");
		l.add("V");
		
		diagram.setChartLegend(new ChartLegend(l));
		
		String target = "http://chart.apis.google.com/chart?cht=v&chs=200x200&chco=00ff00,0000ff,ff0000&chd=t:100,80,60,30,30,30,10&chdl=A|C|V&chdlp=r&chds=10.0,50.0&chf=bg,lg,10,000000,0.5,ff0000,1.0&chtt=VennDiagramm";

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

		diagram.setLinearStripes(new LinearStripe(
				LinearStripesDestination.Background, 1, Color.CYAN, 0.5f,
				Color.LIGHT_GRAY, 1f));
		
		String target = "http://chart.apis.google.com/chart?cht=v&chs=200x200&chd=e:BaBGAUAKAFAFAK&chdl=A|C|V&chdlp=r&chf=bg,ls,1,00ffff,0.5,c0c0c0,1.0&chtt=VennDiagramm";
		
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
				
		String target = "http://chart.apis.google.com/chart?cht=v&chs=200x200&chd=t:100,80,60,30,30,30,10&chds=10.0,50.0&chtt=VennDiagramm";
		
		Assert.assertEquals(target, diagram.getUrl());
				
	}
	@Test
	public void showCase(){
		
		VennDiagram diagram = new VennDiagram(new Dimension(200, 200));

		diagram.setChartTitle(new ChartTitle("Venn Diagramm"));
				
		diagram.setVennDiagramData(new VennDiagramData(100, 80, 60, 30, 30, 30,
				10));
				
		diagram.setChartLegend(new ChartLegend(Arrays.asList("A","B","C")));		
		
		String target = "http://chart.apis.google.com/chart?cht=v&chs=200x200&chd=e:BkBQA8AeAeAeAK&chdl=A|B|C&chdlp=r&chtt=Venn+Diagramm";
		
		Assert.assertEquals(target, diagram.getUrl());
		
	}

}
