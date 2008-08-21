package googlechartwrapper.interfaces;

import googlechartwrapper.label.IAxisLabelable;
import googlechartwrapper.style.IGridLineable;
import googlechartwrapper.style.IRangeMarkable;
import googlechartwrapper.style.IShapeMarkable;

/**
 * 
 * @author steffan
 *
 */

public interface IMarkable extends IRangeMarkable, IShapeMarkable, IGridLineable, IAxisLabelable{

}
