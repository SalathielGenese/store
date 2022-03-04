package name.genese.salathiel.store.view.category;

import name.genese.salathiel.store.model.Category;
import name.genese.salathiel.store.view.View;

import java.util.List;

/**
 * CategoriesSearchView
 *
 * @author Salathiel @t salathiel@genese.name
 * @since Mar 04, 2022 @t 07:50:34
 */
public class CategoriesSearchView implements View<List<Category>> {
    @Override
    public void render(final List<Category> categories) {
        System.out.println("SEARCH RESULTS");

        if (categories.isEmpty()) {
            System.out.println("    <none>");
        } else {
            for (final Category category : categories) {
                System.out.println("    - " + category);
            }
        }
    }
}
