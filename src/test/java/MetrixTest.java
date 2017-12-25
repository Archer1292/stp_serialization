import org.junit.Assert;
import org.junit.Test;

public class MetrixTest {
    @Test
    public void testMetrixTime() {
        Metrics.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Assert.fail();
        }
        Metrics.stop();
        Assert.assertEquals("Metrix Time Test faild", 1.0, Metrics.getTime(), 0.01);
        Metrics.clear();
        Assert.assertEquals("Metrix Clear Test faild", 0.0, Metrics.getTime(), 0.0);
    }

    @Test
    public void testMetrixMemory() {
        Metrics.start();
        long test = 12;
        Metrics.stop();
        Assert.assertEquals("Metrix Memory Test  faild", 0.00000762939453125, Metrics.getMemory(), 0.01);
        Metrics.clear();
    }


}
