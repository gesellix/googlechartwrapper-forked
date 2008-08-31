package googlechartwrapper.util;

import googlechartwrapper.AbstractChart;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

public class MiscUtils {
	
	public static String getEightCharacterHexValue (Color color){
		return Integer.toHexString(color.getRGB()).substring(2, 8)+
			Integer.toHexString(color.getRGB()).substring(0, 2);
	}
	
	public static  String getSixCharacterHexValue (Color color){
		//TODO mva: fix bug (when transparency in hex with leading 0)
		return Integer.toHexString(color.getRGB()).substring(2, 8);
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
	 * Takes the chart url to laod the image.
	 * 
	 * 
	 * @param chart
	 * 
	 * @return bufferedImage 
	 */
	public static Image getBufferedImage(AbstractChart chart){				
		
		BufferedImage bufferedImage = null;
		
		try {
			bufferedImage = ImageIO.read( new URL(chart.getUrl()) );
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bufferedImage;
		
	}
	

}
