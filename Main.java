package taskframework;

import org.tribot.api.General;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import taskframework.data.Vars;
import taskframework.framework.Task;
import taskframework.framework.TaskManager;
import taskframework.tasks.ExampleTask;

/**
 * Created by Sphiinx on 4/20/2016.
 */
@ScriptManifest(authors = "Sphiinx", category = "", name = "", version = 0.1)
public class Main extends Script {

    private static TaskManager taskManager = new TaskManager();

    @Override
    public void run() {
        Vars.reset();
        addCollection();
        loop(100, 150);
    }

    private void addCollection() {
        taskManager.addTask(new ExampleTask());
    }

    private static void loop(int min, int max) {
        while (!Vars.get().stopProgram) {
            Task task = taskManager.getValidTask();
            if (task != null) {
                task.execute();
                General.sleep(min, max);
            }
        }
    }

}

