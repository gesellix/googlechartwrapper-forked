package googlechartwrapper.util;

import googlechartwrapper.ChartTypeFeature;

/**
 * Appender which collects single features and concatenates it to a full url
 * appendable parameter string. It features an upper limit of features which
 * can be appended to the feature list and behaviour if the limit is exceeded.
 * @author martin (mva) 
 * @param <T> type of elements to append to an url 
 * (must implement {@link IFeatureAppender})
 */
public class UpperLimitGenericAppender<T extends IFeatureAppender> 
	extends GenericAppender<T> implements IExtendedFeatureAppender{

	private int upperLimit;
	private UpperLimitReactions action;
	
	/**
	 * Constructs an empty feature list with an upper limit and
	 * a reaction if the limit is exceeded.
	 * @param m type of feature for this appender: type of the parameter: 
	 * &lt;type&gt;=&lt;parameter data&gt;, e.g  chs=250x100
	 * @param upperLimit upper limit of element count
	 * @param action reaction if the limit is exceeded
	 * @throws IllegalArgumentException if upperLimit &lt; 0 or action == null
	 */
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
	
	public UpperLimitGenericAppender(ChartTypeFeature m, int upperLimit, 
			UpperLimitReactions action, String separator) {
		this(m,upperLimit,action);
		this.separator = separator;
	}
	
	/*
	 * (non-Javadoc)
	 * @see googlechartwrapper.util.
	 * GenericAppender#add(googlechartwrapper.util.IFeatureAppender)
	 */
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
	
	/**
	 * Reactions if the limit is exceeded
	 * @author martin (mva)
	 *
	 */
	public enum UpperLimitReactions {
		/**
		 * Ignore the added element.
		 */
		IgnoreAdded,
		/** 
		 * Remove the first element from the feature list and add the new element.
		 */
		RemoveFirst,
		/**
		 * Remove the last element from the feature list and add the new element.
		 */
		RemoveLast,
		/**
		 * Remove all elements from the feature list and add the new element.
		 */
		RemoveAll;
	}
}
