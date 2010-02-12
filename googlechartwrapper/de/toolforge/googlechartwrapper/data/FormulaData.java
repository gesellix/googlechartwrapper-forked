/**
 * 
 */
package de.toolforge.googlechartwrapper.data;

/**
 * @author steffan
 *
 */
public class FormulaData {
	
	private String tex;
	
	/**
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
