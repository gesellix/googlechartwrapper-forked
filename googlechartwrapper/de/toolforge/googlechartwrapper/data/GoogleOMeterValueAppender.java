package de.toolforge.googlechartwrapper.data;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import de.toolforge.googlechartwrapper.ChartTypeFeature;
import de.toolforge.googlechartwrapper.coder.AutoEncoder;
import de.toolforge.googlechartwrapper.coder.EncoderFactory;
import de.toolforge.googlechartwrapper.coder.EncodingType;
import de.toolforge.googlechartwrapper.coder.IEncoder;
import de.toolforge.googlechartwrapper.interfaces.IEncodeable;
import de.toolforge.googlechartwrapper.util.AppendableFeature;
import de.toolforge.googlechartwrapper.util.IExtendedFeatureAppender;
import de.toolforge.googlechartwrapper.util.IFeatureAppender;

/**
 * 
 * @author mart
 * @author steffan
 * 
 */
public class GoogleOMeterValueAppender implements IExtendedFeatureAppender,
		IEncodeable {

	//NOTE only the TextEncodingWithDataScaling works!
	private IEncoder encoder = EncoderFactory.getEncoder(EncodingType.TextEncodingWithDataScaling);
	/**
	 * list of elements/features
	 */
	protected List<GoogleOMeterValue> list = new ArrayList<GoogleOMeterValue>(1);

	/*
	 * public String getFeaturePrefix() { return "chd"; }
	 */

	public List<AppendableFeature> getAppendableFeatures(
			List<? extends IFeatureAppender> otherAppenders) {
		if (list.size() == 0) {
			return new LinkedList<AppendableFeature>();
		}

		// the raw data
		float[] data = new float[this.list.size()];

		for (int z = 0; z < this.list.size(); z++) {

			data[z] = (float) this.list.get(z).getValue();
		}
		
		boolean isLabelUsed = false;

		// the label
		StringBuilder label = new StringBuilder();
		for (int u = 0; u < this.list.size(); u++) {

			// the user set a label
			if (this.list.get(u).getLabel() != null) {
				isLabelUsed = true;
				label.append(this.list.get(u).getLabel());
			}
			// no label was set, we add ""
			if (this.list.get(u).getLabel() == null) {
				label.append("");
			}

			// otherwise we have a "," at the end
			if (u < this.list.size() - 1) {
				label.append("|");
			}
		}
		
		List<AppendableFeature> features = new ArrayList<AppendableFeature>();

		features.add(new AppendableFeature(this.encoder.encode(data),
				ChartTypeFeature.ChartData));
		
		// if the user set the label we have to add the string
		if (isLabelUsed) {
			features.add(new AppendableFeature(label.toString(),
					ChartTypeFeature.PieChartLabel));
		}

		return features;
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
			throw new IllegalArgumentException("value can not be null");
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