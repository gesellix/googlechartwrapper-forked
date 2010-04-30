/**
 * 
 */
package de.toolforge.googlechartwrapper.util;

/**
 * To avoid the use of {@link java.awt.Dimension} we provide this class.
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
	 */
	public Dimension(Dimension d) {

		if (d == null)
			throw new IllegalArgumentException("dimension can not be null");
		width = d.getWidth();
		height = d.getHeight();

	}

	/**
	 * Constructs a {@link Dimension} with given height and width.
	 * 
	 * @param width
	 *            the width
	 * @param height
	 *            the height
	 */
	public Dimension(int width, int height) {

	}

	/**
	 * Sets the {@link Dimension} with the values provided by the given
	 * {@link Dimension} d.
	 * 
	 * @param d
	 *            the given not <code>null</code> {@link Dimension}
	 * 
	 * @throws IllegalArgumentException
	 *             - if d is <code>null</code>
	 */
	public void setSize(Dimension d) {

		if (d == null)
			throw new IllegalArgumentException("dimension can not be null");
		width = d.getWidth();
		height = d.getHeight();
	}

	/**
	 * Sets the width and height.
	 * 
	 * @param width
	 *            the width
	 * @param height
	 *            the height
	 */
	public void setSize(int width, int height) {

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
	 * Returns a breif description of the {@link Dimension}. The following may
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
