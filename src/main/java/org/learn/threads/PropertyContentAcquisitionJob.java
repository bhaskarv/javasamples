package org.learn.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * Created by vinay on 21/9/19.
 */
public class PropertyContentAcquisitionJob {
    private static List<String> properties = new ArrayList<>();
    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.range(1, 1001).forEach(i -> properties.add("PROP"+i));
        for (int i = 0; i < 10; i++) {
            List<PropertyDownloadTask> dlTasks = new ArrayList<>(10);
            int counter = i * 100;
            for (int j = 0; j < 10; j ++) {
                dlTasks.add(new PropertyDownloadTask(getNextSetOfProperties(counter + (j * 10))));
            }

            List<Future<String>> downloadTasks = executorService.invokeAll(dlTasks);
            downloadTasks.forEach(futureTask -> {
                try {
                    futureTask.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            });
            dlTasks.clear();
            System.out.println(" DONE WITH ONE BATCH ");
        }

        executorService.shutdown();
        executorService.awaitTermination(1000, TimeUnit.SECONDS);

        System.out.println(" DONE ACQ JOB");
    }
    private static List<String> getNextSetOfProperties(int i) {
        return properties.subList(i, i+10);
    }
}
