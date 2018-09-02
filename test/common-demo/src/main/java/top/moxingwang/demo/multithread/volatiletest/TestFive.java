package top.moxingwang.demo.multithread.volatiletest;

/**
 * http://www.cnblogs.com/emanlee/p/3587571.html
 */
public class TestFive {

    volatile   int i = 0;

    public   void add() {
        System.out.println("---- " + i);
        i++;
    }

    public int getI(){
        return i;
    }

    public void testA() {
        while (true) {
            if (getI() > 0) {
                System.out.println("------------------i > 0");
                break;
            }
        }
    }

    public static void main(String[] args) {
        TestFive testTwo = new TestFive();
        Thread threadA = new Thread(() -> {

//            for (int i = 0; i < 1000000 ; i++) {
//                testTwo.add();
//            }

//            testTwo.testA();
//            System.out.println(testTwo.getI() + "-------------");;

            testTwo.testA();


//            testTwo.testA();
//            testTwo.i++;
//
//            System.out.println(testTwo.getI() + "-------------");;


//            testTwo.add();

        });
        threadA.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 1000000 ; i++) {
            testTwo.add();
        }

    }
}
