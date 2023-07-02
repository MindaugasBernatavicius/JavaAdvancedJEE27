package cf.mindaugas._16_reflection;

import java.util.Arrays;

class Animal {}
class Person extends Animal {
    private int age;
    public String name = "A";
}
class Teacher extends Person {}

public class _01_BasicReflection {
    private static void _01_obtainInstanceOfClass() throws ClassNotFoundException {
        // usually the discussion about reflection starts from understanding the "Class" class
        // every object in java can be asked to present its own class (except primitives).

        // System.out.println("".getClass());
        Integer i = 1;
        Class<?> classOfThisObject = i.getClass();
        System.out.println(classOfThisObject);

        System.out.println(String.class);
    }

    public static void _02_getSuperclassAndInterfaces(Class<?> clazz) {
        while (clazz.getSuperclass() != null) {
            System.out.println(clazz.getSuperclass());
            clazz = clazz.getSuperclass();
        }
    }

    public static void _03_getFields() throws NoSuchFieldException {
        System.out.println(Arrays.toString(Person.class.getDeclaredFields()));
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        // _01_obtainInstanceOfClass();
        // _02_getSuperclassAndInterfaces(Teacher.class);
        _03_getFields();
    }
}
