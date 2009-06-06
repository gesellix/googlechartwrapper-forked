package de.toolforge.googlechartwrapper;


import java.awt.Dimension;
import java.util.List;

import de.toolforge.googlechartwrapper.coder.EncoderFactory;
import de.toolforge.googlechartwrapper.coder.EncodingType;
import de.toolforge.googlechartwrapper.coder.IEncoder;
import de.toolforge.googlechartwrapper.color.ChartColor;
import de.toolforge.googlechartwrapper.color.IChartColorable;
import de.toolforge.googlechartwrapper.color.ISolidFillable;
import de.toolforge.googlechartwrapper.color.SolidFill;
import de.toolforge.googlechartwrapper.color.SolidFill.ChartFillDestination;
import de.toolforge.googlechartwrapper.util.GenericAppender;

/*
 * enums from <a href="http://code.google.com/p/charts4j/source/browse/trunk/src/com/googlecode/charts4j/USAState.java"
 * > here</a>
 */
/**
 * @author martin
 * @author steffan
 * @version 06/06/09 
 * @see WorldMap
 * @see UsaMap
 * 
 */
public abstract class AbstractMap extends AbstractChart implements ISolidFillable,
		IChartColorable {

	protected GenericAppender<SolidFill> solidFillAppender = new GenericAppender<SolidFill>(
			ChartTypeFeature.SolidFill);
	protected GenericAppender<ChartColor> chartColorAppender = new GenericAppender<ChartColor>(
			ChartTypeFeature.ChartColor, ",");

	
	public AbstractMap(Dimension chartDimension) {
		super(chartDimension);
		
	}
	

	@Override
	protected ChartType getChartType() {
		return ChartType.Map;
	}

	@Override
	protected String getUrlChartType() {
		return ChartType.Map.getPrefix();
	}

	/**
	 * Only supports {@link ChartFillDestination#Background}.
	 * 
	 * @throws IllegalArgumentException
	 *             if {@link SolidFill#getChartFillDestination()} does not
	 *             equals ChartFillDestination#Background
	 */
	public void addSolidFill(SolidFill sf) {
		if (!sf.getChartFillDestination().equals(
				ChartFillDestination.Background)) {
			throw new IllegalArgumentException(
					"only ChartFillDestination.Background supported");
		}
		solidFillAppender.add(sf);
	}

	public List<SolidFill> getSolidFills() {
		return solidFillAppender.getList();
	}

	public void removeAllSolidFills() {
		solidFillAppender.removeAll();

	}

	public SolidFill removeSolidFill(int index) {
		return solidFillAppender.remove(index);
	}

	public boolean removeSolidFill(SolidFill sf) {
		return solidFillAppender.remove(sf);
	}

	public IEncoder getEncoder() {

		// we use always t: , so give them the textEncoder
		return EncoderFactory.getEncoder(EncodingType.TextEncoding);
	}

	/**
	 * {@inheritDoc}
	 * </br />
	 * <b>Note</b>
	 * <br />
	 * The first color in list is the default color, the rest will be used to interpolate, remember the color level in the
	 * {@link UsaMap#State} and {@link WorldMap#Country} constructors.
	 */
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
	
}
