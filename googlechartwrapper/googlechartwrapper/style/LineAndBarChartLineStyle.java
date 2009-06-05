package googlechartwrapper.style;

import googlechartwrapper.util.AppendableFeature;
import googlechartwrapper.util.IFeatureAppender;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import de.toolforge.googlechartwrapper.ChartTypeFeature;

/**
 * Specifies LineAndBarChartLineStyle <a href=
 * "http://code.google.com/apis/chart/styles.html#line_styles"
 * >http://code.google.com/apis/chart/styles.html#line_styles</a>
 * 
 * @author steffan
 * @version 03/29/09
 * @see ILineAndBarChartLineStyleable
 * 
 */
public class LineAndBarChartLineStyle implements IFeatureAppender {

	private Color color = null;
	private int dataSetIndex;
	private int size;
	private IDataPoint dataPoint = null;
	private Priority priority;

	/**
	 * Constructs a new {@link LineAndBarChartLineStyle} with {@link Priority}.
	 * 
	 * @param color
	 *            the color of the line
	 * @param dataSetIndex
	 *            the line
	 * @param dataPoint
	 *            {@link DataPoint}
	 * @param size
	 *            the line size
	 * @param priority
	 *            {@link Priority}
	 * 
	 * @throws IllegalArgumentException
	 *             if color is {@code null}
	 * @throws IllegalArgumentException
	 *             if dataSetIndex < 0
	 * @throws IllegalArgumentException
	 *             if dataPoint is {@code null}
	 * @throws IllegalArgumentException
	 *             if size < 0
	 * @throws IllegalArgumentException
	 *             if priority is {@code null}
	 */
	public LineAndBarChartLineStyle(Color color, int dataSetIndex,
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

	/**
	 * Constructs a new {@link LineAndBarChartLineStyle}.
	 * 
	 * @param color
	 *            the color of the line
	 * @param dataSetIndex
	 *            the line
	 * @param dataPoint
	 *            {@link DataPoint}
	 * @param size
	 *            the line size
	 * 
	 * 
	 * @throws IllegalArgumentException
	 *             if color is {@code null}
	 * @throws IllegalArgumentException
	 *             if dataSetIndex < 0
	 * @throws IllegalArgumentException
	 *             if dataPoint is {@code null}
	 * @throws IllegalArgumentException
	 *             if size < 0
	 * 
	 */
	public LineAndBarChartLineStyle(Color color, int dataSetIndex,
			IDataPoint dataPoint, int size) {

		if (color == null)
			throw new IllegalArgumentException("color can not be null");
		if (dataSetIndex < 0)
			throw new IllegalArgumentException(
					"dataSetIndex must be 0 or higher");
		if (dataPoint == null)
			throw new IllegalArgumentException("dataPoint can not be null");
		if (size < 0)
			throw new IllegalArgumentException("size out of range");

		this.color = new Color(color.getRGB());
		this.dataSetIndex = dataSetIndex;
		this.dataPoint = dataPoint;
		this.size = size;

	}

	public List<AppendableFeature> getAppendableFeatures(
			List<? extends IFeatureAppender> otherAppenders) {
		StringBuilder builder = new StringBuilder();

		builder.append('D');
		builder.append(',');
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

	/**
	 * 
	 * @author steffan
	 * 
	 * @see DataPoint
	 *
	 */
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
	 * {@link LineAndBarChartLineStyle} constructor, which needs an {@link IDataPoint}
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
		 * The style will be set on every datapoint.
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
		 * The style will be set between this range
		 * 
		 * @param low lower border
		 * @param high higher border
		 * 
		 * @return {@link IDataPoint}
		 */
		public static IDataPoint newDrawPoint(final int low, final int high) {

			return new IDataPoint() {

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
