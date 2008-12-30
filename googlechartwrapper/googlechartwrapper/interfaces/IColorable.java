/**
 * 
 */
package googlechartwrapper.interfaces;

import googlechartwrapper.color.IChartColorable;
import googlechartwrapper.color.ISolidFillable;
import googlechartwrapper.style.IChartMarginable;

/**
 * The interface provides the two top level interfaces {@link IChartColorable} and {@link ISolidFillable}, used
 * by nearly every chart.
 * 
 * @author steffan
 *
 */
public interface IColorable extends IChartColorable, ISolidFillable, IChartMarginable{

}
