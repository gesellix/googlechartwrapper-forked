package googlechartwrapper.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.toolforge.googlechartwrapper.ChartTypeFeature;


/**
 * Appender which collects single features and concatenates it to a full url
 * appendable parameter string.
 * @author martin (mva) *
 * @param <T> type of elements to append to an url 
 * (must implement {@link IFeatureAppender})
 */
public class GenericAppender<T extends IFeatureAppender> implements 
	IExtendedFeatureAppender{
	
	/**
	 * list of elements/features
	 */
	protected List<T> list;
	/**
	 * type of the parameter: &lt;type&gt;=&lt;parameter data&gt;, e.g
	 * chs=250x100
	 */
	protected String prefix;
	/**
	 * separator for each single feature, e.g. the pipe symbol or a comma
	 */
	protected String separator;
	/**
	 * determinates whether an {@link IllegalArgumentException} is thrown
	 * when {@link #add(IFeatureAppender)} is invoked with null.
	 */
	protected boolean throwIAEwhenNull = true;
	
	/**
	 * Constructs a new GenericAppender with the feature prefix which the 
	 * ChartTypeFeature returns when calling {@link ChartTypeFeature#getPrefix()}.
	 * Each dataset is separated with the pipe character (|).
	 * If {@link #add(IFeatureAppender)} is invoked with null an 
	 * {@link IllegalArgumentException} is thrown.
	 * @param m feature for prefix
	 */
	public GenericAppender(ChartTypeFeature m){
		this(m,"|");
	}
	
	/**
	 * Constructs a new GenericAppender with the given feature prefix or type.
	 * type/prefix of the parameter: &lt;type&gt;=&lt;parameter data&gt;, e.g
	 * chs=250x100
	 * Each dataset is separated with the pipe character (|).
	 * If {@link #add(IFeatureAppender)} is invoked with null an 
	 * {@link IllegalArgumentException} is thrown.
	 * @param prefix type/prefix of the parameter, e.g. "chs"
	 */
	public GenericAppender(String prefix){
		this(prefix,"|");
	}
	
	/**
	 * Constructs a new GenericAppender with the feature prefix which the 
	 * ChartTypeFeature returns when calling {@link ChartTypeFeature#getPrefix()}.
	 * Each dataset is separated with the pipe character (|). 
	 * @param m feature for prefix
	 * @param throwIAEwhenNull <code>true</code> if an {@link IllegalArgumentException}
	 * is thrown when {@link #add(IFeatureAppender)} is invoked with null;
	 * otherwise <code>false</code>
	 */
	public GenericAppender (ChartTypeFeature m, boolean throwIAEwhenNull){
		this (m);
		this.throwIAEwhenNull = throwIAEwhenNull;
	}
	
	/**
	 * Constructs a new GenericAppender with the feature prefix which the 
	 * ChartTypeFeature returns when calling {@link ChartTypeFeature#getPrefix()}.
	 * If {@link #add(IFeatureAppender)} is invoked with null an 
	 * {@link IllegalArgumentException} is thrown.
	 * @param m feature for prefix
	 * @param separator separator for each dataset
	 */
	public GenericAppender (ChartTypeFeature m, String separator){
		if (separator == null){
			throw new IllegalArgumentException("sep cannot be null");
		}
		list = new ArrayList<T>();
		prefix = m.getPrefix();
		this.separator = separator;
	}
	
	/**
	 * Constructs a new GenericAppender with the given feature prefix or type.
	 * type/prefix of the parameter: &lt;type&gt;=&lt;parameter data&gt;, e.g
	 * chs=250x100
	 * If {@link #add(IFeatureAppender)} is invoked with null an 
	 * {@link IllegalArgumentException} is thrown.
	 * @param stm type/prefix of the parameter, e.g. "chs"
	 * @param separator separator for each dataset
	 */
	public GenericAppender(String stm, String separator){
		if (separator == null){
			throw new IllegalArgumentException("sep cannot be null");
		}
		list = new ArrayList<T>();
		prefix = stm;
		this.separator = separator;
	}
	
	/**
	 * Constructs a new GenericAppender with the given feature prefix or type.
	 * type/prefix of the parameter: &lt;type&gt;=&lt;parameter data&gt;, e.g
	 * chs=250x100
	 * @param stm type/prefix of the parameter, e.g. "chs"
	 * @param separator separator for each dataset
	 * @param throwIAEwhenNull <code>true</code> if an {@link IllegalArgumentException}
	 * is thrown when {@link #add(IFeatureAppender)} is invoked with null;
	 * otherwise <code>false</code>
	 */
	public GenericAppender(String stm, String separator, boolean throwIAEwhenNull){
		if (separator == null){
			throw new IllegalArgumentException("sep cannot be null");
		}
		list = new ArrayList<T>();
		prefix = stm;
		this.separator = separator;
		this.throwIAEwhenNull = throwIAEwhenNull;
	}
	
	/**
	 * Appends the specified element to the end of this appender. 
	 * @param m element to be appended to this list.
	 * @throws IllegalArgumentException if, and only if m == null and 
	 * {@link #throwIAEwhenNull}==true
	 * @see #GenericAppender(ChartTypeFeature, boolean)
	 */
	public void add (T m){
		if (m == null && throwIAEwhenNull){
			throw new IllegalArgumentException("new element cannot be null");
		}
		list.add(m);
	}
	
	/**
	 * Removes the first occurrence in this list of the specified element 
	 * (optional operation). If this list does not contain the element, it is 
	 * unchanged. More formally, removes the element with the lowest index i 
	 * such that <code>(o==null ? get(i)==null : o.equals(get(i))) </code>
	 * (if such an element exists). 
	 * @param m element to be removed from this list, if present
	 * @return <code>true</code> if this list contained the specified element
	 */
	public boolean remove (T m){
		return list.remove(m);
	}
	
	/**
	 * Removes the element at the specified position in this feature list. 
	 * Shifts any subsequent elements to the left 
	 * (subtracts one from their indices). Returns the element that was 
	 * removed from the feature list. 
	 * @param index the index of the element to removed
	 * @return the element previously at the specified position
	 * @throws IndexOutOfBoundsException if the index is out of 
	 * range (index < 0 || index >= size of this feature list).
	 */
	public T remove (int index){
		return list.remove(index);
	}
	
	/**
	 * Removes all of the elements from this appender.
	 * This appender feature list will be empty after this call returns.
	 *
	 */
	public void removeAll (){
		for (int i = 0; i < list.size();){
			list.remove(i);
		}
	}
	
	/**
	 * Returns the list of all T elements added to this appender. 
	 * It returns an unmodifiable view of the value list.
	 * Consequently "read-only" access is possible
	 * @return unmodifiable view of the values
	 */
	public List<T> getList (){
		return Collections.unmodifiableList(list);
	}
	
	public int getListSize (){
		return list.size();
	}
	
	/**
	 * Returns the list of all T elements added to this appender. 
	 * It returns an unmodifiable view of the value list.
	 * Consequently "read-only" access is possible. The value list is filtered
	 * for elements which are instance of the parameter class.
	 * @param c optional parameter: filters the returned list to classes of this type
	 * @return unmodifiable view of the values
	 */
	public List<? extends T> getList (Class<? extends T> c){
		List<T> retList = new ArrayList<T>();
		for (T value: list){			
			if (value.getClass().equals(c) ){
				retList.add(value);
			}
		}
		return Collections.unmodifiableList(retList);
	}

	/*
	 * (non-Javadoc)
	 * @see googlechartwrapper.util.IFeatureAppender#getAppendableString(java.util.List)
	 */
	public List<AppendableFeature> getAppendableFeatures(List<? extends IFeatureAppender> 
		otherAppenders) {
		if (list.size() > 0){			
			StringBuilder bf = new StringBuilder(list.size()*10);
			
			for (IFeatureAppender m:list){
				List<AppendableFeature> features = m.getAppendableFeatures(otherAppenders);
				String app = "";
				for (AppendableFeature ap : features){
					app = app +ap.getData()+ separator;
				}
				if (app.length()>0){
					bf.append(app.substring(0,app.length()-1));
					bf.append(separator);		
				}
									
			}
			if (bf.length()>0){
				List<AppendableFeature> features = new ArrayList<AppendableFeature>();
				features.add(new AppendableFeature(bf.substring(0, bf.length()-1),
						getFeaturePrefix()));
				return features;
			}
			else {
				return new ArrayList<AppendableFeature>();
			}
			
		}
		else {
			return new ArrayList<AppendableFeature>();
		}
		
		
		
//		if (list.size() > 0){
//			StringBuilder bf = new StringBuilder(list.size()*10);
//			//bf.append("chm=");
//			for (IFeatureAppender m:list){
//				String app = m.getAppendableString(otherAppenders);
//				if (app.length()>0){
//					bf.append(app);
//					bf.append(separator);		
//				}
//				//bf.append(m.getAppendableString(otherAppenders));
//						
//			}
//			if (bf.length()>0){
//				return bf.substring(0, bf.length()-1);
//			}
//			else {
//				return "";
//			}
//			
//		}
//		else return "";
	}
	
	/*
	 * (non-Javadoc)
	 * @see googlechartwrapper.util.IExtendedFeatureAppender#getFeaturePrefix()
	 */
	public String getFeaturePrefix (){
		return prefix;
	}
	
	@Override
	public String toString() {
		return super.toString()+" "+list;
	}

}
