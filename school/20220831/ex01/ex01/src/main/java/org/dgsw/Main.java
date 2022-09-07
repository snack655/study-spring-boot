package org.dgsw;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext acac =
                new AnnotationConfigApplicationContext(AppCtx.class);

        AA a1 = acac.getBean(AA.class);
        AA a2 = acac.getBean(AA.class);
        AA a3 = new AA();

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);

        acac.close();

        System.out.println("Hello world!");
    }
}
