package cf.mindaugas._21_streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class App {
    public static void _00_CreatingStreams(){
        // 0. Creating from collections
        List<String> names = List.of("Jimmy", "Jill", "Joe", "Anna");
        // names.stream().forEach(System.out::println);

        Stream<String> s = names.stream();
        s.forEach(System.out::println);

        // s.forEach(System.out::println); // java.lang.IllegalStateException: stream has already been operated upon or closed
        names.stream().forEach(System.out::println);

        // 1. Creating a stream directly, ussually just for learning/demonstration purposes
        Stream.of("Jimmy", "Jill", "Joe", "Anna");
    }
    public static void _01_TerminalAndIntermediateOperations(){
        // var res = List.of("AB", "BB", "BD", "BC").stream().filter(s -> s.startsWith("B"));
        // System.out.println(res); // java.util.stream.ReferencePipeline$2@4dd8dc3

        var res = List.of("AB", "BB", "BD", "BC")
                .stream().filter(s -> s.startsWith("B"))
                .count();
                // .collect(Collectors.toList());

        System.out.println(res); // java.util.stream.ReferencePipeline$2@4dd8dc3
    }
    public static void _02_Filter(){
        // var res = List.of("AB", "BB", "BD", "BC")
        //         .stream()
        //         .filter(s -> s.startsWith("B") && s.endsWith("D"))
        //         .toList();
        // System.out.println(res);

        // var res = List.of("AB", "BB", "BD", "BC")
        //         .stream()
        //         .filter(s -> s.startsWith("B"))
        //         .filter(s -> s.endsWith("D")) // not recommended although not big of a deal
        //         .toList();
        // System.out.println(res);

        Optional<String> res = List.of("AB", "BB", "BD", "BC").stream()
                .filter(s -> s.startsWith("B")).findAny();

        // 0.
        // res.ifPresentOrElse(System.out::println, () -> System.out.println("No value found"));

        // 1.
        // res.ifPresent(System.out::println);
        // res.orElse("No one found");

        // 2.
        if(res.isEmpty())
            System.out.println("No one found");
        else
            System.out.println(res.get());
    }
    public static void _03_MapAndComboWithFilter(){
        List<String> numbers = Arrays.asList("1", "2", "B", "3", "4922", "5", "6", "A");
        System.out.println("original list: " + numbers);

        // List<Integer> numberAsInts = numbers.stream()
        //         .map(s -> {
        //             Integer result = null;
        //             try {
        //                 result = Integer.valueOf(s);
        //             } catch (NumberFormatException e){
        //                 // System.out.println(e);
        //             }
        //             return result;
        //         })
        //         .filter(Objects::nonNull)
        //         .toList();
        // System.out.println(numberAsInts);

        // ... to avoid dealing with exceptions, we can prevent them from happening by filtering first
        numbers.stream()
            .filter(s -> s.matches("\\d+"))
            .map(Integer::valueOf)
            .map(integer -> integer * integer)
            .forEach(System.out::print);
    }
    public static void _04_Reduce(){
        // var vals = new int[]{ 2, 4, 6, 8, 10, 12, 14, 16 };
        // var sum = Arrays.stream(vals).sum();
        // System.out.println(sum);

        List<Integer> numbers = Arrays.asList(-2, 0, 4, 6, 8);
        var res = numbers.stream().reduce(0, (partialResult, nextValInList) ->  partialResult + nextValInList);
        System.out.println(res);

        // Finding sum of all elements
        // - initial value for the accumulator --> 0
        // - partialResult --> represents the result of all the previous operations
        // - nextValInList --> just the next element from the stream
        // - whatever gets returned from reduction will be passed to the accumulator untill all items in stream are processed
        // (0 (-2, 0, 4, 6, 8) -> (0 +-2 (0, 4, 6, 8) -> (-2 + 0 (, 6, 8) ...

        System.out.println(numbers.stream().reduce(0, Integer::sum));

        List<String> names = Arrays.asList("Andrew", "Bu", "ThisIsLonger", "Michael");
        System.out.println(names.stream().reduce((s1, s2) -> s1 + " " + s2).get());

        // determine the longest string (max reduction)
        System.out.println(names.stream().reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2).get());
    }

    public static void _05_MapFilterReduce(){
        // get the averate lenght of a persons name for all names that are > 4 letters long
        var averageLengthOfLongerNames = List.of("John Johnaton", "Max Maximilian", "Alikosa Frisko", "Zoro Zoroani", "Mango Kiwi")
                .stream()
                .map(s -> s.split(" ")[0])
                .filter(s -> s.length() > 4)
                .mapToInt(s -> s.length())
                .average();
        System.out.println(averageLengthOfLongerNames.getAsDouble());

        // var il = List.of("John Johnaton", "Max Maximilian", "Alikosa Frisko", "Zoro Zoroani", "Mango Kiwi");
        // var counter = new AtomicInteger();
        // var averageLengthOfLongerNames = il
        //         .stream()
        //         .map(s -> s.split(" ")[0])
        //         // .filter(s -> s.length() > 4)
        //         .mapToDouble(String::length)
        //         .reduce(0.0, (acc, next) -> {
        //             if(il.size()-1 == counter.get()) {
        //                 return (acc + next) / il.size();
        //             } else {
        //                 counter.getAndIncrement();
        //                 return acc + next;
        //             }
        //         });
        // System.out.println(averageLengthOfLongerNames);
    }

    public static void main(String[] args) {
        // _00_CreatingStreams();
        // _01_TerminalAndIntermediateOperations();
        // _02_Filter();
        // _03_MapAndComboWithFilter();
        // _04_Reduce();
        _05_MapFilterReduce();
    }
}
