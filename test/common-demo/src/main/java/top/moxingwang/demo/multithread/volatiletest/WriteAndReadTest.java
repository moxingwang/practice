package top.moxingwang.demo.multithread.volatiletest;

/**
 * Created by M on 17/7/20.
 */
public class WriteAndReadTest {
    int x = 0;
     boolean v = false;

    public void writer() {
        x = 42;
        v = true;
    }

    public void reader() {
        if (v == true) {
            System.out.println(x);
        }
    }

    public void test(){
        Thread thread1 = new Thread(()->{
            writer();
        });

        Thread thread2 = new Thread(()->{
            reader();
        });

        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) {
        WriteAndReadTest writeAndReadTest = new WriteAndReadTest();
        writeAndReadTest.test();
    }

}
