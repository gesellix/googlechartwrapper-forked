/**
 * 
 */
package unitTests;

import googlechartwrapper.Map;
import googlechartwrapper.Map.Country;
import googlechartwrapper.Map.CountryName;
import googlechartwrapper.Map.GeographicalArea;
import googlechartwrapper.color.ChartColor;
import googlechartwrapper.color.SolidFill;
import googlechartwrapper.color.SolidFill.ChartFillDestination;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author steffan
 *
 */
public class MapTest {
	
	@Test
	public void example(){
		
		//new england states
		Map newEnglandStates = new Map(new Dimension(400,200),Arrays.asList(new Map.State(Map.StateCode.CT,100),new Map.State(Map.StateCode.ME,100),new Map.State(Map.StateCode.MA,100),new Map.State(Map.StateCode.NH,100),new Map.State(Map.StateCode.RI,100),new Map.State(Map.StateCode.VT,100)));
		newEnglandStates.addSolidFill(new SolidFill(ChartFillDestination.Background,Color.BLUE));
				
		System.out.println(newEnglandStates.getUrl());
		final String expected ="http://chart.apis.google.com/chart?cht=t&chs=400x200&chtm=usa&chld=CTMEMANHRIVT&chd=t:100,100,100,100,100,100&chf=bg,s,0000ff";

		Assert.assertEquals(expected, newEnglandStates.getUrl());
				
	}
	@Test
	public void showCase(){
		
		//all 27 eu member
		List<Country> member = new LinkedList<Country>();
		member.add(new Map.Country(CountryName.GERMANY,100));
		member.add(new Map.Country(CountryName.FRANCE,100));
		member.add(new Map.Country(CountryName.BELGIUM,100));
		member.add(new Map.Country(CountryName.ITALY,100));
		member.add(new Map.Country(CountryName.ROMANIA,0));
		member.add(new Map.Country(CountryName.BULGARIA,0));
		member.add(new Map.Country(CountryName.LITHUANIA,0));
		member.add(new Map.Country(CountryName.SWEDEN,0));
		member.add(new Map.Country(CountryName.DENMARK,0));
		member.add(new Map.Country(CountryName.LATVIA,0));
		member.add(new Map.Country(CountryName.SLOVAKIA,0));
		member.add(new Map.Country(CountryName.LUXEMBOURG,100));
		member.add(new Map.Country(CountryName.SLOVENIA,0));
		member.add(new Map.Country(CountryName.ESTONIA,0));
		member.add(new Map.Country(CountryName.MALTA,0));
		member.add(new Map.Country(CountryName.SPAIN,0));
		member.add(new Map.Country(CountryName.FINLAND,0));
		member.add(new Map.Country(CountryName.NETHERLANDS,100));
		member.add(new Map.Country(CountryName.CZECH_REPUBLIC,0));
		member.add(new Map.Country(CountryName.AUSTRIA,0));
		member.add(new Map.Country(CountryName.HUNGARY,0));
		member.add(new Map.Country(CountryName.GREECE,0));
		member.add(new Map.Country(CountryName.POLAND,0));
		member.add(new Map.Country(CountryName.UNITED_KINGDOM,0));
		member.add(new Map.Country(CountryName.IRELAND,0));
		member.add(new Map.Country(CountryName.PORTUGAL,0));
		member.add(new Map.Country(CountryName.CYPRUS,0));
		
		Map eu = new Map(new Dimension(400,200),GeographicalArea.EUROPE,member);
		
		eu.addSolidFill(new SolidFill(ChartFillDestination.Background,Color.BLUE));
		eu.addChartColor(new ChartColor(Color.LIGHT_GRAY));
		eu.addChartColor(new ChartColor(Color.YELLOW));
		new Color(0);
		eu.addChartColor(new ChartColor(Color.decode("#FFD700")));
	
		final String expected = "http://chart.apis.google.com/chart?cht=t&chs=400x200&chtm=europe&chld=DEFRBEITROBGLTSEDKLVSKLUSIEEMTESFINLCZATHUGRPLGBIEPTCY&chd=t:100,100,100,100,0,0,0,0,0,0,0,100,0,0,0,0,0,100,0,0,0,0,0,0,0,0,0&chco=c0c0c0,ffff00,ffd700&chf=bg,s,0000ff";
		
		Assert.assertEquals(expected, eu.getUrl());
				
	}

}
