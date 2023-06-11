package cf.mindaugas._05_polymorphism;

// P

// abstract class SchoolPerson {}
class SchoolPerson {
    public void doAnything(){
        System.out.println(">>>>");
    }
}

class Teacher extends SchoolPerson {}

class Student extends SchoolPerson {}

public class App {
    public static void doSomethingWithSchoolPeople(SchoolPerson schoolPerson){
        // ((Teacher) obj).doAnything(); // casting - not good!
        schoolPerson.doAnything();
    }

    public static void main(String[] args) {
        // if String was added to this array we would get this error:
        // .. java: incompatible types: java.lang.String cannot be converted to cf.mindaugas._05_polymorphism.SchoolPerson
        SchoolPerson[] allPeopleInTheSchool = new SchoolPerson[]{
                new Teacher(), new Teacher(), new Student(), new Student()
        };

        for (var schoolPerson: allPeopleInTheSchool) {
            // doSomethingWithSchoolPeople("schoolPerson");
            doSomethingWithSchoolPeople(schoolPerson);
        }
    }
}
