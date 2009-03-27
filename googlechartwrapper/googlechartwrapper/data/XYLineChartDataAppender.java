package googlechartwrapper.data;

import googlechartwrapper.ChartTypeFeature;
import googlechartwrapper.DefaultValues;
import googlechartwrapper.coder.AutoEncoder;
import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.interfaces.IEncodeable;
import googlechartwrapper.util.AppendableFeature;
import googlechartwrapper.util.IExtendedFeatureAppender;
import googlechartwrapper.util.IFeatureAppender;
import googlechartwrapper.util.MiscUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author steffan
 * 
 */
public class XYLineChartDataAppender implements IExtendedFeatureAppender,
		IEncodeable {

	private IEncoder encoder = new AutoEncoder();
	private List<XYLineChartData> xyLineChartData = new ArrayList<XYLineChartData>();

	/**
	 * 
	 * @param data
	 * 
	 * @throws IllegalArgumentException
	 *             if data is {@code null}
	 */
	public void addXYLineChartData(XYLineChartData data) {

		if (data == null)
			throw new IllegalArgumentException("data can not be null");
		this.xyLineChartData.add(data);
	}

	/**
	 * 
	 * @param data
	 * 
	 * @throws IllegalArgumentException
	 *             if data is {@code null} and/or value is {@code null}
	 */
	public void addXYLineChartData(List<? extends XYLineChartData> data) {

		if (data == null)
			throw new IllegalArgumentException("data can not be null");

		List<XYLineChartData> temp = Collections.unmodifiableList(data);

		for (XYLineChartData current : temp) {
			if (current == null)
				throw new IllegalArgumentException("pair can not be null");
		}
		this.xyLineChartData.addAll(temp);

	}

	/**
	 * Removes all {@link XYLineChartData}
	 */
	public void removeAllXYLineChartData() {
		this.xyLineChartData.clear();
	}

	/**
	 * 
	 * @param index
	 * @return
	 * 
	 * @throws IndexOutOfBoundsException
	 *             if index is out of bound
	 */
	public XYLineChartData removeXYLineChartData(int index) {
		return this.xyLineChartData.remove(index);
	}

	/**
	 * Removes a given {@link XYLineChartData} and returns the status.
	 * 
	 * @param XYLineChartData
	 * @return {@code true} if success
	 */
	public boolean removeXYLineChartData(XYLineChartData xyLineChartData) {

		return this.xyLineChartData.remove(xyLineChartData);
	}

	/*
	 * public String getFeaturePrefix() {
	 * 
	 * return ChartTypeFeature.ChartData.getPrefix(); }
	 */

	public List<AppendableFeature> getAppendableFeatures(
			List<? extends IFeatureAppender> otherAppenders) {

		// the raw data
		List<float[]> data = new ArrayList<float[]>();

		for (XYLineChartData currentDataSet : this.xyLineChartData) {

			float[] firstDataSet = new float[currentDataSet.getDataSet()
					.getFirst().size()];

			// no x values are set, so we can use -1
			if (currentDataSet.getDataSet().getFirst().isEmpty()) {
					firstDataSet = new float[]{-1};
			}
			// we have x values
			else {
				// first dataset

				for (int i = 0; i < currentDataSet.getDataSet().getFirst()
						.size(); i++) {

					firstDataSet[i] = currentDataSet.getDataSet().getFirst()
							.get(i);
				}
			}
			// second dataset
			float[] secondDataSet = new float[currentDataSet.getDataSet()
					.getSecond().size()];
			for (int z = 0; z < currentDataSet.getDataSet().getSecond().size(); z++) {

				secondDataSet[z] = currentDataSet.getDataSet().getSecond().get(
						z);
			}

			data.add(firstDataSet);
			data.add(secondDataSet);
		}

		boolean isColorUsed = false;

		// the color string
		StringBuilder color = new StringBuilder();
		for (int i = 0; i < this.xyLineChartData.size(); i++) {

			// the user set a color
			if (this.xyLineChartData.get(i).getColor() != null) {
				isColorUsed = true;
				color.append(MiscUtils
						.getSixCharacterHexValue(this.xyLineChartData.get(i)
								.getColor()));
			}
			// no color was set, we add the default color
			if (this.xyLineChartData.get(i).getColor() == null) {
				color.append(MiscUtils
						.getSixCharacterHexValue(DefaultValues.DataColor));
			}

			// otherwise we have a "," at the end
			if (i < this.xyLineChartData.size() - 1) {
				color.append(",");
			}
		}

		boolean isStyleUsed = false;
		// the lineStyle
		StringBuilder style = new StringBuilder();
		for (int u = 0; u < this.xyLineChartData.size(); u++) {

			// the user set a style
			if (this.xyLineChartData.get(u).getStyle() != null) {
				isStyleUsed = true;
				style.append(this.xyLineChartData.get(u).getStyle()
						.getAppendableFeatures(null).get(0).getData());
			}
			// no style was set, we add the default style
			if (this.xyLineChartData.get(u).getStyle() == null) {
				style.append(DefaultValues.LineStyle
						.getAppendableFeatures(null).get(0).getData());
			}

			// otherwise we have a "," at the end
			if (u < this.xyLineChartData.size() - 1) {
				style.append("|");
			}
		}
		boolean isLegendUsed = false;

		// the chartLegend
		StringBuilder legend = new StringBuilder();
		for (int u = 0; u < this.xyLineChartData.size(); u++) {

			// the user set a legend
			if (this.xyLineChartData.get(u).getLegend() != null) {
				isLegendUsed = true;
				legend.append(this.xyLineChartData.get(u).getLegend()
						.getAppendableFeatures(null).get(0).getData());
			}
			// no style was set, we add the default legend
			if (this.xyLineChartData.get(u).getLegend() == null) {
				legend.append("");
			}

			// otherwise we have a "," at the end
			if (u < this.xyLineChartData.size() - 1) {
				legend.append("|");
			}
		}

		List<AppendableFeature> features = new ArrayList<AppendableFeature>();

		features.add(new AppendableFeature(this.encoder
				.encodeFloatCollection(data), ChartTypeFeature.ChartData));

		// if the user set the color we have to add the string
		if (isColorUsed) {
			features.add(new AppendableFeature(color.toString(),
					ChartTypeFeature.ChartColor));
		}
		// if the user set the style we have to add the string
		if (isStyleUsed) {
			features.add(new AppendableFeature(style.toString(),
					ChartTypeFeature.LineStyle));
		}
		// if the user set the style we have to add the string
		if (isLegendUsed) {
			features.add(new AppendableFeature(legend.toString(),
					ChartTypeFeature.ChartLegend));
		}

		return features;
	}

	public IEncoder getEncoder() {

		return this.encoder;
	}

	public void removeEncoder() {
		this.encoder = new AutoEncoder();

	}

	public void setEncoder(IEncoder encoder) {

		this.encoder = encoder;

		if (encoder == null) {
			this.encoder = new AutoEncoder();
		}

	}

}
