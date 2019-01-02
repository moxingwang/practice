package top.moxingwang.demo.multithread.threadlocal;

import org.junit.Test;

/**
 * @author MoXingwang on 2018/1/23.
 */
public class XService2 {
    ThreadLocal<String> threadLocal2 = new ThreadLocal<String>();


    static {
        System.out.println("XService2");
    }

    @Test
    public void testThreadLocalValue() {
        threadLocal2.set("test1");
        String str1 = threadLocal2.get();

        Thread thread2 = new Thread(() -> {
            threadLocal2.set("test2");
            String str2 = threadLocal2.get();
        });

        thread2.start();
    }

}
