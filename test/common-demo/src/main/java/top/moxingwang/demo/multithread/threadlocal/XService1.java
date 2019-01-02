package top.moxingwang.demo.multithread.threadlocal;

import org.junit.Test;

/**
 * @author MoXingwang on 2018/1/23.
 */
public class XService1 {
    ThreadLocal<String> threadLocal1 = new ThreadLocal<String>();

    static {
        System.out.println("XService1");
    }


    @Test
    public void testThreadLocalValue() {
        threadLocal1.set("test1");
        String str1 = threadLocal1.get();

        Thread thread2 = new Thread(() -> {
            threadLocal1.set("test2");
            String str2 = threadLocal1.get();
        });

        thread2.start();
    }



}
