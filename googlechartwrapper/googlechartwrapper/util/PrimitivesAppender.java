package googlechartwrapper.util;

import java.util.ArrayList;
import java.util.List;

import googlechartwrapper.ChartTypeFeature;

/**
 * Appender for primitives. <br />
 * This appender is made for Float, Integer.... related to {@link GenericAppender}
 * @author steffan
 *
 */
public class PrimitivesAppender <T extends Number> implements IExtendedFeatureAppender{

	/**
	 * the feature
	 */
	protected ChartTypeFeature feature;
	/**
	 * the primitive, e.g. Float
	 */
	protected Number primitive = null;
	
	/**
	 * Constructs a PrimitivesAppender.
	 * 
	 * @param feature 
	 * 
	 * @throws IllegalArgumentException if feature is {@code null}
	 */
	public PrimitivesAppender(ChartTypeFeature feature) {
		
		if(feature == null)
			throw new IllegalArgumentException("feature can not be null");
		
		this.feature = feature;
	}
	
	/**
	 * Sets the primitive.
	 * 
	 * @param primitiv
	 * 
	 * @throws IllegalArgumentException if primitive is {@code null}
	 */
	public void set(T primitive){
		if(primitive == null)
			throw new IllegalArgumentException("primitiv can not be null");
		
		this.primitive = primitive;
	}
	/**
	 * Removes the primitive.
	 */
	public void removeAll(){
		this.primitive = null;
	}
	/**
	 * Removes the primitive.
	 * 
	 * @return the primitive, can be {@code null} if no one was set, or removed
	 */	
	public T remove(){
		
		@SuppressWarnings("unchecked")
		T copy = (T) this.primitive;
		
		this.removeAll();
		
		return copy;
	}
	
	public String getFeaturePrefix() {
		
		return this.feature.getPrefix();
	}
	public List<AppendableFeature> getAppendableFeatures(
			List<? extends IFeatureAppender> otherAppenders) {
		
		if(this.primitive != null){
			
			StringBuilder builder = new StringBuilder();			
			builder.append(this.primitive.toString());
			
			
			List<AppendableFeature> feature = new ArrayList<AppendableFeature>(); 
			
	        feature.add(new AppendableFeature(builder.toString(), 
	                  this.feature)); 
	        
			return feature;
			
		}
		else{
			return new ArrayList<AppendableFeature>();
		}
	}
	/**
	 * Return the {@link PrimitivesAppender} toString.
	 */
	@Override
	public String toString() {
		
		return this.primitive.toString();
	}
}
