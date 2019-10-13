package org.learn.callback;

/**
 * Created by vinay on 23/7/19.
 */
public class DBPersistenceCallback implements Callback {
    @Override
    public void call() {
        System.out.println(" SAVING TASK EXECUTION DETAILS TO DB ");
    }
}
