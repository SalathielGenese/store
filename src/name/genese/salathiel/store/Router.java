package name.genese.salathiel.store;

import name.genese.salathiel.store.controller.CategoryController;
import name.genese.salathiel.store.repository.CategoryRepository;

import java.sql.Connection;
import java.util.Map;

/**
 * Router
 *
 * @author Salathiel @t salathiel@genese.name
 * @since Mar 04, 2022 @t 06:06:42
 */
public class Router {
    private static final String EXIT = "/exit";
    private static final String CATEGORIES = "/categories";
    private static final String CATEGORIES_CREATE = "/categories/create";
    private static final String CATEGORIES_UPDATE = "/categories/update";
    private static final String CATEGORIES_DELETE = "/categories/delete";

    private final CategoryController categoryController;

    public Router(final Connection connection) {
        final CategoryRepository categoryRepository = new CategoryRepository(connection);
        categoryController = new CategoryController(categoryRepository);
    }

    public boolean accepts(final String path, final Map<String, String> request) {
        switch (path) {
            case EXIT:
                return false;
            case CATEGORIES:
                final String terms = request.get("terms");
                final String name = request.get("name");
                final String id = request.get("id");

                if (null == terms) {
                    //
                }
                break;
            default:
                throw new UnsupportedOperationException(String.format("PATH '%s'", path));
        }

        return true;
    }
}
