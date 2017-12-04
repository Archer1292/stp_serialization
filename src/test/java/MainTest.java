import org.junit.Assert;
import org.junit.Test;
/**
 * @author Bratus Nadja on 10/4/2017
 * @project lab5
 */
public class MainTest {
    @Test
    public void getRandomPersonTest() {
        Assert.assertNotNull(Main.getRandomCyity());
    }

    @Test
    public void getRandonString() {
        Assert.assertNotNull(Main.randonString(5, 5));
    }

    @Test
    public void getRandonNum() {
        Assert.assertNotNull(Main.randonNum());
    }
}