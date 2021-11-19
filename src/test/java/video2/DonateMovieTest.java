package video2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DonateMovieTest {

    private Library library;
    private Movie movie;

    public DonateMovieTest() {
        library = new Library();
        movie = new Movie();
    }

    /*
                Three habits of TDD:
                1. Start with Assertion first: What question do I want to answer?
                - Write assertion statement, Assert
                - Create dependencies needed to answer the question, Arrange
                - Specify the action needed to put system in the appropriate state: Act
                -- Start with the WHAT and work back toward the HOW

                2. Ensure test fails for the right reason
                - Make sure your assertion fails for the right reason
                - Don't rely on an unhandled exception
                -- Test the test before you write any code to make it pass

                3. Each test should have only one reason to fail
                - Single assertion
                - Split multiple assertions to separate tests
    */
    @Test
    public void movieAddedToCatalog() {
        library.donateMovie(movie);
        assertTrue(library.contains(movie));
    }

    @Test
    public void rentalCopyAdded() {
        library.donateMovie(movie);
        assertEquals(1, movie.getCopies());
    }

}
