package top.moxingwang.multithread.volatiletest;

/**
 * Created by M on 17/7/23.
 * java -XX:+PrintAssembly -Xcomp -XX:CompileCommand=dontinline,*Bar.sum -XX:CompileCommand=compileonly,*Bar.sum Bar
 *
 * export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64/bin/javac

 */
public class Bar {

    private static volatile int id = 111;

    public static void main(String[] args) {
        id = 222;
//        System.out.println(id);
    }

}
