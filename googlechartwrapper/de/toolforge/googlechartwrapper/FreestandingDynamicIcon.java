/**
 *
 */
package de.toolforge.googlechartwrapper;

import de.toolforge.googlechartwrapper.coder.IEncoder;
import de.toolforge.googlechartwrapper.data.FreestandingDynamicIconData;
import de.toolforge.googlechartwrapper.data.FreestandingDynamicIconDataAppender;

/**
 * @author steffan
 */
public class FreestandingDynamicIcon extends AbstractChart {

    protected FreestandingDynamicIconDataAppender freestandingDynamicIconDataAppender = new FreestandingDynamicIconDataAppender();


    public FreestandingDynamicIcon(FreestandingDynamicIconData data) {

        freestandingDynamicIconDataAppender.add(data);
    }

    @Override
    protected ChartType getChartType() {

        return ChartType.FreestandingDynamicIcon;
    }

    @Override
    protected String getUrlChartType() {

        return null;
    }


    public IEncoder getEncoder() {
        return null;
        //return freestandingDynamicIconDataAppender.get
    }

}
