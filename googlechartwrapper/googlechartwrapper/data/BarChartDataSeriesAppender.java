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
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author steffan
 * 
 */
public class BarChartDataSeriesAppender implements IExtendedFeatureAppender,
		IEncodeable {

	private IEncoder encoder = new AutoEncoder();
	protected List<BarChartDataSerie> barChartDataSeries = new LinkedList<BarChartDataSerie>();

	/**
	 * 
	 * @param ds
	 * 
	 * @throws IllegalArgumentException
	 *             if barChartDataSerie is {@code null}
	 */
	public void add(BarChartDataSerie barChartDataSerie) {
		if (barChartDataSerie == null)
			throw new IllegalArgumentException(
					"barChartDataSerie can not be null");

		barChartDataSeries.add(barChartDataSerie);
	}

	/**
	 * 
	 * @param barChartDataSeries
	 * 
	 * @throws IllegalArgumentException
	 *             if barCharDataSeries or member is {@code null}
	 */
	public void add(List<? extends BarChartDataSerie> barChartDataSeries) {

		if (barChartDataSeries == null)
			throw new IllegalArgumentException(
					"barChartDataSeries can not be null");

		List<? extends BarChartDataSerie> temp = Collections
				.unmodifiableList(barChartDataSeries);

		for (BarChartDataSerie current : temp) {

			if (current == null)
				throw new IllegalArgumentException("member can not be null");
		}
		this.barChartDataSeries.addAll(temp);
	}

	public boolean remove(BarChartDataSerie ds) {
		return barChartDataSeries.remove(ds);
	}

	public BarChartDataSerie remove(int index) {
		return barChartDataSeries.remove(index);
	}

	public void removeAll() {
		this.barChartDataSeries.clear();
	}

	/**
	 * Returns a unmodifiable list of all {@link BarChartDataSerie}
	 * 
	 * @return unmodifiable list, empty if nothing was set
	 */
	public List<? extends BarChartDataSerie> getAllBarChartDataSeries() {
		return Collections.unmodifiableList(this.barChartDataSeries);
	}

	public String getFeaturePrefix() {

		return ChartTypeFeature.ChartData.getPrefix();
	}

	public List<AppendableFeature> getAppendableFeatures(
			List<? extends IFeatureAppender> otherAppenders) {

		// the raw data
		List<int[]> data = new LinkedList<int[]>();

		for (int z = 0; z < this.barChartDataSeries.size(); z++) {

			int values[] = new int[this.barChartDataSeries.get(z).getData()
					.size()];
			// copy elements
			for (int u = 0; u < this.barChartDataSeries.get(z).getData().size(); u++) {
				values[u] = this.barChartDataSeries.get(z).getData().get(u);
			}
			data.add(values);
		}

		boolean isColorUsed = false;
		// the color string
		StringBuilder color = new StringBuilder();
		for (int i = 0; i < this.barChartDataSeries.size(); i++) {

			// the user set a color
			if (this.barChartDataSeries.get(i).getColor() != null) {
				isColorUsed = true;
				color.append(MiscUtils
						.getMatchingColorHexValue(this.barChartDataSeries.get(i)
								.getColor()));
			}
			// no color was set, we add the default color
			if (this.barChartDataSeries.get(i).getColor() == null) {
				color.append(MiscUtils
						.getMatchingColorHexValue(DefaultValues.DataColor));
			}

			// otherwise we have a "," at the end
			if (i < this.barChartDataSeries.size() - 1) {
				color.append(",");
			}
		}

		boolean isLegendUsed = false;

		// the chartLegend
		StringBuilder legend = new StringBuilder();
		for (int u = 0; u < this.barChartDataSeries.size(); u++) {

			// the user set a legend
			if (this.barChartDataSeries.get(u).getLegend() != null) {
				isLegendUsed = true;
				legend.append(this.barChartDataSeries.get(u).getLegend()
						.getAppendableFeatures(null).get(0).getData());
			}
			// no style was set, we add the default legend
			if (this.barChartDataSeries.get(u).getLegend() == null) {
				legend.append("");
			}

			// otherwise we have a "," at the end
			if (u < this.barChartDataSeries.size() - 1) {
				legend.append("|");
			}
		}

		List<AppendableFeature> features = new ArrayList<AppendableFeature>();

		features.add(new AppendableFeature(this.encoder
				.encodeIntegerCollection(data), ChartTypeFeature.ChartData));

		// if the user set the color we have to add the string
		if (isColorUsed) {
			features.add(new AppendableFeature(color.toString(),
					ChartTypeFeature.ChartColor));
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
