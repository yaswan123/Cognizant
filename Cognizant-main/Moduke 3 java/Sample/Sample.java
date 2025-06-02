public class Sample {
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Sample s = new Sample();
        System.out.println(s.add(5, 3));
    }
}
