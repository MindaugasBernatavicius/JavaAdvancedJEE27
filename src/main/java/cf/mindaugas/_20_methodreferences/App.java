package cf.mindaugas._20_methodreferences;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(100, "Book"));
        products.add(new Product(50, "Sugar"));
        products.add(new Product(200, "Kakao"));

        // static method reference that must match the Comparator.compare definition
        // ... int compare(T o1, T o2); - we are mathing the comparator method
        // products.sort(ProductComparator::compare);

        // method reference to an instance method
        // ... product1.compareTo(product2)
        products.sort(Product::compareTo);

        var productBrands = new ArrayList<String>();
        productBrands.add("Castco");
        productBrands.add("Apple");

        var products2 = productBrands.stream()
                .map(Product::new)
                .collect(Collectors.toList());
        System.out.println(products2);
    }
}

class ProductComparator  {
    public static int compare(Product o1, Product o2) {
        return o1.weight - o2.weight;
    }
}

@AllArgsConstructor
@ToString
class Product implements Comparable<Product> {
    int weight;
    String label;

    public Product(String label) {
        this.label = label;
    }

    @Override
    public int compareTo(Product o) {
        return weight - o.weight;
    }
}