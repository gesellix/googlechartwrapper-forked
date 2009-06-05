package de.toolforge.googlechartwrapper.data;

/**
 * Specifies a special point for ScatterPlotData, it is possible to set only the x and y coordiantes, but also the point size.
 * If construct only points without pointsize, the api will produce only a dataset, but after the first time you give a pointsize
 * the api will fill the rest of the not given size with 'default value'.
 * 
 * @author steffan
 *
 */
public class ScatterPlotPoint {
	
	private int xCoordinate;
	private int yCoordinate;
	private int size = 200;
	private boolean isSizeSet = false;
	
	
	
	/**
	 * Constructs a ScatterPlotPoint
	 * 
	 * @param xCoordinate
	 * @param yCoordinate
	 * 
	 * @throws IllegalArgumentException if coordinates out of range
	 */
	public ScatterPlotPoint(int xCoordinate, int yCoordinate) {
		
		if(xCoordinate < 0 || yCoordinate < 0)
			throw new IllegalArgumentException("coordinate can not < 0");
		
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
	

	/**
	 * Constructs a ScatterPlotPoint with point size
	 * 
	 * @param xCoordinate
	 * @param yCoordinate
	 * 
	 * @param size the point size
	 * 
	 * @throws IllegalArgumentException if coordinates out of range
	 */
	public ScatterPlotPoint(int xCoordinate, int yCoordinate, int size) {
		
		if(xCoordinate < 0 || yCoordinate < 0)
			throw new IllegalArgumentException("coordinate can not < 0");
		
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.size = size;
		
		this.isSizeSet = true;
	}

	/**
	 * Returns the xCoordinate of the scatterplot point.
	 * @return the xCoordinate
	 */
	public int getXCoordinate() {
		return xCoordinate;
	}

	/**
	 * Sets the xCoordinate.
	 * @param coordinate the xCoordinate to set
	 * 
	 * @throws IllegalArgumentException if coordinate is out of range
	 */
	public void setXCoordinate(int coordinate) {
		
		if(coordinate < 0)
			throw new IllegalArgumentException("coordinate can not < 0");
		
		xCoordinate = coordinate;
	}

	/**
	 * Returns the yCoordinate.
	 * @return the yCoordinate
	 */
	public int getYCoordinate() {
		return yCoordinate;
	}

	/**
	 * Sets the yCoordinate. (>= 0)
	 * @param coordinate the yCoordinate to set
	 * 
	 * @throws IllegalArgumentException if coordinate is of range
	 */
	public void setYCoordinate(int coordinate) {
		if(coordinate < 0)
			throw new IllegalArgumentException("coordinate can not < 0");
		
		yCoordinate = coordinate;
	}

	/**
	 * Returns the size of the scatterplot point.
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Sets the size of the point.
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
		
		this.isSizeSet = true;
	}
	
	/**
	 * Returns whether the size of the point was modified by the user or is
	 * still the default value.
	 * @return the isSizeSet
	 */
	public boolean isSizeSet() {
		return isSizeSet;
	}

}
