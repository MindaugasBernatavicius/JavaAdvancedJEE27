package cf.mindaugas._04_inheritence;

import java.util.Arrays;

class Person {
    private String name;

    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void test(){}
}
class Employee extends Person {
    private int employeeId;
    public Employee(int employeeId, String name){
        super(name);
        this.employeeId = employeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
class Teacher extends Employee {
    public Teacher(int employeeId, String name) {
        super(employeeId, name);
    }

    @Override
    public String toString() {
        return "Teacher{employeeId=" + super.getEmployeeId()
            + ", name='" + super.getName() + "'}";
    }
}
class Student extends Person {
    private int[] grades;

    // method overloading
    public Student() {}

    public Student(String name, int[] grades) {
        super(name);
        this.grades = grades;
    }

    // @Override
    // public String toString() {
    //     return "Student{name='" + super.getName() + '\'' + '}';
    // }

    @Override
    public String toString() {
        return "Student{name='" + super.getName()
                + "', grades='" + Arrays.toString(this.grades)
                + "'}";
    }

    // method overriding
    @Override // java: method does not override or implement a method from a supertype
    public void test(){
        System.out.println(">>>");
    }
}

public class App {
    public static void main(String[] args) {
        var student1 = new Student("Max",new int[]{ 10, 9, 5, 8 });
        System.out.println(student1);

        var student2 = new Student("Peter",new int[]{ 6, 9, 10, 8 });
        System.out.println(student2);

        student2.test();

        var chemistryTeacher = new Teacher(65, "Albert");
        System.out.println(chemistryTeacher);
    }
}
