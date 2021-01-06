import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultiThreadClient {

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        long keepAliveTime = 100000;

        try (FileWriter writer = new FileWriter("output.txt")) {

            ThreadPool threadPool = new ThreadPool(8);
            Counter counter = new Counter();

            double[] a = new double[10000];
            double[] b = new double[10000];
            double[] c = new double[10000];

            for (int i = 0; i < 10000; i++) {
                a[i] = (Math.random() * (10000 + 1)) - 5000;
                b[i] = (Math.random() * (10000 + 1)) - 5000;
                c[i] = (Math.random() * (10000 + 1)) - 5000;
            }

            List<Future<String>> futures = new ArrayList<>();
            for (int i = 0; i < 10000; i++) {
                final int j = i;
                futures.add(
                        CompletableFuture.supplyAsync(() -> counter.count(a[j], b[j], c[j]), threadPool));
            }

            double value = 0;
            for (Future<String> future : futures) {
                writer.append(getResult(keepAliveTime, future));
            }
            threadPool.shutdown();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static String getResult(long timer, Future<String> future) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        long time = System.currentTimeMillis();
        while ((time - start) < timer && !future.isDone())
        {
            time = System.currentTimeMillis();
        }
        if (future.isDone())
        {
            return future.get();
        }
        else
            return "Time's up\n";
    }

}

