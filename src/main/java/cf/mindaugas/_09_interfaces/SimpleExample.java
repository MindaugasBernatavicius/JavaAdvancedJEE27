package cf.mindaugas._09_interfaces;

interface Jsonable {
    String toJson();
}

class Person implements Jsonable, Sortable {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
    @Override
    public String toJson(){
        return "{ \"name\": \"" + name + "\", \"age\": " + age + " }";
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean compare(Sortable sortable) {
        return this.age > ((Person)sortable).age ? true : false;
    }
}

class Car implements Jsonable, Sortable {
    String maker;

    public Car(String maker) {
        this.maker = maker;
    }

    @Override
    public String toJson(){
        return "{ \"maker\": \"" + maker + "\"" + " }";
    }

    @Override
    public String toString() {
        return "Car{" +
                "maker='" + maker + '\'' +
                '}';
    }

    @Override
    public boolean compare(Sortable sortable) {
        var otherMaker = ((Car)sortable).maker;
        return this.maker.compareTo(otherMaker) > 0 ? true : false;
    }
}

public class SimpleExample {
    private static void doSomethingWithJsonRepresentation(Jsonable jsonable){
        System.out.println(jsonable.toJson());
    }

    public static void main(String[] args) {
        doSomethingWithJsonRepresentation(new Person(55, "John"));
        doSomethingWithJsonRepresentation(new Car("Mercedes"));

        Jsonable[] jsonables = {new Person(55, "John"), new Car("Mercedes")};
    }
}
