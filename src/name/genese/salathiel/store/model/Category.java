package name.genese.salathiel.store.model;

/**
 * Category
 *
 * @author Salathiel @t salathiel@genese.name
 * @since Mar 04, 2022 @t 06:29:03
 */
public class Category {
    private final int id;
    private String name;

    public Category(final String name) {
        this(0, name);
    }

    public Category(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Category{ id=%d, name='%s' }", id, name);
    }
}
