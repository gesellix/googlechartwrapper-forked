package unitTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  GoogleOMeterTest.class,
  PieChartTest.class,
  QTCodesTest.class,
  ScatterPlotTest.class,
  VennDiagramTest.class
})

public class AllChartTests {
}
