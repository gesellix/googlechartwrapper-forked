package googlechartwrapper.data;

import java.util.List;

import googlechartwrapper.util.IFeatureAppender;

/**
 * 
 * @author steffan
 * @author martin
 *
 */
public class DataScalingSet implements IFeatureAppender{
	
	private double minimumValue;
	private double maximumValue;

	/**
	 * @param maximumValue
	 * @param minimumValue
	 */
	public DataScalingSet(double minimumValue, double maximumValue) {
		
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

	public double getMaximumValue() {
		return maximumValue;
	}

	public void setMaximumValue(double maximumValue) {
		this.maximumValue = maximumValue;
	}

	public double getMinimumValue() {
		return minimumValue;
	}

	public void setMinimumValue(double minimumValue) {
		this.minimumValue = minimumValue;
	}

}
