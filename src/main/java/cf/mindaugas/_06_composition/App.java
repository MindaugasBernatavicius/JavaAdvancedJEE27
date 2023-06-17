package cf.mindaugas._06_composition;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@AllArgsConstructor
class Engine {
    private String brand;
    private int horsePower;
}

@ToString
class Car {
    // No dependency injection - direct instantiation (not a good thing)
    // private Engine engine = new Engine("BMW", 150);
    private Engine engine;
    private int seatCount;

    // // Also not the best idea, no dependency injection
    // public Car() {
    //     this.engine = new Engine("BMW", 150);
    //     this.seatCount = 4;
    // }

    // 1st dependency injection type: constructor injection
    public Car(Engine engine, int seatCount) {
        this.engine = engine;
        this.seatCount = seatCount;
    }

    public Car() {
    }

    // 2nd dependency injection type: setter injection
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }
}




class Tweet {
    private String tweetText;
    private User author;
    private Comment[] comments;
    private LocalDateTime createdAt;
    private int countTimeLiked;
}

class User {
    private String name;
    private Tweet[] tweets;
}


class Comment {}


public class App {
    public static void main(String[] args) {
        System.out.println(new Car(new Engine("BMW", 150), 4));
        System.out.println(new Car(new Engine("Ferrari", 500), 2));

        var car = new Car();
        car.setEngine(new Engine("Lada", 10));
        car.setSeatCount(6);
        System.out.println(car);
    }
}