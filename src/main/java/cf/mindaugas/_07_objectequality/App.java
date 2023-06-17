package cf.mindaugas._07_objectequality;

class Student {
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    // @Override
    // public boolean equals(Object o) {
    //     if (this == o) return true;
    //     if (o == null || getClass() != o.getClass()) return false;
    //     Student student = (Student) o;
    //     return age == student.age && Objects.equals(name, student.name);
    // }

    @Override
    public boolean equals(Object o) {
        Student student = (Student) o;
        return age == student.age && name.equals(student.name);
    }
}

public class App {
    public static boolean areStudentsTheSame(Student student1, Student student2){
        return student1.age == student2.age && student1.name.equals(student2.name);
    }

    public static void main(String[] args) {
        // String[] agesOfStudents = { "18", "19", "19", "20" };
        // String ageToFind = "19";
        // for (String age: agesOfStudents) {
        //     if (age.equals(ageToFind)){
        //         System.out.println("Found it!");
        //         break;
        //     }
        // }

        Student[] students = {
                new Student(18, "John"),
                new Student(19, "Peter")
        };
        Student studentToFind = new Student(18, "John");
        boolean wasFound = false;

        for (Student student: students) {
            System.out.println(student + " " + studentToFind);
            // if(student == studentToFind){
            // if(student.equals(studentToFind)){
            //     wasFound = true;
            //     break;
            // }

            if(areStudentsTheSame(student, studentToFind)){
                wasFound = true;
                break;
            }
        }

        if (wasFound)
            System.out.println("Found");
        else
            System.out.println("No such student");
    }
}
