package googlechartwrapper;

import googlechartwrapper.coder.IEncoder;

public interface Chart {

	/**
	 * 
	 * @param values
	 */
	public abstract void setValues(int[] values);

	/**
	 * 
	 * @param values
	 */
	public abstract void setValues(float[] values);

	public abstract void setEncoder(IEncoder newEncoder);

	public abstract IEncoder getEncoder();

	public abstract String getUrl();

}