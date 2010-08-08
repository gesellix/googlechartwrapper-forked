package unitTests;

import de.toolforge.googlechartwrapper.Color;
import de.toolforge.googlechartwrapper.Dimension;
import de.toolforge.googlechartwrapper.RadarChart;
import de.toolforge.googlechartwrapper.coder.EncoderFactory;
import de.toolforge.googlechartwrapper.coder.EncodingType;
import de.toolforge.googlechartwrapper.color.FillArea;
import de.toolforge.googlechartwrapper.color.FillArea.DataSetKind;
import de.toolforge.googlechartwrapper.data.RadarChartLine;
import de.toolforge.googlechartwrapper.label.*;
import de.toolforge.googlechartwrapper.style.GridLine;
import de.toolforge.googlechartwrapper.style.LineStyle;
import de.toolforge.googlechartwrapper.style.ShapeMarker;
import de.toolforge.googlechartwrapper.style.ShapeMarker.DataPoint;
import de.toolforge.googlechartwrapper.style.ShapeMarker.MarkerTyp;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RadarChartTest {

    @Test
    public void example1() {
        RadarChart chart = new RadarChart(new Dimension(200, 200));

        List<Integer> values = Arrays.asList(new Integer[]{10, 20, 30, 50,
                70, 90, 100, 120});
        RadarChartLine line = new RadarChartLine(Color.RED, values);

        chart.addRadarChartLine(line);
        chart.setEncoder(EncoderFactory.getEncoder(EncodingType.TextEncoding));

        AxisLabelContainer axisLabel = new AxisLabelContainer(AxisType.XAxis);
        for (int i = 0; i < 316; i = i + 45) {
            axisLabel.addLabel(new AxisLabel("" + i));
        }
        axisLabel.setAxisRange(new AxisRange(0, 360));
        chart.addAxisLabelContainer(axisLabel);

        chart.addFillArea(new FillArea(DataSetKind.Multi, new Color(
                Color.ORANGE.getRed(), Color.ORANGE.getGreen(), Color.ORANGE
                        .getBlue(), 80), 0, 1));


        chart.setGridLine(new GridLine.GridLineBuilder(25, 25).build());

        chart.setChartTitle(new ChartTitle("Java Google Chart Wrapper"));


        String expected = "http://chart.apis.google.com/chart?cht=rs&chs=200x200&chco=ff0000&chd=t:10,20,30,50,70,90,100,120&chg=25,25&chm=B,ffc80050,0,1,0&chtt=Java+Google+Chart+Wrapper&chxl=0:|0|45|90|135|180|225|270|315&chxr=0,0,360&chxt=x";
        assertEquals(expected, chart.getUrl());
    }

    @Test
    public void example2() {

        RadarChart chart = new RadarChart(new Dimension(200, 200));
        List<Integer> values = Arrays.asList(new Integer[]{10, 20, 30, 50,
                70, 90, 100, 120});
        RadarChartLine line = new RadarChartLine(Color.GREEN, values);
        chart.addRadarChartLine(line);
        chart.setEncoder(EncoderFactory.getEncoder(EncodingType.TextEncoding));

        chart.addShapeMarker(new ShapeMarker(MarkerTyp.Cross, Color.ORANGE, 0,
                DataPoint.newDrawNPoint(2), 15));

        String expected = "http://chart.apis.google.com/chart?cht=rs&chs=200x200&chco=00ff00&chd=t:10,20,30,50,70,90,100,120&chm=c,ffc800,0,-2,15";
        assertEquals(expected, chart.getUrl());

    }

    @Test
    public void showCase() {

        RadarChart chart = new RadarChart(new Dimension(400, 400));
        chart.setChartTitle(new ChartTitle("free time activities"));
        chart.setDefault();

        chart.addRadarChartLine(new RadarChartLine(Color.GREEN, Arrays.asList(30, 50, 50, 80, 20, 30)));

        AxisLabelContainer container = new AxisLabelContainer(AxisType.XAxis);
        container.addLabel(new AxisLabel("Math"));
        container.addLabel(new AxisLabel("Coding (Java)"));
        container.addLabel(new AxisLabel("Music"));
        container.addLabel(new AxisLabel("Sport"));
        container.addLabel(new AxisLabel("Reading"));

        chart.addAxisLabelContainer(container);

        AxisLabelContainer container2 = new AxisLabelContainer(AxisType.YAxis);

        container2.setAxisRange(new AxisRange(0, 100));
        container2.addLabel(new AxisLabel("0"));
        container2.addLabel(new AxisLabel("20"));
        container2.addLabel(new AxisLabel("40"));
        container2.addLabel(new AxisLabel("60"));
        container2.addLabel(new AxisLabel("100"));
        chart.addAxisLabelContainer(container2);

        chart.addLineStyle(new LineStyle(3.5f, 0f, 0f));
        chart.addShapeMarker(new ShapeMarker(MarkerTyp.Arrow, Color.RED, 1, ShapeMarker.DataPoint.newDrawPoint(3f), 10));

        chart.addShapeMarker(new ShapeMarker(MarkerTyp.HorizontalLine, Color.YELLOW, 0, ShapeMarker.DataPoint.newDrawEachPoint(), 1));

        chart.setEncoder(EncoderFactory.getEncoder(EncodingType.TextEncoding));

        String expected = "http://chart.apis.google.com/chart?cht=r&chs=400x400&chco=00ff00&chd=t:30,50,50,80,20,30&chls=3.5,0.0,0.0&chm=a,ff0000,0,3.0,10|h,ffff00,0,-1,1&chtt=free+time+activities&chxl=0:|Math|Coding (Java)|Music|Sport|Reading|1:|0|20|40|60|100&chxr=1,0,100&chxt=x,y";
        assertEquals(expected, chart.getUrl());
    }

}
