package name.genese.salathiel.store.view.category;

import name.genese.salathiel.store.model.Category;
import name.genese.salathiel.store.view.View;

import java.util.Optional;

/**
 * CategoryCreationView
 *
 * @author Salathiel @t salathiel@genese.name
 * @since Mar 04, 2022 @t 07:38:07
 */
public class CategoryCreationView implements View<Optional<Category>> {
    @Override
    public void render(final Optional<Category> optionalCategory) {
        System.out.println("CREATION RESULT");

        if (optionalCategory.isPresent()) {
            System.out.println("    - " + optionalCategory.get());
        } else {
            System.out.println("    <none>");
        }
    }
}
