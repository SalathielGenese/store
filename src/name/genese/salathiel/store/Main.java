package name.genese.salathiel.store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    // DROP TABLE IF EXISTS;
    // CREATE TABLE category(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255) UNIQUE);
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        final String PASSWORD = "";
        final String USERNAME = "root";
        final String URL = "jdbc:mysql://localhost:3306/store";

        try (final Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            final Scanner scanner = new Scanner(System.in);
            final Router router = new Router(connection);
            Map<String, String> request;
            String[] pair;
            String path;
            String line;

            do {
                request = new HashMap<>();
                path = scanner.nextLine();

                while (!(line = scanner.nextLine()).isBlank()) {
                    pair = line.split("=", 2);
                    request.put(pair[0], 1 == pair.length ? null : pair[1]);
                }
            } while (router.accepts(path, request));
        }
    }
}
