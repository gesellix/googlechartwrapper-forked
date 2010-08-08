/*
 * Copyright (c) 2008-2010, Steffan Vo�, Martin Vanauer
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Steffan Vo�, Martin Vanauer BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package de.toolforge.googlechartwrapper;

/**
 * Own implementation of a chart color to support environments where the
 * java.awt.Color class is not available. If a java.awt.color object exists it
 * may be wrapped using the public constructor with a color object parameter.
 * The implementation is partially based on the original java.awt.Color class by
 * Sun. (see issue 20)
 *
 * @author martin
 * @author steffan
 * @version 07/29/10
 */
public final class Color {

    private int red, green, blue, alpha;
    private int value;


    public final static Color WHITE = new Color(255, 255, 255);
    public final static Color LIGHT_GRAY = new Color(192, 192, 192);
    public final static Color GRAY = new Color(128, 128, 128);
    public final static Color DARK_GRAY = new Color(64, 64, 64);
    public final static Color BLACK = new Color(0, 0, 0);
    public final static Color RED = new Color(255, 0, 0);
    public final static Color PINK = new Color(255, 175, 175);
    public final static Color ORANGE = new Color(255, 200, 0);
    public final static Color YELLOW = new Color(255, 255, 0);
    public final static Color GREEN = new Color(0, 255, 0);
    public final static Color MAGENTA = new Color(255, 0, 255);
    public final static Color CYAN = new Color(0, 255, 255);
    public final static Color BLUE = new Color(0, 0, 255);

    /**
     * Creates an sRGB color with the specified red, green, blue,
     * and alpha values in the range (0 - 255).
     *
     * @param r the Red component
     * @param g the Green component
     * @param b the Blue component
     * @param a the alpha component
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
     *
     * @param r the Red component
     * @param g the Green component
     * @param b the Blue component
     */
    public Color(int r, int g, int b) {
        this(r, g, b, 255);
    }

    /**
     * Creates an sRGB color with the specified red, green, blue,
     * and alpha values by the awt color object.
     * Legacy parsing for old implementations based on awt color object
     * before the introduction of own object.
     *
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
     *
     * @return awt color object
     */
    public java.awt.Color toAwtColor() {
        return new java.awt.Color(red, green, blue, alpha);
    }

    /**
     * Checks the color integer components supplied for validity. Throws an
     * {@link IllegalArgumentException} if the value is out of range. From:
     *
     * @param r the Red component
     * @param g the Green component
     * @param b the Blue component
     * @param a the alpha/transparency component
     */
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
        System.out.println(Integer.toHexString(getRGB()) + " " + alpha);
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
     *
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
