package googlechartwrapper.data;

import java.util.List;

public interface IMultiDataScaleable {

	public void addDataScalingSet(DataScalingSet ds);
	
	public List<DataScalingSet> getDataScalings();
	
	public void removeAllDataScalings();
	
	public DataScalingSet removeDataScalingSet(int index);
	
	public boolean removeDataScalingSet(DataScalingSet set);

}
