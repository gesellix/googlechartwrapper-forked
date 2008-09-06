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
		
}
