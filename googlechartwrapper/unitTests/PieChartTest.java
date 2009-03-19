package unitTests;

import static org.junit.Assert.assertEquals;
import googlechartwrapper.ConcentricPieChart;
import googlechartwrapper.PieChart;
import googlechartwrapper.data.ConcentricPieChartSlice;
import googlechartwrapper.data.PieChartSlice;
import googlechartwrapper.label.ChartTitle;
import googlechartwrapper.style.ChartMargin;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 
 * @author steffan
 *
 */
public class PieChartTest {

		
	@Test
	public void example1 (){
		
		PieChart chart = new PieChart(new Dimension(400,180));
		
		chart.setChartTitle(new ChartTitle("GDP of the world(nominal)"));
		
		chart.addPieChartSlice(new PieChartSlice.PieChartSliceBuilder(13840000).label("USA").color(Color.BLUE).build());
		chart.addPieChartSlice(new PieChartSlice.PieChartSliceBuilder(4384000).label("Japan").build());
		chart.addPieChartSlice(new PieChartSlice.PieChartSliceBuilder(3322000).label("Germany").build());
		chart.addPieChartSlice(new PieChartSlice.PieChartSliceBuilder(3251000).label("China (PRC)").build());
		chart.addPieChartSlice(new PieChartSlice.PieChartSliceBuilder(2773000).label("United Kingdom").build());
		chart.addPieChartSlice(new PieChartSlice.PieChartSliceBuilder(2560000).label("France").build());
		chart.addPieChartSlice(new PieChartSlice.PieChartSliceBuilder(2105000).label("Italy").build());
		chart.addPieChartSlice(new PieChartSlice.PieChartSliceBuilder(1439000).label("Spain").build());
		chart.addPieChartSlice(new PieChartSlice.PieChartSliceBuilder(1432000).label("Canada").build());
		chart.addPieChartSlice(new PieChartSlice.PieChartSliceBuilder(1314000).label("Brazil").build());
		chart.addPieChartSlice(new PieChartSlice.PieChartSliceBuilder(54620000-13840000-4384000-3322000-
				3251000-2773000-2560000-2105000-1439000-1432000-1314000).label("other").build());
						
		assertEquals("http://chart.apis.google.com/chart?cht=p&chs=400x180&chd=t:25,8,6,5,5,4,3,2,2,2,33&chco=0000ff,ff9d0a,ff9d0a,ff9d0a,ff9d0a,ff9d0a,ff9d0a,ff9d0a,ff9d0a,ff9d0a,ff9d0a&chl=USA|Japan|Germany|China (PRC)|United Kingdom|France|Italy|Spain|Canada|Brazil|other&chtt=GDP+of+the+world(nominal)", 
				chart.getUrl());
			
		
		 
		 
		
	}
	@Test
	public void example2(){
		
		PieChart chart = new PieChart(new Dimension(400,180));
		
		chart.setChartTitle(new ChartTitle("GDP of the world(nominal)"));
		
		chart.addPieChartSlice(new PieChartSlice.PieChartSliceBuilder(80).label("USA").color(Color.BLUE).build());
		chart.addPieChartSlice(new PieChartSlice.PieChartSliceBuilder(20).label("Canada").build());
		chart.setPieChartOrientation(2.5f);
	
		assertEquals("http://chart.apis.google.com/chart?cht=p&chs=400x180&chd=t:80,20&chco=0000ff,ff9d0a&chl=USA|Canada&chp=2.5&chtt=GDP+of+the+world(nominal)"
				,chart.getUrl());
				
	}
	@Test
	public void example3(){
		
		PieChart chart = new PieChart(new Dimension(400,180));
		
		chart.setChartTitle(new ChartTitle("GDP of the world(nominal)"));
		
		chart.addPieChartSlice(new PieChartSlice.PieChartSliceBuilder(80).label("USA").color(Color.BLUE).build());
		chart.addPieChartSlice(new PieChartSlice.PieChartSliceBuilder(20).label("Canada").build());
		chart.setChartMargin(new ChartMargin(40,40,40,40));
					
		assertEquals("http://chart.apis.google.com/chart?cht=p&chs=400x180&chd=t:80,20&chco=0000ff,ff9d0a&chl=USA|Canada&chma=40,40,40,40&chtt=GDP+of+the+world(nominal)"
				,chart.getUrl());
		
		
	}
	@Test
	public void example4(){
		
		ConcentricPieChart chart = new ConcentricPieChart(new Dimension(400,180));
		
		List<PieChartSlice> list = new ArrayList<PieChartSlice>();
		
		list.add(new PieChartSlice.PieChartSliceBuilder(80).label("USA").color(Color.BLUE).build());
		list.add(new PieChartSlice.PieChartSliceBuilder(20).label("Canada").build());
		
		ConcentricPieChartSlice cslice = new ConcentricPieChartSlice.ConcentricPieChartSliceBuilder(list).build();
		
		chart.addConcentricPieChartSlice(cslice);
		
		List<PieChartSlice> list2 = new ArrayList<PieChartSlice>();
		
		list2.add(new PieChartSlice.PieChartSliceBuilder(1314000).label("Brazil").build());
		list2.add(new PieChartSlice.PieChartSliceBuilder(4384000).label("Japan").build());
		
		ConcentricPieChartSlice cslice2 = new ConcentricPieChartSlice.ConcentricPieChartSliceBuilder(list2).build();
		
		chart.addConcentricPieChartSlice(cslice2);
		
		System.out.println(chart.getUrl());
		
		
	}
	
	@Test
	public void showCase (){
		
		PieChart chart = new PieChart(new Dimension(400,180));
		
		chart.setChartTitle(new ChartTitle("GDP (nominal)"));
		chart.set3D();
		
		chart.addPieChartSlice(new PieChartSlice.PieChartSliceBuilder(16620000).label("EU").build());
		chart.addPieChartSlice(new PieChartSlice.PieChartSliceBuilder(13840000).label("USA").build());
		chart.addPieChartSlice(new PieChartSlice.PieChartSliceBuilder(4384000).label("Japan").build());
		chart.addPieChartSlice(new PieChartSlice.PieChartSliceBuilder(3251000).label("China").build());		
		chart.addPieChartSlice(new PieChartSlice.PieChartSliceBuilder(54620000-16620000-13840000
				-4384000-3251000).label("rest").build());		
		
		assertEquals("http://chart.apis.google.com/chart?cht=p3&chs=400x180&chd=t:30,25,8,5,30&chl=EU|USA|Japan|China|rest&chtt=GDP+(nominal)", 
				chart.getUrl());
				
		
	}
	
}
