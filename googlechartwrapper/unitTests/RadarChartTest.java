package unitTests;

import static org.junit.Assert.assertEquals;
import googlechartwrapper.RadarChart;
import googlechartwrapper.coder.EncoderFactory;
import googlechartwrapper.coder.EncodingType;
import googlechartwrapper.color.FillArea;
import googlechartwrapper.color.FillArea.DataSetKind;
import googlechartwrapper.data.RadarChartLine;
import googlechartwrapper.label.AxisLabel;
import googlechartwrapper.label.AxisLabelContainer;
import googlechartwrapper.label.AxisRange;
import googlechartwrapper.label.AxisType;
import googlechartwrapper.label.ChartTitle;
import googlechartwrapper.style.GridLine;
import googlechartwrapper.style.ShapeMarker;
import googlechartwrapper.style.ShapeMarker.DataPoint;
import googlechartwrapper.style.ShapeMarker.MarkerTyp;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class RadarChartTest {

	@Test
	public void testSimpleExample() {
		RadarChart chart = new RadarChart(new Dimension(200, 200), false);

		List<Integer> values = Arrays.asList(new Integer[] { 10, 20, 30, 50,
				70, 90, 100, 120 });
		RadarChartLine line = new RadarChartLine(Color.ORANGE, values);

		chart.addRadarChartLine(line);
		chart.setEncoder(EncoderFactory.getEncoder(EncodingType.TextEncoding));

		AxisLabelContainer axisLabel = new AxisLabelContainer(AxisType.XAxis);
		for (int i = 0; i < 316; i = i + 45) {
			axisLabel.addLabel(new AxisLabel("" + i));
		}
		axisLabel.setAxisRange(new AxisRange(0, 360));
		chart.addAxisLabelSummary(axisLabel);

		chart.addFillArea(new FillArea(DataSetKind.Multi, new Color(
				Color.ORANGE.getRed(), Color.ORANGE.getGreen(), Color.ORANGE
						.getBlue(), 80), 0, 1));

		
		chart.setGridLine(new GridLine.GridLineBuilder(25,25).build());

		chart.setChartTitle(new ChartTitle("Java Google Chart Wrapper"));

		String expected = "http://chart.apis.google.com/chart?cht=rs&chs=200x200&"
				+ "chd=t:10,20,30,50,70,90,100,120&ffc800&chg=25.0,25.0&"
				+ "chm=B,ffc800,0,1,0&chtt=Java+Google+Chart+Wrapper&chxt=x&"
				+ "chxl=0:|0|45|90|135|180|225|270|315&chxr=0,0,360";
		assertEquals(expected, chart.getUrl());
	}

	@Test
	public void example2() {

		RadarChart chart = new RadarChart(new Dimension(200, 200), false);
		List<Integer> values = Arrays.asList(new Integer[] { 10, 20, 30, 50,
				70, 90, 100, 120 });
		RadarChartLine line = new RadarChartLine(Color.ORANGE, values);
		chart.addRadarChartLine(line);
		chart.setEncoder(EncoderFactory.getEncoder(EncodingType.TextEncoding));

		chart.addShapeMarker(new ShapeMarker(MarkerTyp.Cross, Color.ORANGE, 0,
				DataPoint.drawNPoint(2), 15));

		String expected = "http://chart.apis.google.com/chart?cht=rs&chs=200x200&chd=t:10,20,30,50,70,90,100,120&ffc800&chm=c,ffc800,0,-2,15";
		assertEquals(expected, chart.getUrl());

	}

}
