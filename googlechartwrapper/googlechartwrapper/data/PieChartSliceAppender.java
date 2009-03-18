package googlechartwrapper.data;

import googlechartwrapper.ChartTypeFeature;
import googlechartwrapper.DefaultValues;
import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.coder.PercentageEncoder;
import googlechartwrapper.util.AppendableFeature;
import googlechartwrapper.util.IExtendedFeatureAppender;
import googlechartwrapper.util.IFeatureAppender;
import googlechartwrapper.util.MiscUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *   
 * @author steffan
 *
 */
public class PieChartSliceAppender implements IExtendedFeatureAppender{
	
	protected List<PieChartSlice> pieChartSlices = new LinkedList<PieChartSlice>();
	protected IEncoder encoder = new PercentageEncoder();
	
	public void add (List<? extends PieChartSlice> pieChartSlices){
		
		List<PieChartSlice> temp = Collections.unmodifiableList(pieChartSlices);

		for (PieChartSlice current : temp) {
			if (current == null)
				throw new IllegalArgumentException("member can not be null");
		}
		
		this.pieChartSlices.addAll(pieChartSlices);
	}
	public void add (PieChartSlice pieChartSlice){
		
		if(pieChartSlice == null)
			throw new IllegalArgumentException("pieChartSlice can not be null");
		pieChartSlices.add(pieChartSlice);
	}
	
	public boolean remove (PieChartSlice m){
		return pieChartSlices.remove(m);
	}
	
	public PieChartSlice remove (int index){
		return pieChartSlices.remove(index);
	}
	
	public void removeAll (){
		for (int i = 0; i < pieChartSlices.size();){
			pieChartSlices.remove(i);
		}		
	}
	
	/**
	 * Returns the list of all PieChartSlice elements added to this appender. 
	 * It returns an unmodifiable view of the value list.
	 * Consequently "read-only" access is possible
	 * @return unmodifiable view of the values
	 */
	public List<? extends PieChartSlice> getList (){
		return Collections.unmodifiableList(pieChartSlices);
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
	

	public List<AppendableFeature> getAppendableFeatures(List<? extends IFeatureAppender> otherAppenders) {
		
		/*
		//chco fuer colors of slices
		//chl fuer labels
		//chartdata vom encoder
		int values[] = new int[pieChartSlices.size()];
		StringBuilder labelbf = new StringBuilder(values.length*7);
		//labelbf.append("chl=");
		StringBuilder colorbf = new StringBuilder(values.length*7+4);
				
		for (int i = 0, size = pieChartSlices.size(); i < size; i++){
			values[i] = pieChartSlices.get(i).getData(); //val
			
			PieChartSlice slice = pieChartSlices.get(i); //label
			if (slice.getLabel() != null){
				labelbf.append(slice.getLabel());
			}
			labelbf.append("|");
			
			if (slice.getColor() != null){
				colorbf.append(MiscUtils.getMatchingColorHexValue(slice.getColor()));
				colorbf.append(",");
			}			
		}
		
		List<AppendableFeature> feature = new ArrayList<AppendableFeature>(); 
		
		String val = encoder.encode(values);		
		
		String labels;
		if (labelbf.length()<1){ //keine labels
			labels = "";
			labelbf = null;
		}
		else {
			labels = labelbf.substring(0, labelbf.length()-1);
			feature.add(new AppendableFeature(labels, "chl"));
		}
		
		//
		//if (colorbf.length()==0){
		//	colors = "";
		//}
		if (colorbf.length()!=0) {			
			String colors = colorbf.substring(0, colorbf.length()-1 );
			feature.add(new AppendableFeature(colors, "chco"));
		}		
		*/
		
		// the raw data
		int[] data = new int[this.pieChartSlices.size()];

		for (int z = 0; z < this.pieChartSlices.size(); z++) {
			
			data[z] = this.pieChartSlices.get(z).getValue();
		}
		
		boolean isColorUsed = false;

		// the color string
		StringBuilder color = new StringBuilder();
		for (int i = 0; i < this.pieChartSlices.size(); i++) {

			// the user set a color
			if (this.pieChartSlices.get(i).getColor() != null) {
				isColorUsed = true;
				color.append(MiscUtils.getSixCharacterHexValue(this.pieChartSlices.get(i)
						.getColor()));
			}
			// no color was set, we add the default color
			if (this.pieChartSlices.get(i).getColor() == null) {
				color.append(MiscUtils
						.getSixCharacterHexValue(DefaultValues.DataColor));
			}

			// otherwise we have a "," at the end
			if (i < this.pieChartSlices.size() - 1) {
				color.append(",");
			}
		}
		
		boolean isLabelUsed = false;
		
		// the label
		StringBuilder label = new StringBuilder();
		for (int u = 0; u < this.pieChartSlices.size(); u++) {

			// the user set a label
			if (this.pieChartSlices.get(u).getLabel() != null) {
				isLabelUsed = true;
				label.append(this.pieChartSlices.get(u).getLabel());
			}
			// no label was set, we add ""
			if (this.pieChartSlices.get(u).getLabel() == null) {
				label.append("");
			}

			// otherwise we have a "," at the end
			if (u < this.pieChartSlices.size() - 1) {
				label.append("|");
			}
		}
		
		List<AppendableFeature> features = new ArrayList<AppendableFeature>(); 
		
		features.add(new AppendableFeature(this.encoder.encode(data),ChartTypeFeature.ChartDataAppender));
		
		// if the user set the color we have to add the string
		if (isColorUsed) {
			features.add(new AppendableFeature(color.toString(),
					ChartTypeFeature.ChartColor));
		}
		
		// if the user set the label we have to add the string
		if (isLabelUsed) {
			features.add(new AppendableFeature(label.toString(),
					ChartTypeFeature.PieChartLabel));
		}
		              
		return features;
	}	

}
