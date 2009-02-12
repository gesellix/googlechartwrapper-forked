package googlechartwrapper.style;

import java.util.List;

import googlechartwrapper.util.IFeatureAppender;

/**
 *  * Specifies a ChartMargin <a href=
 * "http://code.google.com/intl/de-DE/apis/chart/styles.html#bar_width"
 * >http://code.google.com/intl/de-DE/apis/chart/styles.html#bar_width</a>
 * 
 * @author steffan
 *
 */
public class BarWidthAndSpacing implements IFeatureAppender{

	public String getAppendableString(
			List<? extends IFeatureAppender> otherAppenders) {
		
		StringBuilder builder = new StringBuilder();
		
		return builder.toString();
	}

}
