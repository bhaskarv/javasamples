package org.learn.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * Created by vinay on 21/9/19.
 */
public class PropertyContentAcquisitionJobV1 {

    public static void main(String[] args) throws Exception {
        List<String> properties = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.range(1, 1099).forEach(i -> properties.add("PROP"+i));

        PropertyContainer propertyContainer = new PropertyContainer(properties);

        int iterations = (properties.size() % 100 > 0) ? properties.size() / 100 + 1 : properties.size() / 100;

        for (int i = 0; i < iterations; i++) {
            List<PropertyDownloadTask> dlTasks = new ArrayList<>(10);

            for (int j = 0; j < 10; j ++) {
                dlTasks.add(new PropertyDownloadTask(propertyContainer.nextBatch(10)));
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
}
