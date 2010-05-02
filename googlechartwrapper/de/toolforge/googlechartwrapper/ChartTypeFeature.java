package de.toolforge.googlechartwrapper;

/**
 * 
 * @author steffan
 *
 */
public enum ChartTypeFeature {

	Marker("chm"),
	GridLine("chg"),
	ChartTitle("chtt"),
	ChartTitleStyle("chts"),
	LinearGradient("chf"),
	FillArea("chm"),
	SolidFill("chf"),
	AxisLabel("chxt"),
	LinearStripes("chf"),
	ChartLegend("chdl"),	
	ChartLegendPosition("chdlp"),
	ChartData("chd"),
	ChartDataAppender(""),
	ChartColor("chco"),
	DataScaling("chds"),
	PieChartOrientation("chp"),
	ChartMargin("chma"),
	LineStyle("chls"),
	BarWidthAndSpacing("chbh"),
	BarChartZeroLine("chp"),
	FormulaData("chl"),
	//also used for tex - wtf
	PieChartLabel("chl"),
	LineAndBarChartLineStyle("chm=D"),
	FreeStandingDynamicIcon("chst"),
	EmbeddedDynamicIconMarker("chem");
	
	
	
	private String prefix;
		
	ChartTypeFeature(String prefix) {
		this.prefix = prefix;
	}
	
	public String getPrefix(){
		return prefix;
	}
	
}
