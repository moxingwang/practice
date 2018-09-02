package top.moxingwang.multithread.volatiletest;

/**
 * http://www.cnblogs.com/emanlee/p/3587571.html
 */
public class TestFour {

     int i = 0;

    public synchronized void add() {
        System.out.println(i);
        i++;
    }

    public void testA() {
        while (true) {
            if (i > 0) {
                System.out.println("------------------i > 0");
                break;
            }
        }
    }

    public static void main(String[] args) {
        TestFour testTwo = new TestFour();
        Thread threadA = new Thread(() -> {
            testTwo.testA();
        });
        threadA.start();







        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread threadC = new Thread(() -> {
            while (testTwo.i < 100000) {
                testTwo.add();
            }
        });
        threadC.start();

        while (testTwo.i < 100000) {
            testTwo.add();
        }
    }
}
