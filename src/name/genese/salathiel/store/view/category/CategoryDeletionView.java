package name.genese.salathiel.store.view.category;

import name.genese.salathiel.store.view.View;

/**
 * CategoryDeletionView
 *
 * @author Salathiel @t salathiel@genese.name
 * @since Mar 04, 2022 @t 07:56:09
 */
public class CategoryDeletionView implements View<Boolean> {
    @Override
    public void render(final Boolean deleted) {
        System.out.println("DELETION RESULT");
        System.out.println("    " + (Boolean.TRUE.equals(deleted) ? "<success>" : "<none>"));
    }
}
