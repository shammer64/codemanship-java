package video6;

import java.util.Map;

public interface MovieInfoSource {
    Map<String, String> searchById(String imdbId);
}
