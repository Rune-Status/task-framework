package taskframework.tasks;


import taskframework.framework.AbstractTask;

/**
 * Created by Sphiinx on 4/20/2016.
 */
public class ExampleTask extends AbstractTask {


    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public void execute() {
    }

    @Override
    public String toString() {
        return "";
    }

}

