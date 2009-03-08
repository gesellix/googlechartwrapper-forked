package googlechartwrapper.style;

import googlechartwrapper.ChartTypeFeature;
import googlechartwrapper.util.AppendableFeature;
import googlechartwrapper.util.IFeatureAppender;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Specifies a RangeMarker <a href=
 * "http://code.google.com/intl/de-DE/apis/chart/styles.html#shape_markers"
 * >http://code.google.com/intl/de-DE/apis/chart/styles.html#shape_markers</a>
 * 
 * @author steffan
 * 
 */
public class ShapeMarker implements IFeatureAppender {

	private MarkerTyp markerTyp;
	private Color color;
	private int dataSetIndex;
	private IDataPoint dataPoint;
	private int size;
	private Priority priority;

	/**
	 * Constructs a shapemaker.
	 * 
	 * @param markerTyp
	 *            {@link MarkerTyp}
	 * @param color
	 * @param dataSetIndex
	 *            value >=0
	 * @param dataPoint
	 *            {@link DataPoint} can build all dataPoints.
	 * @param size
	 *            the size of the marker in pixels, value >=0
	 * 
	 * @throws IllegalArgumentException
	 */
	public ShapeMarker(MarkerTyp markerTyp, Color color, int dataSetIndex,
			IDataPoint dataPoint, int size) {

		if (markerTyp == null)
			throw new IllegalArgumentException("markerTyp can not be null");
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
		this.markerTyp = markerTyp;
		this.dataPoint = dataPoint;
		this.size = size;

	}

	/**
	 * Constructs a shapemarker.
	 * 
	 * @param markerTyp
	 *            {@link MarkerTyp}
	 * @param color
	 * @param dataSetIndex
	 *            value >=0
	 * @param dataPoint
	 *            {@link DataPoint} can build all dataPoints.
	 * @param size
	 *            the size of the marker in pixels, value >=0
	 * @param priority
	 *            {@link Priority}
	 * 
	 * @throws IllegalArgumentException
	 */
	public ShapeMarker(MarkerTyp markerTyp, Color color, int dataSetIndex,
			IDataPoint dataPoint, int size, Priority priority) {

		if (dataSetIndex < 0)
			throw new IllegalArgumentException(
					"dataSetIndex must be 0 or higher");
		if (markerTyp == null)
			throw new IllegalArgumentException("markerTyp can not be null");
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
		this.markerTyp = markerTyp;
		this.dataPoint = dataPoint;
		this.size = size;
		this.priority = priority;

	}

	/**
	 * 
	 * @param color
	 * 
	 * @throws IllegalArgumentException
	 */
	public void setColor(Color color) {

		if (color == null)
			throw new IllegalArgumentException("color can not be null");

		this.color = new Color(color.getRGB());

	}

	/**
	 * 
	 * @return
	 */
	public Color getColor() {
		return new Color(this.color.getRGB());
	}

	/**
	 * 
	 * @param markerTyp
	 * 
	 * @throws IllegalArgumentException
	 *             if markerTyp <code>null</code>
	 */
	public void setMarkerTyp(MarkerTyp markerTyp) {
		if (markerTyp == null)
			throw new IllegalArgumentException("markerTyp can not be null");
		this.markerTyp = markerTyp;
	}

	/**
	 * 
	 * @return
	 */
	public MarkerTyp getMarkerTyp() {
		return this.markerTyp;
	}

	/**
	 * 
	 * @return
	 * 
	 * 
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * 
	 * @param size
	 * 
	 * @throws IllegalArgumentException
	 *             if index out of range
	 */
	public void setSize(int size) {
		if (size < 0)
			throw new IllegalArgumentException("size out of range");
		this.size = size;
	}

	public IDataPoint getDataPoint() {
		return this.dataPoint;
	}

	/**
	 * 
	 * @param dataPoint
	 * 
	 * @throws IllegalArgumentException
	 *             if dataPoint iss {@code null}
	 */
	public void setDataPoint(IDataPoint dataPoint) {

		if (dataPoint == null)
			throw new IllegalArgumentException("dataPoint can not be null");
		this.dataPoint = dataPoint;
	}

	/**
	 * 
	 * @return
	 */
	public int getDataSetIndex() {
		return dataSetIndex;
	}

	/**
	 * 
	 * @param dataSetIndex
	 * 
	 * @throws IllegalArgumentException
	 *             if dataSetIndex < 0
	 */
	public void setDataSetIndex(int dataSetIndex) {

		if (dataSetIndex < 0)
			throw new IllegalArgumentException(
					"dataSetIndex must be 0 or higher");
		if (markerTyp == null)
			this.dataSetIndex = dataSetIndex;
	}

	/**
	 * 
	 * @return
	 */
	public Priority getPriority() {
		return priority;
	}

	/**
	 * 
	 * @param priority
	 * 
	 * @throws IllegalArgumentException
	 *             if markerTyp <code>null</code>
	 */
	public void setPriority(Priority priority) {
		if (markerTyp == null)
			throw new IllegalArgumentException("markerTyp can not be null");
		this.priority = priority;
	}

	public List<AppendableFeature> getAppendableFeatures(
			List<? extends IFeatureAppender> otherAppenders) {
		StringBuilder builder = new StringBuilder();

		// one features needs a @ character at pos 0
		if (this.dataPoint.isPrefixRequiered()) {

			builder.append(this.dataPoint.getPrefix());
		}
		builder.append(this.markerTyp.getMarkerChar());
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
	 */
	public enum MarkerTyp {

		Arrow('a'), Cross('c'), Diamond('d'), Circle('o'), Square('s'), Text(
				't'),
		/**
		 * represents a vertical line from the x-axis to the data point.
		 */
		VerticalLineFrom('v'), VerticalLineTo('V'), HorizontalLine('h'), XShape(
				'x');

		private char markerChar;

		MarkerTyp(char markerChar) {
			this.markerChar = markerChar;
		}

		public char getMarkerChar() {
			return this.markerChar;
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

					return "-1";
				}

				public String getPrefix() {
					return null;
				}

				public boolean isPrefixRequiered() {

					return false;
				}

			};

		};

