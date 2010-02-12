/**
 * 
 */
package de.toolforge.googlechartwrapper.data;

import java.util.Arrays;
import java.util.List;

import de.toolforge.googlechartwrapper.ChartTypeFeature;
import de.toolforge.googlechartwrapper.util.AppendableFeature;
import de.toolforge.googlechartwrapper.util.IExtendedFeatureAppender;
import de.toolforge.googlechartwrapper.util.IFeatureAppender;

/**
 * @author steffan
 *
 */
public class FormulaDataAppender implements IExtendedFeatureAppender{
	
	private FormulaData data;
	
	public void setFormulaData(FormulaData data){
		
		if(data == null)
			throw new IllegalArgumentException("data can not be null");
		
		this.data = data;
	}
	
	public FormulaData getFormulaData(){
		
		return this.data;
	}

	public List<AppendableFeature> getAppendableFeatures(
			List<? extends IFeatureAppender> otherAppenders) {
		
		return Arrays.asList(new AppendableFeature(data.getTex(), ChartTypeFeature.FormulaData));
	}

}
