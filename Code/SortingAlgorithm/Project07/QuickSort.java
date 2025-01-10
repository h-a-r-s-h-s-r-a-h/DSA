package Code.SortingAlgorithm.Project07;

import java.util.Arrays;

public class QuickSort {

    public void sort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            sort(arr, low, p - 1);
            sort(arr, p + 1, high);
        }
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        int j = low;
        while (i <= high) {
            if (arr[i] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
            i++;
        }
        return j - 1;
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] arr = {9, -3, 5, 2, 6, 8, -6, 1, 3};
        System.out.println("Original Array :- " + Arrays.toString(arr));
        qs.sort(arr, 0, arr.length - 1);
        System.out.println("Sorted Array :- " + Arrays.toString(arr));
    }
}
