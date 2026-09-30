@FunctionalInterface
public interface Calculator {

    int calculate(int a, int b);

    default void print(){
        System.out.println(" this is default method");
    }

    static void mes(){
        System.out.println(" this is static method");
    }
}
