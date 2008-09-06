package googlechartwrapper.coder;

import java.util.Collection;

/**
 * The default encoder implementation
 * 
 * @author steffan
 *
 */
public class Encoder implements IEncoder {	
	
        public  String encode(int[] values)
        {
        
            int maxValue = this.getMaxValue(values);
            
            if (maxValue <= 61)
            {
                return simpleEncoding(values);
            }
            else if(maxValue <= 4095)
            {
                return extendedEncoding(values);
            }

            return null;
        }

        public String encodeIntegerCollection(Collection<int[]> values)
        {
            int maxValue = this.getMaxValue(values);
            
            if (maxValue <= 61)
            {
                return simpleEncoding(values);
            }
            else if (maxValue <= 4095)
            {
                return extendedEncoding(values);
            }

            return null;
        }

        public String encode(float[] values)
        {
            return textEncoding(values);
        }

        public String encodeFloatCollection(Collection<float[]> values)
        {
            return textEncoding(values);
        }

       

        public String simpleEncoding(int[] values)
        {
            return "s:" + simpleEncode(values);
        }

        public String simpleEncoding(Collection<int[]> values)
        {
            StringBuilder chartValues = new StringBuilder();
            
            chartValues.append("s:");

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
      
        public String textEncoding(float[] data)
        {
            return "t:" + textEncode(data);
        }

        public String textEncoding(Collection<float[]> values)
        {
            StringBuilder chartValues = new StringBuilder();
            chartValues.append("t:");

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
      

        public String extendedEncoding(int[] values)
        {
            return "e:" + extendedEncode(values);
        }

        public String extendedEncoding(Collection<int[]> values)
        {
            StringBuilder chartValues = new StringBuilder();
            chartValues.append("e:");

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
         * @param values array of integer to search
         * @return the max value
         */
        private int getMaxValue(int[] values)
        {
        	int max = 0;
        	for (int i = 0; i < values.length; i++){
        		if (values[i]>max){
        			max = values[i];
        		}
			}
			return max;        	
        }
        /**
         * 
         * @param values collection of integer arrays to search
         * @return the max value
         */
        private int getMaxValue(Collection<int[]> values)
        {
        	int max = 0;         	
        	for(int[] array: values){
        		
        		if(this.getMaxValue(array) > max){
        			max = this.getMaxValue(values);
        		}        		
        	}        	
        	return max;      
        }
    

}
