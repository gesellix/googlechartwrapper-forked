package googlechartwrapper.style;

import googlechartwrapper.util.IFeatureAppender;

import java.util.List;

/**
 * Specifies a GridLine <a
 * href="http://code.google.com/intl/de-DE/apis/chart/styles.html#grid>
 * http://code.google.com/intl/de-DE/apis/chart/styles.html#grid</a>
 * <br />
 * To construct a {@link GridLine}{@link #GridLine(Builder)} you have to use the builder pattern {@link Builder}.
 * 
 * @author steffan
 *  
 */

public class GridLine implements IFeatureAppender {

	private float xAxisStepSize;
	private float yAxisStepSize;
	private float lengthLineSegment;
	private float lengthBlankSegment = 0f;
	private boolean isStepSizeDefined = false;
	private boolean isOffsetDefined = false;
	private float xOffset;
	private float yOffset;

	public GridLine(Builder builder) {

		this.xAxisStepSize = builder.xAxisStepSize;
		this.yAxisStepSize = builder.yAxisStepSize;
		this.lengthLineSegment = builder.lengthLineSegment;
		this.lengthBlankSegment = builder.lengthBlankSegment;
		this.xOffset = builder.xOffset;
		this.yOffset = builder.yOffset;

		this.isStepSizeDefined = builder.isStepSizeDefined;
		this.isOffsetDefined = builder.isOffsetDefined;
	}

	/**
	 * @return the xAxisStepSize
	 */
	public float getXAxisStepSize() {
		return xAxisStepSize;
	}

	/**
	 * @param axisStepSize
	 *            the xAxisStepSize to set
	 * 
	 * @throws IllegalArgumentException
	 *             if axisStepSize < 0
	 */
	public void setXAxisStepSize(float axisStepSize) {

		if (xAxisStepSize < 0)
			throw new IllegalArgumentException("xisStepSize can not be < 0");

		xAxisStepSize = axisStepSize;
	}

	/**
	 * @return the yAxisStepSize
	 */
	public float getYAxisStepSize() {
		return yAxisStepSize;
	}

	/**
	 * @param axisStepSize
	 *            the yAxisStepSize to set
	 * 
	 * @throws IllegalArgumentException
	 *             if axisStepSize < 0
	 */
	public void setYAxisStepSize(float axisStepSize) {

		if (yAxisStepSize < 0)
			throw new IllegalArgumentException("AxisStepSize can not be < 0");

		yAxisStepSize = axisStepSize;
	}

	/**
	 * @return the lengthLineSegment
	 */
	public float getLengthLineSegment() {
		return lengthLineSegment;
	}

	/**
	 * 
	 *@param lengthLineSegment
	 *            value > 0
	 * @param lengthBlankSegment
	 *            - 0 (default) for solid line
	 * 
	 * @throws IllegalArgumentException
	 *             if lengthLineSegment < 0 and/or lengthBlankSegment < 0
	 */
	public void setLengthLineSegment(float lengthLineSegment,
			float lengthBlankSegment) {

		if (lengthBlankSegment < 0)
			throw new IllegalArgumentException(
					"lengthBlankSegement can not be < 0");
		if (lengthLineSegment < 0)
			throw new IllegalArgumentException(
					"lengthLineSegment can not be < 0");

		this.lengthLineSegment = lengthLineSegment;
		this.lengthBlankSegment = lengthBlankSegment;

		this.isStepSizeDefined = true;
	}

	/**
	 * @return the lengthBlankSegment
	 */
	public float getLengthBlankSegment() {
		return lengthBlankSegment;
	}

	/**
	 * <b>Important</b> You must also call {@link Builder}{@link #segment(float, float)}.
	 * 
	 * @param xOffset
	 * @param yOffset
	 * 
	 * @throws IllegalArgumentException
	 *             if xOffset < 0 and/or yOffset < 0
	 */
	public void setOffset(float xOffset, float yOffset) {

		if (xOffset < 0)
			throw new IllegalArgumentException("xOffset can not be < 0");
		if (yOffset < 0)
			throw new IllegalArgumentException("yOffset can not be < 0");

		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.isOffsetDefined = true;

	}

	/**
	 * @return the xOffset
	 */
	public float getXOffset() {
		return xOffset;
	}

	/**
	 * @return the yOffset
	 */
	public float getYOffset() {
		return yOffset;
	}

