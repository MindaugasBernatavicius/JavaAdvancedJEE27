package cf.mindaugas._19_functionalInterfaces;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    @FunctionalInterface
    interface TriFunction<A, B, C, O>{
        O apply(A a, B b, C c);
    }

    public static void main(String[] args) {
        // Function<Integer, Integer> squerer = integer -> integer * integer;
        // var numbersSquared = Stream.of(1, 2, 3).map(squerer).toList();
        // System.out.println(numbersSquared);

        Function<Integer, Double> halver = integer -> ((double) integer) / 2;
        var numbersSquared = Stream.of(1, 2, 3).map(halver).collect(Collectors.toList());
        System.out.println(numbersSquared);

        BiFunction<Integer, Integer, Double> adder = (i1, i2) -> (double)(i1 + i2);

        TriFunction<Integer, Integer, Integer, Double> x = (i1, i2, i3) -> (double)(i1 + i2);
    }
}
