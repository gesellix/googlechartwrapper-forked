package unitTests.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import unitTests.coder.AutoEncoderTest;
import unitTests.coder.ExtendedEncoderTest;
import unitTests.coder.SimpleEncoderTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({  
  ExtendedEncoderTest.class,
  SimpleEncoderTest.class,
  AutoEncoderTest.class
})

/**
 * Suite of all modul tests, so no complete charts.
 */
public class AllModulTests {

}
