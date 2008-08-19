package googlechartwrapper.label;

import java.util.ArrayList;
import java.util.List;

public class AxisLabelSummary {
	
	protected AxisType type; //chxt
	protected List<AxisLabel> labels = new ArrayList<AxisLabel>(0); //chxl
	protected boolean useLabelPositions = false;
	protected boolean useLabels = true;
	protected AxisRange axisRange; //chxr
	protected AxisStyle axisStyle; //chxs

	public AxisLabelSummary(AxisType type) {
		if (type == null){
			throw new IllegalArgumentException("AxisType type cannot be null");
		}
		this.type = type;
	}
	
	public AxisStyle getAxisStyle() {
		return axisStyle;
	}

	public void setAxisStyle(AxisStyle axisStyle) {
		this.axisStyle = axisStyle;
	}
	
	public AxisRange getAxisRange() {
		return axisRange;
	}

	public void setAxisRange(AxisRange axisRange) {
		this.axisRange = axisRange;
	}	

	public List<AxisLabel> getLabels() {
		return labels;
	}
	
	/**
	 * The first label is placed at the start, 
	 * the last at the end, others are uniformly spaced in between.
	 * @param label
	 */
	public void addLabel (AxisLabel label){
		labels.add(label);
	}
	
	public void removeLabel (int index){
		labels.remove(index);
	}
	
	public void removeAllLabels (){
		labels = new ArrayList<AxisLabel>(0);
	}
	
	public AxisType getType() {
		return type;
	}

	public boolean isUseLabelPositions() {
		return useLabelPositions;
	}

	public void setUseLabelPositions(boolean useLabelPositions) {
		this.useLabelPositions = useLabelPositions;
	}

	public boolean isUseLabels() {
		return useLabels;
	}

	public void setUseLabels(boolean useLabels) {
		this.useLabels = useLabels;
	}
	
	
	
	

}
