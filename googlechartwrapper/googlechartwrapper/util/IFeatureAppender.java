package googlechartwrapper.util;

import java.util.List;

/**
 * Interface for feature appenders which returns a string in a google api format. 
 * @author martin
 *
 */
public interface IFeatureAppender {
	
	/**
	 * Returns the google api formated string for the individual feature. It
	 * shall be without the feature prefix and separating characters besides
	 * other class expect it to behave in this special manner.
	 * @param otherAppenders other appenders of the chart
	 * @return google api formated string for feature
	 */
	public String getAppendableString (List<? extends IFeatureAppender> otherAppenders);

}
