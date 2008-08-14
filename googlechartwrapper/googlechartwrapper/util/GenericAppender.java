package googlechartwrapper.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import googlechartwrapper.ChartType;
import googlechartwrapper.ChartTypeFeature;

public class GenericAppender< T extends IFeatureAppender> implements IExtendedFeatureAppender{
	
	private List<T> list;
	private String prefix;
	
	public GenericAppender(ChartTypeFeature m){
		list = new ArrayList<T>();
		prefix = m.getPrefix();
	}
	
	public GenericAppender(String stm){
		list = new ArrayList<T>();
		prefix = stm;
	}
	
	public void add (T m){
		list.add(m);
	}
	
	public boolean remove (T m){
		return list.remove(m);
	}
	
	public List<T> getList (){
		return Collections.unmodifiableList(list);
	}
	
	public List<? extends T> getList (Class<? extends T> c){
		//TODO
		return Collections.unmodifiableList(list);
	}

	public String getAppendableString(List<? extends IFeatureAppender> otherAppenders) {
		
		if (list.size() > 0){
			StringBuilder bf = new StringBuilder(list.size()*10);
			//bf.append("chm=");
			for (IFeatureAppender m:list){
				String app = m.getAppendableString(otherAppenders);
				if (app.length()>0){
					bf.append(app);
					bf.append("|");		
				}
				//bf.append(m.getAppendableString(otherAppenders));
						
			}
			if (bf.length()>0){
				return bf.substring(0, bf.length()-1);
			}
			else {
				return "";
			}
			
		}
		else return "";
	}
	
	public String getFeaturePrefix (){
		return prefix;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" "+list;
	}

}
