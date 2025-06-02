import java.util.List;
import java.util.stream.Collectors;

record Person(String name, int age) {}

public class RecordDemo {
    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("Alice", 30),
            new Person("Bob", 17),
            new Person("Charlie", 22),
            new Person("Daisy", 16)
        );

        for (Person person : people) {
            System.out.println(person);
        }

        List<Person> adults = people.stream()
                                    .filter(p -> p.age() >= 18)
                                    .collect(Collectors.toList());

        System.out.println("Adults:");
        for (Person person : adults) {
            System.out.println(person);
        }
    }
}
