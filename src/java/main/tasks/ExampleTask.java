package main.tasks;


import main.framework.Task;

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