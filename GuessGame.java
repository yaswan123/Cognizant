import java.util.Scanner;
import java.util.Random;
public class GuessGame {
    public static void main(String[] args) {
        Random r = new Random();
        int n = r.nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);
        int g;
        do {
            System.out.print("Guess a number (1-100): ");
            g = sc.nextInt();
            if (g > n) 
            {
                System.out.println("Too high!");
            } 
            else if (g < n) 
            {
                System.out.println("Too low!");
            } 
            else 
            {
                System.out.println("Correct! You guessed it.");
            }
        } 
        while (g != n);
        sc.close();
    }
}
