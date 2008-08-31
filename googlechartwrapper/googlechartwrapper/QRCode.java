package googlechartwrapper;

import java.awt.Dimension;

/**
 * 
 * Specifies a bar chart <a href="http://code.google.com/apis/chart/#qrcodes">
 * http://code.google.com/apis/chart/#qrcodes</a>
 * 
 * @author steffan
 * 
 */
public class QRCode extends AbstractChart {

	public QRCode(Dimension chartDimension) {
		super(chartDimension);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ChartType getChartType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getUrlChartType() {
		// TODO Auto-generated method stub
		return null;
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

}
