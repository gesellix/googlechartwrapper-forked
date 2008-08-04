package googlechartwrapper;

import googlechartwrapper.coder.Encoder;
import googlechartwrapper.coder.IEncoder;

import java.awt.Color;
import java.awt.Dimension;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author steffan
 * 
 * base class for every chart
 *
 */
abstract class AbstractChart implements Chart {
	
	 private final String googleAPI = "http://chart.apis.google.com/chart?";
     protected Queue<String> urlElements = new LinkedList<String>();
	 protected String values;
	 private IEncoder encoder = new Encoder();
	 protected Dimension chartDimension;
	 //private String title;
     //private String titleColor;
     private String newLine = System.getProperty("line.separator");
     protected Color[] dataColors;
	 

    
     public AbstractChart(Dimension chartDimension){
         this.chartDimension = chartDimension;
     }

     /* (non-Javadoc)
	 * @see googlechartwrapper.Chart#setValues(int[])
	 */
     public void setValues(int [] values){
    	 
    	 this.values = this.encoder.encode(values);
     }
     /**
      * 
      * @param values
      */
     public void setValues(Collection<int []> values){
         this.values = this.encoder.encodeIntegerCollection(values);
     }
     /* (non-Javadoc)
	 * @see googlechartwrapper.Chart#setValues(float[])
	 */
     public void setValues(float [] values){
    	 
    	 this.values = this.encoder.encode(values);
     }
    
    public void setEncoder(IEncoder newEncoder){
     
    	 this.encoder = newEncoder;
     }
     /* (non-Javadoc)
	 * @see googlechartwrapper.Chart#getEncoder()
	 */
    public IEncoder getEncoder(){
    	 return this.encoder;
     }    

