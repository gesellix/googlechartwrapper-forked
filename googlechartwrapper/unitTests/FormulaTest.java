package unitTests;

import org.junit.Assert;
import org.junit.Test;

import de.toolforge.googlechartwrapper.Formula;
import de.toolforge.googlechartwrapper.data.FormulaData;

/**
 * 
 * @author steffan
 *
 */
public class FormulaTest {
	
	@Test
	public void showcase(){
		
		Formula formula = new Formula(new FormulaData("e^{\\mathrm{i}\\,\\pi}%2B1=0\\"));

		String target = "http://chart.apis.google.com/chart?cht=tx&chl=e^{\\mathrm{i}\\,\\pi}%2B1=0\\";
		
		Assert.assertEquals(target, formula.getUrl());
		
	}
	
	@Test
	public void example(){
				
		Formula formula = new Formula(new FormulaData("x=\\frac{-b\\pm\\sqrt{b^2-4ac}}{2a}"), 200);
			
		String target = "http://chart.apis.google.com/chart?cht=tx&chs=200&chl=x=\\frac{-b\\pm\\sqrt{b^2-4ac}}{2a}";
		
		Assert.assertEquals(target, formula.getUrl());
		
	}
	

}
