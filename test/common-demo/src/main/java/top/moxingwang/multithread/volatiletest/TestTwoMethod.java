package top.moxingwang.multithread.volatiletest;

/**
 * Created by M on 17/7/23.
 */
public class TestTwoMethod {
    static int i = 0, j = 0;

    static void one() {
        /*i++;
        j++;
        if (i != j) {
            throw new RuntimeException("error i=" + i + " j=" + j);
        }*/

        for(;;){
            i++;
        }
    }

    static void two() {
        int i1 = i;
        System.out.print("before i  = " + i1);

        int i2 = i;
        System.out.println(" after i  = " + i2);

        if (i1 != i2) {
            throw new RuntimeException("error i1=" + i1 + " i2=" + i2);
        }

    }


    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            one();
            /*for (; ; ) {
                one();
            }
            */
        });

        Thread thread2 = new Thread(() -> {
            for (; ; ) {
                two();
            }
        });

        thread1.start();
        thread2.start();


    }
}
