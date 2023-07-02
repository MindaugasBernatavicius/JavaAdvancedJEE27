package cf.mindaugas._13_maps;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@ToString
@Getter
class Person {
    private int age;
    private String name;
    private int phoneNumber;
}

public class App {
    public static Integer getPhoneNumberByNameFromList(List<Person> phoneBookList, String personsNameImLookingFor){
        Integer phoneNumber = null;
        // linear search
        for (int i = 0; i < phoneBookList.size(); i++) {
            if(phoneBookList.get(i).getName().equals(personsNameImLookingFor))
                phoneNumber =  phoneBookList.get(i).getPhoneNumber();
        }
        return phoneNumber;
    }

    // public static Integer getPhoneNumberByNameFromMap(Map<Person> phoneBookList, String personsNameImLookingFor){
    //     Integer phoneNumber = null;
    //     // linear search
    //     for (int i = 0; i < phoneBookList.size(); i++) {
    //         if(phoneBookList.get(i).getName().equals(personsNameImLookingFor))
    //             phoneNumber =  phoneBookList.get(i).getPhoneNumber();
    //     }
    //     return phoneNumber;
    // }

    public static void _00_simpleUsage(){
        // construction
        Map<String, Integer> phoneBook = new HashMap<>();

        // adding elements
        phoneBook.put("Max", 8961613);
        phoneBook.put("Jenny", 95996131);

        // printing
        System.out.println(phoneBook);

        // getting an element
        System.out.println(phoneBook.get("Jenny"));
    }

    public static void _01_listVsMap(){
        List<Person> phoneBookList = new ArrayList<>();
        phoneBookList.add(new Person(55, "A", 25189));
        phoneBookList.add(new Person(66, "B", 578578));
        phoneBookList.add(new Person(77, "C", 57858758));

        System.out.println(getPhoneNumberByNameFromList(phoneBookList,"C"));


        Map<String, Person> phoneBookMap = new HashMap<>();
        phoneBookMap.put("A", new Person(55, "A", 25189));
        phoneBookMap.put("B", new Person(66, "B", 578578));
        phoneBookMap.put("C", new Person(77, "C", 57858758));

        var res = phoneBookMap.get("D");
        System.out.println(res != null ? res.getPhoneNumber() : "Not found");
    }

    public static void main(String[] args) {
        // _00_simpleUsage();
        _01_listVsMap();
    }
}
