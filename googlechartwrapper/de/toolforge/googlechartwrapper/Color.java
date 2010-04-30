package de.toolforge.googlechartwrapper;

/**
 * Own implementation of a chart color to support environments where the
 * java.awt.Color class is not available. If a java.awt.color object exists it
 * may be wrapped using the public constructor with a color object parameter.
 * The implementation is partially based on the original java.awt.Color class by
 * Sun. (see issue 20)
 * 
 * @author martin
 * 
 */
public class Color {

	private int red, green, blue, alpha;
	private int value;

	/**
	 * Creates an sRGB color with the specified red, green, blue, 
	 * and alpha values in the range (0 - 255). 
	 * @param r  the Red component
	 * @param g  the Green component
	 * @param b  the Blue component
	 * @param a  the alpha component
	 */
	public Color(int r, int g, int b, int a) {
		value = ((a & 0xFF) << 24) | ((r & 0xFF) << 16) | ((g & 0xFF) << 8)
				| ((b & 0xFF) << 0);

		testColorValueRange(r, g, b, a);
		red = r;
		green = g;
		blue = b;
		alpha = a;
	}

	/**
	 * Creates an opaque sRGB color with the specified red, green, and blue values 
	 * in the range (0 - 255). Alpha is defaulted to 255. 
	 * @param r  the Red component
	 * @param g  the Green component
	 * @param b  the Blue component
	 */
	public Color(int r, int g, int b) {
		this(r, g, b, 255);
	}

	/**
	 * Creates an sRGB color with the specified red, green, blue, 
	 * and alpha values by the awt color object. 
	 * Legacy parsing for old implementations based on awt color object
	 * before the introduction of own object.
	 * @param c base color
	 * @throws IllegalArgumentException if color == null
	 */
	public Color(java.awt.Color c) {
		if (c == null) {
			throw new IllegalArgumentException("color can not be null");
		}
		int r = c.getRed();
		int g = c.getGreen();
		int b = c.getBlue();
		int a = c.getAlpha();

		value = ((a & 0xFF) << 24) | ((r & 0xFF) << 16) | ((g & 0xFF) << 8)
				| ((b & 0xFF) << 0);

		testColorValueRange(r, g, b, a);
		red = r;
		green = g;
		blue = b;
		alpha = a;
	}

	/**
	 * Transforms the color object into an awt color object.
	 * All 4 components (r,g,b,a) are retained.
	 * @return awt color object
	 */
	public java.awt.Color toAwtColor() {
		return new java.awt.Color(red, green, blue, alpha);
	}

	/**
	 * Checks the color integer components supplied for validity. Throws an
	 * {@link IllegalArgumentException} if the value is out of range. From:
	 * 
	 * @param r
	 *            the Red component
	 * @param g
	 *            the Green component
	 * @param b
	 *            the Blue component
	 * @param a
	 *            the alpha/transparency component
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
		System.out.println(Integer.toHexString(getRGB())+ " "+alpha);
		return Integer.toHexString(getRGB()).substring(2, 8)
				+ Integer.toHexString(getRGB()).substring(0, 2);
	}

	public int getRGB() {
		return value;
	}

	public int getRed() {
		return red;
	}

	public int getGreen() {
		return green;
	}

	public int getBlue() {
		return blue;
	}

	public int getAlpha() {
		return alpha;
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

	/**
	 * Returns a 6 letter hex value if the alpha value is 255 or an 8 letter
	 * string otherwise.
	 * @return hex string based on alpha value
	 * @see #getSixCharacterHexValue()
	 * @see #getEightCharacterHexValue()
	 */
	public String getMatchingColorHexValue() {
		if (alpha == 255) {
			return (getSixCharacterHexValue());
		} else {
			return (getEightCharacterHexValue());
		}
	}
}
