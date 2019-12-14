package top.moxingwang.demo.classloader.testobj;

import java.util.ArrayList;
import java.util.List;

/**
 * @author moxingwang
 */
public class MyObj2 {
    public static int  a ;
    public static final List list = new ArrayList(100);

    public static void main(String[] args) {
        System.out.println(1);
        MyObj2 myObj2 = new MyObj2();
        myObj2.testAdd();
    }

    static  {
        a=1;
        System.out.println("执行静态方法" + a);
    }

    public void getString(String a ){
        int i = 10;
        i++;
        i--;

        Integer integer = new Integer(i);

        System.out.println("执行方法getString");
    }

    public void testAdd(){
        int i = 10;
        System.out.println(i++);
    }

    public void testAdd2(){
        int i = 10;
        i++;
        System.out.println(i);
    }

}
