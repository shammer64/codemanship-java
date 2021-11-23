package propertybased;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareRootTest {

    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "4,2", "9,3", "16,4", "25,5", "0.25,0.5", "2,1.414213562373095"})
    public void squareRootUsingBabylonianMethod(double operand, double root) {
        assertEquals(root, Maths.sqrt(operand), 0.0);
    }

    @ParameterizedTest
    @MethodSource("parametersForSquareRootTest")
    public void squareRootUsingBabylonianMethod_2(double operand, double root) {
        assertEquals(root, Maths.sqrt(operand), 1E-10);
    }

    @ParameterizedTest
    @MethodSource("parametersForSquareRootTest")
    public void squareRootUsingBabylonianMethod_3(double operand, double root) {
        assertEquals(operand, Maths.sqrt(operand) * Maths.sqrt(operand), 1E-10);
    }

    private static Stream<Arguments> parametersForSquareRootTest() {
        return IntStream.range(0,100).mapToObj((num) -> Arguments.arguments(num, Math.sqrt(num)));
    }

    @ParameterizedTest
    @MethodSource("parametersAsFractionsForSquareRootTest")
    public void squareRootUsingBabylonianMethod_4(double operand) {
        assertEquals(operand, Maths.sqrt(operand) * Maths.sqrt(operand), 1E-10);
    }

    private static Stream<Arguments> parametersAsFractionsForSquareRootTest() {
        return IntStream.range(2, 50).mapToDouble((num) -> (double)1/num).mapToObj((fraction) -> Arguments.arguments(fraction));
    }

}
