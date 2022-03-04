package name.genese.salathiel.store;

import name.genese.salathiel.store.controller.CategoryController;
import name.genese.salathiel.store.model.Category;
import name.genese.salathiel.store.repository.CategoryRepository;
import name.genese.salathiel.store.view.category.CategoriesSearchView;
import name.genese.salathiel.store.view.category.CategoryCreationView;
import name.genese.salathiel.store.view.category.CategoryDeletionView;
import name.genese.salathiel.store.view.category.CategorySearchView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    public boolean accepts(final String path, final Map<String, String> request) throws SQLException {
        switch (path) {
            case EXIT:
                return false;

            //
            // Routes for categories
            //
            case CATEGORIES:
                if (null == request.get("id")) {
                    if (null == request.get("name")) {
                        final List<Category> categories = categoryController.search(request.get("terms"));
                        new CategoriesSearchView().render(categories);
                    } else {
                        final List<Category> categories = categoryController.search(new Category(request.get("name")));
                        new CategoriesSearchView().render(categories);
                    }
                } else {
                    new CategorySearchView().render(categoryController.search(Integer.parseInt(request.get("id"))));
                }
                break;
            case CATEGORIES_CREATE:
                new CategoryCreationView().render(categoryController.create(new Category(request.get("name"))));
                break;
            case CATEGORIES_UPDATE:
                final Optional<Category> optionalCategory = categoryController.update(new Category(
                        Integer.parseInt(request.get("id")),
                        request.get("name")));
                new CategoryCreationView().render(optionalCategory);
                break;
            case CATEGORIES_DELETE:
                final boolean deleted = categoryController.delete(Integer.parseInt(request.get("id")));
                new CategoryDeletionView().render(deleted);
                break;
            default:
                throw new UnsupportedOperationException(String.format("PATH '%s'", path));
        }

        System.out.println(); // NOTE: add empty line for a more readable output
        return true;
    }
}
