public class PatternMatchingSwitch {
    public static void printTypeInfo(Object obj) {
        switch (obj) {
            case Integer i -> System.out.println("It's an Integer: " + i);
            case String s -> System.out.println("It's a String: " + s);
            case Double d -> System.out.println("It's a Double: " + d);
            case null -> System.out.println("It's null.");
            default -> System.out.println("Unknown type: " + obj);
        }
    }

    public static void main(String[] args) {
        printTypeInfo(42);
        printTypeInfo("Hello");
        printTypeInfo(3.14);
        printTypeInfo(true);
        printTypeInfo(null);
    }
}
