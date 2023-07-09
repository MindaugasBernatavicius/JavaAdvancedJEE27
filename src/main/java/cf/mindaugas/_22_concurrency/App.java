package cf.mindaugas._22_concurrency;

public class App {
    public static void _00_Threads() throws InterruptedException {
        var t1 = new StopwatchThread();
        var t2 = new StopwatchThread();
        var t3 = new StopwatchThread();
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }

    public static void _01_Runnable(){

    }

    public static void main(String[] args) throws InterruptedException {
        _00_Threads();
    }
}

class StopwatchThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            var threadName = Thread.currentThread().getName();
            System.out.println("Stop watch : " + threadName + ": " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println();
            }
        }
    }
}