package googlechartwrapper.label;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import googlechartwrapper.util.AppendableFeature;
import googlechartwrapper.util.IExtendedFeatureAppender;
import googlechartwrapper.util.IFeatureAppender;
import googlechartwrapper.util.MiscUtils;

/**
 * Collects all axis label containers and appends it to the url.
 * @author martin
 *
 */
public class AxisLabelAppender implements IExtendedFeatureAppender{
	
	List<AxisLabelContainer> axis = new ArrayList<AxisLabelContainer>();

	public String getFeaturePrefix() {
		return "chxt";
	}

	public List<AppendableFeature> getAppendableFeatures(List<? extends IFeatureAppender> otherAppenders) {
		if (axis.size() < 1){
			return new ArrayList<AppendableFeature>();
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
			AxisLabelContainer sum = axis.get(i);
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
			AxisLabelContainer sum = axis.get(i);
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
			AxisLabelContainer sum = axis.get(i);
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
			AxisLabelContainer sum = axis.get(i);
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
		
		
		//String axis = axisTypes.substring(0, axisTypes.length()-1);		
		//String ret = axis;
		
		//String axisLabelsS ="";//chxl= <axis index>:|<label 1>|<label n>|
		List<AppendableFeature> features = new ArrayList<AppendableFeature>();
		
		features.add(new AppendableFeature(axisTypes.substring(0, axisTypes.length()-1),
				getFeaturePrefix()));
		
		
		if (axisLabels.length()>1){
			features.add(new AppendableFeature(axisLabels.substring(0, 
					axisLabels.length()-1),"chxl"));
			//axisLabelsS="chxl="+axisLabels.substring(0, axisLabels.length()-1);			
			//ret = ret +"&"+axisLabelsS;
		}
		
		//String axisPos=""; //chxp= <axis index>,<label 1 position>,<label n position>|
		if (axisLabelsPos.length()>1){
			features.add(new AppendableFeature(axisLabelsPos.substring(0, 
					axisLabelsPos.length()-1),"chxp"));
			//axisPos="chxp="+axisLabelsPos.substring(0, axisLabelsPos.length()-1);
			//ret = ret +"&"+axisPos;
		}
		
		//String axisRangeS=""; //chxr= <axis index>,<start of range>,<end of range>|
		if (axisRange.length()>1){
			features.add(new AppendableFeature(axisRange.substring(0, 
					axisRange.length()-1),"chxr"));
			//axisRangeS="chxr="+axisRange.substring(0, axisRange.length()-1);
			//ret = ret +"&"+axisRangeS;
		}
		
		String axisStyleS=""; //chxs= <axis index>,<color>,<font size>,<alignment>|
		if (axisStyle.length()>1){
			features.add(new AppendableFeature(axisStyle.substring(0, 
					axisStyle.length()-1),"chxs"));
			//axisStyleS="chxs="+axisStyle.substring(0, axisStyle.length()-1);
			//ret = ret +"&"+axisStyleS;
		}
		return features;
		//return ret;
	}
	
	public void addAxis (AxisLabelContainer axis){
		this.axis.add(axis);
	}
	
	public boolean removeAxis (AxisLabelContainer axis){
		return this.axis.remove(axis);
	}
	
	public AxisLabelContainer removeAxis (int index){
		return axis.remove(index);
	}
	
	public void removeAll (){
		for (int i = 0; i < axis.size();){
			axis.remove(i);
		}
	}
	
	public List<AxisLabelContainer> getList (){
		return Collections.unmodifiableList(axis);
	}
	
	

}
