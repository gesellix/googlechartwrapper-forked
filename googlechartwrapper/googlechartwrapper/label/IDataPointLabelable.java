package googlechartwrapper.label;

import googlechartwrapper.style.RangeMarker;

import java.util.List;

/**
 * The interface for chart types which supports <a href="http://code.google.com/apis/chart/labels.html#data_point_labels">
 * http://code.google.com/apis/chart/labels.html#data_point_labels</a>
 * 
 * @author steffan
 *
 */
public interface IDataPointLabelable {

	/**
	 * Adds an new DataPointLabel to the Chart.
	 * 
	 * @param dpl the new DataPointLabel
	 * 
	 * @throws IllegalArgumentException if you try to add <code>null</code>
	 */
	public void addDataPointLabel(DataPointLabel dpl);
	
	/**
	 * Returns a unmodifiable list of DataPointLabels.
	 * 
	 * @return list of DataPointLabel, can be empty.
	 */
	public List<DataPointLabel> getDataPointLabels();
	
	/**
	 * Removes an DataPointLabel at the given position.
	 * 
	 * @param index
	 * 
	 * @return the removed DataPointLabel
	 * 
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public DataPointLabel removeDataPointLabel(int index);
	
	/**
	 * Removes an given DataPointLabel object. 
	 * 
	 * @param dpl the DataPointLabel object in the list.
	 * 
	 * @return true if the remove was successful
	 */
	public boolean removeDataPointLabel(DataPointLabel dpl);
	
	/**
	 * Removes all DataPointLabels in the list.
	 * 
	 */
	public void removeDataPointLabels();
}
