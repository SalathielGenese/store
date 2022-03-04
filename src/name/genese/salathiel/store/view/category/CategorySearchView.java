package name.genese.salathiel.store.view.category;

import name.genese.salathiel.store.model.Category;
import name.genese.salathiel.store.view.View;

import java.util.Optional;

/**
 * CategorySearchView
 *
 * @author Salathiel @t salathiel@genese.name
 * @since Mar 04, 2022 @t 07:49:15
 */
public class CategorySearchView implements View<Optional<Category>> {
    @Override
    public void render(final Optional<Category> optionalCategory) {
        System.out.println("SEARCH RESULT");

        if (optionalCategory.isPresent()) {
            System.out.println("    - " + optionalCategory.get());
        } else {
            System.out.println("    <none>");
        }
    }
}
