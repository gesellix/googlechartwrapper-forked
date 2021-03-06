package de.toolforge.googlechartwrapper;



import java.util.List;

import de.toolforge.googlechartwrapper.coder.AutoEncoder;
import de.toolforge.googlechartwrapper.coder.DataScalingTextEncoder;
import de.toolforge.googlechartwrapper.coder.IEncoder;
import de.toolforge.googlechartwrapper.coder.PercentageEncoder;
import de.toolforge.googlechartwrapper.color.ChartColor;
import de.toolforge.googlechartwrapper.color.IMultiDataSetChartColorable;
import de.toolforge.googlechartwrapper.color.MultiDataSetChartColorAppender;
import de.toolforge.googlechartwrapper.data.ConcentricPieChartAppender;
import de.toolforge.googlechartwrapper.data.ConcentricPieChartSlice;
import de.toolforge.googlechartwrapper.data.DataScalingSet;
import de.toolforge.googlechartwrapper.data.IMultiDataScaleable;
import de.toolforge.googlechartwrapper.data.PieChartSlice;
import de.toolforge.googlechartwrapper.data.ConcentricPieChartSlice.ConcentricPieChartSliceBuilder;
import de.toolforge.googlechartwrapper.interfaces.IEncodeable;
import de.toolforge.googlechartwrapper.util.GenericAppender;

/**
 * Specifies a ConcentricPieChart <a
 * href="http://code.google.com/apis/chart/types.html#pie_charts">
 * http://code.google.com/apis/chart/types.html#pie_charts</a> <br />
 * For pie chart see {@link PieChart}.
 * 
 * <p>
 * Here are some examples of how concentric pie chart can be used:
 * <p>
 * <blockquote>
 * 
 * <pre>
 * ConcentricPieChart chart = new ConcentricPieChart(new Dimension(400,180));
 *		
 * List<PieChartSlice> list = new ArrayList<PieChartSlice>();
 *		
 * list.add(new PieChartSlice.PieChartSliceBuilder(80).label("USA").color(Color.BLUE).build());
 * list.add(new PieChartSlice.PieChartSliceBuilder(20).label("Canada").build());
 *		
 * ConcentricPieChartSlice cslice = new ConcentricPieChartSlice.ConcentricPieChartSliceBuilder(list).color(Color.RED).build();
 *		
 * chart.addConcentricPieChartSlice(cslice);
 * </pre>
 * 
 * </blockquote>
 * <p>
 * 
 * @author steffan
 * @version 03/21/09
 * @see ConcentricPieChartSlice
 * @see ConcentricPieChartSliceBuilder
 * 
 */
