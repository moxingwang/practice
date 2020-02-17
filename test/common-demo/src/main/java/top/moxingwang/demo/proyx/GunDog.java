package top.moxingwang.demo.proyx;

public class GunDog implements Dog {
    @Override
    public void info() {
        System.out.println("我是一只狗");
    }

    @Override
    public void run() {
        System.out.println("我会跑...");
    }
}
