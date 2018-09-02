package top.moxingwang.demo.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author MoXingwang on 2018/3/19.
 */
public class LockTest {

    static int a = 0;

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();


        for (int i = 0; i < 100; i++) {


            new Thread(()->{
                try {
                    reentrantLock.lock();
                    a++;

                }finally {
                    reentrantLock.unlock();
                }


            }).start();
        }


        System.out.println(a);

    }
}
