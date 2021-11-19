package video6;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/*
    Outside In TDD
    - Fetching from IMDB is an external concern or dependency; use dependency injection to decouple
    and enable swapping out of the implementation
    - Identify dependencies and their interfaces
    - When finished/mature at top level, drill down into each dependency
 */
public class LibraryTest {

    @Test
    public void donateMovieAddedToCatalogWithIMDBInfo() {
        EmailServer emailServer = mock(EmailServer.class);
        String imdbId = "tt12345";
        String title = "The Abyss";
        int year = 1969;
        Library library = setupLibrary(imdbId, title, year, emailServer);
        library.donate(imdbId);
        Movie movie = library.findMovie(imdbId);
        assertEquals(title, movie.getTitle());
        assertEquals(year, movie.getYear());
    }

    @Test
    public void sendEmailToLibraryMembersWhenDonationOccurs() {
        EmailServer mockEmailServer = mock(EmailServer.class);
        String imdbId = "tt12345";
        String title = "The Abyss";
        int year = 1969;
        Library library = setupLibrary(imdbId, title, year, mockEmailServer);
        library.donate(imdbId);
        verify(mockEmailServer).send("New Movie", "All Members", new String[] {title, String.valueOf(year)});
    }

    private Library setupLibrary(String imdbId, String title, int year, EmailServer emailServer) {
        MovieInfoSource movieInfoSource = new StubMovieInfoSource(imdbId, title, year);
        Library library = new Library(movieInfoSource, emailServer);
        return library;
    }

    private class StubMovieInfoSource implements MovieInfoSource {

        private Map<String, String> movieInfoMap = new HashMap<>();

        public StubMovieInfoSource(String imdbId, String title, int year) {
            movieInfoMap.put("imdbId", imdbId);
            movieInfoMap.put("title", title);
            movieInfoMap.put("year", String.valueOf(year));
        }

        @Override
        public Map<String, String> searchById(String imdbId) {
            return movieInfoMap;
        }
    }
}
