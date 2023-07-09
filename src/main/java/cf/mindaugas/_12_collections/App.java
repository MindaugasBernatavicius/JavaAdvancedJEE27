package cf.mindaugas._12_collections;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.*;

// - DynamicArray (data structure) in Java is called ArrayList
// - new ArrayList<Person> - means that my list can only contain Person obj. (and derived types/child types: Teacher)
// - from now on, unless required use this data structure instead of array
// - List<String> this is an interface that is implemented by a few concrete classes: ArrayList, LinkedList, Vector
// - LinkedList - scattered in memory, not contiguous like ArrayList:
//      ... operations like adding members to the beginning or middle, deleting members from the middle faster with L.L.
//      ... operations like looping, accessing members in the middle or end, adding members to the end faster with A.L.
// - ArrayList should be the default if you don't know othervise

@AllArgsConstructor
@ToString
@EqualsAndHashCode
class Person {
    private String name;
}
class Employee {}
class Table {}
class Exercise implements Comparable<Exercise> {
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

    public String getName() {
        return name;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    @Override
    public int compareTo(Exercise o) {
        // return this.name.compareTo(o.name);
        return this.getDurationSeconds() - o.getDurationSeconds();
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
        // List<String> stringsList = new ArrayList<>();
        // stringsList.add("String1");
        // stringsList.add("String2");
        // stringsList.add("String3");
        //
        // // remove element
        // System.out.println(stringsList);
        // stringsList.remove(0);
        // System.out.println(stringsList);

        // remove elements by value (object equality)
        List<Person> people = new ArrayList<>();
        people.add(new Person("Jax"));
        people.add(new Person("Jammie"));
        System.out.println(people);
        // people.remove(new Person("Jonas")); // will not fail if object does not exist
        people.remove(new Person("Jax"));
        System.out.println(new Person("Jax").equals(new Person("Jax")));
        System.out.println(people);
    }
    
    public static void sortingLists(){
        List<Exercise> trainingSchedule = new ArrayList<>();
        trainingSchedule.add(new Exercise("Jogging", 1500));
        trainingSchedule.add(new Exercise("Weight Training", 4500));
        trainingSchedule.add(new Exercise("Stretches", 1200));
        trainingSchedule.add(new Exercise("Ab Crunches", 1200));

        System.out.println("Before sorting: " + trainingSchedule);

        // 0. Provide custom algorithm (not recommended in production)

        // 1. Collections.sort()
        // ERROR:: no instance(s) of type variable(s) T exist so that Exercise conforms to Comparable<? super T>
        // ... this means we don't have Comparable interface implemented.
        // ... 2 ways to solve it: Implement Comparable on Exercise or provide a custom Comparator
        // Collections.sort(trainingSchedule, (o1, o2) -> o1.durationSeconds - o2.durationSeconds);
        // Collections.sort(trainingSchedule, new Comparator<Exercise>() {
        //     @Override
        //     public int compare(Exercise o1, Exercise o2) {
        //         return o1.durationSeconds - o2.durationSeconds;
        //     }
        // });
        // class ExerciseComparator implements Comparator<Exercise> {
        //     @Override
        //     public int compare(Exercise o1, Exercise o2) {
        //         return o1.durationSeconds - o2.durationSeconds;
        //     }
        // }
        // Collections.sort(trainingSchedule, new ExerciseComparator());
        // Collections.sort(trainingSchedule, (o1, o2) -> {
        //     if(o1.durationSeconds > o2.durationSeconds) return 1;
        //     else if (o1.durationSeconds == o2.durationSeconds) return o1.getName().compareTo(o2.name);
        //     else return -1;
        // });

        // Collections.sort(trainingSchedule);

        // 2. list.sort() - the best practice
        // trainingSchedule.sort(Exercise::compareTo); // method reference - use for default way of comparing
        // trainingSchedule.sort((o1, o2) -> o1.durationSeconds - o2.durationSeconds);
        // trainingSchedule.sort(Comparator.comparingInt(o -> o.getDurationSeconds()));
        // trainingSchedule.sort(Comparator.comparingInt(o -> o.getDurationSeconds()).reversed());
        // trainingSchedule.sort(Comparator.comparingInt(o -> ((Exercise)o).getDurationSeconds()).reversed());
        // trainingSchedule.sort(Comparator.comparingInt(Exercise::getDurationSeconds)); // best practice
        trainingSchedule.sort(Comparator.comparing(Exercise::getName));
        // trainingSchedule.sort(Comparator.comparingInt(Exercise::getDurationSeconds).reversed());
        // trainingSchedule.sort(Comparator
        //         .comparingInt(Exercise::getDurationSeconds)
        //         .thenComparing(Exercise::getName));
        // trainingSchedule.sort(Comparator
        //         .comparingInt(Exercise::getDurationSeconds)
        //         .thenComparing(Exercise::getName)
        //         .reversed());

        System.out.println("After sorting: " + trainingSchedule);
    }

    public static void multidimensionality(){
        List<Person> class11D = new ArrayList<>() {{ add(new Person("A")); add(new Person("B")); }};
        List<Person> class12A = new ArrayList<>() {{ add(new Person("C")); add(new Person("D")); }};
        List<List<Person>> school = new ArrayList<>() {{ add(class11D); add(class12A); }};
        // ... this initialization syntax is not recommended, used here only for brevity

        for (List<Person> classRoom : school)
            for(Person student: classRoom)
                System.out.println(student);
    }

    public static void iterators(){
        List<String> stringsList = new ArrayList<>();
        stringsList.add("String1");
        stringsList.add("String2");
        stringsList.add("String3");
        stringsList.add("String4");
        stringsList.add("String5");

        for (String s : stringsList) System.out.println(s);

        // Iterator<String> i = stringsList.iterator();
        // while(i.hasNext())
        //     System.out.println(i.next());
    }

    public static void sets() {
        // Set<String> strings = new HashSet<>();
        // strings.add("ABC");
        // strings.add("DFE");
        // strings.add("ABC");
        // System.out.println(strings);
        // System.out.println(strings.size());
        //
        // for(String s : strings)
        //     System.out.println(s);

        // // ... simple thus far - where are they useful?
        // // ... 1. removing duplicates from other collections
        // List<Person> people = new ArrayList<>();
        // people.add(new Person("Jammie"));
        // people.add(new Person("Jax"));
        // people.add(new Person("Jammie"));
        // System.out.println(people);
        // Set<Person> uniqueMembers = new HashSet<>(people);
        // System.out.println(uniqueMembers);

        // ... 2. mathematical set operations (check if two groups of people contain same members - group membership)
        Set<Person> goodStudents = new HashSet<>();
        goodStudents.add(new Person("Jammie"));
        goodStudents.add(new Person("Jax"));
        goodStudents.add(new Person("Dick"));

        Set<Person> studentsWithCriminalRecord = new HashSet<>();
        studentsWithCriminalRecord.add(new Person("Ammie"));
        studentsWithCriminalRecord.add(new Person("Dick"));
        studentsWithCriminalRecord.add(new Person("Ax"));

        // ... intersection of two sets
        Set<Person> intersectionSet = new HashSet<>(goodStudents);
        intersectionSet.retainAll(studentsWithCriminalRecord);
        System.out.println(intersectionSet);

        // ... additional mathematical operations: https://www.baeldung.com/java-set-operations
    }

    public static void queues() {
        // Person cannot be cast to class java.lang.Comparable
        Queue<Exercise> exerciseQueue = new PriorityQueue<> ();
        // Queue<Exercise> exerciseQueue = new PriorityQueue<>((o1, o2) -> /* custom comparator order */);

        var ex1 = new Exercise("Jogging", 1500);
        exerciseQueue.add(ex1);
        // ex1.name = "--------";
        exerciseQueue.add(new Exercise("Weight Training", 4500));
        exerciseQueue.add(new Exercise("Ab Crunches", 1200));

        // System.out.println(exerciseQueue);
        // System.out.println(exerciseQueue.remove());
        // System.out.println(exerciseQueue);
        // System.out.println(exerciseQueue.remove());
        // System.out.println(exerciseQueue);

        // // when printing, you will see weird order - as if the queue is just partially ordered
        // for (var exercise : exerciseQueue)
        //     System.out.println(exercise);
        //
        // while(!exerciseQueue.isEmpty())
        //     System.out.println(exerciseQueue.poll());
        // System.out.println(exerciseQueue);
    }

    public static void main(String[] args) {
        // simpleListUsage();
        // removingElementsFromList();
        // sortingLists();
        // multidimensionality();
        // iterators();
        // sets();
        queues();
    }
}
