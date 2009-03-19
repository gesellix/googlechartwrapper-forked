package googlechartwrapper.label;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import googlechartwrapper.ChartTypeFeature;
import googlechartwrapper.AbstractPieChart;
import googlechartwrapper.ConcentricPieChart;
import googlechartwrapper.PieChart;
import googlechartwrapper.data.PieChartSlice;
import googlechartwrapper.util.AppendableFeature;
import googlechartwrapper.util.IFeatureAppender;

/**
 * Specifies a PieChartLAbel. <a
 * href="http://code.google.com/apis/chart/labels.html#pie_labels">
 * http://code.google.com/apis/chart/labels.html#pie_labels</a>
 * 
 * @author steffan
 * @version 03/17/09 
 * @see AbstractPieChart
 * @see PieChart
 * @see ConcentricPieChart
 * @see PieChartSlice
 */
public class PieChartLabel implements IFeatureAppender {

	List<String> labelList = new ArrayList<String>();

	/**
	 * Constructs a new PieChartLabel.
	 * 
	 * @param labelList list of labels
	 * 
	 * @throws IllegalArgumentException if labelList is {@code null} or member is {@code null}
	 */
	public PieChartLabel(List<String> labelList) {

		if (labelList == null)
			throw new IllegalArgumentException("labelList can not be null");

		List<String> temp = Collections.unmodifiableList(labelList);
		
		for (String current : temp) {

			if (current == null)
				throw new IllegalArgumentException("member can not be null");
		}
		this.labelList = temp;
	}
	/**
	 * Constructs a new PieChartLabel
	 * 
	 * @param label the label
	 * 
	 * @throws IllegalArgumentException if label is {@code null}
	 */
	public PieChartLabel(String label) {
		
		if(label == null)
			throw new IllegalArgumentException("label can not be null");
		
		this.labelList.add(label);
	}

	public List<AppendableFeature> getAppendableFeatures(
			List<? extends IFeatureAppender> otherAppenders) {
		
		StringBuilder builder = new StringBuilder();

		for (String currentLabel : this.labelList) {
			builder.append(currentLabel);
			builder.append('|');
		}

		// only if we have one or more elements
		if (this.labelList.size() > 0) {
			builder.deleteCharAt(builder.length() - 1);
		}
		
		List<AppendableFeature> feature = new ArrayList<AppendableFeature>();
		
		feature.add(new AppendableFeature(builder.toString(),
				ChartTypeFeature.PieChartLabel));	
		
		return feature;
	}

}
