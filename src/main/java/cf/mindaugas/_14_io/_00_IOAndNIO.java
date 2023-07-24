package cf.mindaugas._14_io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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

public class _00_IOAndNIO {
    public static void _00_representingAFile() throws IOException {
        // File dataFile = new File("target\\classes\\data.csv");
        // File dataFile = new File("C:\\Users\\Mindaugas\\Desktop\\data2.csv");
        // System.out.println(dataFile.canRead());
        // C:\Users\Mindaugas\Desktop\Projects\SDA\JavaAdvancedJEE27\target\classes\data.csv
        // C:\Users\Mindaugas\Desktop\Projects\SDA\JavaAdvancedJEE27

        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        File dataFile = new File("test2.txt");
        System.out.println((new FileReader(dataFile)).read());
    }
    public static void _01_ReadingCSVLineByLine() throws IOException {
        File dataFile = new File("target\\classes\\data.csv");
        List<Person> people = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(dataFile));
        String fileLine;
        bufferedReader.readLine(); // skipping the first line
        while ((fileLine = bufferedReader.readLine()) != null) {
            System.out.println(fileLine);
            // System.out.println(Arrays.toString(fileLine.split(",")));
            // String[] values = fileLine.split(",");
            // people.add(new Person(
            //         Integer.parseInt(values[0]),
            //         values[1],
            //         Double.parseDouble(values[2]))
            // );
        }
    }
    public static void _02_ReadingWithIOCharByChar(){}
    public static void _03_ReadingWithIOBuffered() {}
    public static void _04_AppendVsWrite(){
        File absoluteFile = new File("test.txt");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absoluteFile, true))) {
            String fileLine = "\nappended file line";
            bufferedWriter.write(fileLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void _05_ReadWriteWithNIO(){
        Path filePath = Paths.get("target/classes/data.csv");
        try {
            var lines = Files.readAllLines(filePath);
            // skip the first line
            for (int i = 1; i < lines.size(); i++) {
                System.out.println(lines.get(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // for (String line : Files.readAllLines(filePath))
        //     System.out.println(line);
    }

    public static void _06_FilesAndPaths() throws IOException {
        Path path = Paths.get("target/classes/data.csv");
        Files.delete(path);
        Files.createFile(path);
        Files.write(path, "test data\n".getBytes(), StandardOpenOption.APPEND);
        Files.copy(path, Paths.get("target/classes/data2.csv"));
    }

    public static void main(String[] args) throws IOException {
        // _00_representingAFile();
        // _04_AppendVsWrite();
        _05_ReadWriteWithNIO();
    }
}
