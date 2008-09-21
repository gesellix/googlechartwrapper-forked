package googlechartwrapper.data;

import java.awt.Point;
import java.util.Collection;

/**
 * 
 * @author steffan
 *
 */ 
public class ScatterPlotData {
	
	private Collection<Point> dataSet;	
	private Collection<Integer> dataSetSize;
	
	public ScatterPlotData(Collection<Point> dataSet){
		
		if(dataSet == null)
			throw new IllegalArgumentException("dataSet can not be null");
		
		for(Point p : dataSet){
			
			if(p.x < 0 || p.y < 0)
				throw new IllegalArgumentException("coordinate can not < 0");
			if(p == null)
				throw new IllegalArgumentException("point can not be null");
		}
		
		this.dataSet = dataSet;
		
		
	}
	
	public ScatterPlotData(Collection<Point> dataSet, Collection<Integer> dataSetSize){
		
		if(dataSet == null)
			throw new IllegalArgumentException("dataSet can not be null");
		
		for(Point p : dataSet){
			if(p.x < 0 || p.y < 0)
				throw new IllegalArgumentException("coordinate can not < 0");
			if(p == null)
				throw new IllegalArgumentException("point can not be null");
		}
		
		if(dataSetSize == null)
			throw new IllegalArgumentException("dataSetSize can not be null");		
		
		this.dataSet = dataSet;
		this.dataSetSize = dataSetSize;
		
	}	

	/**
	 * @return the dataSetX
	 */
	public Collection<Point> getDataSet() {
		return dataSet;
	}

	/**
	 * @param dataSetX the dataSetX to set
	 * 
	 * @throws IllegalArgumentException
	 */
	public void setDataSet(Collection<Point> dataSet) {
		
		if(dataSet == null)
			throw new IllegalArgumentException("dataSet can not be null");
		
		for(Point p : dataSet){
			if(p.x < 0 || p.y < 0)
				throw new IllegalArgumentException("coordinate can not < 0");
			if(p == null)
				throw new IllegalArgumentException("point can not be null");
		}
		
		this.dataSet = dataSet;
	}
	

	/**
	 * @return the dataSetSize
	 */
	public Collection<Integer> getDataSetSize() {
		return dataSetSize;
	}

	/**
	 * @param dataSetSize the dataSetSize to set
	 * 
	 * @throws IllegalArgumentException
	 */
	public void setDataSetSize(Collection<Integer> dataSetSize) {
		
		if(dataSetSize == null)
			throw new IllegalArgumentException("dataSetSize can not be null");		
		
		this.dataSetSize = dataSetSize;
	}
	
	

}
