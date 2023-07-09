package cf.mindaugas._18_lambda_expressions;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class _02_LambdaSyntaxWPredicate {
    public static void main(String[] args) {
        // Rules for lambda syntax:
        // - (params) -> logic.
        // - we need to write (Param p) -> { //... } , when we pass parameters and we have multiline logic inside { //... }
        // - when we have only one line, we don't need curly braces: { } - and we don't need to write keyword return
        // - if no parameters are passed in, we have to write () -> {}
        // - if we have a generic type indicator, e.g.: Predicate<String>, then we don't need to specify parameter type, e.g.: s -> {}

        // Student student1 = new Student("Jimmy", "Dog", 23);
        // Predicate<Student> studentIsAdult = s -> s.age > 18;
        // // can't use student variable name, because lambda has access to enclosing scope
        // // BiPredicate<Student, String> studentIsAdult = (student, name) -> student.age > 18 && student.firstName.equals(name);
        // // BiPredicate<Student, String> studentIsAdult = (Student student, String name) -> student.age > 18 && student.firstName.equals(name);
        // // Predicate<Student> studentIsAdult = s -> {
        // //     System.out.println(">>>"); // do not print anything inside lambda unless only for dirty debugging
        // //     return s.age > 18;
        // // };
        // // System.out.println("Is student older than 18: " + studentIsAdult.test(student1, "Jenny"));
        // System.out.println("Is student older than 18: " + studentIsAdult.test(student1));

        // Implementing a test or String to see if it starts with some value
        Predicate<String> startsWithABCTest = s -> s.startsWith("ABC");
        System.out.println(startsWithABCTest.test("ABCDEF"));
        System.out.println(startsWithABCTest.test("XYZABG"));

        // chaining predicates
        System.out.println(startsWithABCTest
                .and(s -> s.endsWith("DEF"))
                .test("ABCDEF"));

        // declaring predicates inline is usual not the best syntax
        System.out.println(((Predicate<String>) s -> s.startsWith("ABC")).and(s -> s.endsWith("DEF")).test("Jonas"));

        // where are predicates used in java? Filter method in streams
        List.of(89,262,65)
                .stream()
                .filter(i -> i > 80)
                .forEach(System.out::println);


        Supplier<Exercise> generateExercise = () -> new Exercise("a", 5);
    }
}

@AllArgsConstructor
class Student {
    public String firstName;
    public String lastName;
    public int age;
}