	public String getAppendableString(
			List<? extends IFeatureAppender> otherAppenders) {

		//because the api, needs the 2 parameters 
		if (isStepSizeDefined == false && isOffsetDefined) {
			throw new IllegalArgumentException("NOTE: you must set also the segment if you use the offset");
		}

		StringBuilder builder = new StringBuilder();

		builder.append(this.CutNumber(xAxisStepSize));
		builder.append(',');
		builder.append(this.CutNumber(yAxisStepSize));

		if (isStepSizeDefined) {

			builder.append(',');
			builder.append(this.CutNumber(lengthLineSegment));
			builder.append(',');
			builder.append(this.CutNumber(lengthLineSegment));

		}
		if (isOffsetDefined) {

			builder.append(',');
			builder.append(this.CutNumber(xOffset));
			builder.append(',');
			builder.append(this.CutNumber(yOffset));

		}
		return builder.toString();
	}

	/**
	 * 
	 * @param number
	 * @return
	 */
	private String CutNumber(float number) {

		String s = Float.toString(number);

		int i = s.indexOf(".");

		// cut decimal place
		if (s.length() > i) {
			return s.substring(0, i + 2);
		}
		return s;
	}

	/**
	 * Provides the builder, necessary for {@link GridLine#GridLine(Builder)}.
	 * 
	 * @author steffan
	 * 
	 */
	public static class Builder {

		// required
		private float xAxisStepSize;
		private float yAxisStepSize;
		// optional
		private float lengthLineSegment;
		private float lengthBlankSegment = 0f;
		private boolean isStepSizeDefined = false;

		private float xOffset;
		private float yOffset;
		private boolean isOffsetDefined = false;

		/**
		 * Constructs the grid line. <br />
		 * Note parameters only have a single decimal place, if the are longer,
		 * they will be cut.
		 * 
		 * @param xAxisStepSize
		 *            value >= 0
		 * @param yAxisStepSize
		 *            value >= 0
		 * 
		 * @throws IllegalArgumentException
		 *             if xAxisStepSize < 0 and/or yAxisStepSize < 0
		 */
		public Builder(float xAxisStepSize, float yAxisStepSize) {

			if (xAxisStepSize < 0)
				throw new IllegalArgumentException(
						"xAxisStepSize can not be < 0");
			if (yAxisStepSize < 0)
				throw new IllegalArgumentException(
						"yAxisStepSize can not be < 0");

			this.xAxisStepSize = xAxisStepSize;
			this.yAxisStepSize = yAxisStepSize;
		}

		/**
		 * Adds the segment.
		 * 
		 * Note parameters have only a single decimal place, if the are longer,
		 * they will be cut.
		 * 
		 * @param lengthLineSegment
		 *            value > 0
		 * @param lengthBlankSegment
		 *            - 0 (default) for solid line
		 * @return {@link Builder}
		 * 
		 * @throws IllegalArgumentException
		 *             if lengthLineSegment < 0 and/or lengthBlankSegment < 0
		 */
		public Builder segment(float lengthLineSegment, float lengthBlankSegment) {

			if (lengthBlankSegment < 0)
				throw new IllegalArgumentException(
						"lengthBlankSegement can not be < 0");
			if (lengthLineSegment < 0)
				throw new IllegalArgumentException(
						"lengthLineSegment can not be < 0");

			this.isStepSizeDefined = true;

			this.lengthLineSegment = lengthLineSegment;
			this.lengthBlankSegment = lengthBlankSegment;
			return this;
		}

		/**
		 * Adds the offset.
		 * 
		 * Note parameters have only a single decimal place, if the are longer,
		 * they will be cut. <br />
		 * <b>Important</b> You must also call {@link Builder}{@link #segment(float, float)}.
		 * 
		 * 
		 * @param xOffset
		 *            value >= 0
		 * @param yOffset
		 *            value >= 0
		 * @return {@link Builder}
		 * 
		 * @throws IllegalArgumentException
		 *             if xOffset < 0 and/or yOffset < 0
		 */
		public Builder offset(float xOffset, float yOffset) {

			if (xOffset < 0)
				throw new IllegalArgumentException("xOffset can not be < 0");
			if (yOffset < 0)
				throw new IllegalArgumentException("yOffset can not be < 0");

			this.isOffsetDefined = true;
			this.xOffset = xOffset;
			this.yOffset = yOffset;
			return this;
		}

		/**
		 * Constructs the {@link GridLine} object.
		 * 
		 * @return {@link GridLine}
		 */
		public GridLine build() {
			return new GridLine(this);
		}
	}

}
