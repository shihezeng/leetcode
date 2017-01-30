package other;

import java.util.Arrays;

public class Algorithm {

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) swap(array, j - 1, j);
            }
        }
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minId = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minId]) {
                    minId = j;
                }
            }
            swap(array, i, minId);
        }
    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int lo, int hi) {
        if (lo < hi) {
            int j = partition(array, lo, hi);
            quickSort(array, lo, j - 1);
            quickSort(array, j, hi);
        }
    }

    public static int partition(int[] array, int i, int j) {
        int pivot = array[i];
        while (i < j) {
            while (array[i] < pivot)
                i++;
            while (array[j] > pivot)
                j--;
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        return i;
    }

    public static void mergeSort(int[] array) {
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
    }

    public static void mergeSort(int[] array, int[] helper, int lo, int hi) {
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            mergeSort(array, helper, lo, mid);
            mergeSort(array, helper, mid + 1, hi);
            merge(array, helper, lo, mid, hi);
        }
    }

    public static void merge(int[] array, int[] helper, int lo, int mid,
            int hi) {
        for (int i = lo; i <= hi; i++) {
            helper[i] = array[i];
        }
        int i = lo, j = mid + 1, k = lo;
        while (i <= mid && j <= hi) {
            if (helper[i] <= helper[j]) {
                array[k++] = helper[i++];
            } else {
                array[k++] = helper[j++];
            }
        }
        while (i <= mid) {
            array[k++] = helper[i++];
        }
    }

    public static void main(String[] args) {
        int[] a = { 8, 4, 2, 1, 10 };
        System.out.println(Arrays.toString(a));
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
        System.out.println("==========");
        int[] b = { 8, 4, 2, 1, 10 };
        System.out.println(Arrays.toString(b));
        selectionSort(b);
        System.out.println(Arrays.toString(b));
        System.out.println("==========");
        int[] c = { 8, 4, 2, 1, 10 };
        System.out.println(Arrays.toString(c));
        quickSort(c);
        System.out.println(Arrays.toString(c));
        System.out.println("==========");
        int[] d = { 8, 4, 2, 1, 10 };
        System.out.println(Arrays.toString(d));
        mergeSort(d);
        System.out.println(Arrays.toString(d));
    }

}
