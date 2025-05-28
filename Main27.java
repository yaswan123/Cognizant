import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main27 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("yash");
        names.add("abhi");
        names.add("jishnu");
        Collections.sort(names, (a, b) -> a.compareToIgnoreCase(b));
        System.out.println("Sorted names:");
        names.forEach(System.out::println);
    }
}