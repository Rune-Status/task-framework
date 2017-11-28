package main;


import main.data.ExampleVars;
import main.framework.TaskManager;
import main.tasks.ExampleTask;

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
        task_manager.loop(150);
    }

    private static void addTasks() {
        task_manager.addTask(new ExampleTask());
    }

}