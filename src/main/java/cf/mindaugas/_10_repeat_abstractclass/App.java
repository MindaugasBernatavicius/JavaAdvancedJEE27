package cf.mindaugas._10_repeat_abstractclass;

abstract class Shape {
    int width;
    abstract double getArea();
}

class Square extends Shape {
    public double getArea(){
        return width * width;
    }
}

class Circle extends Shape {
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

    }
}
