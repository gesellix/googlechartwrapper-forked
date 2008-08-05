package googlechartwrapper.util;

import java.util.List;
import java.util.Queue;

public interface FeatureAppender {
	
	public String getAppendableString (List<FeatureAppender> otherAppenders);

}
