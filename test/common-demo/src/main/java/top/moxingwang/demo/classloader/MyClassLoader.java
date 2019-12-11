package top.moxingwang.demo.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {
    private String path;

    public MyClassLoader(ClassLoader parent, String path) {
        super(parent);
        this.path = path;
    }

    public MyClassLoader(String path) {
        this.path = path;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        return super.loadClass(name, resolve);
    }

    @Override
    protected Class<?> findClass(String className) {
        Class clazz = null;
        String fileName =  path+File.separator + className.replace(".",File.separator) + ".class";
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
            clazz = defineClass(className, b, 0, b.length);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return clazz;
    }
}
