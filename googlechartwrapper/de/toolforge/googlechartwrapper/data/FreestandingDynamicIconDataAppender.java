/**
 *
 */
package de.toolforge.googlechartwrapper.data;

import de.toolforge.googlechartwrapper.coder.IEncoder;
import de.toolforge.googlechartwrapper.interfaces.IEncodeable;
import de.toolforge.googlechartwrapper.util.AppendableFeature;
import de.toolforge.googlechartwrapper.util.IExtendedFeatureAppender;
import de.toolforge.googlechartwrapper.util.IFeatureAppender;

import java.util.List;

/**
 * @author steffan
 */
public class FreestandingDynamicIconDataAppender implements IExtendedFeatureAppender, IEncodeable {

    private FreestandingDynamicIconData data;

    public FreestandingDynamicIconDataAppender() {


    }

    public void add(FreestandingDynamicIconData data) {

        this.data = data;
    }


    @Override
    public List<AppendableFeature> getAppendableFeatures(
            List<? extends IFeatureAppender> otherAppenders) {

        return data.getAbstractDynamicIcon().getAppendableFeatures(otherAppenders);
    }

    public IEncoder getEncoder() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setEncoder(IEncoder encoder) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void removeEncoder() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
