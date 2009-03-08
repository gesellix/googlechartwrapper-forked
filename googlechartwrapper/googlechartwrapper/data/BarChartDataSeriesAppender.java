package googlechartwrapper.data;

import googlechartwrapper.ChartTypeFeature;
import googlechartwrapper.coder.AutoEncoder;
import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.interfaces.IEncodeable;
import googlechartwrapper.util.AppendableFeature;
import googlechartwrapper.util.IExtendedFeatureAppender;
import googlechartwrapper.util.IFeatureAppender;

import java.util.ArrayList;
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
	protected List<BarChartDataSeries> list = new LinkedList<BarChartDataSeries>();

	public void add(BarChartDataSeries ds) {
		list.add(ds);
	}

	public boolean remove(BarChartDataSeries ds) {
		return list.remove(ds);
	}

	public BarChartDataSeries remove(int index) {
		return list.remove(index);
	}

	public void removeAll() {
		for (int i = 0; i < list.size();) {
			list.remove(i);
		}
	}

	public String getFeaturePrefix() {

		return ChartTypeFeature.ChartData.getPrefix();
	}

	public List<AppendableFeature> getAppendableString(
			List<? extends IFeatureAppender> otherAppenders) {
		// TODO
		
		StringBuilder builder = new StringBuilder();
		// data
		for (int i = 0; i < this.getLongestDataSeriesSize(); i++) {

			for (BarChartDataSeries currentSeries : this.list) {

				if (currentSeries.getData().size() < i) {

					builder.append(',');
					builder.append(currentSeries.getData().toArray()[i]);
				}
			}
		}
		builder.append("s:hello,world");
		
List<AppendableFeature> feature = new ArrayList<AppendableFeature>(); 
		
        feature.add(new AppendableFeature(builder.toString(), 
                  ChartTypeFeature.ChartData)); 
        
		return feature;
	}

	private int getLongestDataSeriesSize() {

		int size = 0;

		for (BarChartDataSeries currentSeries : this.list) {

			if (currentSeries.getData().size() > size) {
				size = currentSeries.getData().size();
			}
		}

		return size;
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
