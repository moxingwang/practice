package top.moxingwang.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MoXingwang on 2017/11/13.
 *
 * 栈内存设置： -Xss112M
 * -Xss1M -Xms1m -Xmx10m -XX:MetaspaceSize=1m -XX:MaxMetaspaceSize=6m
 */
public class MetaspaceSizeTest {

    List<java.lang.String> s = new ArrayList<>();

    public static void main(java.lang.String[] args) {
        new MetaspaceSizeTest().test();
    }




    void test(){
        java.lang.String a = "";
        int i = 0;
        while (true){
//            a += "fdsssssssssssssfsdafsafsfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfdsfsdds";
            i += i * 10000;
//            s.add(new java.lang.String());
        }
        /*x
        i ++;
        if(i > 1000000){
            return;
        }
        test();*/

    }
}
