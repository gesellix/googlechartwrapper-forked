/**
 * 
 */
package unitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.toolforge.googlechartwrapper.FreestandingDynamicIcon;

/**
 * @author steffan
 *
 */
public class FreestandingDynamicIconTest {

	@Test
	public void example1(){
		
		FreestandingDynamicIcon chart = new FreestandingDynamicIcon();
		
	
		assertEquals("http://chart.apis.google.com/chart?cht=p&chs=400x180&chco=0000ff," +
				"ff9d0a&chd=e:..QA&chl=USA|Canada&chp=2.5&chtt=GDP+of+the+world(nominal)"
				,chart.getUrl());
				
	}
}
