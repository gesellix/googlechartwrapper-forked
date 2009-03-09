package googlechartwrapper.data;

import googlechartwrapper.ChartTypeFeature;
import googlechartwrapper.DefaultValues;
import googlechartwrapper.LineChart;
import googlechartwrapper.coder.AutoEncoder;
import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.interfaces.IEncodeable;
import googlechartwrapper.util.AppendableFeature;
import googlechartwrapper.util.IExtendedFeatureAppender;
import googlechartwrapper.util.IFeatureAppender;
import googlechartwrapper.util.MiscUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author steffan
 * 
 * @see LineChart
 * @see LineChartData
 * 
 */
public class LineChartDataAppender implements IExtendedFeatureAppender,
		IEncodeable {

	private IEncoder encoder = new AutoEncoder();
	private List<LineChartData> data = new ArrayList<LineChartData>();

	
	public String getFeaturePrefix() {

		return ChartTypeFeature.ChartData.getPrefix();
	}

	/**
	 * The {@link LineChartData} will be added to the list.
	 * 
	 * @param data
	 *            {@link LineChartData}
	 * 
	 * @throws IllegalArgumentException
	 *             if data is {@code null}
	 */
	public void addLineChartData(LineChartData data) {
		if (data == null)
			throw new IllegalArgumentException("data can not be nulll");
		this.data.add(data);
	}

	/**
	 * The list will be merged.
	 * 
	 * @param data
	 *            {@link LineChartData}
	 * 
	 * @throws IllegalArgumentException
	 *             if collection is {@code null} or value is {@code null}
	 */
	public void addLineChartData(List<LineChartData> data) {

		if (data == null) {
			throw new IllegalArgumentException("data can not be null");
		} else {
			for (LineChartData temp : Collections.unmodifiableCollection(data)) {
				if (temp == null)
					throw new IllegalArgumentException("value can not be null");
			}
			this.data.addAll(Collections.unmodifiableList(data));
		}
	}

	public List<AppendableFeature> getAppendableFeatures(
			List<? extends IFeatureAppender> otherAppenders) {

		// the raw data
		List<int[]> data = new LinkedList<int[]>();

		for (int z = 0; z < this.data.size(); z++) {

			int values[] = new int[this.data.get(z).getDataSet().size()];
			// copy elements
			for (int u = 0; u < this.data.get(z).getDataSet().size(); u++) {
				values[u] = this.data.get(z).getDataSet().get(u);
			}
			data.add(values);
		}
		boolean isColorUsed = false;

		// the color string
		StringBuilder color = new StringBuilder();
		for (int i = 0; i < this.data.size(); i++) {

			// the user set a color
			if (this.data.get(i).getColor() != null) {
				isColorUsed = true;
				color.append(MiscUtils.getSixCharacterHexValue(this.data.get(i)
						.getColor()));
			}
			// no color was set, we add the default color
			if (this.data.get(i).getColor() == null) {
				color.append(MiscUtils
						.getSixCharacterHexValue(DefaultValues.DataColor));
			}

			// otherwise we have a "," at the end
			if (i < this.data.size() - 1) {
				color.append(",");
			}
		}

		boolean isStyleUsed = false;
		// the lineStyle
		StringBuilder style = new StringBuilder();
		for (int u = 0; u < this.data.size(); u++) {

			// the user set a style
			if (this.data.get(u).getStyle() != null) {
				isStyleUsed = true;
				style.append(this.data.get(u).getStyle().getAppendableFeatures(null).get(0).getData());
			}
			// no style was set, we add the default style
			if (this.data.get(u).getStyle() == null) {
				style.append(DefaultValues.LineStyle.getAppendableFeatures(null).get(0).getData());
			}

			// otherwise we have a "," at the end
			if (u < this.data.size() - 1) {
				style.append("|");
			}
		}
		boolean isLegendUsed = false;
		
		// the chartLegend
		StringBuilder legend = new StringBuilder();
		for (int u = 0; u < this.data.size(); u++) {

			// the user set a legend
			if (this.data.get(u).getlegend() != null) {
				isLegendUsed = true;
				legend.append(this.data.get(u).getlegend().getAppendableFeatures(null).get(0).getData());
			}
			// no style was set, we add the default legend
			if (this.data.get(u).getlegend() == null) {
				legend.append("");
			}

			// otherwise we have a "," at the end
			if (u < this.data.size() - 1) {
				legend.append("|");
			}
		}

		List<AppendableFeature> features = new ArrayList<AppendableFeature>();

		features.add(new AppendableFeature(this.encoder.encodeIntegerCollection(
				data, ","), ChartTypeFeature.ChartData));

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
