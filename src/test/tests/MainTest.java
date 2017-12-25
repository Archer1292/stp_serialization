package tests;

import org.junit.Test;
import serialization.Main;
import org.junit.contrib.java.lang.system.*;
import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void main() throws Exception {
        Main main = new Main();
        SystemOutRule rule = new SystemOutRule().enableLog();
        main.main(null);
        assertEquals(false, rule.getLog().contains("ERROR"));
    }
}