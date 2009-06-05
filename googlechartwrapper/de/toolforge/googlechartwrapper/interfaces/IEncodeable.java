package de.toolforge.googlechartwrapper.interfaces;

import de.toolforge.googlechartwrapper.coder.IEncoder;

/**
 * 
 * The interface for every class which deals with encoder.
 * 
 * @author steffan
 *
 */
public interface IEncodeable {

	/**
	 * Returns the encoder.
	 * 
	 * @return the encoder
	 */
	public IEncoder getEncoder();
	
	/**
	 * If the argument is null we use the default implementation of the encoder
	 * 
	 * @param encoder
	 */
	public void setEncoder(IEncoder encoder);
	
	
	/**
	 * Remove means in this case, that we use the default implementation of the encoder, 
	 * because we need one - in every case.
	 */
	public void removeEncoder();
		
}
