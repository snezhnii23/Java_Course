import junit.framework.TestCase;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class MultiThreadClientTest extends TestCase {

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        long keepAliveTime = 100000;


        try (FileWriter writer = new FileWriter("output.txt")) {

            ThreadPool threadPool = new ThreadPool(8);
            Counter counter = new Counter();

            double[] a = {1, 3, 3, 4 ,5};
            double[] b = {2, 4, 5, 2, 7};
            double[] c = {1, 2, 1, 5, 1};


            List<Future<String>> futures = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                final int j = i;
                futures.add(
                        CompletableFuture.supplyAsync(() -> counter.count(a[j], b[j], c[j]), threadPool));
            }
            String result = "";

            String wantedResult = "x = -1,000000\nD<0 no real roots\nx1 = -0,232408, x2 = -1,434259\nD<0 no real roots\nx1 = -0,161484, x2 = -1,238516\n";

            double value = 0;
            for (Future<String> future : futures) {
                writer.append(getResult(keepAliveTime, future));
                result += getResult(keepAliveTime, future);
            }
            threadPool.shutdown();
            assertEquals(result, wantedResult);
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