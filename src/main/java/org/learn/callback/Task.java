package org.learn.callback;

/**
 * Created by vinay on 23/7/19.
 */
public abstract class Task {
    public void executeWith(Callback cb) {
        execute();
        if (cb != null) {
            cb.call();
        }
    }

    public abstract void execute();
}
