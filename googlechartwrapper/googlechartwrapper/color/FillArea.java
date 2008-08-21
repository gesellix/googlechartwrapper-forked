package googlechartwrapper.color;

import java.awt.Color;
import java.util.List;

import googlechartwrapper.util.IFeatureAppender;
import googlechartwrapper.util.MiscUtils;

/**
 * Specifies a RangeMarker <a
 * href="http://code.google.com/apis/chart/#fill_area_marker">
 * http://code.google.com/apis/chart/#fill_area_marker</a>
 * 
 * @author steffan
 * 
 */
public class FillArea implements IFeatureAppender {

	private Color color;
	private int startLineIndex;
	private int endLineIndex;
	private DataSetKind dataSetKind;

	/**
	 * Constructs a fillarea
	 * 
	 * @param kind For a single fillarea it is easier to use single, in this case everything under the is 
	 * filled. <br />Multi does not work with an radar chart, but you can use single.
	 * @param color
	 * @param startLineIndex is the index of the line at which the fill starts <br />
	 * first data set specified has an index of zero (0), the second 1, and so on
	 * @param endLineIndex the index of the line at which the fill ends <br />
	 * first data set specified has an index of zero (0), the second 1, and so on
	 * 
	 * @throws IllegalArgumentException if color is <code>null</code> or start/end index are out of range
	 */
	public FillArea(DataSetKind kind, Color color, int startLineIndex, int endLineIndex) {

		if (startLineIndex < 0)
			throw new IllegalArgumentException(
					"startLineIndex must be 0 or higher");
		if (endLineIndex < 0)
			throw new IllegalArgumentException(
					"endLineIndex must be 0 or higher");
		if (color == null)
			throw new IllegalArgumentException("color can not be null");

		this.color = color;
		this.startLineIndex = startLineIndex;
		this.endLineIndex = endLineIndex;
		this.dataSetKind = kind;
	}

	public String getAppendableString(
			List<? extends IFeatureAppender> otherAppenders) {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append(this.dataSetKind.getDataSetKind());
		builder.append(',');
		if (color.getAlpha()==255){
			builder.append(MiscUtils.getSixCharacterHexValue(this.color));
		}
		else {
			builder.append(MiscUtils.getEightCharacterHexValue(this.color));
		}
		
		builder.append(',');
		builder.append(this.startLineIndex);
		builder.append(',');
		builder.append(this.endLineIndex);
		builder.append(',');
		//ignored value
		builder.append('0');
		
		
		return builder.toString();
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 * 
	 * @throws IllegalArgumentException if color is <code>null</code>
	 */
	public void setColor(Color color) {
		if (color == null)
			throw new IllegalArgumentException("color can not be null");
		this.color = color;
	}

	/**
	 * @return the startLineIndex
	 */
	public int getStartLineIndex() {
		return startLineIndex;
	}

	/**
	 * @param startLineIndex the startLineIndex to set
	 * 
	 * @throws IllegalArgumentException if color startindex is out of range
	 */
	public void setStartLineIndex(int startLineIndex) {
		if (startLineIndex < 0)
			throw new IllegalArgumentException(
					"startLineIndex must be 0 or higher");
		this.startLineIndex = startLineIndex;
	}

	/**
	 * @return the endLineIndex
	 */
	public int getEndLineIndex() {
		return endLineIndex;
	}

	/**
	 * @param endLineIndex the endLineIndex to set
	 * 
	 * @throws IllegalArgumentException if color endindex is out of range
	 */
	public void setEndLineIndex(int endLineIndex) {
		if (endLineIndex < 0)
			throw new IllegalArgumentException(
					"endLineIndex must be 0 or higher");
		this.endLineIndex = endLineIndex;
	}

	/**
	 * @return the dataSetKind
	 */
	public DataSetKind getDataSetKind() {
		return dataSetKind;
	}

	/**
	 * @param dataSetKind the dataSetKind to set
	 */
	public void setDataSetKind(DataSetKind dataSetKind) {
		this.dataSetKind = dataSetKind;
	}

	/**
	 * 
	 * @author steffan
	 *
	 */
	public enum DataSetKind {

		Single('b'), Multi('B');

		private char kind;

		DataSetKind(char kind) {
			this.kind = kind;
		}

		public char getDataSetKind() {
			return this.kind;

		}
	}

}
