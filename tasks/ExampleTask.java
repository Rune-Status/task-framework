package scripts.task_framework.tasks;


import scripts.task_framework.framework.Task;

/**
 * Created by Sphiinx on 4/20/2016.
 */
public class ExampleTask implements Task {


    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public void execute() {
    }

    @Override
    public String toString() {
        return null;
    }

}