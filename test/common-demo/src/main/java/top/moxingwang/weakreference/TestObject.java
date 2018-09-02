package top.moxingwang.weakreference;

/**
 * Created by MoXingwang on 2017-07-05.
 */
public class TestObject {
    private Long id;
    private String name;

    public TestObject(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
