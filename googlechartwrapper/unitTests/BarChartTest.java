/*
 * Copyright (c) 2008-2010, Steffan Voß, Martin Vanauer
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Steffan Voß, Martin Vanauer BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/**
 *
 */
package unitTests;


import de.toolforge.googlechartwrapper.BarChart;
import de.toolforge.googlechartwrapper.BarChart.BarChartOrientation;
import de.toolforge.googlechartwrapper.BarChart.BarChartStyle;
import de.toolforge.googlechartwrapper.coder.EncoderFactory;
import de.toolforge.googlechartwrapper.coder.EncodingType;
import de.toolforge.googlechartwrapper.data.BarChartDataSerie;
import de.toolforge.googlechartwrapper.data.DataScalingSet;
import de.toolforge.googlechartwrapper.label.*;
import de.toolforge.googlechartwrapper.style.BarWidthAndSpacing;
import de.toolforge.googlechartwrapper.style.LineAndBarChartLineStyle;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;

/**
 * @author steffan
 * @author martin
 */
public class BarChartTest {

    @Test
    public void showCase() {

        BarChart bc = new BarChart(new Dimension(300, 300), BarChartOrientation.Horizontal, BarChartStyle.Grouped);
        bc.setChartTitle(new ChartTitle("Heights of Black Cherry trees"));

        bc.setEncoder(EncoderFactory.getEncoder(EncodingType.TextEncoding));
        BarChartDataSerie s = new BarChartDataSerie.BarChartDataSerieBuilder(Arrays.asList(24, 24, 64, 80, 40, 16)).color(Color.ORANGE).build();
        bc.addBarChartDataSerie(s);

        bc.addLineAndBarChartLineStyle(new LineAndBarChartLineStyle(new Color(255, 122, 89), 0, LineAndBarChartLineStyle.DataPoint.newDrawEachPoint(), 5));

        AxisLabelContainer x = new AxisLabelContainer(AxisType.XAxis);
        x.setAxisRange(new AxisRange(60, 90, 5));
        bc.addAxisLabelContainer(x);

        AxisLabelContainer y = new AxisLabelContainer(AxisType.YAxis);
        y.setAxisRange(new AxisRange(0, 10, 2));
        bc.addAxisLabelContainer(y);

        AxisLabelContainer xl = new AxisLabelContainer(AxisType.XAxis);
        AxisLabel label = new AxisLabel("Height (feet)");
        label.setPos(50);
        xl.setUseLabelPositions(true);
        xl.addLabel(label);
        bc.addAxisLabelContainer(xl);

        AxisLabelContainer yl = new AxisLabelContainer(AxisType.YAxis);
        AxisLabel label2 = new AxisLabel("Frequency");
        label2.setPos(50);
        yl.setUseLabelPositions(true);
        yl.addLabel(label2);
        bc.addAxisLabelContainer(yl);


        bc.setBarWidthAndSpacing(BarWidthAndSpacing.newAutomaticallyResize());

        String target = "http://chart.apis.google.com/chart?cht=bvg&chs=300x300&chbh=a&chco=ffc800&chd=t:24,24,64,80,40,16&chm=D,ff7a59,0,0,5&chtt=Heights+of+Black+Cherry+trees&chxl=2:|Height (feet)|3:|Frequency&chxp=2,50|3,50&chxr=0,60,90,5|1,0,10,2&chxt=x,y,x,y";

        Assert.assertEquals(target, bc.getUrl());

    }

    @Test
    public void example1() {

        BarChart bc = new BarChart(new Dimension(400, 150), BarChartOrientation.Horizontal, BarChartStyle.Grouped);

        BarChartDataSerie bcds1 = new BarChartDataSerie.BarChartDataSerieBuilder(Arrays.asList(24, 24, 64, 80, 40, 16)).color(de.toolforge.googlechartwrapper.Color.GREEN).build();
        BarChartDataSerie bcds2 = new BarChartDataSerie.BarChartDataSerieBuilder(Arrays.asList(24, 24, 64, 80, 40, 16)).color(de.toolforge.googlechartwrapper.Color.BLACK).build();
        bc.addBarChartDataSerie(bcds1);
        bc.addDataScalingSet(new DataScalingSet(0, 200)); //Scalingset 1
        bc.addBarChartDataSerie(bcds2);
        bc.addDataScalingSet(new DataScalingSet(0, 20));  //Scalingset 2

        System.out.println(bc.getUrl());
    }


}
