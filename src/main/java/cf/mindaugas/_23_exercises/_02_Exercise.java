package cf.mindaugas._23_exercises;

// Create a method that takes a string list as a parameter,
// then returns that list sorted alphabetically from Z to
// A case-insensitive.

import java.util.ArrayList;
import java.util.List;

public class _02_Exercise {
    public static List<String> sortStringInReverseOrder(List<String> strings){
        var stringsToBeSorted = new ArrayList<>(strings);
        stringsToBeSorted.sort((s1, s2) -> s1.compareToIgnoreCase(s2) * -1);
        return stringsToBeSorted;
    }

    public static void main(String[] args) {
        // List.of() - ImmutableList, can not be sorted
        var strings = new ArrayList<>(List.of("A", "X", "B", "a", "K"));

        System.out.println("Before: " + strings);
        var sortedStrings = sortStringInReverseOrder(strings);
        System.out.println("Copy After Sorting: " + sortedStrings);
        System.out.println("Original After Sorting: " + strings);
    }
}
