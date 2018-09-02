package top.moxingwang.memory;

/**
 * Created by MoXingwang on 2017-07-06.
 */
public class JavaExecuteSequence {
    static int a = 100;

    static {
        int B = 200;
        System.out.println("静态方法块");
    }

    {
        System.out.println("普通方法块");
    }

    public JavaExecuteSequence() {
        System.out.println("构造方法");
    }

    public static void main(String[] args) {
        new JavaExecuteSequence();
    }
}
