package de.toolforge.googlechartwrapper;

/**
 * Specifies the format charts can be exported.
 * Note that some output formats are graphcal (for example, PNG and GIF)
 * but others are not.
 * For details see 
 * <a href="http://code.google.com/apis/chart/docs/chart_params.html#gcharts_chof">
 * http://code.google.com/apis/chart/docs/chart_params.html#gcharts_chof</a>.
 * @author mart
 *
 */
public enum OutputFormat {
	/**
	 * Returns the chart as a PNG image.
	 */
	PNG("png"),
	/**
	 * Returns the chart as a GIF image.
	 */
	GIF("gif"),
	/**
	 * Returns image map data for the chart, as a JSON string.
	 * Warning: non-graphical format.
	 */
	JSON("json"),
	/**
	 * Returns an HTML page listing any errors in the chart URL.
	 * Warning: non-graphical format.
	 */
	VALIDATE("validate");
	
	private String append;

	private OutputFormat(String append) {
		this.append = append;
	}
	
	protected String getParameter(){
		return "chof="+append;
	}

}
