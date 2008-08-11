package googlechartwrapper.marker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import googlechartwrapper.util.IFeatureAppender;

public class MarkerAppender implements IFeatureAppender{
	
	private List<IMarker> list;
	
	public MarkerAppender(){
		list = new ArrayList<IMarker>();
	}
	
	public void addMarker (IMarker m){
		list.add(m);
	}
	
	public boolean removeMarker (IMarker m){
		return list.remove(m);
	}
	
	public List<IMarker> getMarkers (){
		return Collections.unmodifiableList(list);
	}

	public String getAppendableString(List<IFeatureAppender> otherAppenders) {
		
		if (list.size() > 0){
			StringBuilder bf = new StringBuilder(list.size()*10);
			bf.append("chm=");
			for (IMarker m:list){
				bf.append(m.getAppendableString(otherAppenders));
				bf.append("|");
			}
			return bf.substring(0, bf.length()-1);			
		}
		else return "";
	}

}
