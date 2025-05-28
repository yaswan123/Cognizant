public class TypeCast {
    public static void main(String[] args) {
        byte b = 10;
        short s = b;
        int i = s;
        long l = i;
        float f = l;
        double d = f;
        char c = (char) i;
        System.out.println("byte to short: " + s);
        System.out.println("short to int: " + i);
        System.out.println("int to long: " + l);
        System.out.println("long to float: " + f);
        System.out.println("float to double: " + d);
        System.out.println("int to char: " + c);
        double d2 = 65.25;
        int i2 = (int) d2;
        char c2 = (char) i2;
        System.out.println("double to int: " + i2);
        System.out.println("int to char: " + c2);
    }
}
