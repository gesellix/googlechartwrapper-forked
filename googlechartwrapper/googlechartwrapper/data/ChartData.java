package googlechartwrapper.data;

import googlechartwrapper.coder.Encoder;
import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.util.IFeatureAppender;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 
 * @author steffan
 * 
 */
public class ChartData implements IFeatureAppender, IEncodeable {

	private Collection<Integer> chartData;

	private IEncoder encoder = new Encoder();

	/**
	 * 
	 * @param chartData
	 * 
	 * @throws IllegalArgumentException
	 */
	public ChartData(Collection<Integer> chartData) {

		
		if (chartData == null)
			throw new IllegalArgumentException("chartData can not be null");

		this.chartData = chartData;
		
	}

	public ChartData(int[] chartData) {

		this.chartData = this.arrayToCollection(chartData);
	}

	public String getAppendableString(
			List<? extends IFeatureAppender> otherAppenders) {

		StringBuilder builder = new StringBuilder();

		int a[] = new int[this.chartData.size()];

		for (int i = 0; i < this.chartData.size(); i++) {
			a[i] = (Integer) this.chartData.toArray()[i];
		}

		builder.append(encoder.encode(a));

		return builder.toString();
	}

	public IEncoder getEncoder() {

		return this.encoder;
	}

	public void setEncoder(IEncoder encoder) {

		if (encoder == null)
			throw new IllegalArgumentException("encoder can not bet null");

		this.encoder = encoder;

	}

	private Collection<Integer> arrayToCollection(int[] data) {
		Collection<Integer> c = new ArrayList<Integer>();

		for (int i = 0; i < data.length; i++) {
			c.add(data[i]);
		}

		return c;
	}

	public void removeEncoder() {
		
		this.encoder = new Encoder();		
	}

}
