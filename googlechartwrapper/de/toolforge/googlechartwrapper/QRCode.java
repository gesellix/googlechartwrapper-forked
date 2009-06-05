package de.toolforge.googlechartwrapper;

import googlechartwrapper.coder.EncoderFactory;
import googlechartwrapper.coder.EncodingType;
import googlechartwrapper.coder.ExtendedEncoder;
import googlechartwrapper.coder.IEncoder;

import java.awt.Dimension;

/**
 * 
 * Specifies a qr code <a href="http://code.google.com/intl/de-DE/apis/chart/types.html#qrcodes">
 * http://code.google.com/intl/de-DE/apis/chart/types.html#qrcodes</a>
 * 
 * <p>
 * Here are some examples of how QRCode can be used:
 * <p><blockquote><pre>
 *     QRCode qrCode = new QRCode(new Dimension(300,300),"made in germany");
 *     
 *     QRCode qrCode = new QRCode(new Dimension(300,300),"example",ECLevel.Medium,10);     
 * </pre></blockquote>
 * <p>
 * 
 * @author steffan
 * @version 03/17/09 
 * @see ECLevel
 * @see OutputEncoding
 * 
 */
public class QRCode extends AbstractChart {

	private String textToEncode;
	private ECLevel ecLevel = null;
	private int margin = 4;
	private OutputEncoding outputEncoding = OutputEncoding.UTF8;

	/**
	 * Constructs a QRCode.
	 * 
	 * @param chartDimension
	 * @param textToEncode  the text for the QR code
	 * 
	 * @throws IllegalArgumentException if textToEncode is {@code null}
	 */
	public QRCode(Dimension chartDimension, String textToEncode) {
		super(new Dimension(chartDimension));

		if (textToEncode == null)
			throw new IllegalArgumentException("textToEncode can not be null");

		this.textToEncode = textToEncode;
	}

	/**
	 * Constructs a QRCode with {@link ECLevel}.
	 * 
	 * @param chartDimension
	 * @param textToEncode  the text for the QR code
	 * @param ecLevel
	 * @param margin defines the margin (or blank space) around the QR code
	 * 
	 * @throws IllegalArgumentException if textToEncode is {@code null}
	 * @throws IllegalArgumentException if ecLevel is {@code null}
	 * 
	 * @see ECLevel
	 * 
	 */
	public QRCode(Dimension chartDimension, String textToEncode,
			ECLevel ecLevel, int margin) {
		
		super(new Dimension(chartDimension));

		if (textToEncode == null)
			throw new IllegalArgumentException("textToEncode can not be null");
		if (ecLevel == null)
			throw new IllegalArgumentException("ecLevel can not be null");

		this.ecLevel = ecLevel;
		this.margin = margin;
		this.textToEncode = textToEncode;
	}

	/**
	 * @return the textToEncode
	 */
	public String getTextToEncode() {
		return textToEncode;
	}

	/**
	 * @param textToEncode
	 *            the textToEncode to set
	 * 
	 * @throws IllegalArgumentException if textToEncode is {@code null}
	 */
	public void setTextToEncode(String textToEncode) {

		if (textToEncode == null)
			throw new IllegalArgumentException("textToEncode can not be null");

		this.textToEncode = textToEncode;
	}

	/**
	 * Setes the ECLevel.
	 * 
	 * @param ecLevel
	 *            the ecLevel to set
	 * 
	 * @throws IllegalArgumentException if ecLevel is {@code null}
	 * @see ECLevel
	 */
	public void setEcLevel(ECLevel ecLevel) {

		if (ecLevel == null)
			throw new IllegalArgumentException("ecLevel can not be null");

		this.ecLevel = ecLevel;
	}

	/**
	 * Returns the ECLEvel.
	 * 
	 * @return the ecLevel
	 * @see ECLevel
	 */
	public ECLevel getEcLevel() {
		return ecLevel;
	}

