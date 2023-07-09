package cf.mindaugas._17_generics;

import java.util.ArrayList;

public class _01_SimpleExample {
    public static void doSomething(Person p){
        System.out.println(p);
    }

    public static void main(String[] args) {
        var p = new Person();
        var b = new Box(p);
        var gb = new GenericBox<Person>(p);
        // System.out.println(b.getItem());

        // doSomething(b.getItem()); // you would need to cast the item into a Person
        doSomething(gb.getItem()); // when using generics you do not need to cast
    }
}

class Person {}

class GenericBox<T> {
    private T item;

    public GenericBox(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}

class Box {
    private Object item;

    public Box(Object item) {
        this.item = item;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }
}
