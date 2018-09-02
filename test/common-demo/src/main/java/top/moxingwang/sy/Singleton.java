package top.moxingwang.sy;

/**
 * Created by M on 17/7/13.
 */
public class Singleton {

    /**
     *
     给 instance 分配内存
     调用 Singleton 的构造函数来初始化成员变量
     将instance对象指向分配的内存空间（执行完这步 instance 就为非 null 了）
     */

    private static Singleton instance;

    public static Singleton getSingleton() {
        if (instance == null) {                         //Single Checked
            synchronized (Singleton.class) {
                if (instance == null) {                 //Double Checked
                    instance = new Singleton();
                }
            }
        }
        return instance ;
    }


}
