package googlechartwrapper.label;

import googlechartwrapper.label.ChartLegend.ChartLegendPosition;
import googlechartwrapper.util.AppendableFeature;
import googlechartwrapper.util.IFeatureAppender;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import de.toolforge.googlechartwrapper.ChartTypeFeature;

/**
 * This container is used for the {@link ChartLegend}, to add the {@link ChartLegendPosition}.
 * 
 * @author steffan
 * @see IChartLegendable
 * @see ChartLegend
 */
public class ChartLegendPositionContainer implements IFeatureAppender {

	private ChartLegend.ChartLegendPosition chartLegendPosition = null;

	/**
	 * Constructs a new {@link ChartLegendPositionContainer}.
	 * 
	 * @param chartLegendPosition
	 * 
	 * @throws IllegalArgumentException if chartLegendPosition is {@code null}
	 */
	public ChartLegendPositionContainer(final ChartLegendPosition chartLegendPosition) {
		
		if(chartLegendPosition == null)
			throw new IllegalArgumentException("chartLegendPosition can not null");
		
		this.chartLegendPosition = chartLegendPosition;
	}
	

	public List<AppendableFeature> getAppendableFeatures(
			List<? extends IFeatureAppender> otherAppenders) {

		//should not be necessary 
		if (this.chartLegendPosition != null) {

			List<AppendableFeature> feature = new ArrayList<AppendableFeature>();
			
			//adding direct the string
			feature.add(new AppendableFeature(this.chartLegendPosition
					.getPosition(), ChartTypeFeature.ChartLegendPosition));

			return feature;

		} else {
			return new LinkedList<AppendableFeature>();
		}

	}

}
