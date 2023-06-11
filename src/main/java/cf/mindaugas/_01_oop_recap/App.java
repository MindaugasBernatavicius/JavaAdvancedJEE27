package cf.mindaugas._01_oop_recap;


class Solution {
    static class Person {
        static int numberOfInstances = 0;

        public Person() {
            numberOfInstances++;
        }

        @Override
        public String toString() {
            return "This is the person from the inner class";
        }
    }
    class Point2D {
        static String name = "MyPointClass";
        float x;
        float y;

        public Point2D() {
            x = 0;
            y = 0;
        }

        public Point2D(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public float getX() {
            return x;
        }

        public void setX(float x) {
            this.x = x;
        }

        public float getY() {
            return y;
        }

        public void setY(float y) {
            this.y = y;
        }

        public void setXY(float x, float y){
            this.x = x;
            this.y = y;
        }

        public float[] getXY(){
            // float[] floatArray = {x, y};
            // return floatArray;

            // return new float[]{this.x, this.y};

            return new float[]{x, y};
        }

        @Override
        public String toString() {
            return "{x=" + x + ", y=" + y + '}';
        }
    }
}

public class App {
    public static void main(String[] args) {
        var person = new Solution.Person();

        Solution solution = new Solution();

        var point = solution.new Point2D(5, 10);
        System.out.println(point);

        int initialAge = 80;
        int finalAge = initialAge + 1;
    }
}