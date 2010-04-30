/**
 * 
 */
package de.toolforge.googlechartwrapper;

import de.toolforge.googlechartwrapper.coder.IEncoder;

/**
 * @author steffan
 *
 */
public class FreestandingDynamicIcon extends AbstractChart {
	
	public FreestandingDynamicIcon() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ChartType getChartType() {
		
		return ChartType.FreestandingDynamicIcon;
	}

	@Override
	protected String getUrlChartType() {
		
		return ChartType.FreestandingDynamicIcon.getPrefix();
	}

	@Override
	public IEncoder getEncoder() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getUrl() {
		// TODO Auto-generated method stub
		return super.getUrl();
	}

}
