package top.moxingwang.password;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by MoXingwang on 2017/8/26.
 */
public interface Base65Interface {

    char[] pem_array = {'d','G','f','W','g','o','T','9','+','x','j','V','z','m','i','H','0','D','c','n','p','k','L','t','e','s','5','6','Q','F','a','P','X','y','u','O','B','h','4','8','2','R','w','S','N','I','U','M','q','C','l','b','v','E','/','r','Z','Y','J','1','3','K','A','7'};

    default String getKey(){
        String word = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+/";
        char[] chars = word.toCharArray();

        List<String> list = new ArrayList<>();

        for (char aChar : chars) {
            list.add(String.valueOf(aChar));
        }

        Collections.shuffle(list);

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : list) {
            stringBuilder.append(",'" +s+ "'");
        }

        return stringBuilder.toString();

    }


}
