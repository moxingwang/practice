package top.moxingwang.demo.memory;

/**
 * Created by MoXingwang on 2017-07-06.
 */
public class A {
    static String S = "A";

    void a(){
        System.out.println("A a()");
    }

    void b(){
        a();
        System.out.println("A b()");
    }
}
