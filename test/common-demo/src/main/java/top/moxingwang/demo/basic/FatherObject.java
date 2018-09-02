package top.moxingwang.demo.basic;

/**
 * Created by M on 17/7/19.
 */
public class FatherObject {
    String name = "扯";
    public FatherObject() {
        System.out.println("FatherObject");
    }

    public void fatherSay(){
        System.out.println("father say");
    }

    public void say(){
        System.out.println("father");
    }
}
