/**
 * 
 */
package googlechartwrapper.label;

import googlechartwrapper.ChartTypeFeature;
import googlechartwrapper.util.AppendableFeature;
import googlechartwrapper.util.IFeatureAppender;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Specifies a Data point label <a
 * href="http://code.google.com/apis/chart/labels.html#data_point_labels">
 * http://code.google.com/apis/chart/labels.html#data_point_labels</a>
 * 
 * @author steffan
 * 
 */
public class DataPointLabel implements IFeatureAppender {

	private LabelType labelType;
	private Color color;
	private int dataSetIndex;
	private IDataPoint dataPoint;
	private Priority priority;
	private AbstractNumber number;
	private int size;

	public DataPointLabel(LabelType labelType, String labelContent,
			Color color, int dataSetIndex, IDataPoint dataPoint, int size) {
		// TODO Auto-generated constructor stub
	}

	public DataPointLabel(AbstractNumber number, Color color, int dataSetIndex,
			IDataPoint dataPoint, int size, Priority priority) {

		this.number = number;
		this.color = color;
		this.dataSetIndex = dataSetIndex;
		this.dataPoint = dataPoint;
		this.size = size;
		this.priority = priority;
	}	

	public List<AppendableFeature> getAppendableFeatures(
			List<? extends IFeatureAppender> otherAppenders) {

		StringBuilder builder = new StringBuilder();

		builder.append(number.getLabelContent());

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
	public enum LabelType {

		Flag('a'), PlainText('t');/* Number('N'); */

		private char labelTypeChar;

		LabelType(char labelTypeChar) {
			this.labelTypeChar = labelTypeChar;
		}

		public char getLabelTypeChar() {
			return this.labelTypeChar;
		}
	}

	/**
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

	public static abstract class AbstractNumber {

		public AbstractNumber(AbstractNumberBuilder builder) {
			// TODO Auto-generated constructor stub
		}

		protected abstract String getLabelContent();

	}

	public static abstract class AbstractNumberBuilder {

		protected String before = null;
		protected String after = null;
		protected int precisionLevel;
		protected boolean displayTrailingZeros = false;
		protected boolean displayGroupSeparator = false;
		protected boolean displayXCoordinate = false;
		protected boolean displayYCoordiante = false;

		public AbstractNumberBuilder(int precisionLevel) {

			if (precisionLevel < 0)
				throw new IllegalArgumentException(
						"precisionLevel can not be < 0");
			this.precisionLevel = precisionLevel;
		}

		public AbstractNumberBuilder textBefore(String before) {

			this.before = before;

			return this;
		}

		public AbstractNumberBuilder textAfter(String after) {

			this.after = after;

			return this;
		}

		public AbstractNumberBuilder displayTrailingZeros() {
			this.displayTrailingZeros = true;
			return this;
		}

		public AbstractNumberBuilder displayGroupSeparator() {
			this.displayGroupSeparator = true;
			return this;
		}

		public AbstractNumberBuilder displayXCoordinateValue() {
			this.displayXCoordinate = true;
			this.displayYCoordiante = false;
			return this;
		}

		public AbstractNumberBuilder displayYCoordinateValue() {
			this.displayXCoordinate = false;
			this.displayXCoordinate = true;
			return this;
		}

		protected abstract String getLabelContent();

		public abstract AbstractNumber build();

	}

	public static class FloatingPointNumberBuilder extends
			AbstractNumberBuilder {

		private final NumberType numberType = NumberType.FloatingPoint;

		public FloatingPointNumberBuilder(int precisionLevel) {
			super(precisionLevel);

		}

		public AbstractNumber build() {
			return new FloatingPointNumber(this);

		}

		@Override
		protected String getLabelContent() {

			StringBuilder builder = new StringBuilder();

			if (before != null) {
				builder.append(before);
			}
			builder.append("*");
			builder.append(numberType.getLabelTypeChar());
			builder.append(precisionLevel);
			if (displayTrailingZeros) {
				builder.append("z");
			}
			if (displayGroupSeparator) {
				builder.append("s");
			}
			if (displayXCoordinate) {
				builder.append("x");
			}
			if (displayYCoordiante) {
				builder.append("y");
			}
			builder.append("*");
			if (after != null) {
				builder.append(after);
			}

			return builder.toString();
		}

	}

	public static class CurrencyValueNumberBuilder extends
			AbstractNumberBuilder {

		private NumberType numberType = NumberType.Currency;
		private String currency;

		public CurrencyValueNumberBuilder(int precisionLevel, String currency) {
			super(precisionLevel);

			if (currency == null)
				throw new IllegalArgumentException("currency can not be null");

			this.currency = currency;
		}

		@Override
		public AbstractNumber build() {

			return new CurrencyValueNumber(this);
		}

		@Override
		protected String getLabelContent() {
			StringBuilder builder = new StringBuilder();

			if (before != null) {
				builder.append(before);
			}
			builder.append("*");
			builder.append(numberType.getLabelTypeChar());
			builder.append(currency);
			builder.append(precisionLevel);
			if (displayTrailingZeros) {
				builder.append("z");
			}
			if (displayGroupSeparator) {
				builder.append("s");
			}
			if (displayXCoordinate) {
				builder.append("x");
			}
			if (displayYCoordiante) {
				builder.append("y");
			}
			builder.append("*");
			if (after != null) {
				builder.append(after);
			}

			return builder.toString();
		}
	}

	public static class FloatingPointNumber extends AbstractNumber {

		private AbstractNumberBuilder builder;

		public FloatingPointNumber(AbstractNumberBuilder builder) {
			super(builder);
			this.builder = builder;
		}

		@Override
		protected String getLabelContent() {

			return builder.getLabelContent();
		}
	}

	public static class CurrencyValueNumber extends AbstractNumber {

		private AbstractNumberBuilder builder;

		public CurrencyValueNumber(AbstractNumberBuilder builder) {
			super(builder);
			this.builder = builder;
		}

		@Override
		protected String getLabelContent() {

			return builder.getLabelContent();
		}
	}

	/**
	 * 
	 * @author steffan
	 * 
	 */
	public enum NumberType {

		FloatingPoint('f'), PercentageValue('p'), Currency('c'), Scientific('e');

		private char numberTypeChar;

		NumberType(char numberTypeChar) {
			this.numberTypeChar = numberTypeChar;
		}

		public char getLabelTypeChar() {
			return this.numberTypeChar;
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
	 * {@link DataPointLabel} constructor, which needs an {@link IDataPoint}
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
		 * The {@link DataPointLabel} will be set on every datapoint.
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
		 * The {@link DataPointLabel} will be drawn every nth datapoint
		 * 
		 * @param n
		 *            the nth position
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
		 * The {@link DataPointLabel} will be drawn at the nth datapoint
		 * 
		 * @param n
		 *            the position
		 * @return {@link IDataPoint}
		 * 
		 * @throws IllegalArgumentException
		 *             if n is < 0
		 */
		public static IDataPoint newDrawPoint(final int n) {

			if (n < 0)
				throw new IllegalArgumentException("n can not < 0");

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
		 * Draws a {@link DataPointLabel} every nth point were low is the lower
		 * bound and high the higher bound.
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

	}

}
