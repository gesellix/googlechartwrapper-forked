package de.toolforge.googlechartwrapper;



import java.util.List;

import de.toolforge.googlechartwrapper.coder.AutoEncoder;
import de.toolforge.googlechartwrapper.coder.DataScalingTextEncoder;
import de.toolforge.googlechartwrapper.coder.IEncoder;
import de.toolforge.googlechartwrapper.coder.PercentageEncoder;
import de.toolforge.googlechartwrapper.color.ChartColor;
import de.toolforge.googlechartwrapper.color.LinearGradient;
import de.toolforge.googlechartwrapper.color.LinearStripe;
import de.toolforge.googlechartwrapper.color.SolidFill;
import de.toolforge.googlechartwrapper.data.DataScalingSet;
import de.toolforge.googlechartwrapper.data.ISingleDataScaleable;
import de.toolforge.googlechartwrapper.data.VennDiagramData;
import de.toolforge.googlechartwrapper.data.VennDiagramDataAppender;
import de.toolforge.googlechartwrapper.interfaces.IColorable;
import de.toolforge.googlechartwrapper.interfaces.IEncodeable;
import de.toolforge.googlechartwrapper.interfaces.ILinearable;
import de.toolforge.googlechartwrapper.interfaces.IPercentageScaleable;
import de.toolforge.googlechartwrapper.label.ChartLegend;
import de.toolforge.googlechartwrapper.label.ChartLegendPositionContainer;
import de.toolforge.googlechartwrapper.label.ChartTitle;
import de.toolforge.googlechartwrapper.label.IChartLegendable;
import de.toolforge.googlechartwrapper.style.ChartMargin;
import de.toolforge.googlechartwrapper.util.GenericAppender;
import de.toolforge.googlechartwrapper.util.UpperLimitGenericAppender;
import de.toolforge.googlechartwrapper.util.UpperLimitGenericAppender.UpperLimitReactions;

/**
 * Specifies a venn diagram <a
 * href="http://code.google.com/apis/chart/types.html#venn">
 * http://code.google.com/apis/chart/types.html#venn</a>
 * 
 * <p>
 * Here are some examples of how pie chart can be used:
 * <p>
 * <blockquote>
 * 
 * <pre>
 * VennDiagram diagram = new VennDiagram(new Dimension(200, 200));
 * 
 * diagram.setChartTitle(new ChartTitle(&quot;VennDiagramm&quot;));
 * 
 * diagram.setVennDiagramData(new VennDiagramData(90, 70, 20, 10, 5, 5, 10));
 * 
 * List&lt;String&gt; l = new ArrayList&lt;String&gt;();
 * 
 * l.add(&quot;A&quot;);
 * l.add(&quot;C&quot;);
 * l.add(&quot;V&quot;);
 * 
 * diagram.setChartLegend(new ChartLegend(l));
 * </pre>
 * 
 * </blockquote>
 * <p>
 * 
 * @author steffan
 * @version 03/21/09
 * @see VennDiagramData
 * 
 */
