package googlechartwrapper.coder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 
 * @author steffan
 *
 */
public class Encoder implements IEncoder {	
	
        public  String encode(int[] values)
        {
        	System.out.println(Arrays.toString(values));
            int maxValue = this.getMaxValue(values);
            
            if (maxValue <= 61)
            {
                return SimpleEncoding(values);
            }
            else if(maxValue <= 4095)
            {
                return ExtendedEncoding(values);
            }

            return null;
        }

        public String encodeIntegerCollection(Collection<int[]> values)
        {
            int maxValue = this.getMaxValue(values);
            
            if (maxValue <= 61)
            {
                return SimpleEncoding(values);
            }
            else if (maxValue <= 4095)
            {
                return ExtendedEncoding(values);
            }

            return null;
        }

        public String encode(float[] values)
        {
            return TextEncoding(values);
        }

        public String encodeFloatCollection(Collection<float[]> values)
        {
            return TextEncoding(values);
        }

       

        public String SimpleEncoding(int[] values)
        {
            return "chd=s:" + simpleEncode(values);
        }

        public String SimpleEncoding(Collection<int[]> values)
        {
            StringBuilder chartValues = new StringBuilder();
            
            chartValues.append("chd=s:");

            for(int [] array : values){
            	chartValues.append(simpleEncode(array)+",");
            }           
            return chartValues.toString();
            //FIXME mh was ist damit gemeint?
            //return chartData.TrimEnd(",".ToCharArray());
        }

        private String simpleEncode(int[] values)
        {
           final String simpleEncoding = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            StringBuilder chartValues = new StringBuilder();

            
            for(int value : values){
            	
            	if(value == -1){
            		chartValues.append("_");
            	}
            	else{
            		char c = simpleEncoding.charAt(value);
            		chartValues.append(c);
            	}
            }
            return chartValues.toString();            
        }
      
        public String TextEncoding(float[] data)
        {
            return "chd=t:" + textEncode(data);
        }

        public String TextEncoding(Collection<float[]> values)
        {
            StringBuilder chartValues = new StringBuilder();
            chartValues.append("chd=t:");

            for(float [] array : values){
            	
            	chartValues.append(textEncode(array)+"|");
            }
           
            return chartValues.toString();
            //FIXME
            //return chartData.TrimEnd("|".ToCharArray());
        }

        private String textEncode(float[] values)
        {
            StringBuilder chartValues = new StringBuilder();

            for(float value : values){
            	
            	if(value == -1){
            		
            		chartValues.append("-1");
            	}
            	else{
            		chartValues.append(Float.toString(value)+",");
            	}
            }
            return chartValues.toString();
           //FIXME schon wieder...
            //return chartData.TrimEnd(",".ToCharArray());
        }
      

        public String ExtendedEncoding(int[] values)
        {
            return "chd=e:" + extendedEncode(values);
        }

        public String ExtendedEncoding(Collection<int[]> values)
        {
            StringBuilder chartValues = new StringBuilder();
            chartValues.append("chd=e:");

            for(int [] array : values){
            	
            	chartValues.append(extendedEncode(array)+",");
            }
            
            return chartValues.toString();
            	//FIXME
            //return chartData.TrimEnd(",".ToCharArray());
        }

        private String extendedEncode(int[] values)
        {
           final String extendedEncoding = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-.";
            StringBuilder chartValues = new StringBuilder();

            for(int value : values){
            	//FIXME das mit -1 und so muss nicht sein
            	if(value == -1){
            		
            		chartValues.append("__");
            	}
            	else{
            		
            		int firstCharPos = (int)(Math.floor((double)(value / extendedEncoding.length())));
                    int secondCharPos =(int)(Math.floor((double)(value % extendedEncoding.length())));

                    chartValues.append(extendedEncoding.charAt(firstCharPos));
                  chartValues.append(extendedEncoding.charAt(secondCharPos));
                
            	}
            }
          

                   

            return chartValues.toString();
        }

        
        
        /**
         * 
         * @param values
         * @return
         */
        private int getMaxValue(int[] values)
        {
        	int max = 0;
        	for (int i = 0; i < values.length; i++){
        		if (values[i]>max){
        			max = values[i];
        		}
			}
			return 0;

        	/*if(values.length > 0) {
        	Arrays.sort(values);
        	
        	return values[values.length-1];
        	}
        	//there is no value inside
            return 0;*/
        }
        /**
         * 
         * @param values
         * @return
         */
        private int getMaxValue(Collection<int[]> values)
        {
        	List<Integer> lMaxValues = new ArrayList<Integer>(values.size());
        	
        	for(int[] array: values){
        		
        		lMaxValues.add(getMaxValue(array));
        	}
        	
        	Arrays.sort(lMaxValues.toArray());
           //FIXME ordentlcihes grenzen checken
            return lMaxValues.get(lMaxValues.size()-1);
        }
    

}
