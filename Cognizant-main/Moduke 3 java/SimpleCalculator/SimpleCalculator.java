import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

       
        System.out.println("Choose an operation: +  -  *  /");
        System.out.print("Enter your choice: ");
        char operation = scanner.next().charAt(0);

        double result;
        boolean valid = true;

      
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0)
                    result = num1 / num2;
                else 
                {
                    System.out.println("Error: Division by zero!");
                    valid = false;
                    result = 0;
                }
                break;
            default:
                System.out.println("Invalid operation!");
                valid = false;
                result = 0;
        }

       
        if (valid) {
            System.out.println("Result: " + result);
        }

        scanner.close();
    }
}
