package googlechartwrapper.data;

import googlechartwrapper.ChartTypeFeature;
import googlechartwrapper.coder.AutoEncoder;
import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.coder.PercentageEncoder;
import googlechartwrapper.data.ConcentricPieChartSlice.ConcentricPieChartSliceBuilder;
import googlechartwrapper.interfaces.IEncodeable;
import googlechartwrapper.style.DefaultValues;
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
 * @see ConcentricPieChartSlice
 * @see ConcentricPieChartSliceBuilder
 * @see ConcentricPieChartSlice
 * 
 */
public class ConcentricPieChartAppender implements IExtendedFeatureAppender,
		IEncodeable {

	protected List<ConcentricPieChartSlice> concentricPieChartSlices = new LinkedList<ConcentricPieChartSlice>();
	protected IEncoder encoder = new PercentageEncoder();

	

	/**
	 * 
	 * @throws IllegalArgumentException
	 *             if concentricPieChartSlices or member is {@code null}
	 */
	public void add(
			List<? extends ConcentricPieChartSlice> concentricPieChartSlices) {

		if (concentricPieChartSlices == null)
			throw new IllegalArgumentException(
					"concentricPieChartSlices can not be null");

		List<ConcentricPieChartSlice> temp = Collections
				.unmodifiableList(concentricPieChartSlices);

		for (ConcentricPieChartSlice current : temp) {
			if (current == null)
				throw new IllegalArgumentException("member can not be null");
		}

		this.concentricPieChartSlices.addAll(concentricPieChartSlices);
	}

	/**
	 * 
	 * @param concentricPieChartSlice
	 * 
	 * @throws IllegalArgumentException
	 *             if concentricPieChartSlice is {@code null}
	 */
	public void add(ConcentricPieChartSlice concentricPieChartSlice) {

		if (concentricPieChartSlice == null)
			throw new IllegalArgumentException(
					"concentricPieChartSlice can not be null");

		this.concentricPieChartSlices.add(concentricPieChartSlice);
	}

	public ConcentricPieChartSlice removeConcentricPieChartSlice(int index) {
		return this.concentricPieChartSlices.remove(index);
	}

	public boolean removeConcentricPieChartSlice(
			ConcentricPieChartSlice concentricPieChartSlice) {
		return this.concentricPieChartSlices.remove(concentricPieChartSlice);
	}

	public void removeAllConcentricPieChartSlice() {
		this.concentricPieChartSlices.clear();
	}

	/**
	 * Returns a unmodifiable list. Empty if nothing was added.
	 * 
	 * @return
	 */
	public List<? extends ConcentricPieChartSlice> getList() {
		return Collections.unmodifiableList(this.concentricPieChartSlices);
	}

	public List<AppendableFeature> getAppendableFeatures(
			List<? extends IFeatureAppender> otherAppenders) {

		// the raw data
		List<int[]> data = new LinkedList<int[]>();

		for (int z = 0; z < this.concentricPieChartSlices.size(); z++) {

			int values[] = new int[this.concentricPieChartSlices.get(z)
					.getPieChartSlices().size()];
			// copy elements
			for (int u = 0; u < this.concentricPieChartSlices.get(z)
					.getPieChartSlices().size(); u++) {
				values[u] = this.concentricPieChartSlices.get(z)
						.getPieChartSlices().get(u).getValue();
			}
			data.add(values);
		}

		boolean isColorUsed = false;
		// the color
		StringBuilder color = new StringBuilder();
		for (int i = 0; i < this.concentricPieChartSlices.size(); i++) {

			// color for the whole concentric slice
			if (this.concentricPieChartSlices.get(i).getColor() != null) {

				isColorUsed = true;
				color.append(MiscUtils
						.getMatchingColorHexValue(this.concentricPieChartSlices
								.get(i).getColor()));				
			}

			// we have to add all the colors in the slices
			else {				

				for (int u = 0; u < this.concentricPieChartSlices.get(i)
						.getPieChartSlices().size(); u++) {

					// no color was set in the slice, we add the default value
					if (this.concentricPieChartSlices.get(i)
							.getPieChartSlices().get(u).getColor() == null) {
						color
								.append(MiscUtils
										.getMatchingColorHexValue(DefaultValues.DataColor));
					}
					// we add the set color
					else {
						color
								.append(MiscUtils
										.getMatchingColorHexValue(this.concentricPieChartSlices
												.get(i).getPieChartSlices()
												.get(u).getColor()));
					}
					// the default delimiter
					if (u < this.concentricPieChartSlices.get(i)
							.getPieChartSlices().size() - 1) {
						color.append("|");
					}
				}
			}

			// otherwise we have a "," or "|" at the end
			if (i < this.concentricPieChartSlices.size() - 1) {
				color.append(",");
			}

		}
		boolean isLabelUsed = false;

		// the label
		StringBuilder label = new StringBuilder();
		for (int x = 0; x < this.concentricPieChartSlices.size(); x++) {

			for (int e = 0; e < this.concentricPieChartSlices.get(x)
					.getPieChartSlices().size(); e++) {

				// the user set a label
				if (this.concentricPieChartSlices.get(x).getPieChartSlices()
						.get(e).getLabel() != null) {
					isLabelUsed = true;
					label.append(this.concentricPieChartSlices.get(x)
							.getPieChartSlices().get(e).getLabel());
				}
				// no label was set, we set ""
				else {
					label.append("");

				}

				// otherwise we have a "|" at the end
				if (e < this.concentricPieChartSlices.get(x)
						.getPieChartSlices().size() - 1) {
					label.append("|");
				}
			}
			// otherwise we have a "|" at the end
			if (x < this.concentricPieChartSlices.size() - 1) {
				label.append("|");
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
		// if the user set the label we have to add the string
		if (isLabelUsed) {
			features.add(new AppendableFeature(label.toString(),
					ChartTypeFeature.PieChartLabel));
		}

		return features;
	}

	public void setEncoder(IEncoder encoder) {
		if (encoder == null) {
			throw new IllegalArgumentException("encoder cannot be null");
		}
		this.encoder = encoder;
	}

	public IEncoder getEncoder() {
		return encoder;
	}

	public void removeEncoder() {
		this.encoder = new AutoEncoder();

	}

}
