package unitTests.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import unitTests.BarChartTest;
import unitTests.GoogleOMeterTest;
import unitTests.LineChartTest;
import unitTests.MapTest;
import unitTests.PieChartTest;
import unitTests.QRCodeTest;
import unitTests.RadarChartTest;
import unitTests.ScatterPlotTest;
import unitTests.VennDiagramTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  GoogleOMeterTest.class,
  PieChartTest.class,
  QRCodeTest.class,
  ScatterPlotTest.class,
  VennDiagramTest.class,
  RadarChartTest.class,
  LineChartTest.class,
  MapTest.class,
  BarChartTest.class
})

/**
 * Testsuite for all complete charts
 */
public class AllChartTests {
}
