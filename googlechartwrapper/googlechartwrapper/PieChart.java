package googlechartwrapper;

import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.color.ILinearGradientable;
import googlechartwrapper.color.ILinearStripeable;
import googlechartwrapper.color.ISolidFillable;
import googlechartwrapper.color.LinearGradient;
import googlechartwrapper.color.LinearStripes;
import googlechartwrapper.color.SolidFill;
import googlechartwrapper.color.LinearGradient.GradientFillDestination;
import googlechartwrapper.color.LinearStripes.LinearStripesDestination;
import googlechartwrapper.data.PieChartSlice;
import googlechartwrapper.data.PieChartSliceAppender;
import googlechartwrapper.label.ChartTitle;
import googlechartwrapper.label.IChartTitleable;
import googlechartwrapper.util.GenericAppender;
import googlechartwrapper.util.UpperLimitGenericAppender;
import googlechartwrapper.util.UpperLimitGenericAppender.UpperLimitReactions;

import java.awt.Dimension;
import java.util.Collection;
import java.util.List;

public class PieChart extends AbstractChart implements ISolidFillable,
		ILinearGradientable, ILinearStripeable, IChartTitleable {

	private boolean threeD;
	protected PieChartSliceAppender dataAppender = new PieChartSliceAppender();
	protected GenericAppender<SolidFill> solidFillAppender = new GenericAppender<SolidFill>(
			ChartTypeFeature.SolidFill);
	protected UpperLimitGenericAppender<LinearGradient> linearGradientAppender = new UpperLimitGenericAppender<LinearGradient>(
			ChartTypeFeature.LinearGradient, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<LinearStripes> linearStripesAppender = new UpperLimitGenericAppender<LinearStripes>(
			ChartTypeFeature.LinearStripes, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<ChartTitle> chartTitleAppender = new UpperLimitGenericAppender<ChartTitle>(
			ChartTypeFeature.ChartTitle, 1, UpperLimitReactions.RemoveFirst);

	public PieChart(Dimension chartDimension, boolean threeD) {
		super(chartDimension);
		this.threeD = threeD;
	}

	@Override
	protected ChartType getChartType() {
		return ChartType.PieChart;
	}

	@Override
	protected String getUrlChartType() {
		return threeD ? "p3" : "p";
	}

	/**
	 * Returns if the chart is displayed 3-dimensional or 2-dimensional.
	 * 
	 * @return <code>true</code> if chart is displayed 3-dimensional;
	 *         <code>false</code> otherwise
	 */
	public boolean isThreeD() {
		return threeD;
	}

	/**
	 * Sets whether the chart is displayed 3-dimensional or not.
	 * 
	 * @param threeD
	 *            <code>true</code> if chart is displayed 3-dimensional;
	 *            <code>false</code> otherwise
	 */
	public void setThreeD(boolean threeD) {
		this.threeD = threeD;
	}

	/**
	 * Adds a slice to the chart. The data values are transformed into
	 * percentages by the API. If some slices have a color set and others don't,
	 * the color of the slices is interpolated.
	 * 
	 * @param slice
	 */
	public void addPieChartSlice(PieChartSlice slice) {
		dataAppender.add(slice);
	}

	public boolean removePieChartSlice(PieChartSlice slice) {
		return dataAppender.remove(slice);
	}

	public PieChartSlice removePieChartSlice(int index) {
		return dataAppender.remove(index);
	}

	public void removeAllPieChartSlices() {
		dataAppender.removeAll();
	}

	public List<? extends PieChartSlice> getAllPieChartSlices() {
		return dataAppender.getList();
	}

	public IEncoder getEncoder() {
		return dataAppender.getEncoder();
	}

	public void setEncoder(IEncoder encoder) {
		dataAppender.setEncoder(encoder);
	}

	public void addSolidFill(SolidFill sf) {
		this.solidFillAppender.add(sf);

	}

	public List<SolidFill> getSolidFills() {

		return this.solidFillAppender.getList();
	}

	public void removeAllSolidFills() {
		this.solidFillAppender.removeAll();

	}

	public SolidFill removeSolidFill(int index) {
		return this.solidFillAppender.remove(index);
	}

	public boolean removeSolidFill(SolidFill sf) {
		return this.solidFillAppender.remove(sf);
	}

	public void removeLinearGradient() {
		linearGradientAppender.removeAll();
	}

	public void setLinearGradient(LinearGradient lg) {
		if (lg == null) {
			linearGradientAppender.removeAll();
			return;
		}
		if (!lg.getFillDestination().equals(GradientFillDestination.Background)) {
			throw new IllegalArgumentException("only GradientFillDestination"
					+ ".Background supported");
		}
		this.linearGradientAppender.add(lg);
	}

	public void removeLinearStripes() {
		linearStripesAppender.removeAll();
	}

	public void setLinearStripes(LinearStripes ls) {
		if (ls == null) {
			linearStripesAppender.removeAll();
			return;
		}
		if (!ls.getFillDestination()
				.equals(LinearStripesDestination.Background)) {
			throw new IllegalArgumentException("only LinearStripesDestination"
					+ ".Background supported");
		}
		this.linearStripesAppender.add(ls);
	}

	public void removeChartTitle() {
		this.chartTitleAppender.removeAll();

	}

	public void setChartTitle(ChartTitle title) {
		if (title == null) {
			removeChartTitle();
			return;
		}
		this.chartTitleAppender.add(title);

	}

	public ChartTitle getChartTitle() {

		if (this.chartTitleAppender.getList().size() > 0) {
			return this.chartTitleAppender.getList().get(0);

		} else {
			return null;
		}

	}
	
	/**
	 * from 0..100 percent
	 * @author mart
	 *
	 */
	public static class PercentageEncoder implements IEncoder{

		public String encode(int[] values) {
			int sum = 0;
			for (int i = 0; i < values.length; i++){
				sum = sum+values[i];
			}
			StringBuffer bf = new StringBuffer(values.length*3+5);
			bf.append("chd=t:");
			for (int i = 0; i < values.length; i++){
				bf.append(Integer.toString((values[i]*100/sum)));
				bf.append(",");
			}
			return bf.substring(0, bf.length()-1);
		}

		public String encode(float[] values) {
			/*StringBuffer bf = new StringBuffer(values.length*3+5);
			bf.append("chd=t:");
			for (int i = 0; i < values.length; i++){
				bf.append((int)values[i]%100);
				bf.append(",");
			}
			return bf.substring(0, bf.length()-1);*/
			return null;
		}

		public String encodeFloatCollection(Collection<float[]> values) {
			return null;
		}

		public String encodeIntegerCollection(Collection<int[]> values) {
			
			return null;
		}
		
	}

}
