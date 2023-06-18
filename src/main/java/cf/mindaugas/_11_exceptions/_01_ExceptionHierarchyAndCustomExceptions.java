package cf.mindaugas._11_exceptions;

// ... creating custom ex is possible, but please consider throwing existing ones first
// ... exception hierarchy: https://cdn.rollbar.com/wp-content/uploads/2021/07/java-exceptions-hierarchy-example.png.webp
// ... types to remember: Exception(), RuntimeException(), IllegalArgumentException(), IOException()
// ... domain specific exceptions - exceptions that use the names of problems arrising in the business domain we are model
// ... if you need specific exception handling for each exception type the code is throwing sort multi-catch block by reverse inheritence order (most general type should be last)

class Employee {
    int age;
    double salary;

    public Employee(int age, double salary) {
        if(age < 0) throw new IllegalArgumentException("... age, can't be negative");
        if(salary < 0) throw new IllegalArgumentException("... salary, can't be negative");
        this.age = age;
        this.salary = salary;
    }

    public void setAge(int age) {
        if(age < 0) throw new IllegalArgumentException("...");
        this.age = age;
    }

    public void setSalary(double salary) {
        if(salary < 0) throw new IllegalArgumentException("... salary, can't be negative");
        this.salary = salary;
    }
}

class SalaryToBigException extends Exception {}
class SalaryIsNegativeException extends Exception {}

public class _01_ExceptionHierarchyAndCustomExceptions {
    public static double calculateBonus(Employee employee, int yearlyReviewScore) throws Exception {
        var maxSalary = 1500;
        var bonus = employee.age * (employee.salary * (0.01 * yearlyReviewScore));

        if(employee.salary + bonus > maxSalary)
            // throw new Exception(Salary exceeds max");
            throw new SalaryToBigException();
        if(employee.salary + bonus < 0)
            // throw new Exception("Salary, can't go below zero");
            throw new SalaryIsNegativeException();

        return bonus;
    }

    public static void main(String[] args) {
        Employee[] employees = {
                new Employee(25, 1700),
                new Employee(20, 1500),
        };

        int[] reviewScore = { 1, -2 };

        for(int i = 0; i < employees.length; i++) {
            double bonus = 0;
            try {
                bonus = calculateBonus(employees[i], reviewScore[i]);
            } catch (SalaryIsNegativeException e){
                System.out.println("Negative salary");
            } catch (SalaryToBigException e){
                System.out.println("Salary is to big");
            } catch (Exception e) {
                System.out.println("Generic exception");
            }
            System.out.println("Bonus: " + bonus);
        }
    }
}
