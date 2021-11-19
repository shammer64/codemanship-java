package propertybased;

public class Maths {
    public static double sqrt(double operand) {
        double guess = operand/2;
        double last = 0;
        while (Math.abs(guess - last) > 0.0) {
            last = guess;
            guess = (guess + operand/guess)/2;
        };
        return guess;
    }
}
