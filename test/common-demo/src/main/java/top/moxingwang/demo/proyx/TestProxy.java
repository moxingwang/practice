package top.moxingwang.demo.proyx;

public class TestProxy {
    public static void main(String[] args) throws Exception {
        // 实例化一个被代理对象
        Dog target = new GunDog();// 注意二
        // 用被代理对象去产生一个代理类对象 dog
        Dog dog = (Dog) MyProxyFactory.getProxy(target);
        // 代理对象调用被代理对象的方法啦
        dog.info();
        dog.run();
    }
}
