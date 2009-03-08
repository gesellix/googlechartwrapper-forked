package googlechartwrapper.data;

import googlechartwrapper.ChartTypeFeature;
import googlechartwrapper.coder.AutoEncoder;
import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.interfaces.IEncodeable;
import googlechartwrapper.util.AppendableFeature;
import googlechartwrapper.util.IExtendedFeatureAppender;
import googlechartwrapper.util.IFeatureAppender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author mart
 * @author steffan
 * 
 */
public class GoogleOMeterValueAppender implements IExtendedFeatureAppender,
		IEncodeable {

	private IEncoder encoder = new AutoEncoder();
	/**
	 * list of elements/features
	 */
	protected List<GoogleOMeterValue> list = new ArrayList<GoogleOMeterValue>(1);

	public String getFeaturePrefix() {
		return "chd";
	}

	public List<AppendableFeature> getAppendableFeatures(
			List<? extends IFeatureAppender> otherAppenders) {
		if (list.size() == 0) {
			return null;
		}
//TODO evil thrash
		boolean hadLabels = false;
		StringBuilder values = new StringBuilder(list.size() * 2 + 5);
		StringBuilder labels = new StringBuilder(list.size() * 5 + 5);

		values.append("t:");

		for (GoogleOMeterValue val : list) {
			values.append(val.getValue());
			values.append(",");
			if (val.getLabel() == null) {
				labels.append("|");
			} else {
				labels.append(val.getLabel());
				labels.append("|");
				hadLabels = true;
			}
		}
		// http://chart.apis.google.com/chart?chs=225x125&cht=gom&chd=t:70&chl=Hello
		// chd=t:70:
		String ret = values.substring(0, values.length() - 1);
		if (hadLabels) {
			ret = ret + "&chl=" + labels.substring(0, labels.length() - 1);
		}
List<AppendableFeature> feature = new ArrayList<AppendableFeature>(); 
		
        feature.add(new AppendableFeature(ret, 
                  ChartTypeFeature.ChartData)); 
        
		return feature;
	}

	/**
	 * Appends the specified element to the end of this appender.
	 * 
	 * @param m
	 *            element to be appended to tprivate IEncoder encoder = new
	 *            AutoEncoder();his list.
	 * @throws IllegalArgumentException
	 *             if, and only if m == null
	 */
	public void add(GoogleOMeterValue m) {
		if (m == null) {
			throw new IllegalArgumentException("new element cannot be null");
		}
		list.add(m);
	}

	/**
	 * Removes the first occurrence in this list of the specified element
	 * (optional operation). If this list does not contain the element, it is
	 * unchanged. More formally, removes the element with the lowest index i
	 * such that <code>(o==null ? get(i)==null : o.equals(get(i))) </code> (if
	 * such an element exists).
	 * 
	 * @param m
	 *            element to be removed from this list, if present
	 * @return <code>true</code> if this list contained the specified element
	 */
	public boolean remove(GoogleOMeterValue m) {
		return list.remove(m);
	}

	/**
	 * Removes the element at the specified position in this feature list.
	 * Shifts any subsequent elements to the left (subtracts one from their
	 * indices). Returns the element that was removed from the feature list.
	 * 
	 * @param index
	 *            the index of the element to removed
	 * @return the element previously at the specified position
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >= size of
	 *             this feature list).
	 */
	public GoogleOMeterValue remove(int index) {
		return list.remove(index);
	}

	/**
	 * Removes all of the elements from this appender. This appender feature
	 * list will be empty after this call returns.
	 * 
	 */
	public void removeAll() {
		for (int i = 0; i < list.size();) {
			list.remove(i);
		}
	}

	/**
	 * Returns the list of all T elements added to this appender. It returns an
	 * unmodifiable view of the value list. Consequently "read-only" access is
	 * possible
	 * 
	 * @return unmodifiable view of the values
	 */
	public List<GoogleOMeterValue> getList() {
		return Collections.unmodifiableList(list);
	}

	public IEncoder getEncoder() {

		return this.encoder;
	}

	public void setEncoder(IEncoder encoder) {

		this.encoder = encoder;

		if (encoder == null) {
			this.encoder = new AutoEncoder();
		}
	}

	public void removeEncoder() {

		this.encoder = new AutoEncoder();

	}

}