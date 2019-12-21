package top.moxingwang.demo.classloader.testobj;

import top.moxingwang.demo.classloader.statictest.MyObjStatic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author moxingwang
 */
public class MyObj2 {
    public static int  a ;
    public static final List list = new ArrayList(100);

    public static void main(String[] args) {

        double c = 0.1;
        System.out.println(c++);

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

    public void testArgs(String aa, Object b, List c) {
        System.out.println(11111);
    }


    public void testAdd3(){
        int i = 0;
        while (i < 100) {
            i++;
            System.out.println(i);
        }
    }

    public void testStatic(){
        int a = 5;
        int c = MyObjStatic.getInteger(a);
        System.out.println(c);
    }



}
