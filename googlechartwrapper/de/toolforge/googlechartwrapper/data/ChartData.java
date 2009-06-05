package de.toolforge.googlechartwrapper.data;


import java.util.ArrayList;
import java.util.List;

import de.toolforge.googlechartwrapper.ChartTypeFeature;
import de.toolforge.googlechartwrapper.coder.AutoEncoder;
import de.toolforge.googlechartwrapper.coder.IEncoder;
import de.toolforge.googlechartwrapper.interfaces.IEncodeable;
import de.toolforge.googlechartwrapper.util.AppendableFeature;
import de.toolforge.googlechartwrapper.util.IFeatureAppender;

/**
 * 
 * @author steffan
 * 
 */
public class ChartData implements IFeatureAppender, IEncodeable {

	private List<Integer> chartData;

	private IEncoder encoder = new AutoEncoder();

	/**
	 * 
	 * @param chartData
	 * 
	 * @throws IllegalArgumentException
	 */
	public ChartData(List<Integer> chartData) {

		if (chartData == null)
			throw new IllegalArgumentException("chartData can not be null");

		this.chartData = chartData;

	}

	public ChartData(int[] chartData) {

		this.chartData = this.arrayToCollection(chartData);
	}

	public List<AppendableFeature> getAppendableFeatures(
			List<? extends IFeatureAppender> otherAppenders) {

		StringBuilder builder = new StringBuilder();

		int a[] = new int[this.chartData.size()];

		for (int i = 0; i < this.chartData.size(); i++) {
			a[i] = (Integer) this.chartData.toArray()[i];
		}

		builder.append(encoder.encode(a));

		List<AppendableFeature> feature = new ArrayList<AppendableFeature>();

		feature.add(new AppendableFeature(builder.toString(),
				ChartTypeFeature.ChartData));

		return feature;
	}

	public IEncoder getEncoder() {

		return this.encoder;
	}

	public void setEncoder(IEncoder encoder) {

		if (encoder == null)
			throw new IllegalArgumentException("encoder can not bet null");

		this.encoder = encoder;

	}

	private List<Integer> arrayToCollection(int[] data) {
		List<Integer> c = new ArrayList<Integer>();

		for (int i = 0; i < data.length; i++) {
			c.add(data[i]);
		}

		return c;
	}

	public void removeEncoder() {

		this.encoder = new AutoEncoder();
	}

}
