package top.moxingwang.demo.arithmetic;

import org.junit.Test;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * @description: 参考wikipedia
 * 讲究指针和移动
 * @author: MoXingwang 2018-12-25 16:00
 **/
public class SortTest {
    private static Logger logger = Logger.getGlobal();

    public void printArray(int[] source) {
        logger.info(Arrays.toString(source));
    }

    public int[] getSource() {
        return new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
    }

    @Test
    public void test() {
        if (true) {
            int[] source = getSource();
            quickSort(source, 0, source.length - 1);
            printArray(source);
        }
        if (true) {
            int[] source = getSource();
            bubbleSort(source);
            printArray(source);
        }
        if (true) {
            int[] source = getSource();
            insertSort(source);
            printArray(source);
        }

    }

    //冒泡排序
    public void bubbleSort(int[] source) {
        for (int i = 0; i < source.length; i++) {
            for (int j = i; j < source.length - 1; j++) {
                if (source[j + 1] < source[j]) {
                    int temp = source[j];
                    source[j] = source[j + 1];
                    source[j + 1] = temp;
                }
            }
        }
    }


    //快速排序
    public void quickSort(int[] source, int left, int right) {
        if (left > right) {
            return;
        }

        int pivot = source[left];
        int i = left, j = right;

        while (i < j) {
            while (source[i] < pivot) {
                i++;
            }
            while (i < j && source[j] > pivot) {
                j--;
            }

            if (i < j) {
                swap(source, i, j);
            }
        }

        quickSort(source, left, i - 1);
        quickSort(source, i + 1, right);
    }

    //插入排序
    public void insertSort(int[] source) {
        for (int i = 0; i < source.length; i++) {
            int current = source[i];
            int j = i - 1;
            while (j>=0 && source[j]>current){
                source[j+1]=source[j];
                j--;
            }
            source[j+1]=current;
        }
    }

    //选择排序


    public void swap(int[] source, int left, int right) {
        int temp = source[left];
        source[left] = source[right];
        source[right] = temp;
    }
}
