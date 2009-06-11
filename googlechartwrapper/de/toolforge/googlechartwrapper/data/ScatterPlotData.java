package de.toolforge.googlechartwrapper.data;

import java.util.List;

/**
 * 
 * @author steffan
 *
 */ 
public class ScatterPlotData {
	
	private List<ScatterPlotPoint> dataSet;	
	
	/**
	 * 
	 * @param dataSet
	 * 
	 * @throws IllegalArgumentException if dataSet is <code>null</code>
	 */
	public ScatterPlotData(List<ScatterPlotPoint> dataSet){
		
		if(dataSet == null)
			throw new IllegalArgumentException("dataSet can not be null");				
		
		this.dataSet = dataSet;
				
	}	

	/**
	 * @return the dataSet
	 */
	public List<ScatterPlotPoint> getDataSet() {
		
		return this.dataSet;
		
	}

	/**
	 * @param dataSet the dataSet to set
	 * 
	 * @throws IllegalArgumentException
	 */
	public void setDataSet(List<ScatterPlotPoint> dataSet) {
		
		if(dataSet == null)
			throw new IllegalArgumentException("dataSet can not be null");				
		
		this.dataSet = dataSet;
	}	

}
