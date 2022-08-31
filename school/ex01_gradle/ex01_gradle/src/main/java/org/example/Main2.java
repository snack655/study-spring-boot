package org.example;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        GenericXmlApplicationContext gxac = new GenericXmlApplicationContext("appctx.xml");

        A a1 = gxac.getBean(A.class);
        System.out.println(a1);

        gxac.close();
    }
}
