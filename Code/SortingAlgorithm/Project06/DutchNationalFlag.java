package Code.SortingAlgorithm.Project06;

import java.util.Arrays;

public class DutchNationalFlag {

    public void threeNumberSort(int[] arr) {
        int i = 0;
        int j = 0;
        int k = arr.length - 1;
        while (i <= k) {
            if (arr[i] == 0) {
                swap(arr, i, j);
                i++;
                j++;
            } else if (arr[i] == 1) {
                i++;
            } else {
                swap(arr, i, k);
                k--;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        DutchNationalFlag dnf = new DutchNationalFlag();
        int[] arr = {0, 0, 1, 2, 0, 1, 2};
        System.out.println("Original Array :- " + Arrays.toString(arr));
        dnf.threeNumberSort(arr);
        System.out.println("Sorted Array :- " + Arrays.toString(arr));
    }
}
