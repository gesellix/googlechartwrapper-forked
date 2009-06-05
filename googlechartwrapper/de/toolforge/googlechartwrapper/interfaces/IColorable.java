/**
 * 
 */
package de.toolforge.googlechartwrapper.interfaces;

import de.toolforge.googlechartwrapper.color.IChartColorable;
import de.toolforge.googlechartwrapper.color.ISolidFillable;
import de.toolforge.googlechartwrapper.style.IChartMarginable;

/**
 * The interface provides the two top level interfaces {@link IChartColorable} and {@link ISolidFillable}, used
 * by nearly every chart.
 * 
 * @author steffan
 *
 */
public interface IColorable extends IChartColorable, ISolidFillable, IChartMarginable{

}
