package org.learn.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * Created by vinay on 21/9/19.
 */
public class PropertyContentAcquisitionJobV2 {

    public static void main(String[] args) throws Exception {
        List<String> properties = new ArrayList<>();
        System.out.println(" AVAILABLE PROCESSORS "+Runtime.getRuntime().availableProcessors());
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.range(1, 1099).forEach(i -> properties.add("PROP"+i));

        PropertyContainer propertyContainer = new PropertyContainer(properties);

        int iterations = (properties.size() % 10 > 0) ? properties.size() / 10 + 1 : properties.size() / 10;
        long startTime = System.currentTimeMillis();
        CountDownLatch latch = new CountDownLatch(iterations);
        CountDownLatch signalLatch  = new CountDownLatch(1);
        for (int i = 0; i < iterations; i++) {
            executorService.submit(new PropertyDownloadTask(propertyContainer.nextBatch(10), latch, signalLatch) );
        }
        System.out.println(" DONE WITH SETUP ");
        signalLatch.countDown();
        latch.await();
        System.out.println(" TOTAL TIME : "+(System.currentTimeMillis() - startTime));
        executorService.shutdown();
        executorService.awaitTermination(1000, TimeUnit.SECONDS);

        System.out.println(" DONE ACQ JOB");
    }
}
