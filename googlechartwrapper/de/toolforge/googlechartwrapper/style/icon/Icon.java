/**
 * 
 */
package de.toolforge.googlechartwrapper.style.icon;

/**
 * @author steffan
 *
 */
public enum Icon {
	
	BankDollar("bank-dollar");
	
	private final String prefix;
  	
  	private Icon(String prefix) {
		this.prefix = prefix;
	}

  	public String getPrefix(){
  		return this.prefix;
  	}

}
