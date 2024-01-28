package anbu;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class java8 {
    public static void main(String args[]){
        Supplier<Integer> message = () -> 2;
        System.out.println(message.get());
    }
}
