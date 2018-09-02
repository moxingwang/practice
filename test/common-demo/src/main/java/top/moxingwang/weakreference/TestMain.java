package top.moxingwang.weakreference;

import com.sun.org.apache.xpath.internal.operations.String;

import java.lang.ref.WeakReference;

/**
 * Created by MoXingwang on 2017-07-05.
 */
public class TestMain {
    public static void main(String[] args) {
        TestObject testObject = new TestObject(100L, "tom");

        WeakReference<TestObject> weakCar = new WeakReference<TestObject>(testObject);

        int i = 0;

        while (true) {
            if (weakCar.get() != null) {
                System.gc();
                System.runFinalization();
                i++;
//                new String();
                System.out.println("Object is alive for " + i + " loops - " + weakCar);
            } else {
                System.out.println("Object has been collected.");
                break;
            }
        }
    }
}
