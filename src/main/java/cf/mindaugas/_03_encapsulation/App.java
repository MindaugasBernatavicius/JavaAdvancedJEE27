package cf.mindaugas._03_encapsulation;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.lang.reflect.Array;
import java.util.Arrays;


// Encapsulation
// - logical grouping of data and functionality
// - access modifiers
// - getter and setter

@ToString
class Person {
    // public int age = 19;
    // int age = 19;
    // protected int age = 19;
    @ToString.Exclude private int age; // java: age has private access in cf.mindaugas._03_encapsulation.Person
    private String name = "";

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public float getAgeF() {
        return (float)age;
    }

    public void setAge(int age) {
        if (age > 125 || age < 0){
            System.out.println("Invalid age");
            return;
        }
        this.age = age; // age = age + 1 == age += 1 == age++
    }

    public String getName() {
        return name;
    }
}

// @Getter
// @Setter
// @ToString
@Data
class Game {
    private String name;
    private Person[] players;

    public Game(String name, Person[] players) {
        this.name = name;
        this.players = players;
    }
}

public class App {
    public static void main(String[] args) {
        // var person = new Person();
        // person.setAge(-1);
        // // System.out.println(person.age);
        // System.out.println(person.getAge());
        // System.out.println(person.getName());

        var players = new Person[] { new Person(55, "John"), new Person(56, "Peter") };
        var chess = new Game("Chess", players);
        chess.setName("Chess v2.0");
        System.out.println(chess.getName());
        System.out.println(Arrays.toString(chess.getPlayers()));
        System.out.println(chess);
    }
}
