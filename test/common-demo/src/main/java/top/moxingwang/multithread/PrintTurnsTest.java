package top.moxingwang.multithread;

/**
 * 基于 wait方法实现多线程轮询输出
 * Created by M on 17/7/18.
 */
public class PrintTurnsTest {
    private Object object = new Object();

    public void test() {
        Thread thread1 = new Thread(() -> {
            while (true) {
                synchronized (object) {
                    System.out.println("thread1 print 111111");

                    synchronized (object) {
                        try {
                            object.notify();
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {

                System.out.println("thread2 print 2222222");


                synchronized (object) {
                    try {
                        object.notify();
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread3 = new Thread(() -> {
            while (true) {

                System.out.println("thread2 print 3333333");


                synchronized (object) {
                    try {
                        object.wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        thread1.start();
        thread2.start();

//        thread3.start();
    }

    public static void main(String[] args) {
        new PrintTurnsTest().test();
    }
}
