package googlechartwrapper;

import googlechartwrapper.coder.IEncoder;

import java.awt.Dimension;

/**
 * 
 * @author steffan
 *
 */
public class ConcentricPieCharts extends AbstractPieChart{

	public ConcentricPieCharts(Dimension chartDimension) {
		super(chartDimension);
		
	}
	@Override
	protected String getUrlChartType() {
		
		return ChartType.PieChartConcentric.getPrefix();
	}
	@Override
	protected ChartType getChartType() {
		
		return ChartType.PieChartConcentric;
	}
	public void setPercentageScaling(boolean b) {
		// TODO Auto-generated method stub
		
	}
	public IEncoder getEncoder() {
		// TODO Auto-generated method stub
		return null;
	}

}
