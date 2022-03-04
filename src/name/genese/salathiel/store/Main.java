package name.genese.salathiel.store;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Router router = new Router();
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
