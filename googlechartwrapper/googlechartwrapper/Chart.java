package googlechartwrapper;

import googlechartwrapper.coder.IEncoder;

interface Chart {

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

	/*
	 public void setValues(Collection<float[]> values)
	 {
	 this.values = this.encoder.encodeFloatCollection(values);
	 }*/
	public abstract void setEncoder(IEncoder newEncoder);

	public abstract IEncoder getEncoder();

	public abstract String getUrl();

}