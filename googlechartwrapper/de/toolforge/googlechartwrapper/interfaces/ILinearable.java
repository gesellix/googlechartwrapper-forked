package de.toolforge.googlechartwrapper.interfaces;

import de.toolforge.googlechartwrapper.color.ILinearGradientable;
import de.toolforge.googlechartwrapper.color.ILinearStripeable;
import de.toolforge.googlechartwrapper.label.IChartLegendable;
import de.toolforge.googlechartwrapper.label.IChartTitleable;

/**
 * The interface is a logical collection of interfaces which are needed for more than one chart.
 * 
 * @author steffan
 *
 */

public interface ILinearable extends ILinearGradientable, IChartTitleable, ILinearStripeable, IChartLegendable {

}
