import java.lang.reflect.Method;

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("Sample");

        System.out.println("Methods in class " + cls.getName() + ":");
        Method[] methods = cls.getDeclaredMethods();

        for (Method method : methods) {
            System.out.print(method.getName() + "(");
            Class<?>[] params = method.getParameterTypes();
            for (int i = 0; i < params.length; i++) {
                System.out.print(params[i].getSimpleName());
                if (i < params.length - 1) System.out.print(", ");
            }
            System.out.println(")");
        }

        Object obj = cls.getDeclaredConstructor().newInstance();

        Method methodToInvoke = cls.getDeclaredMethod("greet", String.class);
        Object result = methodToInvoke.invoke(obj, "World");

        System.out.println("Invocation result: " + result);
    }
}

// Sample class to test:
class Sample {
    public String greet(String name) {
        return "Hello, " + name;
    }

    private void secret() {
        System.out.println("This is private");
    }
}
