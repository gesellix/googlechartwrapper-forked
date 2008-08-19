package googlechartwrapper.label;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import googlechartwrapper.util.IExtendedFeatureAppender;
import googlechartwrapper.util.IFeatureAppender;
import googlechartwrapper.util.MiscUtils;

public class AxisLabelAppender implements IExtendedFeatureAppender{
	
	List<AxisLabelSummary> axis = new ArrayList<AxisLabelSummary>();

	public String getFeaturePrefix() {
		return "chxt";
	}

	public String getAppendableString(List<? extends IFeatureAppender> otherAppenders) {
		if (axis.size() < 1){
			return "";
		}
		
		StringBuffer axisTypes = new StringBuffer(axis.size()+1);
		for (int i = 0; i < axis.size(); i++){
			axisTypes.append(axis.get(i).getType().getType());
			axisTypes.append(",");
		}
		
		//Axis labels
		StringBuffer axisLabels = new StringBuffer(axis.size()*5+1);
		//chxl= <axis index>:|<label 1>|<label n>|
		for (int i = 0; i < axis.size(); i++){
			AxisLabelSummary sum = axis.get(i);
			if (sum.getLabels().size() > 0){
				if (sum.isUseLabels()){
					axisLabels.append(i);
					axisLabels.append(":|");
					for (AxisLabel label : sum.getLabels()){
						axisLabels.append(label.getLabel());
						axisLabels.append("|");
					}
				}				
			}			
		}
		
		//Position
		//chxp= <axis index>,<label 1 position>,<label n position>|

		StringBuffer axisLabelsPos = new StringBuffer(axis.size()*5+1);
		for (int i = 0; i < axis.size(); i++){
			AxisLabelSummary sum = axis.get(i);
			if (sum.isUseLabelPositions()){
				if (sum.getLabels().size() > 0){
					axisLabelsPos.append(i);
					axisLabelsPos.append(",");
					for (AxisLabel label : sum.getLabels()){
						axisLabelsPos.append(label.getPos());
						axisLabelsPos.append(",");
					}
					axisLabelsPos.replace(axisLabelsPos.length()-1, axisLabelsPos.length(), "");
					axisLabelsPos.append("|");
				}
			}			
		}
		
		//Range
		//chxr= <axis index>,<start of range>,<end of range>|

		StringBuffer axisRange = new StringBuffer(axis.size()*5+1);
		for (int i = 0; i < axis.size(); i++){
			AxisLabelSummary sum = axis.get(i);
			if (sum.getAxisRange() != null){
				axisRange.append(i);
				axisRange.append(",");
				axisRange.append(sum.getAxisRange().getLower());
				axisRange.append(",");
				axisRange.append(sum.getAxisRange().getUpper());
				axisRange.append("|");
			}
		}
		
		//Style
		//chxs= <axis index>,<color>,<font size>,<alignment>|
		StringBuffer axisStyle = new StringBuffer(axis.size()*5+1);
		for (int i = 0; i < axis.size(); i++){
			AxisLabelSummary sum = axis.get(i);
			if (sum.getAxisStyle()!= null){
				axisStyle.append(i);
				axisStyle.append(",");
				axisStyle.append(MiscUtils.getSixCharacterHexValue(
						sum.getAxisStyle().getColor()));
				
				if (sum.getAxisStyle().getFontSize()>0){
					axisStyle.append(",");
					axisStyle.append(sum.getAxisStyle().getFontSize());
					if (sum.getAxisStyle().isAlignmentUsed()){
						axisStyle.append(",");
						axisStyle.append(sum.getAxisStyle().getAlignment());
					}
				}
				axisStyle.append("|");
			}
		}		
		
		
		String axis = axisTypes.substring(0, axisTypes.length()-1);		
		String ret = axis;
		
		String axisLabelsS ="";//chxl= <axis index>:|<label 1>|<label n>|

		if (axisLabels.length()>1){
			axisLabelsS="chxl="+axisLabels.substring(0, axisLabels.length()-1);			
			ret = ret +"&"+axisLabelsS;
		}
		
		String axisPos=""; //chxp= <axis index>,<label 1 position>,<label n position>|
		if (axisLabelsPos.length()>1){
			axisPos="chxp="+axisLabelsPos.substring(0, axisLabelsPos.length()-1);
			ret = ret +"&"+axisPos;
		}
		
		String axisRangeS=""; //chxr= <axis index>,<start of range>,<end of range>|
		if (axisRange.length()>1){
			axisRangeS="chxr="+axisRange.substring(0, axisRange.length()-1);
			ret = ret +"&"+axisRangeS;
		}
		
		String axisStyleS=""; //chxs= <axis index>,<color>,<font size>,<alignment>|
		if (axisStyle.length()>1){
			axisStyleS="chxs="+axisStyle.substring(0, axisStyle.length()-1);
			ret = ret +"&"+axisStyleS;
		}
		return ret;
	}
	
	public void addAxis (AxisLabelSummary axis){
		this.axis.add(axis);
	}
	
	public boolean removeAxis (AxisLabelSummary axis){
		return this.axis.remove(axis);
	}
	
	public AxisLabelSummary removeAxis (int index){
		return axis.remove(index);
	}
	
	public void removeAll (){
		for (int i = 0; i < axis.size();){
			axis.remove(i);
		}
	}
	
	public List<AxisLabelSummary> getList (){
		return Collections.unmodifiableList(axis);
	}
	
	

}
