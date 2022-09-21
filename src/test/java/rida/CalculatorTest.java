package rida;

import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;
import rida.generator.SimpleDisplayNameGenerator;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@DisplayNameGeneration(value = SimpleDisplayNameGenerator.class)
public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @BeforeAll
    public static void beforeAll()
    {
        System.out.println("Before all");
    }

    @AfterAll
    public static void afterAll()
    {
        System.out.println("After all");
    }

    @BeforeEach
    public void setUp()
    {
        System.out.println("before each");
    }

    @AfterEach
    public void tearDown()
    {
        System.out.println("after each");
    }

    @Test
    public void testAddSuccess()
    {
        var result = calculator.add(10,10);
        assertEquals(20, result);
    }

    @Test
    public void testDivideSuccess()
    {
        var result = calculator.divide(100,10);
        assertEquals(10, result);
    }

    @Test
    public void testDivideFailed()
    {
        assertThrows(IllegalArgumentException.class, ()->{
           calculator.divide(100,0);
        });
    }

    @Test
    @Disabled
    public void testComingSoon()
    {

    }

    @Test
    public void testAssumptions()
    {
        var profile = System.getenv("PROFILE");

        assumeTrue("DEV".equals(profile), "Tes dibatalkan karena bukan DEV");
    }
}
