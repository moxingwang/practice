package top.moxingwang.demo.multithread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by m on 2017/3/28.
 */
public class AlternatePrint {
    public static void main(String[] args) {

        Callable<Integer> callable = new Callable<Integer>() {
            public Integer call() throws Exception {
                try {
                    Thread.sleep(51000);// 可能做一些事情
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return new Random().nextInt(100);
            }
        };

        FutureTask<Integer> future = new FutureTask<Integer>(callable);
        new Thread(future).start();
        try {
//            Thread.sleep(5000);// 可能做一些事情
            int a = future.get();
            System.out.println(a);
            System.out.println("434343");
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Thread();
    }
}
