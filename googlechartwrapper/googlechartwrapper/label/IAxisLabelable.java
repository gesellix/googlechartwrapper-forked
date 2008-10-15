package googlechartwrapper.label;

import java.util.List;

public interface IAxisLabelable {
	
	public void addAxisLabelSummary (AxisLabelContainer labelSummary);
	
	public List<AxisLabelContainer> getAxisLabelSummaries();
	
	public AxisLabelContainer removeAxisLabelSummary(int index);
	
	public boolean removeAxisLabelSummary(AxisLabelContainer labelSummary);

	public void removeAllAxisLabelSummaries();

}
