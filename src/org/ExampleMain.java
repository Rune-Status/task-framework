package org;


import org.data.ExampleVars;
import org.framework.TaskManager;
import org.tasks.ExampleTask;

/**
 * Created by Sphiinx on 4/20/2016.
 */
public class ExampleMain {

    private static TaskManager task_manager = new TaskManager();

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        ExampleVars.reset();
        addTasks();
        task_manager.loop(100);
    }

    private static void addTasks() {
        task_manager.addTask(new ExampleTask());
    }

}