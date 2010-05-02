/**
 * 
 */
package de.toolforge.googlechartwrapper.data;

import de.toolforge.googlechartwrapper.style.icon.AbstractDynamicIcon;

/**
 * @author steffan
 *
 */
public class FreestandingDynamicIconData {
	
	private AbstractDynamicIcon icon;
	
public FreestandingDynamicIconData(AbstractDynamicIcon icon) {
	
	this.icon = icon;
	
}

public AbstractDynamicIcon getAbstractDynamicIcon(){
	
	return icon;
}

}
