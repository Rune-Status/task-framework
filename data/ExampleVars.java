package scripts.TaskFramework.data;

/**
 * Created by Sphiinx on 5/2/2016.
 */
public class ExampleVars {

    public static ExampleVars vars;

    public static ExampleVars get() {
        return vars == null ? vars = new ExampleVars() : vars;
    }

    public static void reset() {
        vars = null;
    }

    public boolean stopProgram;

}

