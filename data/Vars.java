package taskframework.data;

/**
 * Created by Sphiinx on 5/2/2016.
 */
public class Vars {

    public static Vars vars;

    public static Vars get() {
        return vars == null ? vars = new Vars() : vars;
    }

    public static void reset() {
        vars = null;
    }

    public boolean stopProgram;

}

