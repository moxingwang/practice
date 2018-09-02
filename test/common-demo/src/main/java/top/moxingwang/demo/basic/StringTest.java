package top.moxingwang.demo.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MoXingwang on 17/8/16.
 */
public class StringTest {

    public static void main(String[] args) {
        String s = "fsdfsdfsdfsdfsdmoxingewangmoxingwangfsdfsdfsdfsdfsd";

        System.out.println(s.indexOf("moxingwang111"));

        String ss = "I am a boy !";
        while (true){
            System.out.println(1);
        }

//        System.out.println(revert(ss));
//        System.out.println(convert2(ss));
    }

    public static String revert(String str){
        String[] strings = str.split(" ");

        StringBuilder stringBuffer = new StringBuilder();
        for (int i=strings.length-1;i>= 0;i--) {
            stringBuffer.append(strings[i]);
            if(i!=0){
                stringBuffer.append(" ");
            }
        }

        return stringBuffer.toString();
    }

    public static String convert2(String str){
        char[] chars = str.toCharArray();

        List<String> stringList = new ArrayList<>();
        String temp = "";

        for (int i = str.length()-1;i>=0;i--){
            if(' ' == chars[i]){
                if(temp.endsWith(" ")){
                    temp += chars[i];
                }else {
                    stringList.add(temp);
                    temp = String.valueOf(chars[i]);
                }
            }else {
                if(temp.endsWith(" ")){
                    stringList.add(temp);
                    temp = String.valueOf(chars[i]);
                }else {
                    temp = chars[i] + temp;
                }
            }
        }
        stringList.add(temp);

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : stringList) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
