package googlechartwrapper.interfaces;

import googlechartwrapper.label.IAxisLabelable;
import googlechartwrapper.style.IGridLineable;
import googlechartwrapper.style.IRangeMarkable;
import googlechartwrapper.style.IShapeMarkable;

/**
 * The interface is a logical collection of interfaces which are needed for more than one chart.
 * 
 * @author steffan
 *
 */

public interface IMarkable extends IRangeMarkable, IShapeMarkable, IGridLineable, IAxisLabelable{

}
