package top.moxingwang.demo.password;

/**
 * Created by MoXingwang on 2017/8/26.
 */
public class Base65Util implements Base65Interface{

    public static void main(String[] args) {

        String s = "3,password,update gis_delete_log set code='222',content='cn' WHERE id=5,$";

//        byte[] a = s.getBytes();

//        System.out.println("base64 encode: " + Base64.encode(s));
//        System.out.println("base64 decode: " + Base64.decode(Base64.encode(s)));
//

        System.out.println("-------------------------------------------------------");

//        System.out.println("base65 encode: " + Base65.encode(s));
//        System.out.println("base65 encode: " + Base65.decode(Base65.encode(s)));

        //打乱ASCII字符
        System.out.println(new Base65Util().getKey());
    }

}
