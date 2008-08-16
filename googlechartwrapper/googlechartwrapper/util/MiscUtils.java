package googlechartwrapper.util;

import java.awt.Color;

public class MiscUtils {
	
	public static  String getSixCharacterHexValue (Color color){
		return Integer.toHexString(color.getRGB()).substring(2, 8);
	}

}
