package top.moxingwang.demo.classloader.testobj;

/**
 * @author moxingwang
 */
public class MyObj1 {
    public static int  a ;

    static  {
        a=1;
        System.out.println("执行静态方法" + a);
    }
}
