package top.moxingwang.multithread.volatiletest;

public class VisibilityTest extends Thread {

    private  boolean stop;

    public void run() {
        int i = 0;
/*
        while(!stop) {
//            System.out.println(stop);
            i++;
        }
*/

        while (true){
            boolean a = stop;
            if (a){
                break;
            }
            i++;
        }
        System.out.println("finish loop,i=" + i);
    }

    public void stopIt() {
        stop = true;
    }

    public boolean getStop(){
        return stop;
    }
    public static void main(String[] args) throws Exception {
        VisibilityTest v = new VisibilityTest();
        v.start();

        Thread.sleep(1000);
        v.stopIt();
        Thread.sleep(2000);
        System.out.println("finish main");
        System.out.println(v.getStop());
    }

}
