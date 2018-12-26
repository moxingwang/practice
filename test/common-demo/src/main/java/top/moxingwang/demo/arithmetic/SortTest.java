package top.moxingwang.demo.arithmetic;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: MoXingwang 2018-12-25 16:00
 **/
public class SortTest {
    int[] source = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};

    public void printArray(int[] source) {
        System.out.println(Arrays.toString(source));
    }

    @Test
    public void testQuickSort() {

        quickSort(source, 0, source.length - 1);
        printArray(source);
    }


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

    public void swap(int[] source, int left, int right) {
        int temp = source[left];
        source[left] = source[right];
        source[right] = temp;
    }
}
