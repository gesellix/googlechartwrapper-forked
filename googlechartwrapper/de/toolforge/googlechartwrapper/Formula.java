/**
 * 
 */
package de.toolforge.googlechartwrapper;

import java.awt.Dimension;
import java.util.List;

import de.toolforge.googlechartwrapper.coder.EncoderFactory;
import de.toolforge.googlechartwrapper.coder.EncodingType;
import de.toolforge.googlechartwrapper.coder.ExtendedEncoder;
import de.toolforge.googlechartwrapper.coder.IEncoder;
import de.toolforge.googlechartwrapper.color.ILinearGradientable;
import de.toolforge.googlechartwrapper.color.ILinearStripeable;
import de.toolforge.googlechartwrapper.color.ISolidFillable;
import de.toolforge.googlechartwrapper.color.LinearGradient;
import de.toolforge.googlechartwrapper.color.LinearStripe;
import de.toolforge.googlechartwrapper.color.SolidFill;
import de.toolforge.googlechartwrapper.data.FormulaData;
import de.toolforge.googlechartwrapper.data.FormulaDataAppender;
import de.toolforge.googlechartwrapper.util.GenericAppender;
import de.toolforge.googlechartwrapper.util.UpperLimitGenericAppender;
import de.toolforge.googlechartwrapper.util.UpperLimitGenericAppender.UpperLimitReactions;

/**
 * @author steffan
 *
 */
public class Formula extends AbstractChart implements ISolidFillable, ILinearGradientable, ILinearStripeable{

	protected UpperLimitGenericAppender<LinearGradient> linearGradientAppender = new UpperLimitGenericAppender<LinearGradient>(
			ChartTypeFeature.LinearGradient, 1, UpperLimitReactions.RemoveFirst);
	protected UpperLimitGenericAppender<LinearStripe> linearStripesAppender = new UpperLimitGenericAppender<LinearStripe>(
			ChartTypeFeature.LinearStripes, 1, UpperLimitReactions.RemoveFirst);
	protected GenericAppender<SolidFill> solidFillAppender = new GenericAppender<SolidFill>(
			ChartTypeFeature.SolidFill);
	protected FormulaDataAppender formulaDataAppender = new FormulaDataAppender();
	
	public Formula(FormulaData data, Dimension chartDimension) {
		super(new Dimension(chartDimension));
		
		this.formulaDataAppender.setFormulaData(data);
		
	}
	public Formula(FormulaData data, int height) {
		super(new Dimension());
		
		this.formulaDataAppender.setFormulaData(data);
		
	}
	public Formula(FormulaData data) {
		super(new Dimension());
		
		this.formulaDataAppender.setFormulaData(data);
		
	}

	@Override
	protected ChartType getChartType() {
		
		return ChartType.Formula;
	}

	protected String getUrlChartType() {
		
		return ChartType.Formula.getPrefix();
	}

	/**
	 * Returns always {@link ExtendedEncoder}.
	 */
	public IEncoder getEncoder() {
		
		return EncoderFactory.getEncoder(EncodingType.TextEncoding);
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
		this.linearGradientAppender.removeAll();

	}

	public void setLinearGradient(LinearGradient lg) {

		if (lg == null) {
			this.removeLinearGradient();
		} else {
			this.linearGradientAppender.add(lg);
		}

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

	public void removeLinearStripes() {
		this.linearStripesAppender.removeAll();

	}

	public void setLinearStripes(LinearStripe ls) {
		this.linearStripesAppender.add(ls);

	}

}
