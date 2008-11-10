package googlechartwrapper;

import googlechartwrapper.coder.IEncoder;
import googlechartwrapper.color.ISolidFillable;
import googlechartwrapper.color.SolidFill;
import googlechartwrapper.color.SolidFill.ChartFillDestination;
import googlechartwrapper.data.DataScalingSet;
import googlechartwrapper.data.GoogleOMeterValue;
import googlechartwrapper.data.ISingleDataScaleable;
import googlechartwrapper.util.GenericAppender;
import googlechartwrapper.util.IExtendedFeatureAppender;
import googlechartwrapper.util.IFeatureAppender;
import googlechartwrapper.util.UpperLimitGenericAppender;
import googlechartwrapper.util.UpperLimitGenericAppender.UpperLimitReactions;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Specifies a GoogleOMeter
 * @author mart
 *
 */
public class GoogleOMeter extends AbstractChart implements ISolidFillable, 
	ISingleDataScaleable{
	
	protected GenericAppender<SolidFill> solidFillAppender = new 
		GenericAppender<SolidFill>(ChartTypeFeature.SolidFill);
	protected GoogleOMeterValueAppender valueAppender = new GoogleOMeterValueAppender();
	protected UpperLimitGenericAppender<DataScalingSet> dataScalingAppender = new 
		UpperLimitGenericAppender<DataScalingSet>(ChartTypeFeature.DataScaling,
				1,UpperLimitReactions.RemoveAll,",");
	
	//TODO martin: add data scaling
	
	public GoogleOMeter(Dimension chartDimension) {
		super(chartDimension);
	}
	
	@Override
	protected ChartType getChartType() {		
		return ChartType.GoogleOMeter;
	}

	@Override
	protected String getUrlChartType() {
		return "gom";
	}
	
	public void addSolidFill(SolidFill sf) {
		if (!sf.getChartFillDestination().equals(ChartFillDestination.Background)){
			throw new IllegalArgumentException("only SolidFill " +
					"ChartFillDestination.Background allowed");
		}
		this.solidFillAppender.add(sf);
	}

	public List<SolidFill> getSolidFills() {
		return this.solidFillAppender.getList();
	}

	public void removeAllSolidFills() {
		this.solidFillAppender.removeAll();

	}

	public SolidFill removeSolidFill(int index) {
		return this.solidFillAppender.remove(index);
	}

	public boolean removeSolidFill(SolidFill sf) {
		return this.solidFillAppender.remove(sf);
	}
	
	public void addGoogleOMeterValue (GoogleOMeterValue value){
		valueAppender.add(value);
	}
	
	public List<GoogleOMeterValue> getGoogleOMeterValues() {
		return this.valueAppender.getList();
	}

	public void removeAllGoogleOMeterValues() {
		this.valueAppender.removeAll();
	}

	public GoogleOMeterValue removeGoogleOMeterValue(int index) {
		return this.valueAppender.remove(index);
	}

	public boolean removeGoogleOMeterValue(GoogleOMeterValue sf) {
		return this.valueAppender.remove(sf);
	}
	

	public DataScalingSet getDataScaling() {
		return dataScalingAppender.getListSize() > 0 ? 
				dataScalingAppender.getList().get(0) : null;
	}

	public void removeDataScaling() {
		dataScalingAppender.removeAll();
	}

	public void setDataScaling(DataScalingSet ds) {
		if (ds == null){
			dataScalingAppender.removeAll();
			return ;
		}
		dataScalingAppender.add(ds);
	}

	public IEncoder getEncoder() {
		// TODO Auto-generated method stub
		return null;
	}

	protected final class GoogleOMeterValueAppender implements IExtendedFeatureAppender {
		
		/**
		 * list of elements/features
		 */
		protected List<GoogleOMeterValue> list = new ArrayList<GoogleOMeterValue>(1);

		public String getFeaturePrefix() {
			return "chd";
		}

		public String getAppendableString(List<? extends IFeatureAppender> otherAppenders) {
			if (list.size() == 0){
				return "";
			}
			
			boolean hadLabels = false;
			StringBuilder values = new StringBuilder(list.size()*2+5);
			StringBuilder labels = new StringBuilder(list.size()*5+5);
			
			values.append("t:");
			
			for (GoogleOMeterValue val : list){
				values.append(val.getValue());
				values.append(",");
				if (val.getLabel()==null){
					labels.append("|");
				}
				else {
					labels.append(val.getLabel());
					labels.append("|");
					hadLabels = true;
				}
			}
			//http://chart.apis.google.com/chart?chs=225x125&cht=gom&chd=t:70&chl=Hello
			//chd=t:70:
			String ret = values.substring(0,values.length()-1);
			if (hadLabels){
				ret = ret + "&chl="+labels.substring(0, labels.length()-1);
			}			
			return ret;
		}
		
		/**
		 * Appends the specified element to the end of this appender. 
		 * @param m element to be appended to this list.
		 * @throws IllegalArgumentException if, and only if m == null
		 */
		public void add (GoogleOMeterValue m){
			if (m == null){
				throw new IllegalArgumentException("new element cannot be null");
			}
			list.add(m);
		}
		
		/**
		 * Removes the first occurrence in this list of the specified element 
		 * (optional operation). If this list does not contain the element, it is 
		 * unchanged. More formally, removes the element with the lowest index i 
		 * such that <code>(o==null ? get(i)==null : o.equals(get(i))) </code>
		 * (if such an element exists). 
		 * @param m element to be removed from this list, if present
		 * @return <code>true</code> if this list contained the specified element
		 */
		public boolean remove (GoogleOMeterValue m){
			return list.remove(m);
		}
		
		/**
		 * Removes the element at the specified position in this feature list. 
		 * Shifts any subsequent elements to the left 
		 * (subtracts one from their indices). Returns the element that was 
		 * removed from the feature list. 
		 * @param index the index of the element to removed
		 * @return the element previously at the specified position
		 * @throws IndexOutOfBoundsException if the index is out of 
		 * range (index < 0 || index >= size of this feature list).
		 */
		public GoogleOMeterValue remove (int index){
			return list.remove(index);
		}
		
		/**
		 * Removes all of the elements from this appender.
		 * This appender feature list will be empty after this call returns.
		 *
		 */
		public void removeAll (){
			for (int i = 0; i < list.size();){
				list.remove(i);
			}
		}
		
		/**
		 * Returns the list of all T elements added to this appender. 
		 * It returns an unmodifiable view of the value list.
		 * Consequently "read-only" access is possible
		 * @return unmodifiable view of the values
		 */
		public List<GoogleOMeterValue> getList (){
			return Collections.unmodifiableList(list);
		}
		
	}	
}
