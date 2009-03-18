package unitTests.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import unitTests.GoogleOMeterTest;
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
  RadarChartTest.class
})

/**
 * Testsuite for all complete charts
 */
public class AllChartTests {
}
