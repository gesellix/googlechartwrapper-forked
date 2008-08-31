package googlechartwrapper;

import googlechartwrapper.coder.IEncoder;

public interface Chart {
	
	public abstract IEncoder getEncoder();

	public abstract String getUrl();

}