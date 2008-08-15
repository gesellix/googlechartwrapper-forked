package googlechartwrapper.util;

import googlechartwrapper.ChartTypeFeature;

public class UpperLimitGenericAppender<T extends IFeatureAppender> 
	extends GenericAppender<T> implements IExtendedFeatureAppender{

	private int upperLimit;
	private UpperLimitReactions action;
	
	public UpperLimitGenericAppender(ChartTypeFeature m, int upperLimit, 
			UpperLimitReactions action) {
		
		super(m);
		if (upperLimit <0){
			throw new IllegalArgumentException("upperLimit shall be greater -1");
		}
		if (action == null){
			action = UpperLimitReactions.IgnoreAdded;
		}
		this.action = action;
		this.upperLimit = upperLimit;
	}
	
	@Override
	public void add(T m) {
		if (upperLimit > list.size()){ // space avail
			if (m != null) {
				super.add(m);
			}
		}
		else {
			if (action.equals(UpperLimitReactions.IgnoreAdded))return;
			
			if (action.equals(UpperLimitReactions.RemoveFirst)){
				remove(0);				
			}
			else if (action.equals(UpperLimitReactions.RemoveLast)){
				remove(list.size()-1);
			}
			else if (action.equals(UpperLimitReactions.RemoveAll)){
				removeAll();
			}
			super.add(m);
		}
	}
	
	public enum UpperLimitReactions {
		IgnoreAdded,
		RemoveFirst,
		RemoveLast,
		RemoveAll;
	}
}
