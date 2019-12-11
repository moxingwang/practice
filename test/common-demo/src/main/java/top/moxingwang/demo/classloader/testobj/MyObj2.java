package top.moxingwang.demo.classloader.testobj;

import java.util.ArrayList;
import java.util.List;

/**
 * @author moxingwang
 */
public class MyObj2 {
    public static int  a ;
    public static final List list = new ArrayList(100);

    static  {
        a=1;
        System.out.println("执行静态方法" + a);
    }

    public void getString(String a ){
        System.out.println("执行方法getString");
    }
}
