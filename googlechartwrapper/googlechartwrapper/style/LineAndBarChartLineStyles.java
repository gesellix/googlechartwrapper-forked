package googlechartwrapper.style;

import googlechartwrapper.ChartTypeFeature;
import googlechartwrapper.util.AppendableFeature;
import googlechartwrapper.util.IFeatureAppender;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author steffan
 * 
 */
public class LineAndBarChartLineStyles implements IFeatureAppender {

	private Color color = null;
	private int dataSetIndex;
	private int size;
	private IDataPoint dataPoint = null;
	private Priority priority;

	public LineAndBarChartLineStyles(Color color, int dataSetIndex,
			IDataPoint dataPoint, int size, Priority priority) {

		if (color == null)
			throw new IllegalArgumentException("color can not be null");
		if (dataSetIndex < 0)
			throw new IllegalArgumentException(
					"dataSetIndex must be 0 or higher");
		if (dataPoint == null)
			throw new IllegalArgumentException("dataPoint can not be null");
		if (size < 0)
			throw new IllegalArgumentException("size out of range");
		if (priority == null)
			throw new IllegalArgumentException("priority can not be null");

		this.color = new Color(color.getRGB());
		this.dataSetIndex = dataSetIndex;
		this.dataPoint = dataPoint;
		this.size = size;
		this.priority = priority;
	}

	public List<AppendableFeature> getAppendableFeatures(
			List<? extends IFeatureAppender> otherAppenders) {
		StringBuilder builder = new StringBuilder();

		
		
		builder
				.append(Integer.toHexString(this.color.getRGB())
						.substring(2, 8));
		builder.append(',');
		builder.append(this.dataSetIndex);
		builder.append(',');
		builder.append(this.dataPoint.getAppendableString());
		builder.append(',');
		builder.append(this.size);

		if (this.priority != null) {
			builder.append(',');
			builder.append(this.priority.getPriority());
		}

		List<AppendableFeature> feature = new ArrayList<AppendableFeature>(); 
		
        feature.add(new AppendableFeature(builder.toString(), 
                  ChartTypeFeature.ChartData)); 
        
		return feature;
	}

	public interface IDataPoint {

		/**
		 * The method build the complete datapoint string.
		 * 
		 * @return the complete and appendable string
		 */
		public String getAppendableString();

	}

	/**
	 * Provides a DataPoint factory. <br />
	 * This factory includes all methods to build an object for the
	 * {@link ShapeMarker} constructor, which needs an {@link IDataPoint}
	 * interface.
	 * 
	 * @author steffan
	 * 
	 */
	static public class DataPoint {

		/**
		 * nobody should ever construct an object of this class
		 */
		private DataPoint() {
		};

		/**
		 * The shapemarker will be set on every datapoint.
		 * 
		 * @return {@link IDataPoint}
		 */
		public static IDataPoint newDrawEachPoint() {

			return new IDataPoint() {

				public String getAppendableString() {

					return "0";
				}

			};

		};
		/**
		 * 
		 * @param low
		 * @param high
		 * @return
		 */
		public static IDataPoint newDrawPoint(final int low, final int high) {
			
			return new IDataPoint(){

				public String getAppendableString() {
					
					StringBuilder builder = new StringBuilder();
					builder.append(low);
					builder.append(":");
					builder.append(high);					

					return builder.toString();
				}
				
			};
		}
	}

	/**
	 * 
	 * @author steffan
	 * 
	 */
	public enum Priority {

		First(1), Default(0), Last(-1);

		private int priority;

		Priority(int priority) {
			this.priority = priority;
		}

		public int getPriority() {
			return this.priority;
		}
	}

}
