package top.moxingwang.demo.multithread.threadlocal;

/**
 * @author MoXingwang on 2018/1/23.
 */
public class XService1 {
    ThreadLocal<String> threadLocal1 = new ThreadLocal<String>();

    public void testThreadLocalValue() {
        threadLocal1.set("test1");
        String str1 = threadLocal1.get();
    }
}
