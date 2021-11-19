package propertybased;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareRootTest {

    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "4,2", "9,3", "16,4", "25,5", "0.25,0.5", "2,1.414213562373095"})
    public void squareRootUsingBabylonianMethod(double operand, double root) {
        assertEquals(Maths.sqrt(operand), root, 0.0);
    }

    @ParameterizedTest
    @MethodSource("parametersForSquareRootTest")
    public void squareRootUsingBabylonianMethod_2(double operand, double root) {
        assertEquals(Maths.sqrt(operand), root, 0.00000000001);
    }

    private static Stream<Arguments> parametersForSquareRootTest() {
        return IntStream.range(0,100).mapToObj((num) -> Arguments.arguments(num, Math.sqrt(num)));
    }
}
