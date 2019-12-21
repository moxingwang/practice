package top.moxingwang.demo.classloader.statictest;

public class MyStatic1 {
    public static void main(String[] args) {
        MyS2 myStatic1 = new MyS2();
        myStatic1.get1();
    }
    public static void get1(){
        System.out.println("father");
    }
}

class MyS2 extends MyStatic1{
    public static void get1(){
        int count = 0;

        for (int i = 0; i < 10000; i++) {
            System.out.println("sun");
            count++;
        }

        System.out.println(1);

    }
}
