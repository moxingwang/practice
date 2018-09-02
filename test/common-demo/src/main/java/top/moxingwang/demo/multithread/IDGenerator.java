package top.moxingwang.demo.multithread;

import java.util.Calendar;

/**
 * Created by MoXingwang on 2017/5/27.
 * 支持最多64年，128个部署节点，每一毫秒最多支持1048576个订单
 */
public class IDGenerator {

    public static void main(String[] args) {
        IDGenerator generator = new IDGenerator();
        String re = generator.nextOrderID("SO");
        System.out.println(re);
        System.out.println("SO2016111000000080");
    }


    private int serverID = 0;
    private long currOrderSequence = 0;
    private long currTimestamp = 0;


    /**
     * 初始化机器码
     */
    public void init() {
        serverID = 0;

    }


    public synchronized String nextOrderID(String prefix) {

        Calendar can = Calendar.getInstance();
        int year = can.get(Calendar.YEAR) - 2017;
        int month = can.get(Calendar.MONTH) + 1;
        int day = can.get(Calendar.DAY_OF_MONTH);
        int hour = can.get(Calendar.HOUR_OF_DAY);
        int min = can.get(Calendar.MINUTE);
        int sec = can.get(Calendar.SECOND);
        int ms = can.get(Calendar.MILLISECOND);

        long req = year;
        req = req << 4 | month;
        req = req << 5 | day;
        req = req << 5 | hour;
        req = req << 6 | min;
        req = req << 6 | sec;
        req = req << 10 | ms;

        //豪秒变化后 ， 回归currOrderSequence=0
        if (req > currTimestamp) {
            currOrderSequence = 0;
            currTimestamp = req;
        } else {
            currOrderSequence++;
        }


        req = req << 7 | serverID;
        req = req << 18 | currOrderSequence;

        System.out.println(1<<18);

        return prefix + req;
    }
}
