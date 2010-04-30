package de.toolforge.googlechartwrapper;


/**
 * Own implementation of a chart color to support environments where the
 * java.awt.Color class is not available. If a java.awt.color object exists it
 * may be wrapped using the public constructor with a color object parameter.
 * The implementation is partially based on the original java.awt.Color
 * class by Sun.
 * (see issue 20)
 * @author martin
 * 
 */
public class Color {

	private int red, green, blue, transparency;
	private int value;

	public Color(int r, int g, int b, int a) {
		value = ((a & 0xFF) << 24) | ((r & 0xFF) << 16) | ((g & 0xFF) << 8)
				| ((b & 0xFF) << 0);

		testColorValueRange(r, g, b, a);
		red = r;
		green = g;
		blue = b;
		transparency = a;
	}
	
	public Color (int r, int g, int b){
		this (r,g,b,255);
	}
	
	public Color (java.awt.Color c){
		this(c.getRed(), c.getGreen(), c.getBlue(), c.getTransparency());
	}
	
	public java.awt.Color toAwtColor (){
		return new java.awt.Color(red, green, blue, transparency);
	}

	/**
	 * Checks the color integer components supplied for validity. Throws an
	 * {@link IllegalArgumentException} if the value is out of range. From:
	 * 
	 * @param r  the Red component
	 * @param g  the Green component
	 * @param b  the Blue component
	 * @param a  the alpha/transparency component
	 **/
	private static void testColorValueRange(int r, int g, int b, int a) {
		boolean rangeError = false;
		String badComponentString = "";

		if (a < 0 || a > 255) {
			rangeError = true;
			badComponentString = badComponentString + " Alpha";
		}
		if (r < 0 || r > 255) {
			rangeError = true;
			badComponentString = badComponentString + " Red";
		}
		if (g < 0 || g > 255) {
			rangeError = true;
			badComponentString = badComponentString + " Green";
		}
		if (b < 0 || b > 255) {
			rangeError = true;
			badComponentString = badComponentString + " Blue";
		}
		if (rangeError == true) {
			throw new IllegalArgumentException(
					"Color parameter outside of expected range:"
							+ badComponentString);
		}
	}

	/**
	 * Transforms the color object into an 8 letter hex value string (with
	 * transparency). RRGGBBTT
	 * 
	 * @return 8 letter string
	 */
	public String getEightCharacterHexValue() {
		return Integer.toHexString(getRGB()).substring(2, 8)
				+ Integer.toHexString(getRGB()).substring(0, 2);
	}

	public int getRGB() {
		return value;
	}

	protected int getRed() {
		return red;
	}

	protected int getGreen() {
		return green;
	}

	protected int getBlue() {
		return blue;
	}

	protected int getTransparency() {
		return transparency;
	}

	/**
	 * Transform the color object into an 6 letter hex value string without
	 * transparency.
	 * 
	 * @return 6 letter string
	 */
	public String getSixCharacterHexValue() {
		// TODO check if fixed mva: fix bug (when transparency in hex with
		// leading 0)
		String intHexString = Integer.toHexString(getRGB());
		if (intHexString.length() == 8) {
			return intHexString.substring(2, 8);
		}
		if (intHexString.length() == 7) {
			return intHexString.substring(1, 7);
		}
		if (intHexString.length() == 6) {
			return intHexString;
		}
		return null;
		// return Integer.toHexString(color.getRGB()).substring(2, 8);
	}

	public String getMatchingColorHexValue() {
		if (transparency == 255) {
			return (getSixCharacterHexValue());
		} else {
			return (getEightCharacterHexValue());
		}
	}
}
