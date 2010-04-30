/**
 * 
 */
package de.toolforge.googlechartwrapper.style.icon;

/**
 * @author steffan
 *
 */
public enum TailDirection {
	
	Bottomleft("bb"),
	BottomLeft("bb"),
	TopLeft("bbtl"),
	TopRight("bbtr"),
	BottomRight("bbbr"),
	NoTail("bbT");
	
	
	private final String direction;
  	
  	private TailDirection(String direction) {
		this.direction = direction;
	}
  	
  	public String getDirection(){
  		return this.direction;
  	}

}
