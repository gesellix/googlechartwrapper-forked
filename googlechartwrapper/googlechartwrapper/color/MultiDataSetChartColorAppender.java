package googlechartwrapper.color;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import googlechartwrapper.ChartTypeFeature;
import googlechartwrapper.util.AppendableFeature;
import googlechartwrapper.util.IExtendedFeatureAppender;
import googlechartwrapper.util.IFeatureAppender;
import googlechartwrapper.util.MiscUtils;

/**
 * 
 * @author steffan
 * 
 * @see IMultiDataSetChartColorable
 */
public class MultiDataSetChartColorAppender implements IExtendedFeatureAppender {

	private StringBuilder color = new StringBuilder();
	private String lastDelimiter = null;

	/**
	 * 
	 * @param chartColorList
	 * 
	 * @throws IllegalArgumentException
	 *             if chartColorList or member is {@code null}
	 */
	public void addChartColorSet(List<ChartColor> chartColorList) {

		if (chartColorList == null)
			throw new IllegalArgumentException("chartColorList can not be null");

		List<ChartColor> temp = Collections.unmodifiableList(chartColorList);

		
		for (ChartColor curent : temp) {
			if (curent == null)
				throw new IllegalArgumentException("member can not be null");
		}
		
		if(this.lastDelimiter != null)
		{
			this.color.append(this.lastDelimiter);
		}		
		
		for (ChartColor current : temp) {

			color.append(MiscUtils.getSixCharacterHexValue(current.getColor()));
			color.append("|");

		}
		
		if(this.color.length() > 0){
			this.color.deleteCharAt(this.color.length()-1);
		}
		
		this.lastDelimiter = ",";
	};

	/**
	 * 
	 * @param cc
	 * 
	 * @throws IllegalArgumentException
	 *             if chartColor is {@code null}
	 */
	public void addChartColor(ChartColor chartColor) {

		if (chartColor == null)
			throw new IllegalArgumentException("chartColor can not be null");
		
		if(this.lastDelimiter != null)
		{
			this.color.append(this.lastDelimiter);
		}
		
		
		this.color.append(MiscUtils.getSixCharacterHexValue(chartColor
				.getColor()));
			
		this.lastDelimiter = ",";
	};

	public List<AppendableFeature> getAppendableFeatures(
			List<? extends IFeatureAppender> otherAppenders) {

		List<AppendableFeature> feature = new ArrayList<AppendableFeature>();

		if (this.color.length() > 0) {
			feature.add(new AppendableFeature(color.toString(),
					ChartTypeFeature.ChartColor));
		}
		return feature;
	}

}
