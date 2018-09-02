package top.moxingwang.basic;

/**
 * Created by M on 17/7/19.
 */
public class SonObject extends FatherObject {
    int name = 100;

    protected SonObject() {
        System.out.println("SonObject");
    }

    public void say(){
        fatherSay();
        System.out.println("son");
    }

    public static void main(String[] args) {
        SonObject sonObject = new SonObject();

        System.out.println(sonObject.name);
        FatherObject fatherObject = sonObject;
        System.out.println(fatherObject.name);

        fatherObject.say();

        System.out.println(Integer.toBinaryString(16));
        System.out.println(Integer.toHexString(10));
        System.out.println(Integer.valueOf("000001",2).toString());
        System.out.println(Integer.valueOf("000010",2).toString());
    }

}
