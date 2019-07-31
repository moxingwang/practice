package top.moxingwang.elasticsearch.SensitiveWord;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: MoXingwang 2019-07-29 13:10
 **/
public class Test {
    //https://www.cnblogs.com/AlanLee/p/5329555.html
    public static void main(String[] args) {

        // 初始化敏感词库对象
        SensitiveWordInit sensitiveWordInit = new SensitiveWordInit();
        // 从数据库中获取敏感词对象集合（调用的方法来自Dao层，此方法是service层的实现类）
        List<SensitiveWord> sensitiveWords = new ArrayList<>();
        {
            sensitiveWords.add(new SensitiveWord("我们的空时间哈哈哈哈哈"));
//            sensitiveWords.add(new SensitiveWord("我的"));
//            sensitiveWords.add(new SensitiveWord("我哈哈"));
//            sensitiveWords.add(new SensitiveWord("你"));
//            sensitiveWords.add(new SensitiveWord("你的"));
//            sensitiveWords.add(new SensitiveWord("他们的"));
        }

        // 构建敏感词库
        Map sensitiveWordMap = sensitiveWordInit.initKeyWord(sensitiveWords);
        // 传入SensitivewordEngine类中的敏感词库
        SensitivewordEngine.sensitiveWordMap = sensitiveWordMap;
        // 得到敏感词有哪些，传入2表示获取所有敏感词
        String text = "我的就是哈我哈哈我";
        Set<String> set = SensitivewordEngine.getSensitiveWord(text, 2);

        System.out.println(set);

    }
}
