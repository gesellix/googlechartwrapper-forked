package de.toolforge.googlechartwrapper.util;

import java.util.List;

/**
 * Interface for feature appenders which returns a string in a google api format. 
 * @author martin
 *
 */
public interface IFeatureAppender {
	
	/**
	 * Returns a List of google api formated string for the individual feature. It
	 * shall be without the feature prefix and separating characters besides
	 * other class expect it to behave in this special manner.
	 * @param otherAppenders other appenders of the chart
	 * @return List of google api formated string for features with prefix
	 */
	public List<AppendableFeature> getAppendableFeatures (List<? extends IFeatureAppender> otherAppenders);

}
