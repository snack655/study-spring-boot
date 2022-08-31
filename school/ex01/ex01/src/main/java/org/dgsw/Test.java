package org.dgsw;

public class Test {

    private static Test test;

    public static Test getInstance() {
        if (test == null)
            test = new Test();
        return test;
    }
}
