package top.moxingwang.memory;

/**
 * Created by MoXingwang on 2017-07-06.
 */
public class B extends A {
    static String S = "B";

    void a(){
        System.out.println("B a()");
    }

    void b(){

        a();
        System.out.println("B b()");
    }
}
