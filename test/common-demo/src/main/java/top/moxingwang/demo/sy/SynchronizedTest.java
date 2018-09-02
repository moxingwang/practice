package top.moxingwang.demo.sy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by M on 17/7/12.
 */
public class SynchronizedTest {
    List<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) {
        SynchronizedTest synchronizedTest = new SynchronizedTest();
//        SynchronizedTest.ThreadA threadA = synchronizedTest.new ThreadA();
        synchronizedTest.test();
    }

    public void test() {
        Thread threadA = new Thread(new ThreadA());
        Thread threadB = new Thread(new ThreadB());

        threadA.start();
        threadB.start();

    }

    class ThreadA implements Runnable{

        @Override
        public void run() {
            ObjectA objectA = new ObjectA();
            objectA.add(list);
        }
    }
    class ThreadB implements Runnable{

        @Override
        public void run() {
            ObjectB objectB = new ObjectB();
            objectB.add(list);
        }
    }

}

