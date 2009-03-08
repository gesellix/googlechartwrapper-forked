package googlechartwrapper.data;

import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.coder.PercentageEncoder;
import googlechartwrapper.util.AppendableFeature;
import googlechartwrapper.util.IExtendedFeatureAppender;
import googlechartwrapper.util.IFeatureAppender;
import googlechartwrapper.util.MiscUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PieChartSliceAppender implements IExtendedFeatureAppender{
	
	protected List<PieChartSlice> list= new LinkedList<PieChartSlice>();
	protected IEncoder encoder = new PercentageEncoder();
	
	public void add (PieChartSlice m){
		list.add(m);
	}
	
	public boolean remove (PieChartSlice m){
		return list.remove(m);
	}
	
	public PieChartSlice remove (int index){
		return list.remove(index);
	}
	
	public void removeAll (){
		for (int i = 0; i < list.size();){
			list.remove(i);
		}
	}
	
	/**
	 * Returns the list of all PieChartSlice elements added to this appender. 
	 * It returns an unmodifiable view of the value list.
	 * Consequently "read-only" access is possible
	 * @return unmodifiable view of the values
	 */
	public List<? extends PieChartSlice> getList (){
		return Collections.unmodifiableList(list);
	}
	
	public void setEncoder (IEncoder encoder){
		if (encoder == null){
			throw new IllegalArgumentException("encoder cannot be null");
		}
		this.encoder = encoder;
	}
	
	public IEncoder getEncoder (){
		return encoder; 
	}

	public String getFeaturePrefix() {
		return "chco";
	}

	public List<AppendableFeature> getAppendableString(List<? extends IFeatureAppender> otherAppenders) {
		//chco fuer colors of slices
		//chl fuer labels
		//chartdata vom encoder
		int values[] = new int[list.size()];
		StringBuilder labelbf = new StringBuilder(values.length*7);
		labelbf.append("chl=");
		StringBuilder colorbf = new StringBuilder(values.length*7+4);
				
		for (int i = 0, size = list.size(); i < size; i++){
			values[i] = list.get(i).getData(); //val
			
			PieChartSlice slice = list.get(i); //label
			if (slice.getLabel() != null){
				labelbf.append(slice.getLabel());
			}
			labelbf.append("|");
			
			if (slice.getColor() != null){
				colorbf.append(MiscUtils.getMatchingColorHexValue(slice.getColor()));
				colorbf.append(",");
			}			
		}
		
		String val = encoder.encode(values);		
		
		String labels;
		if (labelbf.length()<6){ //keine labels
			labels = "";
			labelbf = null;
		}
		else {
			labels = labelbf.substring(0, labelbf.length()-1);
		}
		
		String colors;
		if (colorbf.length()==0){
			colors = "";
		}
		else {
			colors = colorbf.substring(0, colorbf.length()-1 );
		}
				
		return colors+"&"+labels+"&"+val;
	}	

}
