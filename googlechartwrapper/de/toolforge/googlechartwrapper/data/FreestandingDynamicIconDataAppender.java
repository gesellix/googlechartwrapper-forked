/**
 * 
 */
package de.toolforge.googlechartwrapper.data;

import java.util.ArrayList;
import java.util.List;

import de.toolforge.googlechartwrapper.ChartTypeFeature;
import de.toolforge.googlechartwrapper.util.AppendableFeature;
import de.toolforge.googlechartwrapper.util.IExtendedFeatureAppender;
import de.toolforge.googlechartwrapper.util.IFeatureAppender;

/**
 * @author steffan
 *
 */
public class FreestandingDynamicIconDataAppender implements IExtendedFeatureAppender{

	private FreestandingDynamicIconData data;
	
	public FreestandingDynamicIconDataAppender() {
		
		
	}
	
	public void add(FreestandingDynamicIconData data){
		
		this.data = data;
	}
	
	
	@Override
	public List<AppendableFeature> getAppendableFeatures(
			List<? extends IFeatureAppender> otherAppenders) {

		return data.getAbstractDynamicIcon().getAppendableFeatures(otherAppenders);
	}

}
