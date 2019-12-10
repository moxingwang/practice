package top.moxingwang.demo.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) {
        Class clazz = null;
        String fileName = name + ".class";
        FileInputStream inputStream = null;
        ByteArrayOutputStream outputStream = null;

        try {
            File classFile = new File(fileName);
            inputStream = new FileInputStream(classFile);
            outputStream = new ByteArrayOutputStream();

            int ch = -1;
            while ((ch = inputStream.read()) != -1) {
                outputStream.write(ch);
            }

            byte[] b = outputStream.toByteArray();
            clazz = defineClass(name, b, 0, b.length);
            defineClass(name, b, 0, b.length);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return clazz;
    }
}
