/**
 * 
 */
package de.toolforge.googlechartwrapper.data;

import de.toolforge.googlechartwrapper.Formula;

/**
 * @author steffan
 * 
 * @see FormulaDataAppender
 * @see Formula
 *
 */
public class FormulaData {
	
	private String tex;
	
	/**
	 * <b>Note:</b> <br>
	 * URL-Encoding 
	 * Remember that you must URL-encode any non-URL-safe characters used in your formula.
	 * The most common mistake is using + in a formula instead of %2B:
	 * 
	 * @param tex
	 * 
	 * @throws IllegalArgumentException if tex is <code>null</code>
	 */
	public FormulaData(String tex) {
		
		if(tex == null)
			throw new IllegalArgumentException("tex can not be null");
		
		this.tex = tex;
	}

	/**
	 * @return the tex
	 */
	public String getTex() {
		return tex;
	}

	/**
	 * @param tex the tex to set
	 * 
	 * @throws IllegalArgumentException if tex is <code>null</code>
	 */
	public void setTex(String tex) {
		
		if(tex == null)
			throw new IllegalArgumentException("tex can not be null");
		
		this.tex = tex;
	}

}
