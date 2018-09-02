package top.moxingwang.demo.basic;

/**
 * @author MoXingwang on 2018/4/22.
 */
public class ShuangSe {
    static int[][] array = {
            {3, 04, 06, 25, 26, 30, 01},
            {5, 9, 12, 17, 27, 30, 06},
            {1, 04, 06, 8, 21, 24, 07},
            {6, 10, 21, 28, 29, 31, 12},
            {7, 8, 20, 23, 24, 32, 13},
            {1, 03, 8, 13, 18, 23, 16},
            {8, 12, 18, 19, 23, 32, 03},
            {15, 23, 24, 25, 28, 29, 9},
            {01, 06, 07, 8, 27, 30, 10},
            {8, 17, 24, 26, 28, 33, 04},
            {07, 10, 11, 17, 23, 28, 15},
            {01, 05, 11, 22, 23, 26, 15},
            {04, 19, 20, 22, 28, 33, 06},
            {21, 22, 23, 24, 25, 32, 06},
            {02, 16, 18, 19, 27, 30, 14},
            {13, 14, 20, 21, 25, 33, 07},
            {01, 02, 9, 14, 22, 25, 05},
            {03, 8, 11, 14, 18, 23, 16},
            {02, 07, 9, 14, 18, 28, 05},
            {04, 07, 12, 14, 26, 32, 04}

    };


    public static void main(String[] args) {
        for (int[] ints : array) {
            int redAll = 0;
            int all = 0;
            for (int i = 0; i < ints.length; i++) {
                all = all + ints[i];
                if (i < ints.length - 1) {
                    redAll = redAll + ints[i];
                }
            }

            System.out.println("红色之合" + redAll + "红蓝之合" + all + "篮色" + ints[ints.length - 1]);
        }
    }
}
