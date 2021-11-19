package video4_5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

/*
  Rule of Three: wait until I see at least 3 examples of duplication before removing the duplication
  - Too soon...risk not enough examples to create proper abstraction
  - Too late...more work in implementing the change

  Parameterized Test example

  Inside Out TDD
  - Test the individual parts and assemble them
  - Test code becomes familiar with the implementation, so change is harder

  Outside In TDD
  - Test the code with a focus on the system as a whole
  - Tests driven by what customer wants
  - Discover internal design via refactoring

  Rover implementation based on Jason Gorman's tests, with some refactoring
 */
public class RoverTest {

    private static int X = 0;
    private static int Y = 1;

    @Test
    public void initialisedWithLocation() {
        Rover rover = new Rover("N", 1, 2);
        Position response = rover.send("");
        assertThat(response.getXPos(), is(1));
        assertThat(response.getYPos(), is(2));
    }

    @Test
    public void initialisedWithDirection() {
        Rover rover = new Rover("N", 0, 0);
        Position response = rover.send("");
        assertThat(response.getDirection(), is("N"));
    }

    @ParameterizedTest
    @CsvSource({"N,E", "E,S", "S,W", "W,N"})
    public void turnsRightClockwiseOnSend(String initialDirection, String expectedDirection) {
        Rover rover = new Rover(initialDirection, 0, 0);
        Position response = rover.send("R");
        assertThat(response.getDirection(), is(expectedDirection));
    }

    @ParameterizedTest
    @CsvSource({"N,W", "W,S", "S,E", "E,N"})
    public void turnsLeftCounterclockwiseOnSend(String initialDirection, String expectedDirection) {
        Rover rover = new Rover(initialDirection, 0 ,0);
        Position response = rover.send("L");
        assertThat(response.getDirection(), is(expectedDirection));
    }

    @ParameterizedTest
    @CsvSource({"N,N", "W,W", "S,S", "E,E"})
    public void movesForwardFacesSameDirection(String initialDirection, String expectedDirection) {
        Rover rover = new Rover(initialDirection, 0, 0);
        Position response = rover.send("F");
        assertThat(response.getDirection(), is(expectedDirection));
    }

    @ParameterizedTest
    @CsvSource({"N,0,1", "E,1,0", "S,0,-1", "W,-1,0"})
    public void movesForwardOneInDirectionIsFacing(String direction, int finalX, int finalY) {
        Rover rover = new Rover(direction, 0, 0);
        Position response = rover.send("F");
        assertThat(response.getXPos(), is(finalX));
        assertThat(response.getYPos(), is(finalY));
    }

    @ParameterizedTest
    @CsvSource({"N,0,-1", "E,-1,0", "S,0,1", "W,1,0"})
    public void movesBackOneInOppositeDirection(String direction, int finalX, int finalY) {
        Rover rover = new Rover(direction, 0, 0);
        Position response = rover.send("B");
        assertThat(response.getXPos(), is(finalX));
        assertThat(response.getYPos(), is(finalY));
    }

    @Test
    public void executesSequenceOfCommands() {
        Rover rover = new Rover("N",0,0);
        Position response = rover.send("FFRFFLBRF");
        assertThat(response.getXPos(), is(3));
        assertThat(response.getYPos(), is(1));
        assertThat(response.getDirection(), is("E"));
    }

}
