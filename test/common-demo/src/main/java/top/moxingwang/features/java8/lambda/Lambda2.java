package top.moxingwang.features.java8.lambda;

/**
 * @author Benjamin Winterberg
 */
public class Lambda2 {

    @FunctionalInterface
    public static interface Converter<F, T> {
        T convert(F from);
    }

    static class Something {
        String startsWith(String s) {
            return String.valueOf(s.charAt(0));
        }
    }

    interface PersonFactory<P extends Person> {
        P create(String firstName, String lastName);
    }

    public static void main(String[] args) {
        Converter<String, Integer> integerConverter1 = (from) -> Integer.valueOf(from);
        Integer converted1 = integerConverter1.convert("123");
        System.out.println(converted1);   // result: 123

        // method reference

        Converter<String, Integer> integerConverter2 = Integer::valueOf;
        Integer converted2 = integerConverter2.convert("123");
        System.out.println(converted2);   // result: 123

        Something something = new Something();

        Converter<String, String> stringConverter = something::startsWith;
        String converted3 = stringConverter.convert("Java");
        System.out.println(converted3);    // result J

        // constructor reference

        //双冒号：lambda的一种简写方式
        PersonFactory<Person> personFactory = Person::new;
        PersonFactory<Person> personFactory2 = (p,a)-> new Person(p,a);
        Person person = personFactory.create("Peter", "Parker");
    }
}
