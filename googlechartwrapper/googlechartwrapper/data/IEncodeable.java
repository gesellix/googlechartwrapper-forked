package googlechartwrapper.data;

import googlechartwrapper.coder.IEncoder;

/**
 * 
 * @author steffan
 *
 */
public interface IEncodeable {

	/**
	 * 
	 * @return
	 */
	public IEncoder getEncoder();
	
	/**
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
