package video6;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private final MovieInfoSource movieInfoSource;
    private final EmailServer emailServer;
    private Map<String, Movie> catalog = new HashMap<String, Movie>();

    public Library(MovieInfoSource movieInfoSource, EmailServer emailServer) {
        super();
        this.movieInfoSource = movieInfoSource;
        this.emailServer = emailServer;
    }

    public void donate(String imdbId) {
        Map<String, String> movieInfoMap = movieInfoSource.searchById(imdbId);
        Movie movie = new Movie(imdbId, movieInfoMap.get("title"), Integer.parseInt(movieInfoMap.get("year")));
        catalog.put(imdbId, movie);
        emailServer.send("New Movie", "All Members", new String[] {movie.getTitle(), String.valueOf(movie.getYear())});
    }

    public Movie findMovie(String imdbId) {
        return catalog.get(imdbId);
    }
}
