package video6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private final MovieInfo movieInfo;
    private Map<String, Movie> catalog = new HashMap<String, Movie>();

    public Library(MovieInfo movieInfo) {
        super();
        this.movieInfo = movieInfo;
    }

    public void donate(String imdbId) {
        Map<String, String> movieInfoMap = movieInfo.searchById(imdbId);
        Movie movie = new Movie(imdbId, movieInfoMap.get("title"), Integer.parseInt(movieInfoMap.get("year")));
        catalog.put(imdbId, movie);
    }

    public Movie findMovie(String imdbId) {
        return catalog.get(imdbId);
    }
}
