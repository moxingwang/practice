package top.moxingwang.demo.proyx;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    // 需要被代理的那个对象
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("方法调用前");
        Object result = method.invoke(target, objects);// 注释一
        System.out.println("方法调用后");
        return result;

    }
}
