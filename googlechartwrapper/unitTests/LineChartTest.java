package unitTests;


import de.toolforge.googlechartwrapper.LineChart;
import de.toolforge.googlechartwrapper.XYLineChart;
import de.toolforge.googlechartwrapper.coder.EncoderFactory;
import de.toolforge.googlechartwrapper.coder.EncodingType;
import de.toolforge.googlechartwrapper.color.FillArea;
import de.toolforge.googlechartwrapper.color.FillArea.DataSetKind;
import de.toolforge.googlechartwrapper.data.DataScalingSet;
import de.toolforge.googlechartwrapper.data.LineChartData;
import de.toolforge.googlechartwrapper.data.XYLineChartData;
import de.toolforge.googlechartwrapper.label.*;
import de.toolforge.googlechartwrapper.style.FinancialMarker;
import de.toolforge.googlechartwrapper.style.FinancialMarker.Priority;
import de.toolforge.googlechartwrapper.style.LineStyle;
import de.toolforge.googlechartwrapper.style.ShapeMarker;
import de.toolforge.googlechartwrapper.style.ShapeMarker.MarkerTyp;
import de.toolforge.googlechartwrapper.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author steffan
 */
public class LineChartTest {

    @Test
    public void example() {

        LineChart l = new LineChart(new Dimension(300, 300));
        l.setChartTitle(new ChartTitle("linechart"));

        l.addLineChartData(new LineChartData.LineChartDataBuilder(Arrays.asList(20f, 30f, 40f)).build());

        l.addLineChartData(new LineChartData.LineChartDataBuilder(Arrays.asList(40f, 50f, 60f)).build());

        l.addLineChartData(new LineChartData.LineChartDataBuilder(Arrays.asList(60f, 40f, 30f)).build());

        l.addLineChartData(new LineChartData.LineChartDataBuilder(Arrays.asList(40f, 30f, 10f)).build());

        l.addFinancialMarker(new FinancialMarker(0, FinancialMarker.DataPoint.newDrawEachPoint(), 20, Priority.First));

        String target = "http://chart.apis.google.com/chart?cht=lc&chs=300x300&chd=s:Ueo,oy8,8oe,oeK&chm=F,,0,-1,20,1&chtt=linechart";

        Assert.assertEquals(target, l.getUrl());

    }

    @Test
    public void showCase2() {

        XYLineChart chart = new XYLineChart(new Dimension(300, 300));
        chart.setChartTitle(new ChartTitle("xyLineChart"));
        chart.setEncoder(EncoderFactory.getEncoder(EncodingType.TextEncoding));
        Pair<List<Float>, List<Float>> values1 = new Pair<List<Float>, List<Float>>(Arrays.asList(10f, 20f, 30f, 45f, 58f, 60f, 80f), Arrays.asList(34f, 12f, 89f, 45f, 70f, 80f, 110f));
        Pair<List<Float>, List<Float>> values2 = new Pair<List<Float>, List<Float>>(new ArrayList<Float>(), Arrays.asList(25f, 26f, 25f, 70f));

        XYLineChartData data = new XYLineChartData.XYLineChartDataBuilder(values1).color(Color.BLACK).build();
        XYLineChartData data2 = new XYLineChartData.XYLineChartDataBuilder(values2).style(new LineStyle(5, 2, 2)).build();
        List<XYLineChartData> d = new ArrayList<XYLineChartData>();
        d.add(data);
        d.add(data2);

        chart.addXYLineChartData(d);


        String target = "http://chart.apis.google.com/chart?cht=lxy&chs=300x300&chco=000000,ff9d0a&chd=t:10.0,20.0,30.0,45.0,58.0,60.0,80.0|34.0,12.0,89.0,45.0,70.0,80.0,110.0|-1.0|25.0,26.0,25.0,70.0&chls=1.0,0.0,0.0|5.0,2.0,2.0&chtt=xyLineChart";
        Assert.assertEquals(target, chart.getUrl());

    }

    @Test
    public void showCase() {

        LineChart l = new LineChart(new Dimension(600, 350));
        l.setChartTitle(new ChartTitle("Dow Jones 89-09"));

        l.addLineChartData(new LineChartData.LineChartDataBuilder(Arrays.asList(2.168f, 2.753f, 2.633f, 3.168f, 3.301f, 3.754f, 3.834f, 5.117f, 6.448f, 7.908f, 9.181f, 11.497f, 10.787f, 10.021f, 8.341f, 10.453f, 10.783f, 10.717f, 12.463f, 13.264f, 8.776f)).legend(new ChartLegend("Dow Jones")).lineStyle(new LineStyle(5f, 0f, 0f)).build());

        l.addShapeMarker(new ShapeMarker(MarkerTyp.Diamond, Color.BLUE, 0, ShapeMarker.DataPoint.newDrawEachPoint(), 10));


        l.addFillArea(new FillArea(DataSetKind.Multi, Color.RED, 0, 0));

        AxisLabelContainer c = new AxisLabelContainer(AxisType.XAxis);
        c.setAxisRange(new AxisRange(1989, 2009, 2));
        l.addAxisLabelContainer(c);

        l.addDataPointLabel(new DataPointLabel(new DataPointLabel.PercentageValueNumberBuilder(1).build(), Color.BLACK, 0, DataPointLabel.DataPoint.newDrawNPoint(5), 10, de.toolforge.googlechartwrapper.label.DataPointLabel.Priority.First));


        String target = "http://chart.apis.google.com/chart?cht=lc&chs=600x350&chd=s:CDDDDEEFGIJLLKIKLLMNJ&chdl=Dow Jones&chls=5.0,0.0,0.0&chm=d,0000ff,0,-1,10|B,ff0000,0,0,0|N*p1*,000000,0,-5,10,-1&chtt=Dow+Jones+89-09&chxr=0,1989,2009,2&chxt=x";

        Assert.assertEquals(target, l.getUrl());

    }

    @Test
    public void testtest() {

        LineChart chart = new LineChart(new Dimension(600, 300));
        chart.addDataScalingSet(new DataScalingSet(0, 100));
        chart.addLineChartData(new
                LineChartData.LineChartDataBuilder(Arrays.asList(10f, 20f)).build());
        chart.addLineChartData(new
                LineChartData.LineChartDataBuilder(Arrays.asList(40f, 30f)).build());
        System.out.println(chart.getUrl());


    }
}

