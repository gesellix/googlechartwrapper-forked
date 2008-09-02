package unitTests;


import googlechartwrapper.VennDiagram;
import googlechartwrapper.label.ChartTitle;

import java.awt.Dimension;

import org.junit.Assert;
import org.junit.Test;

public class VennDiagramTest {
	
	@Test
	public void example1() {
		
		VennDiagram diagram = new VennDiagram(new Dimension(200,200));
		
		diagram.setChartTitle(new ChartTitle("VennDiagramm"));
		
		System.out.println(diagram.getUrl());
		
		String target ="http://chart.apis.google.com/chart?cht=v&chs=200x200&chtt=VennDiagramm";
		
		Assert.assertEquals(target, diagram.getUrl());		
	}
	

}
