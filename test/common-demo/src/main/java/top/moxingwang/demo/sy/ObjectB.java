package top.moxingwang.demo.sy;

import java.util.List;

/**
 * Created by M on 17/7/12.
 */
public class ObjectB {
    public void add(List<Integer> list){
        for (int i=0;i<10;i++){
            try {
                System.out.println("ObjectB 执行 i = " + (100 +i));
                list.add(100+i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
