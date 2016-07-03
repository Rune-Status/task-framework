package scripts.TaskFramework;

import scripts.TaskFramework.framework.TaskManager;
import scripts.TaskFramework.tasks.ExampleTask;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import scripts.TaskFramework.data.ExampleVars;


/**
 * Created by Sphiinx on 4/20/2016.
 */
@ScriptManifest(authors = "Sphiinx", category = "", name = "", version = 0.1)
public class ExampleMain extends Script {

    private TaskManager task_manager = new TaskManager();

    @Override
    public void run() {
        ExampleVars.reset();
        addCollection();
        task_manager.loop(100, 150);
    }

    private void addCollection() {
        task_manager.addTask(new ExampleTask());
    }

}