package top.moxingwang.features.java8.stream;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * Examples how to avoid null checks with Optional:
 *
 * http://winterbe.com/posts/2015/03/15/avoid-null-checks-in-java/
 *
 * @author Benjamin Winterberg
 *
 * Optional给了我们一个真正优雅的Java风格的方法来解决null安全问题。虽然没有直接提供一个操作符写起来短，但是代码看起来依然很爽很舒服。更何况?.这样的语法好不好看还见仁见智呢。(http://www.importnew.com/26066.html)
 */
public class Optional2 {

    static class Outer {
        Nested nested = new Nested();

        public Nested getNested() {
            return nested;
        }
    }

    static class Nested {
        Inner inner = new Inner();

        public Inner getInner() {
            return inner;
        }
    }

    static class Inner {
        String foo = "boo";

        public String getFoo() {
            return foo;
        }
    }

    public static void main(String[] args) {
//        test1();
        test2();
//        test3();
    }

    public static <T> Optional<T> resolve(Supplier<T> resolver) {
        try {
            T result = resolver.get();
            return Optional.ofNullable(result);
        }
        catch (NullPointerException e) {
            return Optional.empty();
        }
    }

    private static void test3() {
        Outer outer = new Outer();
        resolve(() -> outer.getNested().getInner().getFoo())
                .ifPresent(System.out::println);
    }

    private static void test2() {
        Optional.ofNullable(new Outer());
        Optional.of(new Outer())
                .map(Outer::getNested)
                .map(Nested::getInner)
                .map(Inner::getFoo)
                .ifPresent(System.out::println);
    }

    private static void test1() {
        Optional.of(new Outer())
                .flatMap(o -> Optional.ofNullable(o.nested))
                .flatMap(n -> Optional.ofNullable(n.inner))
                .flatMap(i -> Optional.ofNullable(i.foo))
                .ifPresent(System.out::println);
    }
}
