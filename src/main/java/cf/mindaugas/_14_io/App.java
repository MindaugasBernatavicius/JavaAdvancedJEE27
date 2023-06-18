package cf.mindaugas._14_io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Person {
    int id;
    String name;
    double salary;

    public Person(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class App {
    public static void main(String[] args) throws IOException {
        File dataFile = new File("target\\classes\\data.csv");
        // File dataFile = new File("C:\\Users\\Mindaugas\\Desktop\\data2.csv");
        // System.out.println(dataFile.canRead());
        // C:\Users\Mindaugas\Desktop\Projects\SDA\JavaAdvancedJEE27\target\classes\data.csv
        // C:\Users\Mindaugas\Desktop\Projects\SDA\JavaAdvancedJEE27
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        List<Person> people = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(dataFile));
        String fileLine;
        bufferedReader.readLine(); // skipping the first line
        while ((fileLine = bufferedReader.readLine()) != null) {
            // System.out.println(fileLine);
            // System.out.println(Arrays.toString(fileLine.split(",")));
            String[] values = fileLine.split(",");
            people.add(new Person(
                Integer.parseInt(values[0]),
                values[1],
                Double.parseDouble(values[2]))
            );
        }

        System.out.println(people);

        // TODO: check libraries that would make handling csv files simpler
        // <dependency>
        //     <groupId>org.apache.commons</groupId>
        //     <artifactId>commons-csv</artifactId>
        //     <version>1.10.0</version>
        // </dependency>
    }
}
