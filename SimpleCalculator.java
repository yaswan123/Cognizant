import java.util.Scanner;
public class SimpleCalculator 
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        System.out.println("Choose an operation: +, -, *, /");
        char operation = scanner.next().charAt(0);

        double result;

        if (operation == '+') 
        {
            result = num1 + num2;
            System.out.println("Result: " + result);
        } 
        else if (operation == '-') 
        {
            result = num1 - num2;
            System.out.println("Result: " + result);
        } 
        else if (operation == '*') 
        {
            result = num1 * num2;
            System.out.println("Result: " + result);
        } 
        else if (operation == '/') 
        {
            if (num2 != 0) 
            {
                result = num1 / num2;
                System.out.println("Result: " + result);
            } 
            else 
            {
                System.out.println("Error: Division by zero!");
            }
        } 
        else 
        {
            System.out.println("Invalid operation!");
        }
        scanner.close();
    }
}
