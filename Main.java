package task_framework;

import org.tribot.api.General;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import task_framework.framework.Task;
import task_framework.framework.TaskManager;
import task_framework.tasks.ExampleTask;


/**
 * Created by Sphiinx on 4/20/2016.
 */
@ScriptManifest(authors = "Sphiinx", category = "", name = "", version = 0.1)
public class Main extends Script {

    private static TaskManager taskManager;
    private String status;

    public Main() {
        taskManager = new TaskManager();
    }

    public TaskManager getTaskManager() {
        return taskManager;
    }

    @Override
    public void run() {
        addCollection();
        loop(100, 150);
    }

    private void loop(int min, int max) {
        Task task = taskManager.getValidTask();
        if (task != null) {
            task.execute();
            status = task.toString();
            General.sleep(min, max);
        }
    }

    private void addCollection() {
        getTaskManager().addTask(new ExampleTask());
    }

}

