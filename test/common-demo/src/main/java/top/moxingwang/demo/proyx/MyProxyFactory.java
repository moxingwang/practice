package top.moxingwang.demo.proyx;

import java.lang.reflect.Proxy;

public class MyProxyFactory {
    public static Object getProxy(Object target) throws Exception{
        // 实例化 MyInvocationHandler 对象
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.setTarget(target);
        // 调用 proxy 的 newProxyInstance() 方法传入三个参数,创建代理类实例
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),handler);
    }
}
