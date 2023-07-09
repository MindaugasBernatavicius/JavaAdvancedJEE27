package cf.mindaugas._17_generics;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@ToString
class Invoice implements Comparable<Invoice> {
    int amountInEuros;

    @Override
    public int compareTo(Invoice o) {
        return amountInEuros - o.amountInEuros;
    }
}

public class _03_GenericMethods {
    private static void bubbleSort(Comparable[] comparables){
        for(int j = 0; j < comparables.length-1; j++){
            for(int i = 0; i < comparables.length-1; i++){
                if(comparables[i].compareTo(comparables[i+1]) > 0){
                    Comparable temp = comparables[i];
                    comparables[i] = comparables[i+1];
                    comparables[i+1] = temp;
                }
            }
        }
    }

    private static <T extends Comparable<T>> void bubbleSortGeneric(T[] comparables){
        for(int j = 0; j < comparables.length-1; j++){
            for(int i = 0; i < comparables.length-1; i++){
                if(comparables[i].compareTo(comparables[i+1]) > 0){
                    T temp = comparables[i];
                    comparables[i] = comparables[i+1];
                    comparables[i+1] = temp;
                }
            }
        }
    }

    private static Integer min(List<Integer> items){
        Integer min = items.get(0);
        for (int i = 1; i < items.size(); i++)
            if(items.get(i) < min)
                min = items.get(i);
        return min;
    }

    private static <T extends Comparable<T>> T minGeneric(List<T> items){
        T min = items.get(0);
        for (int i = 1; i < items.size(); i++)
            if(items.get(i).compareTo(min) < 0)
                min = items.get(i);
        return min;
    }

    public static void fillListWithNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) list.add(i);
    }

    private static void performOp(List<? extends Comparable<?>> ts){
        System.out.println(">>>");
    }

    public static void main(String[] args) {
        // Invoice[] invoices = {
        //         new Invoice(500),
        //         new Invoice(300),
        //         new Invoice(1000),
        // };
        //
        // System.out.println("Before: " + Arrays.toString(invoices));
        // // bubbleSort(invoices);
        // bubbleSortGeneric(invoices);
        // System.out.println("After: " + Arrays.toString(invoices));

        var salaries = new ArrayList<Integer>();
        salaries.add(5250);
        salaries.add(562);
        salaries.add(1250);
        // System.out.println(min(salaries));
        System.out.println(minGeneric(salaries));

        performOp(salaries);

        var lst = new ArrayList<Number>();
        fillListWithNumbers(lst);
        System.out.println(lst);
    }
}
