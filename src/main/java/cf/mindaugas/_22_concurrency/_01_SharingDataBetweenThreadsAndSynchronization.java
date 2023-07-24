package cf.mindaugas._22_concurrency;

import lombok.AllArgsConstructor;

public class _01_SharingDataBetweenThreadsAndSynchronization {
    public static void main(String[] args) throws InterruptedException {
        var bench = new Bench(2);

        // 0. No threading (only the main Thread)
        // for (int i = 0; i < 5; i++) {
        //     bench.takeASeat();
        // }

        // // 1. Single Separate Thread (main + another thread)
        // var t0 = new Thread(new SeatTakerThread(bench));
        // t0.start();
        // t0.join();

        // 2. Multiple threads interacting with shared object (shared memory)
        var t0 = new Thread(new SeatTakerThread(bench));
        var t1 = new Thread(new SeatTakerThread(bench));
        var t2 = new Thread(new SeatTakerThread(bench));
        t0.start();
        t1.start();
        t2.start();
        t0.join();
        t1.join();
        t2.join();
    }
}

class SeatTakerThread implements Runnable {
    private Bench bench;
    public SeatTakerThread(Bench bench) {
        this.bench = bench;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            bench.takeASeat();
        }
    }
}

@AllArgsConstructor
class Bench {
    private int availableSeats;

    // public void takeASeat() {
    //     if (availableSeats > 0) {
    //         System.out.println("Taking a seat.");
    //         availableSeats--;
    //         System.out.println("Free seats left " + availableSeats);
    //     } else {
    //         System.out.println("There are no available seats. :^(");
    //     }
    // }

    // synced method
    // public synchronized void takeASeat() {
    //    if (availableSeats > 0) {
    //        System.out.println("Taking a seat.");
    //        availableSeats--;
    //        System.out.println("Free seats left " + availableSeats);
    //    } else {
    //        System.out.println("There are no available seats. :^(");
    //    }
    // }

    // synced block
    public void takeASeat() {
        synchronized (this){
            if (availableSeats > 0) {
                System.out.println("Taking a seat.");
                availableSeats--;
                System.out.println("Free seats left " + availableSeats);
            } else {
                System.out.println("There are no available seats. :^(");
            }
        }
    }
}