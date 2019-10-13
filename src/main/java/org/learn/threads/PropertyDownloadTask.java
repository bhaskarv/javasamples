package org.learn.threads;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * Created by vinay on 21/9/19.
 */
public class PropertyDownloadTask implements Callable<String> {

    private List<String> propertiesToDownload;
    private CountDownLatch latch;
    private CountDownLatch signalLatch;

    public PropertyDownloadTask(List<String> propertiesToDownload, CountDownLatch latch, CountDownLatch signalLatch) {
        this.propertiesToDownload = propertiesToDownload;
        this.latch = latch;
        this.signalLatch = signalLatch;
    }

    public PropertyDownloadTask(List<String> propertiesToDownload) {
        this.propertiesToDownload = propertiesToDownload;
    }

    @Override
    public String call() throws Exception {
        signalLatch.await();
        System.out.println(" THREAD "+Thread.currentThread().getName());
        System.out.println(" Started executing download task for "+propertiesToDownload);
        for (String property : propertiesToDownload) {
            FileWriter fileWriter = new FileWriter(property, "~/Downloads");
            Thread.sleep(25);
            fileWriter.writeFile();
        }

        //Call external API to get the property details
        // for each property data obtained create a file with data
        latch.countDown();
        return "Success";
    }
}
