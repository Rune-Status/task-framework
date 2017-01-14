package src.framework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sphiinx on 4/20/2016.
 */
public class TaskManager {

    /**
     * The master task list for the program.
     */
    private List<Task> task_list = new ArrayList<>();

    /**
     * The master status for the program.
     */
    private static String status;

    /**
     * The master boolean for stopping the program.
     */
    private static boolean stop_program;

    /**
     * Loops through all of the src.tasks in the task list until it finds an valid task that it can execute.
     *
     * @param sleep The sleep delay in milliseconds after executing a task.
     */
    public void loop(int sleep) {
        while (!stop_program) {
            Task task = getValidTask();
            if (task != null) {
                status = task.toString();
                task.execute();
            }
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Adds all of the given src.tasks to the task list.
     *
     * @param tasks The src.tasks to be added to the task list.
     */
    public void addTask(Task... tasks) {
        for (Task task : tasks) {
            if (!task_list.contains(task)) {
                task_list.add(task);
            }
        }
    }

    /**
     * Removed the specified task from the task list.
     *
     * @param task The specified task to be removed from the task list.
     */
    public void removeTask(Task task) {
        if (task_list.contains(task)) {
            task_list.remove(task);
        }
    }

    /**
     * Clears all of the src.tasks in the task list.
     */
    public void clearTasks() {
        task_list.clear();
    }

    /**
     * Gets the count of all the src.tasks in the task list.
     *
     * @return A int count of all the src.tasks in the task list.
     */
    public int getTaskCount() {
        return task_list.size();
    }

    /**
     * Filters through all of the src.tasks in the task list returning a valid task.
     *
     * @return A validated task.
     */
    private Task getValidTask() {
        for (Task task : task_list) {
            if (task.validate()) {
                return task;
            }
        }
        return null;
    }

    /**
     * Gets the current status.
     *
     * @return The current status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Stops the program.
     */
    public static void stopProgram() {
        TaskManager.stop_program = true;
    }

    /**
     * Sets the status of the program.
     *
     * @param status The string of text to set the status.
     */
    public static void setStatus(String status) {
        TaskManager.status = status;
    }

}