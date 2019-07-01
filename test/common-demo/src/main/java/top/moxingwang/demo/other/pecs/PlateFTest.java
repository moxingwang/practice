package top.moxingwang.demo.other.pecs;

import java.rmi.server.ObjID;

/**
 * PlateFTest
 */
public class PlateFTest {

    public static void main(String[] args) {
        Apple apple = new Apple();

        Plate<Fruit> plate1 = new Plate<Fruit>();
        // Plate<Fruit> plate2 = new Plate<Apple>();// compile error

        Plate<? extends Fruit> plate3 = new Plate<>();
        // plate3.setItem(new Fruit()); // compile error
        // plate3.setItem(new Apple()); // compile error
        plate3.getItem();

        Plate<? super Fruit> plate4 = new Plate<>();
        plate4.setItem(new Fruit());
        // plate4.setItem(new Meat()); // compile error
        Fruit f = (Fruit) plate4.getItem();

        System.out.println("complete");
    }
}
