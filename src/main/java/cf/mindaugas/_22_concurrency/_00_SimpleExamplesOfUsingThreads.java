package cf.mindaugas._22_concurrency;

import static java.lang.Thread.currentThread;

public class _00_SimpleExamplesOfUsingThreads {
    public static void _00_ProvingThatThreadsAreExecutedInParallelSeparately() throws InterruptedException {
        var t1 = new StopwatchThread();
        var t2 = new StopwatchThread();
        var t3 = new StopwatchThread();
        var ft = new FastThread();
        t1.start();
        t2.start();
        t3.start();
        ft.start();

        t1.join();
        t2.join();
        t3.join();
        ft.join();
    }

    public static void _01_SimpleExampleRunnable() throws InterruptedException {
        Thread t0 = new Thread(new StopwatchRunnable());
        Thread t1 = new Thread(new StopwatchRunnable());
        t0.start();
        t1.start();

        t0.join();
        t1.join();
    }

    public static void _02_RunnablesAsLambdas() throws InterruptedException {
        // Runnable r0 = () -> {
        //     for (int i = 0; i < 100; i++)
        //         System.out.println("Stop watch : " + currentThread().getName() + ": " + i);
        // };
        // var t0 = new Thread(r0);
        // var t1 = new Thread(r0);
        // t0.start();
        // t1.start();
        // t0.join();
        // t1.join();

        var t0 = new Thread(() -> {
            for (int i = 0; i < 100; i++)
                System.out.println("Stop watch : " + currentThread().getName() + ": " + i);
        });
    }

    public static void main(String[] args) throws InterruptedException {
        // _00_ProvingThatThreadsAreExecutedInParallelSeparately();
        // _01_SimpleExampleRunnable();
        _02_RunnablesAsLambdas();
    }
}


class FastThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println("FastThread: " + i);
            // try {
            //     sleep(10);
            // } catch (InterruptedException e) {
            //     System.out.println();
            // }
        }
    }
}

class StopwatchThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Stop watch : " + currentThread().getName() + ": " + i);
            // try {
            //     sleep(current().nextInt(10, 100));
            // } catch (InterruptedException e) {
            //     System.out.println();
            // }
        }
    }
}

class StopwatchRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++)
            System.out.println("Stop watch : " + currentThread().getName() + ": " + i);
    }
}