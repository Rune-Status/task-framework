package scripts.task_framework;

import scripts.task_framework.framework.TaskManager;
import scripts.task_framework.tasks.ExampleTask;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import scripts.task_framework.data.ExampleVars;


/**
 * Created by Sphiinx on 4/20/2016.
 */
@ScriptManifest(authors = "Sphiinx", category = "", name = "", version = 0.1)
public class ExampleMain extends Script {

    private TaskManager task_manager = new TaskManager();

    @Override
    public void run() {
        ExampleVars.reset();
        addTasks();
        task_manager.loop(100, 150);
    }

    private void addTasks() {
        task_manager.addTask(new ExampleTask());
    }

}