package de.toolforge.googlechartwrapper.util;

import de.toolforge.googlechartwrapper.ChartTypeFeature;

/**
 * Feature which will be appended to the final URL string. It basically serves as a 
 * container class for the individual data string, the feature prefix for the url 
 * ("feature type") and an optional order.
 * The order may be used if a specific ordering for the final url string is 
 * required. For details If and how sorting is done refer to the documentation of 
 * the individual chart or base class.
 * @author martin
 *
 */
public class AppendableFeature /*implements Comparable<AppendableFeature>*/ {
	
	/**
	 * No special order. 
	 */
	public int NO_SPECIAL_ORDER = -1;
	
	private String data;
	private int order=  NO_SPECIAL_ORDER;
	private String prefix;
	
	/**
	 * Constructs an {@link AppendableFeature} with the data string and the 
	 * {@link ChartTypeFeature#getPrefix()} prefix.
	 * @param data detail string appendable to the URL
	 * @param feature feature type
	 */
	public AppendableFeature(String data, ChartTypeFeature feature) {
		super();
		this.data = data;
		this.prefix = feature.getPrefix();
	}
	
	/**
	 * Constructs an {@link AppendableFeature} with the data string and a 
	 * feature type prefix
	 * @param data detail string appendable to the URL
	 * @param prefix feature type prefix
	 */
	public AppendableFeature(String data, String prefix) {
		super();
		this.data = data;
		this.prefix = prefix;
	}
	
	/**
	 * Constructs an {@link AppendableFeature} with the data string and the 
	 * {@link ChartTypeFeature#getPrefix()} prefix. The order may be used if a 
	 * specific ordering for the final url string is 
	 * required. For details if and how sorting is done refer to the documentation of 
	 * the individual chart or base class.
	 * @param data detail string appendable to the URL
	 * @param feature feature type 
	 * @param order order number
	 */
	public AppendableFeature(String data, ChartTypeFeature feature, int order) {
		super();
		this.data = data;
		this.prefix = feature.getPrefix();
		this.order = order;
	}
	
	/**
	 * Constructs an {@link AppendableFeature} with the data string and a 
	 * feature type prefix. The order may be used if a specific ordering for the 
	 * final url string is 
	 * required. For details if and how sorting is done refer to the documentation of 
	 * the individual chart or base class.
	 * @param data detail string appendable to the URL
	 * @param prefix feature type prefix
	 * @param order order number (see {@link AppendableFeature#NO_SPECIAL_ORDER}
	 */
	public AppendableFeature(String data, String prefix, int order) {
		super();
		this.data = data;
		this.prefix = prefix;
		this.order = order;
	}

	/**
	 * Returns the detail string of the feature.
	 * @return detail string
	 */
	public String getData() {
		return data;
	}

	/**
	 * Returns the (optional) order number. Default is -1 (signalizes "no special order")
	 * @see AppendableFeature#NO_SPECIAL_ORDER
	 * @return the order number
	 */
	public int getOrder() {
		return order;
	}

	/**
	 * Returns the prefix of the chart feature.
	 * @return chart feature prefix
	 */
	public String getPrefix() {
		return prefix;
	}

	/*public int compareTo(AppendableFeature arg0) {
		return order-arg0.getOrder();
	}*/
	

}
