package top.moxingwang.demo.weakreference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MoXingwang on 2017-07-05.
 */
public class TestMain2 {
    public static void main(String[] args) {
        ReferenceQueue<String> refQueue = new ReferenceQueue<String>();
        PhantomReference<String> referent = new PhantomReference<String>(
                new String("T"), refQueue);
        System.out.println(referent.get());// null

        System.gc();
        System.runFinalization();

        System.out.println(refQueue.poll() == referent); //true


        TestObject testObject = new TestObject(100L, "tom");

        WeakReference<TestObject> bean = new WeakReference<TestObject>(testObject);

        System.gc();
        System.runFinalization();
//        testObject = null;


        List<TestObject> testObjects = new ArrayList<TestObject>();
        WeakReference<TestObject>[] referents = new WeakReference[100000];
        for (int i = 0; i < referents.length; i++) {
            try {
                TestObject testObject1 = new TestObject(100L, "tom");
                testObjects.add(testObject1);
                referents[i] = new WeakReference<TestObject>(testObject1);
//            referents[i] = new WeakReference<TestObject>(new TestObject(100L, "tom"));
            } catch (Exception e) {
            }
        }

        System.out.println(referents[100].get());// “null”

        System.out.println(bean.get());


    }
}
