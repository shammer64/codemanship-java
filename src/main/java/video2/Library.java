package video2;

import java.util.ArrayList;
import java.util.Collection;

public class Library {

    private Collection<Movie> catalog = new ArrayList<>();

    public void donateMovie(Movie movie) {
        catalog.add(movie);
        movie.addCopy();
    }

    public boolean contains(Movie movie) {
        return catalog.contains(movie);
    }
}
