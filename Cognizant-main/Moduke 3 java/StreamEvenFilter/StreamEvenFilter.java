import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamEvenFilter {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 6, 9, 12, 15, 18, 21);

        List<Integer> evenNumbers = numbers.stream()
                                           .filter(n -> n % 2 == 0)
                                           .collect(Collectors.toList());

        System.out.println("Even numbers: " + evenNumbers);
    }
}
