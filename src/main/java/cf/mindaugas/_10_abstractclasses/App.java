package cf.mindaugas._10_abstractclasses;

// abstract class
// ... a class only for inheritence (and thus for polymorphism)
// ... can't be instantiated (no objects created from it)
// ... in middle between concrete classes (java bean/pojo) and interfaces

// more advanced explanation
// ... we use abstract class when we want to delegate the
// ... method logic to each specific class.
// ... we retain the benefits of inheritance, but delegate the
// ... decision of how the method should act to specific class.


// class Shape {
//     int width;
//
//     public Shape(int width) {
//         this.width = width;
//     }
//
//     public double getArea(){
//         return width * width;
//     }
// }

abstract class Shape {
    int width;

    public Shape(int width) {
        this.width = width;
    }

    public abstract double getArea();
}

class Square extends Shape {
    public Square(int width) {
        super(width);
    }
    @Override
    public double getArea(){
        return width * width;
    }
}

class Circle extends Shape {
    public Circle(int width) {
        super(width);
    }

    @Override
    public double getArea(){
        // pi * r * r
        var r = width / 2.0d;
        return Math.PI * r * r;
    }
}

public class App {
    public static double doubleTheArea(Shape shape){
        return shape.getArea() * 2;
    }

    public static void main(String[] args) {
        System.out.println(doubleTheArea(new Square(56)));
        System.out.println(doubleTheArea(new Circle(56)));
    }
}
