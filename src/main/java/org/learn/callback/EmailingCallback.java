package org.learn.callback;

/**
 * Created by vinay on 23/7/19.
 */
public class EmailingCallback implements Callback {
    @Override
    public void call() {
        System.out.println(" EMAILING THE TASK COMPLETION DETAILS ");
    }
}