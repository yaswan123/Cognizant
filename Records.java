import java.util.List;
public class Records {
    public record Person(String name, int age) {}
    public static void main(String[] args) {
        Person p1 = new Person("Yaswanth", 30);
        Person p2 = new Person("Nikhil", 20);
        Person p3 = new Person("Sneha", 25);
        List<Person> people = List.of(p1, p2, p3);

        System.out.println("All People:");
        people.forEach(System.out::println);

        System.out.println("\nPeople older than 22:");
        people.stream()
              .filter(p -> p.age() > 22)
              .forEach(System.out::println);
    }
}
