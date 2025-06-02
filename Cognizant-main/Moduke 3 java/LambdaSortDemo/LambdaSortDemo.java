import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaSortDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Zara");
        names.add("Bob");
        names.add("Alice");
        names.add("John");

        Collections.sort(names, (a, b) -> a.compareToIgnoreCase(b));

        for (String name : names) {
            System.out.println(name);
        }
    }
}
