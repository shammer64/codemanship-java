package video6;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    Outside In TDD
    - Fetching from IMDB is an external concern or dependency; use dependency injection to decouple
    and enable swapping out of the implementation
 */
public class LibraryTest {

    @Test
    public void donateMovieAddedToCatalogWithIMDBInfo() {
        String imdbId = "tt12345";
        String title = "The Abyss";
        int year = 1969;
        MovieInfo movieInfo = new StubMovieInfo(imdbId, title, year);
        Library library = new Library(movieInfo);
        library.donate(imdbId);
        Movie movie = library.findMovie(imdbId);
        assertEquals(title, movie.getTitle());
        assertEquals(year, movie.getYear());
    }

    private class StubMovieInfo implements MovieInfo {

        private Map<String, String> movieInfoMap = new HashMap<>();

        public StubMovieInfo(String imdbId, String title, int year) {
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
