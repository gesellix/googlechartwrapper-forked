package unitTests;


import de.toolforge.googlechartwrapper.Dimension;
import de.toolforge.googlechartwrapper.QRCode;
import de.toolforge.googlechartwrapper.QRCode.ECLevel;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author steffan
 */
public class QRCodeTest {

    @Test
    public void example() {

        QRCode q = new QRCode(new Dimension(300, 300), "Hello World");

        String target = "http://chart.apis.google.com/chart?cht=qr&chs=300x300&chl=Hello%20World&choe=UTF-8";

        Assert.assertEquals(target, q.getUrl());

    }

    @Test
    public void example2() {

        QRCode q = new QRCode(new Dimension(300, 300), "nothing", ECLevel.Medium, 10);

        q.setTextToEncode("anotherText");


        String target = "http://chart.apis.google.com/chart?cht=qr&chs=300x300&chl=anotherText&choe=UTF-8&chld=M|10";

        Assert.assertEquals(target, q.getUrl());
    }

    @Test(expected = IllegalArgumentException.class)
    public void example3() {

        QRCode q = new QRCode(new Dimension(300, 300), "nothing", ECLevel.Medium, 10);

        q.setTextToEncode(null);

    }

    @Test
    public void showCase() {

        QRCode qrCode = new QRCode(new Dimension(300, 300), "made in germany");

        String target = "http://chart.apis.google.com/chart?cht=qr&chs=300x300&chl=made%20in%20germany&choe=UTF-8";

        Assert.assertEquals(target, qrCode.getUrl());
    }

}
