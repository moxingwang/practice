package top.moxingwang.demo.proyx;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestProxy2 {
    public static void main(String[] args) throws IOException {
        final GunDog gunDog = new GunDog();

        Object o = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Dog.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("方法调用前");
                try {
                    return method.invoke(gunDog, args);
                } finally {
                    System.out.println("方法调用后");
                }
            }
        });

        Dog dog = (Dog)o;

        dog.info();
        buildProxyClass();

        System.out.println("result");
    }

    public static void buildProxyClass() throws IOException {
        byte[] bytes = ProxyGenerator.generateProxyClass("Dog$proxy",new Class[]{Dog.class});

        String fileName = System.getProperty("user.dir") + "/test/common-demo/target/com.sun.proxy.$Proxy0.class";
        File file = new File(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(bytes);
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
