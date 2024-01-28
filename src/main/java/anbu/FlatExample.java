package anbu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatExample {
    public static void main(String[] args) {
        List<List<String>> list = Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("b"));
        System.out.println(list);

        System.out.println(list
                .stream()
                .flatMap(x -> x.stream()).toList());

    }
}
