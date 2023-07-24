package cf.mindaugas._22_concurrency;

import lombok.AllArgsConstructor;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class _02_ImprovingFileReadingPerformanceWithThreads {
    static String[] inputFiles = {
            "data/input/0.txt",
            "data/input/1.txt",
            "data/input/2.txt",
            "data/input/3.txt",
            "data/input/4.txt",
            "data/input/5.txt",
            "data/input/6.txt",
            "data/input/7.txt",
            "data/input/8.txt",
            "data/input/9.txt",
            "data/input/10.txt"
            // "data/input/test0.txt",
            // "data/input/test1.txt",
            // "data/input/test2.txt",
    };

    public static void main(String[] args) throws InterruptedException {
        // parallel approach
        var startTime = System.nanoTime();
        var adders = new ArrayList<Thread>(inputFiles.length);
        for (var filename : inputFiles) {
            var t = new Thread(new Adder(filename));
            t.start();
            adders.add(t);
        }

        for (var adder : adders) adder.join();
        var stopTime = System.nanoTime();
        System.out.println(TimeUnit.NANOSECONDS.toMillis(stopTime - startTime) + "ms");

        // // sequential approach / sequential execution
        // var startTime = System.nanoTime();
        // for (var filename : inputFiles)
        //     new Adder(filename).performAddition();
        //
        // var stopTime = System.nanoTime();
        // System.out.println(TimeUnit.NANOSECONDS.toMillis(stopTime - startTime) + "ms");
    }
}

@AllArgsConstructor
class Adder implements Runnable {
    private String inFile;

    @Override
    public void run() {
        performAddition();
    }

    public void performAddition(){
        var total = 0.0d;
        var line = "";
        var file = new File(inFile);
        try (var br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null)
                total += Double.parseDouble(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Partial result from file: " + inFile + ": " + total);
    }
}
