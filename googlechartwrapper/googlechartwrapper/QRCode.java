package googlechartwrapper;

import googlechartwrapper.coder.IEncoder;

import java.awt.Dimension;

/**
 * 
 * Specifies a qrcodes <a href="http://code.google.com/intl/de-DE/apis/chart/types.html#qrcodes">
 * http://code.google.com/intl/de-DE/apis/chart/types.html#qrcodes</a>
 * 
 * @author steffan
 * 
 */
public class QRCode extends AbstractChart {

	private String textToEncode;
	private ECLevel ecLevel = null;
	private int margin = 4;
	private OutputEncoding outputEncoding = OutputEncoding.UTF8;

	/**
	 * 
	 * @param chartDimension
	 * @param textToEncode
	 * 
	 * @throws IllegalArgumentException
	 */
	public QRCode(Dimension chartDimension, String textToEncode) {
		super(new Dimension(chartDimension));

		if (textToEncode == null)
			throw new IllegalArgumentException("textToEncode can not be null");

		this.textToEncode = textToEncode;
	}

	/**
	 * 
	 * @param chartDimension
	 * @param textToEncode
	 * @param ecLevel
	 * @param margin
	 * 
	 * @throws IllegalArgumentException
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
	 * @throws IllegalArgumentException
	 */
	public void setTextToEncode(String textToEncode) {

		if (textToEncode == null)
			throw new IllegalArgumentException("textToEncode can not be null");

		this.textToEncode = textToEncode;
	}

	/**
	 * @param ecLevel
	 *            the ecLevel to set
	 * 
	 * @throws IllegalArgumentException
	 */
	public void setEcLevel(ECLevel ecLevel) {

		if (ecLevel == null)
			throw new IllegalArgumentException("ecLevel can not be null");

		this.ecLevel = ecLevel;
	}

	/**
	 * @return the ecLevel
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

	public IEncoder getEncoder() {

		return null;
	}

	/**
	 * @return the outputEncoding
	 */
	public OutputEncoding getOutputEncoding() {
		return outputEncoding;
	}

	/**
	 * @param outputEncoding
	 *            the outputEncoding to set
	 * 
	 * @throws IllegalArgumentException
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
		builder.append(this.textToEncode);

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

		public String getEncoding() {
			return this.encoding;
		}

	}

	/**
	 * 
	 * @author steffan
	 * 
	 */
	public enum ECLevel {

		Low('L'), Medium('M'), Quality('Q'), High('H');

		private char level;

		private ECLevel(char level) {
			this.level = level;
		}

		public char getLevel() {
			return this.level;
		}
	}

}
