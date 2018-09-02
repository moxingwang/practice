package top.moxingwang.sy;

import java.util.List;

/**
 * Created by M on 17/7/12.
 */
public class ObjectA {
    Object object = new Object();
    private short i = 0;
    public synchronized void add(List<Integer> list){
        for (int i=0;i<10;i++){
            try {
                System.out.println("ObjectA 执行 i = " + (200 +i));
                list.add(200+i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void aa(){
        if(i ==0){
            synchronized (this){
                System.out.println("111111");
            }
        }
    }


    public void bb(){
        if(i ==0){
            synchronized (this){
                i = 100;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("");
    }
}
