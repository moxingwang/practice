package top.moxingwang.multithread.volatiletest;

/**
 * Created by M on 17/7/23.
 */
public class Exchanger {

    private Object   object       = null;
    private volatile boolean hasNewObject = false;

    public void put(Object newObject) {
        while(hasNewObject) {
            //wait - do not overwrite existing new object
        }
        object = newObject;
        hasNewObject = true; //volatile write
    }

    public Object take(){
        while(!hasNewObject){ //volatile read
            //wait - don't take old object (or null)
        }
        Object obj = object;
        hasNewObject = false; //volatile write
        return obj;
    }


}
