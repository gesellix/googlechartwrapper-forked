package unitTests;

import java.awt.Dimension;

import org.junit.Test;

import de.toolforge.googlechartwrapper.Formula;
import de.toolforge.googlechartwrapper.data.FormulaData;

public class FormulaTest {
	
	@Test
	public void example(){
				
		Formula formula = new Formula(new FormulaData("x=\\frac{-b\\pm\\sqrt{b^2-4ac}}{2a}"), new Dimension(300, 200));
		
		System.out.println(formula.getUrl());
		
	}

}
