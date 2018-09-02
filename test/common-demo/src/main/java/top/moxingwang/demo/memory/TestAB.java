package top.moxingwang.demo.memory;

/**
 * Created by MoXingwang on 2017-07-06.
 */
public class TestAB {
    public static void main(String[] args) {
        B b = new B();
        A a = b;

        System.out.println(b.S);
        System.out.println(a.S);

        a.b();
    }
}