     /*#endregion

     # region Fills
     List<SolidFill> solidFills = new List<SolidFill>();
     List<LinearGradientFill> linearGradientFills = new List<LinearGradientFill>();
     List<LinearStripesFill> linearStripesFills = new List<LinearStripesFill>();

     /// <summary>
     /// Add a solid fill to this chart.
     /// </summary>
     /// <param name="solidFill"></param>
     public void AddSolidFill(SolidFill solidFill)
     {
         solidFills.Add(solidFill);
     }

     /// <summary>
     /// Add a linear gradient fill to this chart.
     /// </summary>
     /// <param name="linearGradientFill"></param>
     public void AddLinearGradientFill(LinearGradientFill linearGradientFill)
     {
         linearGradientFills.Add(linearGradientFill);
     }

     /// <summary>
     /// Add a linear stripes fill to this chart.
     /// </summary>
     /// <param name="linearStripesFill"></param>
     public void AddLinearStripesFill(LinearStripesFill linearStripesFill)
     {
         linearStripesFills.Add(linearStripesFill);
     }
     #endregion

     #region Grid
     bool gridSet = false;
     private float gridXAxisStepSize = -1;
     private float gridYAxisStepSize = -1;
     private float gridLengthLineSegment = -1;
     private float gridLengthBlankSegment = -1;

     /// <summary>
     /// Add a grid to the chart using default line segment and blank line segment length.
     /// </summary>
     /// <param name="xAxisStepSize">Space between x-axis grid lines in relation to axis range.</param>
     /// <param name="yAxisStepSize">Space between y-axis grid lines in relation to axis range.</param>
     public void SetGrid(float xAxisStepSize, float yAxisStepSize)
     {
         ChartType chartType = getChartType();
         if (!(chartType == ChartType.LineChart || chartType == ChartType.ScatterPlot))
         {
             throw new InvalidFeatureForChartTypeException();
         }

         this.gridXAxisStepSize = xAxisStepSize;
         this.gridYAxisStepSize = yAxisStepSize;
         this.gridLengthLineSegment = -1;
         this.gridLengthBlankSegment = -1;
         this.gridSet = true;
     }

     /// <summary>
     /// Add a grid to the chart.
     /// </summary>
     /// <param name="xAxisStepSize">Space between x-axis grid lines in relation to axis range.</param>
     /// <param name="yAxisStepSize">Space between y-axis grid lines in relation to axis range.</param>
     /// <param name="lengthLineSegment">Length of each line segment in a grid line</param>
     /// <param name="lengthBlankSegment">Length of each blank segment in a grid line</param>
     public void SetGrid(float xAxisStepSize, float yAxisStepSize, float lengthLineSegment, float lengthBlankSegment)
     {
         ChartType chartType = getChartType();
         if (!(chartType == ChartType.LineChart || chartType == ChartType.ScatterPlot))
         {
             throw new InvalidFeatureForChartTypeException();
         }

         this.gridXAxisStepSize = xAxisStepSize;
         this.gridYAxisStepSize = yAxisStepSize;
         this.gridLengthLineSegment = lengthLineSegment;
         this.gridLengthBlankSegment = lengthBlankSegment;
         this.gridSet = true;
     }

     private string getGridUrlElement()
     {
         if (gridXAxisStepSize != -1 && gridYAxisStepSize != -1)
         {
             string s = String.Format("chg={0},{1}", gridXAxisStepSize.ToString(), gridYAxisStepSize.ToString());
             if (gridLengthLineSegment != -1 && gridLengthBlankSegment != -1)
             {
                 s += "," + gridLengthLineSegment.ToString() + "," + gridLengthBlankSegment.ToString();
             }
             return s;
         }
         return null;
     }

     #endregion

     #region Markers
     List<ShapeMarker> shapeMarkers = new List<ShapeMarker>();
     List<RangeMarker> rangeMarkers = new List<RangeMarker>();
     List<FillArea> fillAreas = new List<FillArea>();

     /// <summary>
     /// Add a fill area to the chart. Fill areas are fills between / under lines.
     /// </summary>
     /// <param name="fillArea"></param>
     public void AddFillArea(FillArea fillArea)
     {
         this.fillAreas.Add(fillArea);
     }

     /// <summary>
     /// Add a shape marker to the chart. Shape markers are used to call attention to a data point on the chart.
     /// </summary>
     /// <param name="shapeMarker"></param>
     public void AddShapeMarker(ShapeMarker shapeMarker)
     {
         this.shapeMarkers.Add(shapeMarker);
     }

     /// <summary>
     /// Add a range marker to the chart. Range markers are colored bands on the chart.
     /// </summary>
     /// <param name="rangeMarker"></param>
     public void AddRangeMarker(RangeMarker rangeMarker)
     {
         this.rangeMarkers.Add(rangeMarker);
     }

     private string getFillAreasUrlElement()
     {
         string s = string.Empty;
         foreach (FillArea fillArea in fillAreas)
         {
             s += fillArea.GetUrlString() + "|";
         }
         return s.TrimEnd("|".ToCharArray());
     }

     private string getShapeMarkersUrlElement()
     {
         string s = string.Empty;
         foreach (ShapeMarker shapeMarker in shapeMarkers)
         {
             s += shapeMarker.GetUrlString() + "|";
         }
         return s.TrimEnd("|".ToCharArray());
     }

     private string getRangeMarkersUrlElement()
     {
         string s = string.Empty;
         foreach (RangeMarker rangeMarker in rangeMarkers)
         {
             s += rangeMarker.GetUrlString() + "|";
         }
         return s.TrimEnd("|".ToCharArray());
     }

     #endregion

     #region Labels
     List<ChartAxis> axes = new List<ChartAxis>();
     List<string> legendStrings = new List<string>();

     /// <summary>
     /// Set chart legend
     /// </summary>
     /// <param name="strs">legend labels</param>
     public virtual void SetLegend(string[] strs)
     {
         foreach (string s in strs)
         {
             legendStrings.Add(s);
         }
     }

     /// <summary>
     /// Add an axis to the chart
     /// </summary>
     /// <param name="axis"></param>
     public void AddAxis(ChartAxis axis)
     {
         axes.Add(axis);
     }
     */
    
