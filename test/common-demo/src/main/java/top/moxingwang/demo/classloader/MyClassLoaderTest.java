package top.moxingwang.demo.classloader;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author moxingwang
 */
public class MyClassLoaderTest {
    public static void main(String[] args) throws  ClassNotFoundException {
//        Class<MyObj1> myObj1Class = MyObj1.class;
//        int a = MyObj1.a;


        MyClassLoader loader1 = new MyClassLoader("C:\\Users\\xingwang.mo\\Desktop\\classes");
        Class<?> aClass = loader1.loadClass("top.moxingwang.demo.classloader.testobj.MyObj2", true);
        System.out.println(aClass.getName());
        System.out.println("加载到"+aClass.hashCode());
        Field[] declaredFields = aClass.getDeclaredFields();
//        Method[] methods = aClass.getDeclaredMethods();
        try {
//            Object o = aClass.newInstance();
//            Class<?> aClass1 = o.getClass();
//            Method[] methods1 = aClass1.getDeclaredMethods();


            System.out.println(1);

        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println(1);


    }
}
