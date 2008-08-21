package googlechartwrapper.util;

import java.awt.Color;

public class MiscUtils {
	
	public static String getEightCharacterHexValue (Color color){
		return Integer.toHexString(color.getRGB()).substring(2, 8)+
			Integer.toHexString(color.getRGB()).substring(0, 2);
	}
	
	public static  String getSixCharacterHexValue (Color color){
		//TODO mva: fix bug (when transparency in hex with leading 0)
		return Integer.toHexString(color.getRGB()).substring(2, 8);
	}

}
