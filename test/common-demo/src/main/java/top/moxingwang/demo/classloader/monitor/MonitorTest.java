package top.moxingwang.demo.classloader.monitor;

public class MonitorTest {
    public static synchronized void teata(){
        System.out.println(1);
    }

    public  synchronized void teatb(){
        System.out.println(1);
    }



    public  void teatc(){
        synchronized (this){
            System.out.println(1);

        }
    }
}
