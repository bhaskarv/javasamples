package org.learn.callback;

/**
 * Created by vinay on 23/7/19.
 */
public class SimpleTask extends Task {
    @Override
    public void execute() {
        System.out.println(" SIMPLE TASK INITIATED ");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" SIMPLE TASK COMPLETED ");
    }
}
