package scripts.task_framework.framework;

import org.tribot.api.General;

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
     * Loops through all of the tasks in the task list until it finds an valid task that it can execute.
     *
     * @param min The minimum sleep delay after executing a task.
     * @param max The maximum sleep delay after executing a task.
     * */
    public void loop(int min, int max) {
        while (!stop_program) {
            Task task = getValidTask();
            if (task != null) {
                status = task.toString();
                task.execute();
            }
            General.sleep(min, max);
        }
    }

    /**
     * Adds all of the given tasks to the task list.
     *
     * @param tasks The tasks to be added to the task list.
     * */
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
     * */
    public void removeTask(Task task) {
        if (task_list.contains(task)) {
            task_list.remove(task);
        }
    }

    /**
     * Clears all of the tasks in the task list.
     * */
    public void clearTasks() {
        task_list.clear();
    }

    /**
     * Gets the count of all the tasks in the task list.
     *
     * @return A int count of all the tasks in the task list.
     * */
    public int getTaskCount() {
        return task_list.size();
    }

    /**
     * Filters through all of the tasks in the task list returning a valid task.
     *
     * @return A validated task.
     * */
    public Task getValidTask() {
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
     * */
    public String getStatus() {
        return status;
    }

    /**
     * Stops the program if the specified value is true.
     *
     * @param stop_program Stops the program if true; does nothing otherwise.
     * */
    public static void stopProgram(boolean stop_program) {
        TaskManager.stop_program = stop_program;
    }

    /**
     * Sets the status of the program.
     *
     * @param status The string of text to set the status.
     * */
    public static void setStatus(String status) {
        TaskManager.status = status;
    }

}