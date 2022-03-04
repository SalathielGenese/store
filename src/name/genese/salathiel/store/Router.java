package name.genese.salathiel.store;

import java.util.Map;

/**
 * Router
 *
 * @author Salathiel @t salathiel@genese.name
 * @since Mar 04, 2022 @t 06:06:42
 */
public class Router {
    private static final String EXIT = "/exit";

    public boolean accepts(final String path, final Map<String, String> request) {
        switch (path) {
            case EXIT:
                return false;
            default:
                throw new UnsupportedOperationException(String.format("PATH '%s'", path));
        }
    }
}
