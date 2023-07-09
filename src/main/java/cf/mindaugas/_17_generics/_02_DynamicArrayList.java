package cf.mindaugas._17_generics;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
class Order { String id; }

public class _02_DynamicArrayList {
    public static void _00_DynamicArrayWithHardcodedType(){
        DynamicArray da = new DynamicArray();
        da.add(new Order("ID-1"));
        da.add(new Order("ID-2"));
        da.add(new Order("ID-3"));
        da.add(new Order("ID-4"));
        da.add(new Order("ID-5"));

        System.out.println(da);

        da.add(new Order("ID-6"));
        da.add(new Order("ID-7"));
        da.add(new Order("ID-8"));

        System.out.println(da);

        for (int i = 10; i < 1000; i++) {
            da.add(new Order("ID-" + i));
        }

        System.out.println(da);

        System.out.println(da.getByIdx(555));

        // Problem - we can't use other types than Order
        DynamicArray da2 = new DynamicArray();
        // da2.add("SAAA");
    }
    
    public static void _01_DAWithObjects(){
        // DynamicArrayOfObjects daoo1 = new DynamicArrayOfObjects();
        // daoo1.add("S1");
        // daoo1.add("S2");
        // System.out.println(daoo1);

        // DynamicArrayOfObjects daoo2 = new DynamicArrayOfObjects();
        // daoo2.add(new Order("ID-4"));
        // daoo2.add(new Order("ID-5"));
        // System.out.println(daoo2);

        // Problems - we can mix types and when getting the item back, the type is erased
        // daoo2.getByIdx(0); // return type is now Object and not the type I put in
        DynamicArrayOfObjects daoo3 = new DynamicArrayOfObjects();
        daoo3.add(new Order("ID-4"));
        daoo3.add(">>>>>>");
        daoo3.add(1);
        System.out.println(daoo3);
    }

    public static void _02_DynamicGenericArray(){
        DynamicArrayGeneric<String> dag = new DynamicArrayGeneric<>();
        dag.add("S1");
        dag.add("S2");
        // dag.add(new Order("ID-4")); // can't mix types anymore
        System.out.println(dag);
        System.out.println(dag.getByIdx(0).getClass()); // we are getting back the type of object we put in

        // DynamicArrayGeneric<Order> dag2 = new DynamicArrayGeneric<>();
        // DynamicArrayGeneric<Integer> dag3 = new DynamicArrayGeneric<>();
        // DynamicArrayGeneric<List<Person>> dag4 = new DynamicArrayGeneric<>();

        // List<Person>
        // DynamicArrayGeneric<Person>
        // CustomHashMap<String, Person>
    }

    public static void main(String[] args) {
        // _00_DynamicArrayWithHardcodedType();
        // _01_DAWithObjects();
        _02_DynamicGenericArray();
    }
}

class DynamicArray {
    private int currentIdx;
    private Order[] orders;

    public DynamicArray() {
        orders = new Order[5];
        currentIdx = 0;
    }

    public void add(Order order){
        if(currentIdx == orders.length){
            var newArr = new Order[orders.length * 2];
            for (int i = 0; i < orders.length; i++)
                newArr[i] = orders[i];
            orders = newArr;
        }
        orders[currentIdx] = order;
        currentIdx++;
    }

    public Order getByIdx(int idx){
        return orders[idx];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < currentIdx; i++)
            res.append(orders[i]).append(" ");
        return "[" + res + "]";
    }
}

class DynamicArrayOfObjects {
    private int currentIdx;
    private Object[] objects;

    public DynamicArrayOfObjects() {
        objects = new Object[5];
        currentIdx = 0;
    }

    public void add(Object object){
        if(currentIdx == objects.length){
            var newArr = new Object[objects.length * 2];
            for (int i = 0; i < objects.length; i++)
                newArr[i] = objects[i];
            objects = newArr;
        }
        objects[currentIdx] = object;
        currentIdx++;
    }

    public Object getByIdx(int idx){
        return objects[idx];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < currentIdx; i++)
            res.append(objects[i]).append(" ");
        return "[" + res + "]";
    }
}

class DynamicArrayGeneric<T> {
    private int currentIdx;
    private T[] objects;

    public DynamicArrayGeneric() {
        objects = (T[]) new Object[5];
        currentIdx = 0;
    }

    public void add(T object){
        if(currentIdx == objects.length){
            var newArr = (T[]) new Object[objects.length * 2];
            for (int i = 0; i < objects.length; i++)
                newArr[i] = objects[i];
            objects = newArr;
        }
        objects[currentIdx] = object;
        currentIdx++;
    }

    public T getByIdx(int idx){
        return objects[idx];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < currentIdx; i++)
            res.append(objects[i]).append(" ");
        return "[" + res + "]";
    }
}

class CustomHashMap<K, V> { }
