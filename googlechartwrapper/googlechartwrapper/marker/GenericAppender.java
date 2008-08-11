package googlechartwrapper.marker;

import googlechartwrapper.util.IFeatureAppender;

import java.util.List;
import java.util.Map;

public class GenericAppender {	
	
	private List<List<Object>> list;
	private Map<Class, String> os;
	
	public void add(Object o){
		
		for(List<Object> l : list){
			
			//not empty
			if(!l.isEmpty()){
				
				for(Class<?> c : os.keySet()){
					
					if(l.get(0) instanceof c){
						
					}
				}
			}
		}
		list.add(o);
	}
	
public String getAppendableString(List<IFeatureAppender> otherAppenders) {
	
	//in seperate listen sortieren
	
		
	/*
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
	}*/
	
	return null;
}

}
