package top.moxingwang.demo;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {

        ReentrantLock reentrantLock = new ReentrantLock();

        try {
            reentrantLock.lock();
            //do something


            Thread t1 = new Thread(() -> {
                try {
                    Thread.sleep(100);
                    reentrantLock.lock();
                    //do something
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            });
            t1.setName("线程2");
            t1.start();


/*
            Thread t2 = new Thread(() -> {
                try {
                    reentrantLock.lock();
                    //do something
                } finally {
                    reentrantLock.unlock();
                }
            });
            t2.setName("线程3");
            t2.start();
*/


            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }


        System.out.println("测试完成");
    }
}