public class ConcentricPieChart extends AbstractPieChart implements
		IMultiDataSetChartColorable, IEncodeable, IMultiDataScaleable {

	protected ConcentricPieChartAppender concentricPieChartAppender = new ConcentricPieChartAppender();
	protected MultiDataSetChartColorAppender multiDataSetChartColorAppender = new MultiDataSetChartColorAppender();
	protected GenericAppender<DataScalingSet> dataScalingAppender = new GenericAppender<DataScalingSet>(
			ChartTypeFeature.DataScaling);

	/**
	 * Constructs a new {@link ConcentricPieChart}.
	 * 
	 * @param chartDimension
	 * 
	 * @deprecated use {@link #ConcentricPieChart(Dimension)}
	 */
	@Deprecated
	public ConcentricPieChart(java.awt.Dimension awtChartDimension) {
		super(awtChartDimension);

	}
	
	
	/**
	 * Constructs a new {@link ConcentricPieChart}.
	 * 
	 * @param chartDimension
	 */
	public ConcentricPieChart(Dimension chartDimension) {
		super(chartDimension);

	}

	/**
	 * Constructs a new {@link ConcentricPieChart} with a list of
	 * {@link ConcentricPieChartSlice}
	 * 
	 * @param chartDimension
	 * @param concentricPieChartSlices
	 *            list of {@link ConcentricPieChartSlice}.
	 * 
	 * @throws IllegalArgumentException
	 *             if concentricPieChartSlice or member is {@code null}
	 *             
	 * @deprecated use {@link #ConcentricPieChart(Dimension, ConcentricPieChartSlice)}
	 */
	@Deprecated
	public ConcentricPieChart(java.awt.Dimension awtChartDimension,
			List<? extends ConcentricPieChartSlice> concentricPieChartSlices) {
		super(awtChartDimension);

		this.concentricPieChartAppender.add(concentricPieChartSlices);

	}
	
	/**
	 * Constructs a new {@link ConcentricPieChart} with a list of
	 * {@link ConcentricPieChartSlice}
	 * 
	 * @param chartDimension
	 * @param concentricPieChartSlices
	 *            list of {@link ConcentricPieChartSlice}.
	 * 
	 * @throws IllegalArgumentException
	 *             if concentricPieChartSlice or member is {@code null}
	 */
	public ConcentricPieChart(Dimension chartDimension,
			List<? extends ConcentricPieChartSlice> concentricPieChartSlices) {
		super(chartDimension);

		this.concentricPieChartAppender.add(concentricPieChartSlices);

	}

	/**
	 * Constructs a new {@link ConcentricPieChart} with a single
	 * {@link ConcentricPieChartSlice}
	 * 
	 * @param chartDimension
	 * @param concentricPieChartSlice
	 * 
	 * @throws IllegalArgumentException
	 *             if concentricPieChartSlice is {@code null}
	 *             
	 * @deprecated use {@link #ConcentricPieChart(Dimension, ConcentricPieChartSlice)}
	 */
	public ConcentricPieChart(java.awt.Dimension awtChartDimension,
			ConcentricPieChartSlice concentricPieChartSlice) {
		super(awtChartDimension);

		this.concentricPieChartAppender.add(concentricPieChartSlice);

	}

	
	/**
	 * Constructs a new {@link ConcentricPieChart} with a single
	 * {@link ConcentricPieChartSlice}
	 * 
	 * @param chartDimension
	 * @param concentricPieChartSlice
	 * 
	 * @throws IllegalArgumentException
	 *             if concentricPieChartSlice is {@code null}
	 */
	public ConcentricPieChart(Dimension chartDimension,
			ConcentricPieChartSlice concentricPieChartSlice) {
		super(chartDimension);

		this.concentricPieChartAppender.add(concentricPieChartSlice);

	}

	/**
	 * Adds a list of {@link ConcentricPieChartSlice}
	 * 
	 * @param concentricPieChartSlices
	 * 
	 * @throws IllegalArgumentException
	 *             if concentricPieChartSlice or member is {@code null}
	 */
	public void addConcentricPieChartSlice(
			List<? extends ConcentricPieChartSlice> concentricPieChartSlices) {

		this.concentricPieChartAppender.add(concentricPieChartSlices);
	}

	/**
	 * Adds a single {@link ConcentricPieChartSlice}
	 * 
	 * @param concentricPieChartSlice
	 * 
	 * @throws IllegalArgumentException
	 *             if concentricPieChartSlice is {@code null}
	 */
	public void addConcentricPieChartSlice(
			ConcentricPieChartSlice concentricPieChartSlice) {

		this.concentricPieChartAppender.add(concentricPieChartSlice);
	}

	/**
	 * Removes a {@link ConcentricPieChartSlice} at the given position.
	 * 
	 * @param index
	 * @return the removed {@link ConcentricPieChartSlice}
	 * 
	 * @throws IndexOutOfBoundsException
	 *             if index is out of bound
	 */
	public ConcentricPieChartSlice removeConcentricPieChartSlice(int index) {
		return this.concentricPieChartAppender
				.removeConcentricPieChartSlice(index);
	}

	/**
	 * Removes a given {@link ConcentricPieChartSlice} and returns the status.
	 * 
	 * @param concentricPieChartSlice
	 * @return {@code true} if success
	 */
	public boolean removeConcentricPieChartSlice(
			ConcentricPieChartSlice concentricPieChartSlice) {

		return this.concentricPieChartAppender
				.removeConcentricPieChartSlice(concentricPieChartSlice);
	}

	/**
	 * Removes all {@link PieChartSlice}
	 */
	public void removeAllPieChartSlices() {
		this.concentricPieChartAppender.removeAllConcentricPieChartSlice();
	}

	/**
	 * Returns a unmodifiable list of all {@link ConcentricPieChartSlice}.
	 * 
	 * @return unmodifiable list, empty if nothing was set
	 */
	public List<? extends ConcentricPieChartSlice> getAllConcentricPieChartSlices() {
		return this.concentricPieChartAppender.getList();
	}

	@Override
	protected String getUrlChartType() {

		return ChartType.PieChartConcentric.getPrefix();
	}

	@Override
	protected ChartType getChartType() {

		return ChartType.PieChartConcentric;
	}

	/**
	 * Encode the values as percentages before, the api calculates the values.
	 * This can decrease the url length. DEFAULT is true.
	 */
	public void setPercentageScaling(boolean b) {

		if (b) {
			this.concentricPieChartAppender.setEncoder(new PercentageEncoder());
		} else {
			this.concentricPieChartAppender.setEncoder(new AutoEncoder());
		}
	}

	public IEncoder getEncoder() {

		return this.concentricPieChartAppender.getEncoder();
	}

	public void addChartColor(ChartColor chartColor) {
		this.multiDataSetChartColorAppender.addChartColor(chartColor);

	}

	public void addChartColorSet(List<ChartColor> ccl) {

		this.multiDataSetChartColorAppender.addChartColorSet(ccl);

	}
	public void removeEncoder() {
		this.concentricPieChartAppender.removeEncoder();
	}

	public void setEncoder(IEncoder encoder) {
		this.concentricPieChartAppender.setEncoder(encoder);
		
	}
	public void addDataScalingSet(DataScalingSet ds) {
		this.dataScalingAppender.add(ds);
		this.concentricPieChartAppender.setEncoder(new DataScalingTextEncoder());
	}

	public List<DataScalingSet> getDataScalings() {

		return this.dataScalingAppender.getList().size() > 0 ? this.dataScalingAppender
				.getList()
				: null;
	}

	/**
	 * Removes all datascalings and sets the default encoder.
	 *  
	 */
	public void removeAllDataScalings() {

		this.dataScalingAppender.removeAll();

		this.concentricPieChartAppender.removeEncoder();
		

	}

	public DataScalingSet removeDataScalingSet(int index) {
		return this.dataScalingAppender.remove(index);
	}

	public boolean removeDataScalingSet(DataScalingSet set) {
		return this.dataScalingAppender.remove(set);
	}
	

}
