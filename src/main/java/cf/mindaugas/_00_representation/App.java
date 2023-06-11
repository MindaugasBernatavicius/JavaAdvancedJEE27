package cf.mindaugas._00_representation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

public class App {
    public static void main(String[] args) {
        // // representation no. 1 - just properties / variables not encapsulated into anything
        // var name = "Jonas";
        // var ageYears = 55;
        // var totalJobExperienceYears = 32;
        // var timeWorkedInCompanyYears = 15;

        // var raiseStatus = totalJobExperienceYears > 30 && timeWorkedInCompanyYears > 10 ? "RAISE" : "NO RAISE";
        // System.out.println(raiseStatus);


        // // representation no. 2 - we encapsulate data into groups of related pieces of inforamtion
        // Object[][] employees = {
        //         {"Jonas", 32, 15}, // jonas - totalJobExperienceYears , timeWorkedInCompanyYears
        //         {"Petras", 25, 12}, // petras - totalJobExperienceYears , timeWorkedInCompanyYears
        // };
        //
        // for (Object[] employee : employees) {
        //     System.out.println(employee[0]);
        // }

        // representation no. 3
        @AllArgsConstructor
        @ToString
        @Getter
        class Employee {
            private String name;
            private int totalJobExperienceYears;
            private int timeWorkedInCompanyYears;
        }

        Employee[] employees = {
                new Employee("Jonas", 55, 25),
                new Employee("Petras", 55, 18),
        };

        for (Employee employee : employees) {
            System.out.println(employee.getName());

            // var raiseStatus = employee.totalJobExperienceYears > 30 && employee.timeWorkedInCompanyYears > 10
            //         ? "RAISE" : "NO RAISE";
        }
    }
}
