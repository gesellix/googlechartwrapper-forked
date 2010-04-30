/**
 * 
 */
package de.toolforge.googlechartwrapper;

/**
 * To avoid the use of {@link java.awt.Dimension} we provide this class. This
 * class is immutable.
 * 
 * @author steffan
 * @version 04/30/10
 * 
 */
public final class Dimension {

	private int height = 0;
	private int width = 0;

	/**
	 * Constructs a {@link Dimension} with width of zero and height of zero.
	 * 
	 */
	public Dimension() {

	}

	/**
	 * Constructs a {@link Dimension} with the values provided by the given
	 * {@link Dimension} d.
	 * 
	 * @param d
	 *            the given not <code>null</code> {@link Dimension}
	 * 
	 * @throws IllegalArgumentException
	 *             - if d is <code>null</code>
	 * @throws IllegalArgumentException
	 *             -if width and/or height is <code>null</code>
	 */
	public Dimension(Dimension d) {

		if (d == null)
			throw new IllegalArgumentException("dimension can not be null");

		if (d.getWidth() < 0)
			throw new IllegalArgumentException("width can not be < 0");
		if (d.getHeight() < 0)
			throw new IllegalArgumentException("height can not be < 0");

		width = d.getWidth();
		height = d.getHeight();

	}
	
	/**
	 * Constructs a {@link Dimension} with the values provided by the given
	 * {@link java.awt.Dimension} d.
	 * 
	 * @param d
	 *            the given not <code>null</code> {@link java.awt.Dimension}
	 * 
	 * @throws IllegalArgumentException
	 *             - if d is <code>null</code>
	 * @throws IllegalArgumentException
	 *             -if width and/or height is <code>null</code>
	 */
	public Dimension(java.awt.Dimension d){
		
		if (d == null)
			throw new IllegalArgumentException("dimension can not be null");

		if (d.getWidth() < 0)
			throw new IllegalArgumentException("width can not be < 0");
		if (d.getHeight() < 0)
			throw new IllegalArgumentException("height can not be < 0");

		width = (int) d.getWidth();
		height = (int) d.getHeight();
	}

	/**
	 * Constructs a {@link Dimension} with given height and width.
	 * 
	 * @param width
	 *            the width -value >=0
	 * @param height
	 *            the height -value >=0
	 * 
	 * @throws IllegalArgumentException
	 *             -if width and/or height is <code>null</code>
	 */
	public Dimension(int width, int height) {

		if (width < 0)
			throw new IllegalArgumentException("width can not be < 0");
		if (height < 0)
			throw new IllegalArgumentException("height can not be < 0");

		this.width = width;
		this.height = height;
	}

	/**
	 * Returns the width.
	 * 
	 * @return the width
	 */
	public int getWidth() {

		return width;

	}

	/**
	 * Returns the height.
	 * 
	 * @return the height
	 */
	public int getHeight() {

		return height;
	}

	/**
	 * Returns a brief description of the {@link Dimension}. The following may
	 * be regarded as typical:
	 * 
	 * "height: 123 width: 321"
	 */
	@Override
	public String toString() {

		return new StringBuilder().append("height: ").append(height)
				.append(" ").append("width: ").append(width).toString();
	}
}