public class VennDiagram extends AbstractChart implements ILinearable,
		IChartLegendable, ISingleDataScaleable, IPercentageScaleable,
		IColorable, IEncodeable {

	protected UpperLimitGenericAppender<LinearGradient> linearGradientAppender = new UpperLimitGenericAppender<LinearGradient>(
			ChartTypeFeature.LinearGradient, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<LinearStripe> linearStripesAppender = new UpperLimitGenericAppender<LinearStripe>(
			ChartTypeFeature.LinearStripes, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<ChartTitle> chartTitleAppender = new UpperLimitGenericAppender<ChartTitle>(
			ChartTypeFeature.ChartTitle, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<ChartLegend> chartLegendAppender = new UpperLimitGenericAppender<ChartLegend>(
			ChartTypeFeature.ChartLegend, 1, UpperLimitReactions.RemoveFirst);
	protected VennDiagramDataAppender vennDiagramAppender = new VennDiagramDataAppender();
	protected GenericAppender<ChartColor> chartColorAppender = new GenericAppender<ChartColor>(
			ChartTypeFeature.ChartColor, ",");
	protected UpperLimitGenericAppender<DataScalingSet> dataScalingAppender = new UpperLimitGenericAppender<DataScalingSet>(
			ChartTypeFeature.DataScaling, 1, UpperLimitReactions.RemoveFirst);
	protected GenericAppender<SolidFill> solidFillAppender = new GenericAppender<SolidFill>(
			ChartTypeFeature.SolidFill);
	protected UpperLimitGenericAppender<ChartMargin> chartMarginAppender = new UpperLimitGenericAppender<ChartMargin>(
			ChartTypeFeature.ChartMargin, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<ChartLegendPositionContainer> chartLegendPositionAppender = new UpperLimitGenericAppender<ChartLegendPositionContainer>(
			ChartTypeFeature.ChartLegendPosition, 1, UpperLimitReactions.RemoveFirst);

	
	/**
	 * Constructs a venn diagram
	 * 
	 * @param chartDimension
	 *            the size of the diagram
	 *            
	 * @deprecated use {@link #VennDiagram(Dimension)}
	 */
	@Deprecated
	public VennDiagram(java.awt.Dimension awtChartDimension) {
		super(awtChartDimension);

	}
	
	/**
	 * Constructs a venn diagram
	 * 
	 * @param chartDimension
	 *            the size of the diagram
	 */
	public VennDiagram(Dimension chartDimension) {
		super(chartDimension);

	}

	/**
	 * Constructs a venn diagram, with given {@link VennDiagramData}.
	 * 
	 * @param chartDimension
	 *            the size of the diagram
	 * 
	 * @throws IllegalArgumentException
	 *             if data is {@code null}
	 *             
	 * @deprecated use {@link #VennDiagram(Dimension, VennDiagramData)}
	 */
	@Deprecated
	public VennDiagram(java.awt.Dimension awtChartDimension, VennDiagramData data) {
		super(awtChartDimension);

	}
	
	/**
	 * Constructs a venn diagram, with given {@link VennDiagramData}.
	 * 
	 * @param chartDimension
	 *            the size of the diagram
	 * 
	 * @throws IllegalArgumentException
	 *             if data is {@code null}
	 */
	public VennDiagram(Dimension chartDimension, VennDiagramData data) {
		super(chartDimension);

	}

	@Override
	protected ChartType getChartType() {

		return ChartType.VennDiagram;
	}

	@Override
	protected String getUrlChartType() {

		return ChartType.VennDiagram.getPrefix();
	}

	public void removeLinearGradient() {
		this.linearGradientAppender.removeAll();

	}

	public void setLinearGradient(LinearGradient lg) {
		if (lg == null) {
			this.removeLinearGradient();
		} else {
			this.linearGradientAppender.add(lg);
		}

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

	public void removeLinearStripes() {
		this.linearStripesAppender.removeAll();

	}

	public void setLinearStripes(LinearStripe ls) {
		this.linearStripesAppender.add(ls);

	}

	public IEncoder getEncoder() {
		return this.vennDiagramAppender.getEncoder();
	}

	public ChartTitle getChartTitle() {

		if (this.chartTitleAppender.getList().size() > 0) {
			return this.chartTitleAppender.getList().get(0);
		} else {
			return null;
		}
	}

	public ChartLegend getChartLegend() {

		if (this.chartLegendAppender.getList().size() > 0) {
			return this.chartLegendAppender.getList().get(0);
		} else {
			return null;
		}
	}

	public void removeChartLegend() {
		this.chartLegendAppender.removeAll();
		this.chartLegendPositionAppender.removeAll();
	}

	public void setChartLegend(ChartLegend legend) {

		if (legend == null) {
			this.removeChartLegend();
		} else {
			this.chartLegendAppender.add(legend);
			if (new ChartLegendPositionContainer(legend
					.getChartLegendPosition()) != null) {
				this.chartLegendPositionAppender
						.add(new ChartLegendPositionContainer(legend
								.getChartLegendPosition()));
			}
		}
	}

	/**
	 * Returns the data, can be {@code null} if nothing was set.
	 * 
	 * @return {@link VennDiagramData} or {@code null}
	 */
	public VennDiagramData getVennDiagramData() {

		return this.vennDiagramAppender.getVennDiagrammData();
	}

	/**
	 * Removes the {@link VennDiagramData}.
	 */
	public void removeVennDiagrammData() {

		this.vennDiagramAppender.removeVennDiagrammData();
	}

	/**
	 * Set the data, the old one will be overwritten.
	 * 
	 * @param data
	 *            {@link VennDiagramData}
	 * 
	 * @throws IllegalArgumentException
	 *             if data is {@code null}
	 */
	public void setVennDiagramData(VennDiagramData data) {

		this.vennDiagramAppender.setVennDiagrammData(data);
	}

	public void addChartColor(ChartColor cc) {

		this.chartColorAppender.add(cc);
	}

	public List<ChartColor> getChartColors() {

		return this.chartColorAppender.getList().size() > 0 ? this.chartColorAppender
				.getList()
				: null;
	}

	public void removeAllChartColors() {
		this.chartColorAppender.removeAll();

	}

	public ChartColor removeChartColor(int index) {

		return this.chartColorAppender.remove(index);
	}

	public boolean removeChartColor(ChartColor cc) {

		return this.chartColorAppender.remove(cc);
	}

	public DataScalingSet getDataScaling() {

		return this.dataScalingAppender.getList().size() > 0 ? this.dataScalingAppender
				.getList().get(0)
				: null;
	}

	public void setDataScaling(DataScalingSet ds) {

		this.dataScalingAppender.add(ds);

		if (ds != null)
			this.vennDiagramAppender.setEncoder(new DataScalingTextEncoder());

	}

	public LinearStripe getLinearStripes() {

		return this.linearStripesAppender.getList().size() > 0 ? this.linearStripesAppender
				.getList().get(0)
				: null;
	}

	public LinearGradient getLinearGradient() {

		return this.linearGradientAppender.getList().size() > 0 ? this.linearGradientAppender
				.getList().get(0)
				: null;
	}

	public void removeDataScaling() {

		this.dataScalingAppender.removeAll();

		this.vennDiagramAppender.setEncoder(new AutoEncoder());

	}

	public void setPercentageScaling(boolean b) {

		if (b) {
			this.vennDiagramAppender.setEncoder(new PercentageEncoder());
		} else {
			this.vennDiagramAppender.setEncoder(new AutoEncoder());
		}

		this.dataScalingAppender.removeAll();

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

	public ChartMargin getChartMargin() {
		return this.chartMarginAppender.getList().size() > 0 ? this.chartMarginAppender
				.getList().get(0)
				: null;
	}

	public void removeChartMargin() {
		this.chartMarginAppender.removeAll();

	}

	public void setChartMargin(ChartMargin cm) {
		if (cm == null) {
			this.chartMarginAppender.removeAll();
		} else {
			this.chartMarginAppender.add(cm);
		}
	}

	public void removeEncoder() {
		this.vennDiagramAppender.removeEncoder();
		
	}

	public void setEncoder(IEncoder encoder) {
		this.vennDiagramAppender.setEncoder(encoder);
		
	}

}
