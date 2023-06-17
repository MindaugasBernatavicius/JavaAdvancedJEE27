package cf.mindaugas._09_interfaces;

import java.util.Arrays;

interface Sortable {
    boolean compare(Sortable sortable);
}

public class ComplexExample {
    private static void swap(){
        char a = 'a';
        char b = 'b';
        System.out.println("a: " + a + " - " + "b: " + b);
        // incorrect way
        // a = b; // 'b' , 'b'
        // b = a;

        char temp = a;
        a = b;
        b = temp;
        System.out.println("a: " + a + " - " + "b: " + b);
    }

    private static void compareToExample(){
        // a > b -> -1, a == a = 0, b > a -> 1
        System.out.println("a".compareTo("a"));
        System.out.println("a".compareTo("b"));
        System.out.println("b".compareTo("a"));
        System.out.println("Jonas".compareTo("Peter"));
    }

    private static void bubbleSort(int[] numbers){
        for(int j = 0; j < numbers.length-1; j++){
            for(int i = 0; i < numbers.length-1; i++){
                if(numbers[i] > numbers[i+1]){
                    int temp = numbers[i];
                    numbers[i] = numbers[i+1];
                    numbers[i+1] = temp;
                }
            }
        }
    }

    private static void bubbleSort(Person[] people){
        for(int j = 0; j < people.length-1; j++){
            for(int i = 0; i < people.length-1; i++){
                if(people[i].age > people[i+1].age){
                    Person temp = people[i];
                    people[i] = people[i+1];
                    people[i+1] = temp;
                }
            }
        }
    }

    private static void generalBubbleSort(Sortable[] sortables){
        for(int j = 0; j < sortables.length-1; j++){
            for(int i = 0; i < sortables.length-1; i++){
                if(sortables[i].compare(sortables[i+1])){
                    Sortable temp = sortables[i];
                    sortables[i] = sortables[i+1];
                    sortables[i+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        // swap()
        compareToExample();

        // int[] arr = {1, 2, 10, 3, 5, 6, 1000, 12};
        // Person[] arr = {
        //     new Person(30, "Mikaitis"),
        //     new Person(40, "Jonaitis"),
        //     new Person(20, "Tomaitis"),
        //     new Person(30, "Maksaitis")
        // };
        // System.out.println("Before sorting: " + Arrays.toString(arr));
        // bubbleSort(arr);
        // System.out.println("After sorting: " + Arrays.toString(arr));

        // Car[] cars = { new Car("BMW"), new Car("Audi"), new Car("Mercedes")  };
        // System.out.println("Before sorting: " + Arrays.toString(cars));
        // generalBubbleSort(cars);
        // System.out.println("After sorting: " + Arrays.toString(cars));
        //
        // Person[] arr = {
        //     new Person(30, "Mikaitis"),
        //     new Person(40, "Jonaitis"),
        //     new Person(20, "Tomaitis"),
        //     new Person(30, "Maksaitis")
        // };
        // System.out.println("Before sorting: " + Arrays.toString(arr));
        // generalBubbleSort(arr);
        // System.out.println("After sorting: " + Arrays.toString(arr));
    }
}
