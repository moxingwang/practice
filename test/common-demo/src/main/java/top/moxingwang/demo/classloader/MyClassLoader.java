package top.moxingwang.demo.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;

public class MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = null;
        String fileName = name + ".class";
        FileInputStream inputStream = null;
        ByteArrayOutputStream outputStream = null;

        try {
            File classFile = new File(fileName);
            inputStream = new FileInputStream(classFile);
            outputStream = new ByteArrayOutputStream();

            int ch = 0;
            while ((ch = inputStream.read()) != -1) {
                outputStream.write(ch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return clazz;
    }
}
