package name.genese.salathiel.store.controller;

import name.genese.salathiel.store.model.Category;
import name.genese.salathiel.store.repository.CategoryRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * CategoryController
 *
 * @author Salathiel @t salathiel@genese.name
 * @since Mar 04, 2022 @t 07:20:47
 */
public class CategoryController {
    private final CategoryRepository categoryRepository;

    public CategoryController(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Optional<Category> create(final Category category) throws SQLException {
        // TODO: add validation here, before saving
        return categoryRepository.create(category);
    }

    public Optional<Category> search(final int id) throws SQLException {
        return categoryRepository.search(id);
    }

    public List<Category> search(final String terms) throws SQLException {
        return categoryRepository.search(terms);
    }

    public List<Category> search(final Category category) throws SQLException {
        return categoryRepository.search(category);
    }

    public Optional<Category> update(final Category category) throws SQLException {
        // TODO: add validation here, before saving
        return categoryRepository.update(category);
    }

    public boolean delete(final int id) throws SQLException {
        return categoryRepository.delete(id);
    }
}
