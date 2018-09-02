package top.moxingwang.demo.basic;

import java.util.LinkedList;

/**
 * Created by MoXingwang on 2017/7/2.
 */
public class ConcurrentModificationExceptionTest {
    public static void main(String[] args) {
        LinkedList<String> strings = new LinkedList<String>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.add("e");
        strings.add("f");
        strings.add("g");

        strings.subList(1,1);

        for (String string : strings) {
            if ("e".equals(string)) {
                strings.remove(string);
            }
        }
    }
}
