package googlechartwrapper.interfaces;

import googlechartwrapper.color.ILinearGradientable;
import googlechartwrapper.color.ILinearStripeable;
import googlechartwrapper.label.IChartLegendable;
import googlechartwrapper.label.IChartTitleable;

/**
 * The interface is a logical collection of interfaces which are needed for more than one chart.
 * 
 * @author steffan
 *
 */

public interface ILinearable extends ILinearGradientable, IChartTitleable, ILinearStripeable, IChartLegendable {

}
