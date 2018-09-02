package top.moxingwang.demo.basic;

import java.util.Iterator;

/**
 * Created by MoXingwang on 2017/6/30.
 */
public class IterableTest<E> implements Iterable<E> {

    public static void main(String[] args) {
        IterableTest<Integer> integers = new IterableTest<Integer>();
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator() {

            @Override
            public boolean hasNext() {
                //...
                return false;
            }

            @Override
            public Object next() {
                //...
                return null;
            }

            @Override
            public void remove() {
                //...
            }
        };
    }
}
