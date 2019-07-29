package top.moxingwang.elasticsearch;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: MoXingwang 2019-07-29 12:53
 **/
public class TokenizerDemo {
    //词典中最长词的长度，map中的key的最长长度
    private static final int maxSize = 3;
    private static Map<String, String> map = new HashMap<String, String>();

    static {
        //可以从数据库中加载或词表中加载
//        map.put("中国", "");
        map.put("北京", "");
        map.put("中关村", "");
        map.put("海淀", "");
        map.put("国人", "");
    }

    public static void main(String[] args) {
        String text = "中国人民共和国首都是北京，中关村在海淀区。";
        int length = text.length();
        int cc = 0;
        for (int i = 0; i < length; i++) {
            int endIdx = i + maxSize;
            if (endIdx > length) {
                endIdx = length;
            }
            //最大逆序匹配
            for (int j = 0; j < maxSize; j++) {
                String s = text.substring(i, endIdx);
                cc++;
//                System.out.println(s);
                if (map.get(s) != null) {
                    //跳过匹配过的词（后面会说明跳过匹配词的原因）
                    i = endIdx - 1;
                    System.out.println(s);
                    break;
                } else {
                    endIdx -= 1;
                    if (endIdx == i) {
                        break;
                    }
                }
            }

        }

        System.out.println(cc);
    }
}
