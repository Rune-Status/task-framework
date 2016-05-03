package task_framework.framework;

/**
 * Created by Sphiinx on 4/20/2016.
 */
public interface Task {

    boolean validate();

    void execute();

    String toString();

}

