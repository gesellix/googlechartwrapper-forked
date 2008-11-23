package googlechartwrapper.data;

import java.util.List;

/**
 * Interface for charts which (usually) have more than one data set, where each can
 * be scaled individually.
 * @author martin
 *
 */
public interface IMultiDataScaleable {

	/**
	 * Adds a {@link DataScalingSet} to the chart and to the nth data set. 
	 * If you supply fewer data scaling parameters than there are data sets 
	 * the last scaling parameter is applied to the remaining data sets. 
	 * Provide just one pair of scaling parameters to apply a single 
	 * range to a chart.
	 * @param ds set for the nth set.
	 */
	public void addDataScalingSet(DataScalingSet ds);
	
	/**
	 * Returns all data scaling sets. The index of each set in the list
	 * is the index to which data set it is applied.
	 * @return unmodifiable list of data scaling sets.
	 */
	public List<DataScalingSet> getDataScalings();
	
	/**
	 * Removes all data scaling sets of the chart.
	 */
	public void removeAllDataScalings();
	
	/**
	 * Removes the nth (index) data scaling set. Each data scaling set 
	 * after the removed set is applied to the nth - 1 set. (each moves one forward)
	 * @param index index to remove
	 * @return the removed data scaling set
	 * @throws IndexOutOfBoundsException if the index is out of 
	 * range (index < 0 || index >= size of this feature list).
	 */
	public DataScalingSet removeDataScalingSet(int index);
	
	/**
	 * Removes the data scaling set.
	 * @param set set to remove
	 * @return <code>true</code> if this list contained the specified element
	 * @see #removeDataScalingSet(int)
	 */
	public boolean removeDataScalingSet(DataScalingSet set);

}
