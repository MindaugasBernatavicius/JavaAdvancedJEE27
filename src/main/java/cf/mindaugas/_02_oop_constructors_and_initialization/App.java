package cf.mindaugas._02_oop_constructors_and_initialization;

class PersonWDefaultConstructor {
    @Override
    public String toString() {
        return "Person w/o an explicit constructor (default constructor)";
    }
}

class Person {
    int age;
    String name;

    public Person() {
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(int age, String name) {
        // this.age = age;
        this(age);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}


class PersonWithInitializationBlock {
    {
        System.out.println(">>>>");
    }

    public PersonWithInitializationBlock() {
    }
}

public class App {
    public static void main(String[] args) {
        // System.out.println(new PersonWDefaultConstructor());
        // System.out.println(new Person(55, "Jonas"));
        System.out.println(new PersonWithInitializationBlock());
    }
}
