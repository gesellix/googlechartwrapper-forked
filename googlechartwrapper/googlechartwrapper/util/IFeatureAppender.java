package googlechartwrapper.util;

import java.util.List;

public interface IFeatureAppender {
	
	public String getAppendableString (List<? extends IFeatureAppender> otherAppenders);

}