	/**
	 * @return the margin
	 */
	public int getMargin() {
		return margin;
	}

	/**
	 * @param margin
	 *            the margin to set
	 */
	public void setMargin(int margin) {
		this.margin = margin;
	}

	@Override
	protected ChartType getChartType() {

		return ChartType.QRCode;
	}

	@Override
	protected String getUrlChartType() {

		return ChartType.QRCode.getPrefix();
	}
	
	/**
	 * Returns always {@link ExtendedEncoder}.
	 */
	public IEncoder getEncoder() {

		return EncoderFactory.getEncoder(EncodingType.TextEncoding);
	}

	/**
	 * Returns the outputEncoding.
	 * 
	 * @return the outputEncoding
	 * @see OutputEncoding
	 */
	public OutputEncoding getOutputEncoding() {
		return outputEncoding;
	}

	/**
	 * Sets the output encoding.
	 * @param outputEncoding
	 *            the outputEncoding to set
	 * 
	 * @throws IllegalArgumentException if outputEncoding is {@code null}
	 * @see OutputEncoding
	 */
	public void setOutputEncoding(OutputEncoding outputEncoding) {

		if (outputEncoding == null)
			throw new IllegalArgumentException("outputEncoding can not be null");

		this.outputEncoding = outputEncoding;
	}

	@Override
	public String getUrl() {

		StringBuilder builder = new StringBuilder();
		
		//first of all, the api
		builder.append(AbstractChart.GOOGLE_API);
		
		//size		
		builder.append("chs=");
		builder.append((int)super.chartDimension.getWidth());
		builder.append('x');
		builder.append((int)super.chartDimension.getHeight());

		//charttype
		builder.append(AbstractChart.AMPERSAND_SEPARATOR);
		builder.append("cht=qr");

		builder.append(AbstractChart.AMPERSAND_SEPARATOR);
		builder.append("chl=");
		builder.append(this.textToEncode.replaceAll(" ", "%20"));

		builder.append(AbstractChart.AMPERSAND_SEPARATOR);
		builder.append("choe=");
		builder.append(this.outputEncoding.getEncoding());

		// only if ecLevel is set
		if (this.ecLevel != null) {

			builder.append(AbstractChart.AMPERSAND_SEPARATOR);
			builder.append("chld=");
			builder.append(this.ecLevel.getLevel());
			builder.append('|');
			builder.append(this.margin);
		}

		return builder.toString();

	}

	/**
	 * 
	 * @author steffan
	 * 
	 */
	public enum OutputEncoding {

		UTF8("UTF-8"),

		Shift_JIS("Shift_JIS"),

		ISO("ISO-8859-1");

		private String encoding;

		OutputEncoding(String encoding) {
			this.encoding = encoding;
		}
		/**
		 * Returns the encoding, e.g. UTF-8 
		 * 
		 * @return the encoding
		 */
		public String getEncoding() {
			return this.encoding;
		}

	}

	/**
	 * Four levels of error correction (EC) are available. 
	 *  <br />
	 *  <br />
	 *  low 	 allows 7% of a QR code to be restored <br />
     *  medium 	 allows 15% of a QR code to be restored <br />
	 *	quality	 allows 25% of a QR code to be restored <br />
	 *	high	 allows 30% of a QR code to be restored <br />
	 * 
	 * @author steffan
	 * 
	 */
	public enum ECLevel {

		/**
		 * 7%
		 */
		Low('L'), 
		/**
		 * 15%
		 */
		Medium('M'),
		/**
		 * 25%
		 */
		Quality('Q'), 
		/**
		 * 30%
		 */
		High('H');

		private char level;

		private ECLevel(char level) {
			this.level = level;
		}
		
		/**
		 * Returns the ECLevel, e.g. L for low.
		 * 
		 * @return the ECLvele char
		 */
		public char getLevel() {
			return this.level;
		}
	}

}
