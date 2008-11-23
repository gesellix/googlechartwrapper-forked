package googlechartwrapper.data;

import java.util.List;

import googlechartwrapper.util.IFeatureAppender;

/**
 * A DataScalingSet enables the transformation of chart values on one axis. 
 * If you supply fewer data scaling parameters than there are data sets the 
 * last scaling parameter is applied to the remaining data sets.
 * @author steffan
 * @author martin
 * @see ISingleDataScaleable
 * @see IMultiDataScaleable
 *
 */
public class DataScalingSet implements IFeatureAppender{
	
	private double minimumValue;
	private double maximumValue;

	/**
	 * Constructs a DataScalingSet the lowest and highest number you want to 
	 * apply to the dataset. You can specify a missing value with a number 
	 * that is out of range.
	 * @param maximumValue lowest number you want to apply to the data set
	 * @param minimumValue highest number you want to apply to the data set
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

	/**
	 * Returns the maximum value for the dataset.
	 * @return maximum value
	 */
	public double getMaximumValue() {
		return maximumValue;
	}

	/**
	 * Sets the maximum value for the dataset.
	 * @param maximumValue highest number you want to apply to the first data set
	 */
	public void setMaximumValue(double maximumValue) {
		this.maximumValue = maximumValue;
	}

	/**
	 * Returns the minimum value for the dataset.
	 * @return minimum value
	 */
	public double getMinimumValue() {
		return minimumValue;
	}

	/**
	 * Sets the minimum value for the dataset.
	 * @param minimumValue lowest number you want to apply to the first data set
	 */
	public void setMinimumValue(double minimumValue) {
		this.minimumValue = minimumValue;
	}

}
