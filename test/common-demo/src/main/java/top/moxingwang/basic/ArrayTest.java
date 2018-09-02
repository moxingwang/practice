package top.moxingwang.basic;

/**
 * Created by MoXingwang on 2017/8/19.
 */
public class ArrayTest {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 5}, {7, 8, 9}, {11, 16, 19}};

        System.out.println(find(a,8));
    }

    static int find(int[][] data, int target) {
        int rows = data.length-1;
        int columns = data[0].length-1;

        int row = 0;

        while (row < rows && columns >= 0) {
            if(data[row][columns] == target){
                return 1;
            }
            if(data[row][columns]>target){
                columns --;
            }else {
                row ++;
            }
        }

        return -1;
    }


}
