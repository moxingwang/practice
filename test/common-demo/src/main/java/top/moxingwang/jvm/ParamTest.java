package top.moxingwang.jvm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author MoXingwang on 2017/11/19.
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class ParamTest {
    public static void main(String[] args) {
        List<Object> list = new LinkedList<>();

        while (true){
            list.add(new Object());
        }
    }
}
