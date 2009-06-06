/**
 * 
 */
package unitTests;


import java.awt.Color;
import java.awt.Dimension;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import de.toolforge.googlechartwrapper.UsaMap;
import de.toolforge.googlechartwrapper.WorldMap;
import de.toolforge.googlechartwrapper.WorldMap.Country;
import de.toolforge.googlechartwrapper.WorldMap.CountryName;
import de.toolforge.googlechartwrapper.WorldMap.GeographicalArea;
import de.toolforge.googlechartwrapper.color.ChartColor;
import de.toolforge.googlechartwrapper.color.SolidFill;
import de.toolforge.googlechartwrapper.color.SolidFill.ChartFillDestination;

/**
 * @author steffan
 *
 */
public class MapTest {
	
	@Test
	public void example(){
		
		//new england states
		UsaMap newEnglandStates = new UsaMap(new Dimension(400,200),Arrays.asList(new UsaMap.State(UsaMap.StateCode.CT,100),new UsaMap.State(UsaMap.StateCode.ME,100),new UsaMap.State(UsaMap.StateCode.MA,100),new UsaMap.State(UsaMap.StateCode.NH,100),new UsaMap.State(UsaMap.StateCode.RI,100),new UsaMap.State(UsaMap.StateCode.VT,100)));
		newEnglandStates.addSolidFill(new SolidFill(ChartFillDestination.Background,Color.BLUE));
				
		
		final String expected ="http://chart.apis.google.com/chart?cht=t&chs=400x200&chtm=usa&chld=CTMEMANHRIVT&chd=t:100,100,100,100,100,100&chf=bg,s,0000ff";

		Assert.assertEquals(expected, newEnglandStates.getUrl());
				
	}
	@Test
	public void showCase(){
		
		//all 27 eu member
		List<Country> member = new LinkedList<Country>();
		member.add(new WorldMap.Country(CountryName.GERMANY,100));
		member.add(new WorldMap.Country(CountryName.FRANCE,100));
		member.add(new WorldMap.Country(CountryName.BELGIUM,100));
		member.add(new WorldMap.Country(CountryName.ITALY,100));
		member.add(new WorldMap.Country(CountryName.ROMANIA,0));
		member.add(new WorldMap.Country(CountryName.BULGARIA,0));
		member.add(new WorldMap.Country(CountryName.LITHUANIA,0));
		member.add(new WorldMap.Country(CountryName.SWEDEN,0));
		member.add(new WorldMap.Country(CountryName.DENMARK,0));
		member.add(new WorldMap.Country(CountryName.LATVIA,0));
		member.add(new WorldMap.Country(CountryName.SLOVAKIA,0));
		member.add(new WorldMap.Country(CountryName.LUXEMBOURG,100));
		member.add(new WorldMap.Country(CountryName.SLOVENIA,0));
		member.add(new WorldMap.Country(CountryName.ESTONIA,0));
		member.add(new WorldMap.Country(CountryName.MALTA,0));
		member.add(new WorldMap.Country(CountryName.SPAIN,0));
		member.add(new WorldMap.Country(CountryName.FINLAND,0));
		member.add(new WorldMap.Country(CountryName.NETHERLANDS,100));
		member.add(new WorldMap.Country(CountryName.CZECH_REPUBLIC,0));
		member.add(new WorldMap.Country(CountryName.AUSTRIA,0));
		member.add(new WorldMap.Country(CountryName.HUNGARY,0));
		member.add(new WorldMap.Country(CountryName.GREECE,0));
		member.add(new WorldMap.Country(CountryName.POLAND,0));
		member.add(new WorldMap.Country(CountryName.UNITED_KINGDOM,0));
		member.add(new WorldMap.Country(CountryName.IRELAND,0));
		member.add(new WorldMap.Country(CountryName.PORTUGAL,0));
		member.add(new WorldMap.Country(CountryName.CYPRUS,0));
		
		WorldMap eu = new WorldMap(new Dimension(400,200),GeographicalArea.EUROPE,member);
		
		eu.addSolidFill(new SolidFill(ChartFillDestination.Background,Color.BLUE));
		eu.addChartColor(new ChartColor(Color.LIGHT_GRAY));
		eu.addChartColor(new ChartColor(Color.YELLOW));
		
		eu.addChartColor(new ChartColor(Color.decode("#FFD700")));
	
		final String expected = "http://chart.apis.google.com/chart?cht=t&chs=400x200&chtm=europe&chld=DEFRBEITROBGLTSEDKLVSKLUSIEEMTESFINLCZATHUGRPLGBIEPTCY&chd=t:100,100,100,100,0,0,0,0,0,0,0,100,0,0,0,0,0,100,0,0,0,0,0,0,0,0,0&chco=c0c0c0,ffff00,ffd700&chf=bg,s,0000ff";
		
		Assert.assertEquals(expected, eu.getUrl());
				
	}

}
