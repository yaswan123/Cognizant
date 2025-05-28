public class OperatorPrecedence {
    public static void main(String[] args) 
    {
        int a = 10 + 5 * 2;
        int b = (10 + 5) * 2;
        int c = 20 / 5 + 3 * 2;
        int d = 20 / (5 + 3) * 2;
        int e = 3 + 4 * 2 - 6 / 3;
        System.out.println("10 + 5 * 2 = " + a);
        System.out.println("(10 + 5) * 2 = " + b);
        System.out.println("20 / 5 + 3 * 2 = " + c);
        System.out.println("20 / (5 + 3) * 2 = " + d);
        System.out.println("3 + 4 * 2 - 6 / 3 = " + e);
    }
}