     /* (non-Javadoc)
	 * @see googlechartwrapper.Chart#getUrl()
	 */
    public String getUrl()
     {
         collectUrlElements();
         
         return generateUrlString();
     }

     
     protected abstract String getUrlChartType();
     protected abstract ChartType getChartType();

    
     protected  void collectUrlElements()
     {
    	 
    	 urlElements.clear();
    	 urlElements.offer(MessageFormat.format("cht={0}", this.getUrlChartType()));
         urlElements.offer(MessageFormat.format("chs={0}x{1}", this.chartDimension.width, this.chartDimension.height));
         urlElements.offer(this.values);

         // chart title
         /*if (title != null)
         {
             urlElements.offer(MessageFormat.format("chtt={0}", this.title));
         }
         if (titleColor != null)
         {
             urlElements.offer(MessageFormat.format("chts={0}", this.titleColor));
         }*/
         
         //converts the color objects into an hex equivalent for google
         if (dataColors != null && dataColors.length > 0){
         	StringBuffer bf = new StringBuffer(dataColors.length * 8+5);
         	bf.append("chco=");
         	for (Color c: dataColors){
         		bf.append(Integer.toHexString(c.getRGB()).substring(2,8));
         		bf.append(",");
         	}
         	urlElements.offer(bf.toString().substring(0,bf.toString().length()-1));
         }

         /*
         // dataset colors
         if (datasetColors != null)
         {
             string s = "chco=";
             foreach (string color in datasetColors)
             {
                 s += color + ",";
             }
             urlElements.Enqueue(s.TrimEnd(",".ToCharArray()));
         }

         // Fills
         string fillsString = "chf=";
         if (solidFills.Count > 0)
         {
             foreach (SolidFill solidFill in solidFills)
             {
                 fillsString += solidFill.GetUrlString() + "|";
             }
         }
         if (linearGradientFills.Count > 0)
         {
             foreach (LinearGradientFill linearGradient in linearGradientFills)
             {
                 fillsString += linearGradient.GetUrlString() + "|";
             }
         }
         if (linearStripesFills.Count > 0)
         {
             foreach (LinearStripesFill linearStripesFill in linearStripesFills)
             {
                 fillsString += linearStripesFill.GetUrlString() + "|";
             }
         }
         if (solidFills.Count > 0 || linearGradientFills.Count > 0 || linearStripesFills.Count > 0)
         {
             urlElements.Enqueue(fillsString.TrimEnd("|".ToCharArray()));
         }

         // Legends
         if (legendStrings.Count > 0)
         {
             string s = "chdl=";
             foreach (string str in legendStrings)
             {
                 s += str + "|";
             }
             urlElements.Enqueue(s.TrimEnd("|".ToCharArray()));
         }

         // Axes
         if (axes.Count > 0)
         {
             string axisTypes = "chxt=";
             string axisLabels = "chxl=";
             string axisLabelPositions = "chxp=";
             string axisRange = "chxr=";
             string axisStyle = "chxs=";

             int axisIndex = 0;
             foreach (ChartAxis axis in axes)
             {
                 axisTypes += axis.urlAxisType() + ",";
                 axisLabels += axisIndex.ToString() + ":" + axis.urlLabels();
                 string labelPositions = axis.urlLabelPositions();
                 if (! String.IsNullOrEmpty(labelPositions))
                 {
                     axisLabelPositions += axisIndex.ToString() + "," + labelPositions + "|";
                 }
                 string axisRangeStr = axis.urlRange();
                 if (!String.IsNullOrEmpty(axisRangeStr))
                 {
                     axisRange += axisIndex.ToString() + "," + axisRangeStr + "|";
                 }
                 string axisStyleStr = axis.UrlAxisStyle();
                 if (!String.IsNullOrEmpty(axisStyleStr))
                 {
                     axisStyle += axisIndex.ToString() + "," + axisStyleStr + "|";
                 }
                 axisIndex++;
             }
             axisTypes = axisTypes.TrimEnd(",".ToCharArray());
             axisLabels = axisLabels.TrimEnd("|".ToCharArray());
             axisLabelPositions = axisLabelPositions.TrimEnd("|".ToCharArray());
             axisRange = axisRange.TrimEnd("|".ToCharArray());
             axisStyle = axisStyle.TrimEnd("|".ToCharArray());

             urlElements.Enqueue(axisTypes);
             urlElements.Enqueue(axisLabels);
             urlElements.Enqueue(axisLabelPositions);
             urlElements.Enqueue(axisRange);
             urlElements.Enqueue(axisStyle);
         }

         // Grid
         if (gridSet)
         {
             urlElements.Enqueue(getGridUrlElement());
         }
         
         // Markers
         string markersString = "chm=";
         if (shapeMarkers.Count > 0)
         {
             markersString += getShapeMarkersUrlElement() + "|";
         }
         if (rangeMarkers.Count > 0)
         {
             markersString += getRangeMarkersUrlElement() + "|";
         }
         if (fillAreas.Count > 0)
         {
             markersString += getFillAreasUrlElement() + "|";
         }
         if (shapeMarkers.Count > 0 || rangeMarkers.Count > 0 || fillAreas.Count > 0)
         {
             urlElements.Enqueue(markersString.TrimEnd("|".ToCharArray()));
         }*/
     }

     private String generateUrlString()
     {
         StringBuilder url = new StringBuilder();
         
         url.append(this.googleAPI);
      
         url.append(urlElements.poll());         

         while (urlElements.size() > 0)
         {             
             url.append("&"+urlElements.poll());
         }

         return url.toString();
     }

	public void setDataColors(Color[] dataColors) {
		this.dataColors = dataColors;
	}

     
 }


