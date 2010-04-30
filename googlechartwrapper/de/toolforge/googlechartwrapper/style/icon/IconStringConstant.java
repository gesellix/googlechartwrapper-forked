/**
 * 
 */
package de.toolforge.googlechartwrapper.style.icon;

/**
 * @author steffan
 *
 */
enum IconStringConstant {

	BubbleTextSmall("d_bubble_text_small");
	
	private final String prefix;
  	
  	private IconStringConstant(String prefix) {
		this.prefix = prefix;
	}

  	public String getPrefix(){
  		return this.prefix;
  	}
}
