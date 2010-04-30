/**
 * 
 */
package de.toolforge.googlechartwrapper.label;

import java.util.ArrayList;
import java.util.List;

import de.toolforge.googlechartwrapper.ChartTypeFeature;
import de.toolforge.googlechartwrapper.Color;
import de.toolforge.googlechartwrapper.util.AppendableFeature;
import de.toolforge.googlechartwrapper.util.IFeatureAppender;
import de.toolforge.googlechartwrapper.util.MiscUtils;

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
	private Number number;
	private int size;
	private String labelContent;
	private boolean isContentNumber = false;

	/**
	 * Constructs a new {@link DataPointLabel}. Use this constructor for plain text and flags.
	 * 
	 * @param labelType {@link LabelType} choose flag or plain text, if you want to use a number see {@link #DataPointLabel(Number, Color, int, IDataPoint, int, Priority)}
	 * @param labelContent the string to show
	 * @param color color of the text
	 * @param dataSetIndex value &gt;= 0 
	 * @param dataPoint see {@link DataPoint}
	 * @param size the size in pixel
	 * 
	 * @see DataPoint 
	 * 
	 * @throws IllegalArgumentException
	 *             if labelContent is {@code null}
	 * @throws IllegalArgumentException
	 *             if color is {@code null}
	 * @throws IllegalArgumentException
	 *             if dataSetindex is &lt; 0
	 * @throws IllegalArgumentException
	 *             if dataPoint is {@code null}
	 * @throws IllegalArgumentException
	 *             if size is &lt; 0
	 * @throws IllegalArgumentException
	 *             if labelType is {@code null}
	 * @throws IllegalArgumentException
	 *             if priority is {@code null}
	 */
	public DataPointLabel(LabelType labelType, String labelContent,
			Color color, int dataSetIndex, IDataPoint dataPoint, int size, Priority priority) {
		
		if (labelContent == null)
			throw new IllegalArgumentException("labelContent can not be null");
		if (labelType == null)
			throw new IllegalArgumentException("labelType can not be null");
		if (color == null)
			throw new IllegalArgumentException("color can not be null");
		if (dataSetIndex < 0)
			throw new IllegalArgumentException("dataSetIndex can not be < 0");
		if (dataPoint == null)
			throw new IllegalArgumentException("dataPoint can not be null");
		if (size < 0)
			throw new IllegalArgumentException("size can not be < 0");
		if (priority == null)
			throw new IllegalArgumentException("priority can not be null");
		
		
		this.labelType = labelType;
		this.labelContent = labelContent;
		this.color = color;
		this.dataSetIndex = dataSetIndex;
		this.dataPoint = dataPoint;
		this.size = size;
		this.priority = priority;
	}
	
	/**
	 * Constructs a new {@link DataPointLabel}. Use this constructor for plain text and flags.
	 * 
	 * @param labelType {@link LabelType} choose flag or plain text, if you want to use a number see {@link #DataPointLabel(Number, Color, int, IDataPoint, int, Priority)}
	 * @param labelContent the string to show
	 * @param color color of the text
	 * @param dataSetIndex value &gt;= 0 
	 * @param dataPoint see {@link DataPoint}
	 * @param size the size in pixel
	 * 
	 * @see DataPoint 
	 * 
	 * @throws IllegalArgumentException
	 *             if labelContent is {@code null}
	 * @throws IllegalArgumentException
	 *             if color is {@code null}
	 * @throws IllegalArgumentException
	 *             if dataSetindex is &lt; 0
	 * @throws IllegalArgumentException
	 *             if dataPoint is {@code null}
	 * @throws IllegalArgumentException
	 *             if size is &lt; 0
	 * @throws IllegalArgumentException
	 *             if labelType is {@code null}
	 * @throws IllegalArgumentException
	 *             if priority is {@code null}
	 */
	public DataPointLabel(LabelType labelType, String labelContent,
			java.awt.Color color, int dataSetIndex, IDataPoint dataPoint, int size, Priority priority) {
		
		if (labelContent == null)
			throw new IllegalArgumentException("labelContent can not be null");
		if (labelType == null)
			throw new IllegalArgumentException("labelType can not be null");
		if (color == null)
			throw new IllegalArgumentException("color can not be null");
		if (dataSetIndex < 0)
			throw new IllegalArgumentException("dataSetIndex can not be < 0");
		if (dataPoint == null)
			throw new IllegalArgumentException("dataPoint can not be null");
		if (size < 0)
			throw new IllegalArgumentException("size can not be < 0");
		if (priority == null)
			throw new IllegalArgumentException("priority can not be null");
		
		
		this.labelType = labelType;
		this.labelContent = labelContent;
		this.color = new Color(color);
		this.dataSetIndex = dataSetIndex;
		this.dataPoint = dataPoint;
		this.size = size;
		this.priority = priority;
	}


	/**
	 * Constructs a new {@link DataPointLabel}. This constructor creates new
	 * {@link DataPointLabel} with a {@link Number} as label content.
	 * 
	 * @param number to build a number use the number builder, e.g. {@link CurrencyValueNumberBuilder} or {@link FloatingPointNumberBuilder}
	 * @param color the color
	 * @param dataSetIndex value &gt;= 0
	 * @param dataPoint see {@link DataPoint}
	 * @param size the size in pixel
	 * @param priority {@link Priority}
	 * 
	 * @see DataPoint
	 * @see CurrencyValueNumberBuilder
	 * @see FloatingPointNumberBuilder
	 * @see PercentageValueNumberBuilder
	 * @see ScientificNotationNumberBuilder
	 * 
	 * @throws IllegalArgumentException
	 *             if number is {@code null}
	 * @throws IllegalArgumentException
	 *             if color is {@code null}
	 * @throws IllegalArgumentException
	 *             if dataSetindex is &lt; 0
	 * @throws IllegalArgumentException
	 *             if dataPoint is {@code null}
	 * @throws IllegalArgumentException
	 *             if size is &lt; 0
	 * @throws IllegalArgumentException
	 *             if priority is {@code null}
	 */
	public DataPointLabel(Number number, Color color, int dataSetIndex,
			IDataPoint dataPoint, int size, Priority priority) {

		if (number == null)
			throw new IllegalArgumentException("number can not be null");
		if (color == null)
			throw new IllegalArgumentException("color can not be null");
		if (dataSetIndex < 0)
			throw new IllegalArgumentException("dataSetIndex can not be < 0");
		if (dataPoint == null)
			throw new IllegalArgumentException("dataPoint can not be null");
		if (size < 0)
			throw new IllegalArgumentException("size can not be < 0");
		if (priority == null)
			throw new IllegalArgumentException("priority can not be null");

		this.number = number;
		this.color = color;
		this.dataSetIndex = dataSetIndex;
		this.dataPoint = dataPoint;
		this.size = size;
		this.priority = priority;
		this.isContentNumber = true;
	}
	
	/**
	 * Constructs a new {@link DataPointLabel}. This constructor creates new
	 * {@link DataPointLabel} with a {@link Number} as label content.
	 * 
	 * @param number to build a number use the number builder, e.g. {@link CurrencyValueNumberBuilder} or {@link FloatingPointNumberBuilder}
	 * @param color the color
	 * @param dataSetIndex value &gt;= 0
	 * @param dataPoint see {@link DataPoint}
	 * @param size the size in pixel
	 * @param priority {@link Priority}
	 * 
	 * @see DataPoint
	 * @see CurrencyValueNumberBuilder
	 * @see FloatingPointNumberBuilder
	 * @see PercentageValueNumberBuilder
	 * @see ScientificNotationNumberBuilder
	 * 
	 * @throws IllegalArgumentException
	 *             if number is {@code null}
	 * @throws IllegalArgumentException
	 *             if color is {@code null}
	 * @throws IllegalArgumentException
	 *             if dataSetindex is &lt; 0
	 * @throws IllegalArgumentException
	 *             if dataPoint is {@code null}
	 * @throws IllegalArgumentException
	 *             if size is &lt; 0
	 * @throws IllegalArgumentException
	 *             if priority is {@code null}
	 */
	public DataPointLabel(Number number, java.awt.Color color, int dataSetIndex,
			IDataPoint dataPoint, int size, Priority priority) {

		if (number == null)
			throw new IllegalArgumentException("number can not be null");
		if (color == null)
			throw new IllegalArgumentException("color can not be null");
		if (dataSetIndex < 0)
			throw new IllegalArgumentException("dataSetIndex can not be < 0");
		if (dataPoint == null)
			throw new IllegalArgumentException("dataPoint can not be null");
		if (size < 0)
			throw new IllegalArgumentException("size can not be < 0");
		if (priority == null)
			throw new IllegalArgumentException("priority can not be null");

		this.number = number;
		this.color = new Color(color);
		this.dataSetIndex = dataSetIndex;
		this.dataPoint = dataPoint;
		this.size = size;
		this.priority = priority;
		this.isContentNumber = true;
	}

	public List<AppendableFeature> getAppendableFeatures(
			List<? extends IFeatureAppender> otherAppenders) {

		StringBuilder builder = new StringBuilder();

		if (!isContentNumber) {
			builder.append(labelType.getLabelTypeChar());
			builder.append(labelContent);
		}
		if (isContentNumber) {
			builder.append("N");
			builder.append(number.getLabelContent());
		}

		builder.append(",");
		builder.append((color.getMatchingColorHexValue()));
		builder.append(",");
		builder.append(dataSetIndex);
		builder.append(",");
		builder.append(dataPoint.getAppendableString());
		builder.append(",");
		builder.append(size);
		builder.append(",");
		builder.append(priority.getPriority());

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
	 * To construct a obeject see {@link DataPoint}.
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

	/**
	 * To build a special number use one of the builder.
	 * 
	 * @author steffan
	 * 
	 * @see CurrencyValueNumberBuilder
	 * @see FloatingPointNumberBuilder
	 * @see PercentageValueNumberBuilder
	 * @see ScientificNotationNumberBuilder
	 *
	 * 
	 */
	public static class Number {

		protected AbstractNumberBuilder builder;

		/**
		 * Constructs a new number. Use the builder pattern for a new number.
		 * 
		 * @param builder
		 * 
		 * @throws {@link IllegalArgumentException} if builder is {@code null}
		 */
		public Number(AbstractNumberBuilder builder) {
			
			if(builder == null)
			throw new IllegalArgumentException("builder can not be null");
			
			this.builder = builder;
		}
		/**
		 * This method is used to build the hole {@link DataPointLabel} string.
		 * 
		 * @return the complete string, which defines the number 
		 */
		public String getLabelContent() {

			return builder.getLabelContent();
		}

	}

	/**
	 * 
	 * @author steffan
	 * 
	 * @see CurrencyValueNumberBuilder
	 * @see FloatingPointNumberBuilder
	 * @see PercentageValueNumberBuilder
	 * @see ScientificNotationNumberBuilder
	 *
	 */
	public static abstract class AbstractNumberBuilder {

		protected String before = null;
		protected String after = null;
		protected int precisionLevel;
		protected boolean displayTrailingZeros = false;
		protected boolean displayGroupSeparator = false;
		protected boolean displayXCoordinate = false;
		protected boolean displayYCoordiante = false;

		/**
		 * Constructs a new number.
		 * 
		 * @param precisionLevel an integer that specifies how many decimal places are used
		 * 
		 * @throws IllegalArgumentException if precisionLevel is < 0
		 */
		public AbstractNumberBuilder(int precisionLevel) {

			if (precisionLevel < 0)
				throw new IllegalArgumentException(
						"precisionLevel can not be < 0");
			this.precisionLevel = precisionLevel;
		}

		/**
		 * Set the text which stands before the number.
		 * 
		 * @param before text before the number
		 * @return {@link AbstractNumberBuilder}
		 */
		public AbstractNumberBuilder textBefore(String before) {

			this.before = before;

			return this;
		}
		/**
		 * Set the text which stands after the number-
		 * 
		 * @param after the text after the number
		 * @return {@link AbstractNumberBuilder}
		 */
		public AbstractNumberBuilder textAfter(String after) {

			this.after = after;

			return this;
		}
		/**
		 * Call this method to displays trailing zeros.
		 * 
		 * @return {@link AbstractNumberBuilder}
		 */
		public AbstractNumberBuilder displayTrailingZeros() {
			this.displayTrailingZeros = true;
			return this;
		}
		/**
		 * Call this method to displays group separators.
		 * @return {@link AbstractNumberBuilder}
		 */
		public AbstractNumberBuilder displayGroupSeparator() {
			this.displayGroupSeparator = true;
			return this;
		}
		/**
		 * Call this method to display the value of the x-coordinate at the chosen data point.
		 * 
		 * @return {@link AbstractNumberBuilder}
		 */
		public AbstractNumberBuilder displayXCoordinateValue() {
			this.displayXCoordinate = true;
			this.displayYCoordiante = false;
			return this;
		}
		/**
		 * Call this method to display the value of the y-coordinate at the chosen data point.
		 * 
		 * @return {@link AbstractNumberBuilder}
		 */
		public AbstractNumberBuilder displayYCoordinateValue() {
			this.displayXCoordinate = false;
			this.displayXCoordinate = true;
			return this;
		}

		protected abstract String getLabelContent();
		
		/**
		 * The last method to call. This call build the object.
		 * 
		 * @return the new {@link Number} instance
		 */
		public abstract Number build();

	}

	/**
	 * Use this class to build a FloatingPointNumber. To create the object call {@link #build()}
	 * 
	 * @author steffan
	 *
	 */
	public static class FloatingPointNumberBuilder extends
			AbstractNumberBuilder {

		private final NumberType numberType = NumberType.FloatingPoint;

		public FloatingPointNumberBuilder(int precisionLevel) {
			super(precisionLevel);

		}

		public Number build() {
			return new Number(this);

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
	/**
	 * Use this class to build a ScientificNotationNumber. To create the object call {@link #build()}
	 * 
	 * @author steffan
	 *
	 */
	public static class ScientificNotationNumberBuilder extends
			AbstractNumberBuilder {

		private final NumberType numberType = NumberType.Scientific;

		public ScientificNotationNumberBuilder(int precisionLevel) {
			super(precisionLevel);

		}

		public Number build() {
			return new Number(this);

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
	
	/**
	 * Use this class to build a PercentageValueNumber. To create the object call {@link #build()}
	 * 
	 * @author steffan
	 *
	 */
	public static class PercentageValueNumberBuilder extends
			AbstractNumberBuilder {

		private NumberType numberType = NumberType.PercentageValue;

		public PercentageValueNumberBuilder(int precisionLevel) {
			super(precisionLevel);

		}

		@Override
		public Number build() {

			return new Number(this);
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
	
	/**
	 * Use this class to build a CurrencyValueNumber. To create the object call {@link #build()}
	 * 
	 * @author steffan
	 *
	 */
	public static class CurrencyValueNumberBuilder extends
			AbstractNumberBuilder {

		private NumberType numberType = NumberType.Currency;
		private String currency;

		/**
		 *  
		 * @param precisionLevel
		 * @param currency e.g. EUR or USD
		 * 
		 * @throws IllegalArgumentException if currency is {@code null}
		 */
		public CurrencyValueNumberBuilder(int precisionLevel, String currency) {
			super(precisionLevel);

			if (currency == null)
				throw new IllegalArgumentException("currency can not be null");

			this.currency = currency;
		}

		@Override
		public Number build() {

			return new Number(this);
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

	/*
	 * public static class FloatingPointNumber extends AbstractNumber {
	 * 
	 * private AbstractNumberBuilder builder;
	 * 
	 * public FloatingPointNumber(AbstractNumberBuilder builder) {
	 * super(builder); this.builder = builder; }
	 * 
	 * @Override protected String getLabelContent() {
	 * 
	 * return builder.getLabelContent(); } }
	 * 
	 * public static class CurrencyValueNumber extends AbstractNumber {
	 * 
	 * private AbstractNumberBuilder builder;
	 * 
	 * public CurrencyValueNumber(AbstractNumberBuilder builder) {
	 * super(builder); this.builder = builder; }
	 * 
	 * @Override protected String getLabelContent() {
	 * 
	 * return builder.getLabelContent(); } } public static class
	 * PercentageValueNumber extends AbstractNumber{
	 * 
	 * 
	 * public PercentageValueNumber(AbstractNumberBuilder builder) {
	 * super(builder);
	 * 
	 * }
	 * 
	 * @Override protected String getLabelContent() { 
	 * return builder.getLabelContent(); }
	 * 
	 * }
	 */

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

		/**
		 * specifies that the label is drawn before all other parts of the
		 * chart. The label will be hidden if another chart element is drawn in
		 * the same place.
		 */
		First(-1),
		/**
		 * specifies that the label is drawn after bars or lines, but before
		 * other labels.
		 */
		Default(0),
		/**
		 * specifies that the label is drawn after all other parts of the chart.
		 * If more than one label has this value, the first one specified in the
		 * chm parameter will be drawn first, the second one specified in the
		 * chm parameter will be drawn second, and so on.
		 */
		Last(1);

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
