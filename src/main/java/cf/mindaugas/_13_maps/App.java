package cf.mindaugas._13_maps;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.*;

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

        var res = phoneBookMap.get("A");
        System.out.println(res != null ? res.getPhoneNumber() : "Not found");
    }

    public static void _02_IterationOverMapsAndItemRemoval(){
        // a word and it's synonyms
        Map<String, List<String>> synonyms = new HashMap<>();
        synonyms.put("flower", Arrays.asList("herb", "vine", "floret"));
        synonyms.put("car", Arrays.asList("vehicle", "transport"));

        // iteration
        // for(Map.Entry<String, List<String>> kv : synonyms.entrySet()){
        //     System.out.println(kv.getKey() + " -> " + kv.getValue());
        // }

        for(var kv : synonyms.entrySet())
            System.out.println(kv.getKey() + " -> " + kv.getValue());

        // removal
        System.out.println("Before removal: " + synonyms);
        System.out.println("Printing as removal happens" + synonyms.remove("flower"));
        synonyms.remove("flower");
        synonyms.remove("flower");
        synonyms.remove("flower", new ArrayList<String>()); // remove if key is mapped to a specific value and return boolean
        System.out.println("After removal: " + synonyms);
    }

    public static void main(String[] args) {
        // Situations to use a map:
        // - Name -> PhoneNumber == Map<String, Integer> or Map<String, String> if phone number format: +370-265-596191
        // - Word -> Synonyms == Map<String, List<String>> : "flower" -> ["herb", "vine", "floret"], "car" -> ["vehicle", "transport"]
        // - DepartmentName -> People working in that department == Map<String, List<Person>>
        // - CountryName -> All cities in that country == Map<String, List<String | City>>
        // - AverageGrade -> Student == Map<Float, List<Student>>

        // _00_simpleUsage();
        // _01_listVsMap();
        _02_IterationOverMapsAndItemRemoval();
    }
}
