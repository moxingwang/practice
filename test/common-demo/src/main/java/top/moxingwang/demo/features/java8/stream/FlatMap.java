package top.moxingwang.demo.features.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by MoXingwang on 2017/9/5.
 */
public class FlatMap {
    public static void main(String[] args) {
        List<String> tl = new ArrayList<>();
        tl.add("111");
        tl.add("222");
        tl.add("333");

        Stream<List<Integer>> integerListStream = Stream.of(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5)
        );

        Stream<Integer> integerStream = integerListStream .flatMap(Collection::stream);
        integerStream.forEach(System.out::println);


        //java8 之前
        List<List<Integer>> integerLists1 = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5)
        );

        List<Integer> flattened = new ArrayList<>();

        for (List<Integer> integerList : integerLists1)
        {
            flattened.addAll(integerList);
        }

        for (Integer i : flattened)
        {
            System.out.println(i);
        }



        System.out.println("-------");


        List<List<Integer>> integerLists = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5)
        );

        integerLists.stream().flatMap(p-> p.stream()).forEach(System.out::println);

        tl.stream().flatMap(p->Stream.of(p)).count();

    }

}
