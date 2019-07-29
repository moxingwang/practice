package top.moxingwang.elasticsearch.SensitiveWord;

/**
 * @description:
 * @author: MoXingwang 2019-07-29 13:09
 **/
public class SensitiveWord {
    private String content;

    public SensitiveWord(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
