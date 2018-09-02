package top.moxingwang.demo.basic;

/**
 * Created by MoXingwang on 2017/8/19.
 */
public class HappyData {
    static final int COMPLEX = 100;

    private int count = 0;

    public int isHappy(int data) {
        if (count > COMPLEX) {
            return -1;
        }
        count ++;

        char[] chars = String.valueOf(data).toCharArray();

        int sum = 0;
        for (char c : chars) {
            sum += Integer.valueOf(String.valueOf(c)) * Integer.valueOf(String.valueOf(c));
        }

        if(sum > 1){
            return isHappy(sum);
        }

        return 1;
    }


    public static void main(String[] args) {
        HappyData happyData = new HappyData();
        System.out.println(happyData.isHappy(3));
    }
}
