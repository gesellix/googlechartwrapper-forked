package de.toolforge.googlechartwrapper.util;


import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import de.toolforge.googlechartwrapper.AbstractChart;

/**
 * Miscellaneous utility methods for the api.
 * @author mart
 *
 */
public class MiscUtils {
	
	/**
	 * Transforms a color object into an 8 letter hex value string (with transparency).
	 * RRGGBBTT
	 * @param color color to transform
	 * @return 8 letter string
	 */
	public static String getEightCharacterHexValue (Color color){
		return Integer.toHexString(color.getRGB()).substring(2, 8)+
			Integer.toHexString(color.getRGB()).substring(0, 2);
	}
	
	/**
	 * Transform a color object into an 6 letter hex value string without transparency.
	 * @param color color to transform
	 * @return 6 letter string 
	 */
	public static  String getSixCharacterHexValue (Color color){
		//TODO check if fixed mva: fix bug (when transparency in hex with leading 0)
		String intHexString = Integer.toHexString(color.getRGB());
		if (intHexString.length()==8){
			return intHexString.substring(2,8);
		}
		if (intHexString.length()==7){
			return intHexString.substring(1,7);
		}
		if (intHexString.length()==6){
			return intHexString;
		}
		return null;
		//return Integer.toHexString(color.getRGB()).substring(2, 8);
	}
	
	public static String getMatchingColorHexValue (Color color){
		if (color.getAlpha()==255){
			return (MiscUtils.getSixCharacterHexValue(color));
		}
		else {
			return (MiscUtils.getEightCharacterHexValue(color));
		}
	}
	
	/**
	 * Takes the chart url to load the image.
	 * 
	 * 
	 * @param chart
	 * 
	 * @return bufferedImage 
	 */
	public static Image getBufferedImage(AbstractChart chart) throws IOException{				
		
		BufferedImage bufferedImage = null;
		
		//we can ensure that the url is correct
		try {
			bufferedImage = ImageIO.read( new URL(chart.getUrl()) );
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		} 
		return bufferedImage;
		
	}
	

}
