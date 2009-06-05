package de.toolforge.googlechartwrapper.interfaces;

import de.toolforge.googlechartwrapper.label.IAxisLabelable;
import de.toolforge.googlechartwrapper.style.IGridLineable;
import de.toolforge.googlechartwrapper.style.IRangeMarkable;
import de.toolforge.googlechartwrapper.style.IShapeMarkable;

/**
 * The interface is a logical collection of interfaces which are needed for more than one chart.
 * 
 * @author steffan
 *
 */

public interface IMarkable extends IRangeMarkable, IShapeMarkable, IGridLineable, IAxisLabelable{

}
