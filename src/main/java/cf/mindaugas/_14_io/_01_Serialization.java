package cf.mindaugas._14_io;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.io.*;

public class _01_Serialization {
    public static void _00_JavaInbuiltSerialization(){

        var product = new Product(55, "Shoes");
        var fileDest = new File("object_serialized.ser");

        // try-with-resources aka autocloseable
        try(var objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileDest))){
            objectOutputStream.writeObject(product);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void _01_JavaInbuiltDeserialization() {
        Product product;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object_serialized.ser"))) {
            product = (Product)objectInputStream.readObject();
            System.out.println(product);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        // _00_JavaInbuiltSerialization();
        _01_JavaInbuiltDeserialization();
    }
}

@AllArgsConstructor
@ToString
class Product implements Serializable {
    private static final long serialversionUID = 1;

    private int id;
    private transient String name;
}