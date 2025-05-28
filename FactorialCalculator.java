import java.util.Scanner;
public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a +ve integer: ");
        int num = scanner.nextInt();
        if (num < 0) 
        {
            System.out.println("Factorial is not defined for -ve numbers.");
        } 
        else 
        {
            long factorial = 1;
            for (int i = 1; i <= num; i++) 
            {
                factorial *= i;
            }
            System.out.println("The factorial of " + num + " is " + factorial);
        }
        scanner.close();
    }
}
