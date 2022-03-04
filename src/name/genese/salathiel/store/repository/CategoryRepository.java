package name.genese.salathiel.store.repository;

import name.genese.salathiel.store.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * CategoryRepository
 *
 * @author Salathiel @t salathiel@genese.name
 * @since Mar 04, 2022 @t 06:29:47
 */
public class CategoryRepository {
    private final Connection connection;

    public CategoryRepository(final Connection connection) {
        this.connection = connection;
    }

    public Optional<Category> create(final Category category) throws SQLException {
        final PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO category (name) VALUES (?)",
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, category.getName());

        if (1 == preparedStatement.executeUpdate()) {
            final var generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                final int id = generatedKeys.getInt(1);
                return Optional.of(new Category(id, category.getName()));
            }

        }
        return Optional.empty();
    }

    public Optional<Category> search(final int id) throws SQLException {
        final PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM category WHERE id=?");
        preparedStatement.setInt(1, id);
        final ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return Optional.of(new Category(resultSet.getInt("id"), resultSet.getString("name")));
        }

        return Optional.empty();
    }

    public List<Category> search(final String terms) throws SQLException {
        final PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM category WHERE name LIKE ?");
        preparedStatement.setString(1, '%' + terms + '%');
        final ResultSet resultSet = preparedStatement.executeQuery();
        final List<Category> categories = new ArrayList<>();

        while (resultSet.next()) {
            categories.add(new Category(resultSet.getInt("id"), resultSet.getString("name")));
        }

        return categories;
    }

    public List<Category> search(final Category category) throws SQLException {
        if (0 < category.getId()) {
            final Optional<Category> optionalCategory = search(category.getId());

            //noinspection OptionalIsPresent
            if (optionalCategory.isPresent()) {
                return List.of(optionalCategory.get());
            }

            return List.of();
        }

        return search(category.getName());
    }

    public Optional<Category> update(final Category category) throws SQLException {
        final PreparedStatement preparedStatement = connection.prepareStatement("UPDATE category SET name=? WHERE id=?");
        preparedStatement.setString(1, category.getName());
        preparedStatement.setInt(2, category.getId());

        if (1 == preparedStatement.executeUpdate()) {
            return search(category.getId());
        }

        return Optional.empty();
    }

    public boolean delete(final int id) throws SQLException {
        final PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM category WHERE id=?");
        preparedStatement.setInt(1, id);

        return 1 == preparedStatement.executeUpdate();
    }
}
