/**
 *
 */
package unitTests;

import de.toolforge.googlechartwrapper.Color;
import de.toolforge.googlechartwrapper.FreestandingDynamicIcon;
import de.toolforge.googlechartwrapper.data.FreestandingDynamicIconData;
import de.toolforge.googlechartwrapper.style.icon.Bubble;
import de.toolforge.googlechartwrapper.style.icon.BubbleFactory;
import de.toolforge.googlechartwrapper.style.icon.Icon;
import de.toolforge.googlechartwrapper.style.icon.TailDirection;
import org.junit.Test;

/**
 * @author steffan
 */
public class FreestandingDynamicIconTest {

    @Test
    public void example1() {

        Bubble b = BubbleFactory.createBubble(Icon.BankDollar, TailDirection.BottomLeft, "mit der Api verdienen", Color.GREEN, Color.GRAY);

        FreestandingDynamicIcon chart = new FreestandingDynamicIcon(new FreestandingDynamicIconData(b));

        System.out.print(chart.getUrl());

        /*assertEquals("http://chart.apis.google.com/chart?cht=p&chs=400x180&chco=0000ff," +
                  "ff9d0a&chd=e:..QA&chl=USA|Canada&chp=2.5&chtt=GDP+of+the+world(nominal)"
                  ,chart.getUrl());
          */

        System.out.print("\n");
        FreestandingDynamicIcon chart2 = new FreestandingDynamicIcon(new FreestandingDynamicIconData(b.toShadow()));

        System.out.println(chart2.getUrl());
    }
}
