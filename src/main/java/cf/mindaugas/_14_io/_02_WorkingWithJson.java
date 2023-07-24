package cf.mindaugas._14_io;

import com.google.gson.Gson;

public class _02_WorkingWithJson {
    public static void main(String[] args) {
        var person = new Person(1, "John", 1500);
        var personJson = new Gson().toJson(person);
        System.out.println(personJson);
    }
}

// class Person { int id, String name } in json { id: 1, name: "John" }