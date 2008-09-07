package unitTests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Dimension;

import googlechartwrapper.PieChart;
import googlechartwrapper.color.LinearStripes;
import googlechartwrapper.color.LinearStripes.LinearStripesDestination;
import googlechartwrapper.data.PieChartSlice;
import googlechartwrapper.label.ChartTitle;

import org.junit.Test;

public class PieChartTest {

	@Test
	public void testSimpleExample (){
		PieChart chart = new PieChart(new Dimension(400,180),true);
		chart.setChartTitle(new ChartTitle("GDP (nominal)"));
		//WORLD: 54,620,000	//EU: 16,620,000 //USA: 13,840,000 
		//JAPAN: 4,384,000 //China: 3,251,000
		chart.addPieChartSlice(new PieChartSlice(16620000,"EU", null));
		chart.addPieChartSlice(new PieChartSlice(13840000,"USA", null));
		chart.addPieChartSlice(new PieChartSlice( 4384000,"Japan", null));
		chart.addPieChartSlice(new PieChartSlice( 3251000,"China", null));
		chart.addPieChartSlice(new PieChartSlice(54620000-16620000-13840000
				-4384000-3251000,"rest", null));
		
		System.out.println(chart.getUrl());
		assertEquals("http://chart.apis.google.com/chart?cht=p3&chs=400x180&chtt=GDP+" +
				"(nominal)&chco=&chl=EU|USA|Japan|China|rest&chd=t:30,25,8,5,30", 
				chart.getUrl());
	}
	
	@Test
	public void testExtendedExample (){
		PieChart chart = new PieChart(new Dimension(400,180),false);
		chart.setChartTitle(new ChartTitle("GDP of the world(nominal)"));
		
		chart.addPieChartSlice(new PieChartSlice(13840000,"USA", Color.BLUE));
		chart.addPieChartSlice(new PieChartSlice( 4384000,"Japan", null));
		chart.addPieChartSlice(new PieChartSlice( 3322000,"Germany", null));
		chart.addPieChartSlice(new PieChartSlice( 3251000,"China (PRC)", null));
		chart.addPieChartSlice(new PieChartSlice( 2773000,"United Kingdom", null));
		chart.addPieChartSlice(new PieChartSlice( 2560000,"France", null));
		chart.addPieChartSlice(new PieChartSlice( 2105000,"Italy", null));
		chart.addPieChartSlice(new PieChartSlice( 1439000,"Spain", null));
		chart.addPieChartSlice(new PieChartSlice( 1432000,"Canada", null));
		chart.addPieChartSlice(new PieChartSlice( 1314000,"Brazil", null));
		chart.addPieChartSlice(new PieChartSlice(54620000-13840000-4384000-3322000-
				3251000-2773000-2560000-2105000-1439000-1432000-1314000,"other", null));
		
		chart.setLinearStripes(new LinearStripes(LinearStripesDestination.Background,30,Color.ORANGE,0.1f, Color.YELLOW, 0.4f));
			
		System.out.println(chart.getUrl());
	}
	
	

	
}
