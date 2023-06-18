package cf.mindaugas._12_collections;

import java.util.*;


// - DynamicArray (data structure) in Java is called ArrayList
// - new ArrayList<Person> - means that my list can only contain Person obj. (and derived types/child types: Teacher)
// - from now on, unless required use this data structure instead of array
// - List<String> this is an interface that is implemented by a few concrete classes: ArrayList, LinkedList, Vector
// - LinkedList - scattered in memory, not contiguous like ArrayList:
//      ... operations like adding members to the beginning or middle, deleting members from the middle faster with L.L.
//      ... operations like looping, accessing members in the middle or end, adding members to the end faster with A.L.
// - ArrayList should be the default if you don't know othervise

class Table {}

class Exercise {
    String name;
    int durationSeconds;

    public Exercise(String name, int durationSeconds) {
        this.name = name;
        this.durationSeconds = durationSeconds;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "name='" + name + '\'' +
                ", durationSeconds=" + durationSeconds +
                '}';
    }
}

public class App {

    public static void simpleListUsage(){
        String[] stringsArray = new String[2];
        // stringsArray[0] = 5;

        List<String> stringsList = new ArrayList<>();
        // stringsList.add(new Table());

        stringsList.add("String1");
        stringsList.add("String2");
        stringsList.add("String3");
        stringsList.add("String4");
        stringsList.add("String5");

        System.out.println(stringsList);

        stringsList.add(0, "String0");

        System.out.println(stringsList);
        System.out.println(stringsList.size());

        for (String s : stringsList) {
            System.out.println(s);
        }

        // for (int i = 0; i < stringsList.size(); i++) {
        //     System.out.println(stringsList.get(i));
        // }

        List<String> anotherList = new ArrayList<>();
        anotherList.add("AnotherString0");
        anotherList.add("AnotherString1");

        stringsList.addAll(anotherList);

        System.out.println(stringsList);

        //... other "subtypes" of List
        List<String> stringsLL = new LinkedList<>();
        stringsLL.add(">>>");
    }

    public static void removingElementsFromList(){
        List<String> stringsList = new ArrayList<>();
        stringsList.add("String1");
        stringsList.add("String2");
        stringsList.add("String3");

        // remove element
        System.out.println(stringsList);
        stringsList.remove(0);
        System.out.println(stringsList);

        // TODO :: remove elements by value (object equality)
        // List<Person>
        // people.remove(new Person("Jax", "Jonas"))
    }
    
    public static void sortingLists(){
        List<Exercise> trainingSchedule = new ArrayList<>();
        trainingSchedule.add(new Exercise("Jogging", 1500));
        trainingSchedule.add(new Exercise("Weight Training", 4500));
        trainingSchedule.add(new Exercise("Stretches", 1200));

        System.out.println("Before sorting: " + trainingSchedule);

        // trainingSchedule.sort((o1, o2) -> o1.durationSeconds - o2.durationSeconds);
        trainingSchedule.sort(Comparator.comparingInt(o -> o.durationSeconds)); // TODO :: reversed()
        // TODO :: Collections.sort(trainingSchedule);

        System.out.println("After sorting: " + trainingSchedule);
    }

    public static void main(String[] args) {
        // simpleListUsage();
        // removingElementsFromList();
        sortingLists();
    }
}
