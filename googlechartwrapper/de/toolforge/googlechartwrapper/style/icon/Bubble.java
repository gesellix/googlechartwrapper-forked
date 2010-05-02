/**
 * 
 */
package de.toolforge.googlechartwrapper.style.icon;

import java.util.ArrayList;
import java.util.List;

import de.toolforge.googlechartwrapper.ChartTypeFeature;
import de.toolforge.googlechartwrapper.Color;
import de.toolforge.googlechartwrapper.util.AppendableFeature;
import de.toolforge.googlechartwrapper.util.IFeatureAppender;



/**
 * @author steffan
 *
 */
public abstract class Bubble extends AbstractDynamicIcon{
	
	private Bubble() {
		// TODO Auto-generated constructor stub
	}
	
	public static Bubble createSmallBubble(Icon icon,TailDirection direction, Color fillColor, Color textColor, String text){
		
		Bubble b = new Bubble(){
			
			@Override
			public List<AppendableFeature> getAppendableFeatures(
					List<? extends IFeatureAppender> otherAppenders) {
				
				List<AppendableFeature> features = new ArrayList<AppendableFeature>();
				
				features.add(new AppendableFeature("d_bubble_icon_text_small&chld=ski|bb|Wheeee!|FFFFFF|000000",
						ChartTypeFeature.FreeStandingDynamicIcon));
				
				return features;
			}
			
		};
		return b ;// new StringBuilder().append(IconStringConstant.BubbleTextSmall.getPrefix()).
		
	}

	
	@Override
	public List<AppendableFeature> getAppendableFeatures(
			List<? extends IFeatureAppender> otherAppenders) {
		
		List<AppendableFeature> features = new ArrayList<AppendableFeature>();

		return features;
	}

}
