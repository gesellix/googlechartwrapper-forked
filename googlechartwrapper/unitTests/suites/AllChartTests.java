package unitTests.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import unitTests.*;

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
        BarChartTest.class,
        FreestandingDynamicIconTest.class
})

/**
 * Testsuite for all complete charts
 */
public class AllChartTests {
}
