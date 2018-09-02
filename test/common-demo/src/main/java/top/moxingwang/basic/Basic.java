package top.moxingwang.basic;

//import java.util.HashMap;

import java.lang.ref.WeakReference;
import java.util.*;

/**
 * Created by MoXingwang on 2017/6/30.
 */
public class Basic {
    public static void main(String[] args) {
//        HashMap
        WeakHashMap<Object,Object> weakHashMap = new WeakHashMap<Object,Object>();
        weakHashMap.put("1","1");
        weakHashMap.put("2","2");
        weakHashMap.put("3","2");
        weakHashMap.put(new Object(),new Object());
        weakHashMap.put(new Object(),new Object());
        weakHashMap.put(new Object(),new Object());
        weakHashMap.put(new Object(),new Object());
        weakHashMap.put(new Object(),new Object());

        Set<Map.Entry<Object,Object>>  a = weakHashMap.entrySet();
        System.gc();
        System.runFinalization();
        Set<Map.Entry<Object,Object>>  c = weakHashMap.entrySet();


    }
}

