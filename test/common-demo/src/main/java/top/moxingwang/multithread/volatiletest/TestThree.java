package top.moxingwang.multithread.volatiletest;

public class TestThree {

     String i = "a";

    public void add(){
        System.out.println(i);
        i = "b";
    }

    public void testA(){
        while (true){


            if(!"a".equals(i)){
                System.out.println("------------------i > 0");
                break;
            }
        }
    }

    public static void main(String[] args) {
        TestThree testTwo = new TestThree();
        Thread thread1 = new Thread(() -> {
            testTwo.testA();
        });
        thread1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i =0 ;i<10000;i++){
            testTwo.add();

        }
    }
}
