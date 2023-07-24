package cf.mindaugas._23_exercises;

import java.util.TreeMap;

import static java.lang.System.out;

public class _06_Exercise {
    public static void printFirstAndLastEntrySet(TreeMap<Integer, String> treeMap) {
        if (!treeMap.isEmpty())
            out.println("First element: " + treeMap.firstEntry() + ", last element: " + treeMap.lastEntry());
        else out.println("The TreeMap is empty.");
    }

    public static void main(String[] args) {
        var treeMap = new TreeMap<Integer, String>();
        treeMap.put(1, "Apple");
        treeMap.put(2, "Orange");
        treeMap.put(3, "Kiwi");
        treeMap.put(4, "Plum");
        treeMap.put(5, "Blackcurrant");
        treeMap.put(6, "Watermelon");
        treeMap.put(7, "Strawberry");

        printFirstAndLastEntrySet(treeMap);
    }
}
