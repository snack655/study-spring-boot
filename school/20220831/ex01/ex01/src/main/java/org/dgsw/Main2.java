package org.dgsw;

public class Main2 {
    public static void main(String[] args) {
        Test t1 = Test.getInstance();
        Test t2 = Test.getInstance();
        Test t3 = Test.getInstance();

        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);

        if (t1 == t3)
            System.out.println("같음");
        if (t1 != t2)
            System.out.println("다름");
    }
}
