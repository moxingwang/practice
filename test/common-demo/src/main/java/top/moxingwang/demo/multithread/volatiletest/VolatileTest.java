package top.moxingwang.demo.multithread.volatiletest;

/**
 * Created by M on 17/7/19.
 */
public class VolatileTest {
    private volatile Object object ;

    public void testA(){

    }

    public static void main(String[] args) {
        System.out.println("testA");

        try{
//            throw new RuntimeException("test");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
