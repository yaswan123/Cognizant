public class OperatorPrecedence {
    public static void main(String[] args) {
        
        int result1 = 10 + 5 * 2;
        System.out.println("10 + 5 * 2 = " + result1);
     
        int result2 = (10 + 5) * 2;
        System.out.println("(10 + 5) * 2 = " + result2);
    
        int result3 = 100 / 5 + 2 * 3;
        System.out.println("100 / 5 + 2 * 3 = " + result3);

        int result4 = 10 - 3 + 2;
        System.out.println("10 - 3 + 2 = " + result4);
       
    }
}
