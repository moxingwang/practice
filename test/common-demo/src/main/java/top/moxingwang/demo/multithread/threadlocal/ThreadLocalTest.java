package top.moxingwang.demo.multithread.threadlocal;

/**
 * @author MoXingwang on 2018/1/23.
 * https://juejin.im/post/5a64a581f265da3e3b7aa02d?utm_source=gold_browser_extension
 * http://blog.csdn.net/ni357103403/article/details/51970748
 *
 * [ThreadLocal源码分析（JDK8）](http://blog.csdn.net/u010887744/article/details/54730556)
 */
public class ThreadLocalTest implements Runnable {


    private static ThreadLocal<String> sdfMap = new ThreadLocal<String>();

    @Override
    public void run() {
        sdfMap.set("tet1111" + Thread.currentThread().getName());
        String a = sdfMap.get();
        System.out.println(a);
    }

    public static void main(String[] args) {
        new Thread(new ThreadLocalTest()).start();
        new Thread(new ThreadLocalTest()).start();
        new Thread(new ThreadLocalTest()).start();
        System.out.println("");
    }

}
