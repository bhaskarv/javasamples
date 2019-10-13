package org.learn.gof;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vinay on 18/4/19.
 */
public class CommandGof {
    interface Command {
        public void run();
    }

    public static class Logger implements Command {

        public final String message;

        public Logger(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            System.out.println(" LOGGING COMMAND "+message);
        }
    }

    public static class FileSaver implements Command {
        public final String message;

        public FileSaver (String message) {
            this.message = message;
        }

        @Override
        public void run() {
            System.out.println(" SAVING : COMMAND "+message);
        }
    }

    public static class MailSender implements Command {
        public final String message;

        public MailSender (String message) {
            this.message = message;
        }

        @Override
        public void run() {
            System.out.println(" SENDING : COMMAND "+message);
        }
    }

    public static class MyExecutor {
        public void execute(List<Command> commands) {
            commands.forEach( e -> e.run());
        }
    }

    public static void main(String[] args) {
        List<Command> commands = new ArrayList<>();
        commands.add(new Logger(" TO LOG FILE"));
        commands.add(new MailSender(" TO GREAT FUTURE"));
        commands.add(new FileSaver(" TO DOCUMENTS FOLDER"));

        new MyExecutor().execute(commands);
    }
}
