package video6;

public class Movie {
    private final String imdbId;
    private final String title;
    private final int year;

    public Movie(String imdbId, String title, int year) {
        this.imdbId = imdbId;
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }
}
