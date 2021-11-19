package propertybased;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class SquareRootTest {

    @Test
    public void sqrtOfZeroIsZero() {
        assertThat(Maths.sqrt(0), is(0.0));
    }

    @Test
    public void sqrtOfOneIsOne() {
        assertThat(Maths.sqrt(1), is(1.0));
    }

    @Test
    public void sqrtOfOFourIsTwo() {
        assertThat(Maths.sqrt(4), is(2.0));
    }

    @Test
    public void sqrtOfONineIsThree() {
        assertThat(Maths.sqrt(9), is(3.0));
    }

    @Test
    public void sqrtOfOSixteenIsFour() {
        assertThat(Maths.sqrt(16), is(4.0));
    }

    @Test
    public void sqrtOfOTwentyFiveIsFive() {
        assertThat(Maths.sqrt(25), is(5.0));
    }

    @Test
    public void sqrtOfOneQuarterIsoneHalf() {
        assertThat(Maths.sqrt(0.25), is(0.5));
    }

    @Test
    public void sqrtOfTwo() {
        assertThat(Maths.sqrt(2), is(1.414213562373095));
    }

}
