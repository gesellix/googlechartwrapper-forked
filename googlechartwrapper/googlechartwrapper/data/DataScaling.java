package googlechartwrapper.data;

import java.util.List;

import googlechartwrapper.util.IFeatureAppender;

/**
 * 
 * @author steffan
 *
 */
//TODO multi datascaling
public class DataScaling implements IFeatureAppender{
	
	private int minimumValue;
	private int maximumValue;

	/**
	 * @param maximumValue
	 * @param minimumValue
	 */
	public DataScaling(int minimumValue, int maximumValue) {
		
		this.maximumValue = maximumValue;
		this.minimumValue = minimumValue;
	}

	public String getAppendableString(
			List<? extends IFeatureAppender> otherAppenders) {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append(this.minimumValue);
		builder.append(',');
		builder.append(this.maximumValue);

		return builder.toString();
	}

}
