import java.util.Scanner;
public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks out of 100: ");
        int m = sc.nextInt();
        char g;
        if (m >= 90 && m <= 100) 
        g = 'A';
        else if (m >= 80) 
        g = 'B';
        else if (m >= 70) 
        g = 'C';
        else if (m >= 60) 
        g = 'D';
        else 
        g = 'F';
        System.out.println("Grade: " + g);
        sc.close();
    }
}

