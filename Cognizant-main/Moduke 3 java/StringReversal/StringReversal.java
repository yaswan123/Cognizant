import java.util.Scanner;

public class StringReversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        StringBuilder reversed = new StringBuilder(input);
        reversed.reverse();

        System.out.println("Reversed string: " + reversed.toString());

        scanner.close();
    }
}
