package rida;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;


public class ConditionTest {

    @Test
    @EnabledOnOs({OS.WINDOWS})
    public void testRunOnlyOnWindows()
    {

    }

    @Test
    @DisabledOnOs({OS.WINDOWS})
    public void testDisabledOnWindows()
    {

    }

    @Test
    @EnabledOnJre({JRE.JAVA_18})
    public void testEnabledOnJava18()
    {

    }

    @Test
    @DisabledOnJre({JRE.JAVA_18})
    public void testDisabledOnJava18()
    {

    }
}
