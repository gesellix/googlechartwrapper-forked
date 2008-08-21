package googlechartwrapper.label;

import java.util.List;

public interface IAxisLabelable {
	
	public void addAxisLabelSummary (AxisLabelSummary labelSummary);
	
	public List<AxisLabelSummary> getAxisLabelSummaries();
	
	public AxisLabelSummary removeAxisLabelSummary(int index);
	
	public boolean removeAxisLabelSummary(AxisLabelSummary labelSummary);

	public void removeAllAxisLabelSummaries();

}
