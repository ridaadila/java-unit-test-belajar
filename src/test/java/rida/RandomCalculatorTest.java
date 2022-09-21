package rida;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import rida.resolver.RandomParameterResolver;

import java.util.List;
import java.util.Random;

@Extensions({
        @ExtendWith(RandomParameterResolver.class)
})
public class RandomCalculatorTest {

    private Calculator calculator = new Calculator();

    @DisplayName("Test random calculator")
    @RepeatedTest(
            value = 10,
            name = "{displayName} ke {currentRepetition} dari {totalRepetitions}"
    )
    void testRandom(Random random)
    {
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);
    }

    @BeforeEach
    void beforeEach()
    {
        System.out.println("Before Each");
    }

    @DisplayName("test calculator")
    @ParameterizedTest(
            name = "{displayName} dengan parameter {0}"
    )
    @ValueSource(ints = {1,2,3,4,5, 100, 200})
    void testWithParameter(int value)
    {
        var expected = value + value;
        var result = calculator.add(value, value);
        Assertions.assertEquals(expected, result);
    }

    public static List<Integer> methodSource()
    {
        return List.of(1,3,2,4,7,6);
    }

    @DisplayName("test calculator")
    @ParameterizedTest(
            name = "{displayName} dengan parameter {0}"
    )
    @MethodSource({"methodSource"})
    void testMethodSource(int value)
    {
        var expected = value + value;
        var result = calculator.add(value, value);
        Assertions.assertEquals(expected, result);
    }
}
