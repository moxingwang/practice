package top.moxingwang.demo.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author MoXingwang on 2018-05-07.
 */
public class Stream {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("123","43223","erter","167");

        List<String> filterTest = list.stream().filter(p->p.startsWith("1")).collect(Collectors.toList());

        System.out.println(1);
    }
}