		/**
		 * The shapemaker will be drawn every nth datapoint
		 * 
		 * @param n
		 *            the nthe position
		 * @return {@link IDataPoint}
		 * 
		 * @throws IllegalArgumentException
		 *             if n is < 0
		 */
		public static IDataPoint newDrawNPoint(final int n) {

			if (n < 0)
				throw new IllegalArgumentException("n can not < 0");

			return new IDataPoint() {

				public String getAppendableString() {

					return "-" + String.valueOf(n);
				}

				public String getPrefix() {

					return null;
				}

				public boolean isPrefixRequiered() {

					return false;
				}

			};

		};

		/**
		 * Draw at position n the shapemarker. <br />
		 * A decimal number is possible for interpolation.
		 * 
		 * @param n
		 *            value >= 0
		 * 
		 * @return {@link IDataPoint}
		 * 
		 * @throws IllegalArgumentException
		 *             if n < 0;
		 */
		public static IDataPoint newDrawPoint(final float n) {

			if (n < 0)
				throw new IllegalArgumentException("n can not be < 0");
			return new IDataPoint() {

				public String getAppendableString() {

					return String.valueOf(n);
				}

				public String getPrefix() {

					return null;
				}

				public boolean isPrefixRequiered() {

					return false;
				}

			};
		};

		/**
		 * Draws a shapemarker every nth point were low is the lower bound and
		 * high the higher bound.
		 * 
		 * @param low
		 *            first datapoint in range
		 * @param high
		 *            last datapoint in range
		 * @param n
		 *            every nth datapoint, value >= 0
		 * 
		 * @return {@link IDataPoint}
		 * 
		 * @throws IllegalArgumentException
		 *             if < 0 and/or high < low
		 */
		public static IDataPoint newDrawNPoint(final int low, final int high,
				final int n) {

			if (high < low)
				throw new IllegalArgumentException("high can not be < low");
			if (n < 0)
				throw new IllegalArgumentException("n can not be < 0");

			return new IDataPoint() {

				public String getAppendableString() {

					StringBuilder builder = new StringBuilder();
					builder.append(low);
					builder.append(":");
					builder.append(high);
					builder.append(":");
					builder.append(n);

					return builder.toString();
				}

				public String getPrefix() {

					return null;
				}

				public boolean isPrefixRequiered() {

					return false;
				}

			};

		}

		/**
		 * Draw a shapemaker at the specified point (x,y). <br />
		 * Where 0:0 is the bottom left corner and 1:1 is the top right corner
		 * and 0.5:.5 the center.
		 * 
		 * @param x
		 *            value between(inclusive) 0 and 1
		 * @param y
		 *            value between(inclusive) 0 and 1
		 * 
		 * @return {@link IDataPoint}
		 * 
		 * @throws IllegalArgumentException
		 *             if x and/or y , < 0 and/or > 0
		 */
		public static IDataPoint newDrawSpecificPoint(final float x, final float y) {

			if (x < 0 || x > 1)
				throw new IllegalArgumentException(
						"x can not be < 0 and/or > 1");
			if (y < 0 || y > 1)
				throw new IllegalArgumentException(
						"y can not be < 0 and/or > 1");

			return new IDataPoint() {

				public String getAppendableString() {

					StringBuilder builder = new StringBuilder();

					builder.append(x);
					builder.append(":");
					builder.append(y);

					return builder.toString();

				}

				public String getPrefix() {

					return "@";
				}

				public boolean isPrefixRequiered() {

					return true;
				}

			};

		}

		/**
		 * To draw a horizontal line. <br />
		 * Specify a floating point number for the location of the line, where
		 * 0.0 is the bottom of the chart, and 1.0 is the top of the chart. <br />
		 * <b>NOTE</b> <br />
		 * This makes only sense with v oder V {@link MarkerTyp #VerticalLineTo} or
		 * {@link MarkerTyp #VerticalLineFrom}
		 * 
		 * @param n
		 *            value between(inclusive) 0 and 1
		 * 
		 * @return {@link IDataPoint}
		 * 
		 * @throws IllegalArgumentException
		 *             if n < 0 
		 */
		public static IDataPoint newDrawHorizontalLine(final float n) {

			
			if (n < 0)
				throw new IllegalArgumentException(
						"n can not be < 0 and/or > 1");

			return new IDataPoint() {

				public String getAppendableString() {

					return String.valueOf(n);
				}

				public String getPrefix() {

					return null;
				}

				public boolean isPrefixRequiered() {

					return false;
				}

			};
		}
	}

	/**
	 * Interface for the {@link DataPoint} factory, it is used for the
	 * {@link ShapeMarker}.
	 * 
	 * @author steffan
	 * 
	 */
	public interface IDataPoint {

		/**
		 * The method build the complete datapoint string.
		 * 
		 * @return the complete and appendable string
		 */
		public String getAppendableString();

		/**
		 * Check if this datapoint needs a prefix.
		 * 
		 * @return true if required
		 */
		public boolean isPrefixRequiered();

		/**
		 * If prefix was set, the method returns the character, if no prefix is
		 * required the method return {@code null}.
		 * 
		 * @return the prefix or {@code null}
		 */
		public String getPrefix();

	}

}
