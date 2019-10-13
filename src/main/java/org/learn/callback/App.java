package org.learn.callback;

/**
 * Created by vinay on 23/7/19.
 */
public class App {
    public static void main(String[] args) {
        Task task = new SimpleTask();
        task.executeWith(new EmailingCallback());
        task.executeWith(new DBPersistenceCallback());
    }
}
