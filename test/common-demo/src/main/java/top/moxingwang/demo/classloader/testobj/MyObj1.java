package top.moxingwang.demo.classloader.testobj;

/**
 * @author moxingwang
 */
public class MyObj1 {
    public static final  int  a =0;

    static  {
        System.out.println("执行静态方法" );
    }

    public static void getStatic(){
        System.out.println("myobj1 getStatic");
    }
}
