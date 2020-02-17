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

        DogUtil du = new DogUtil();
        // 调用 GunDog 中的 info() 或者 run() 方法前
        du.method1();
        // 用反射去调用 Dog class 中的方法
        Object result = method.invoke(target, objects);// 注释一
        // 调用 GunDog 中的 info() 或者 run() 方法后
        du.method2();
        return result;

    }
}
