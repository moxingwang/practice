package top.moxingwang.demo.number;

import java.math.BigDecimal;

/**
 * Created by M on 17/7/17.
 *
 *  float浮点数的二进制存储方式及转换
 *  C/C++中整数与浮点数在内存中的表示方式

 *  http://blog.csdn.net/zcczcw/article/details/7362473
 *  http://blog.csdn.net/lanuage/article/details/50411916

 */
public class BigdecimalTest {
     final int scale;


    public BigdecimalTest(int scale) {
        this.scale = scale;
    }

    public static void main(String[] args) {

        try {
            System.out.println(decimal2Binary(1.8125));
        } catch (Exception e) {
            e.printStackTrace();
        }

        double d = 5.34375;
        System.out.println(Long.toBinaryString(Double.doubleToLongBits(d)));


        BigdecimalTest t = new BigdecimalTest(11);
        Float f = new Float(11.3);


        int b=Float.floatToIntBits(f);
        System.out.println(Integer.toBinaryString(b));


        BigDecimal bigDecimal = new BigDecimal(1.2282);

        System.out.println(bigDecimal.setScale(2,BigDecimal.ROUND_DOWN));
    }

    public static String decimal2Binary(double value) throws Exception {
        // 整数部分的值
        int in = (int) value;
        System.out.println("The integer is: " + in);
        // 小数部分的值
        double r = value - in;
        System.out.println("The decimal number is: " + r);

        StringBuilder stringBuilder = new StringBuilder();
        // 将整数部分转化为二进制
        int remainder = 0;
        int quotient = 0;
        while (in != 0) {
            // 得商
            quotient = in / 2;
            // 得余数
            remainder = in % 2;
            stringBuilder.append(remainder);
            in = quotient;
        }
        stringBuilder.reverse();
        stringBuilder.append(".");

        // 将小数部分转化为二进制
        int count = 32; // 限制小数部分位数最多为32位，如果超过32为则抛出异常
        double num = 0;
        while (r > 0.0000000001) {
            count--;
            if (count == 0) {
                throw new Exception("Cannot change the decimal number to binary!");
            }
            num = r * 2;
            if (num >= 1) {
                stringBuilder.append(1);
                r = num - 1;
            } else {
                stringBuilder.append(0);
                r = num;
            }
        }

        return stringBuilder.toString();
    }

}
