package de.toolforge.googlechartwrapper.label;

import java.util.List;

/**
 * 
 * @author steffan
 *
 */
public interface IAxisLabelable {
	
	/**
	 * Adds a new container to the chart
	 * @param labelContainer the {@link AxisLabelContainer} to add.
	 * 
	 * @throws IllegalArgumentException if labelContainer is {@code null}
	 */
	public void addAxisLabelContainer (AxisLabelContainer labelContainer);
	
	/**
	 * Returns a list of {@link AxisLabelContainer}, can be empty.
	 * @return list of {@link AxisLabelContainer} or empty list
	 */
	public List<AxisLabelContainer> getAxisLabelContainer();
	
	/**
	 * Removes a {@link AxisLabelContainer} at the given index.
	 * @param index
	 * @return the removed {@link AxisLabelContainer}
	 * 
	 * @throws IndexOutOfBoundsException if index is out of bounds
	 */
	public AxisLabelContainer removeAxisLabelContainer(int index);
	
	/**
	 * Removes a {@link AxisLabelContainer}.
	 * @param labelContainer the {@link AxisLabelContainer} to remove.
	 * @return {@code true} if success
	 */
	public boolean removeAxisLabelContainer(AxisLabelContainer labelContainer);

	/**
	 * Removes all {@link AxisLabelContainer} from the chart.
	 */
	public void removeAllAxisLabelContainer();

}
