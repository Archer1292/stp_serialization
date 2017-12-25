import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    @Test
    public void getRandomPersonTest() {
        Assert.assertNotNull(Main.getRandomPerson());
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
