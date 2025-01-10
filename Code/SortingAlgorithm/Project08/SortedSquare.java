package Code.SortingAlgorithm.Project08;

import java.util.Arrays;

public class SortedSquare {

    public int[] sortedSquares(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        int i = 0;
        int j = n - 1;
        for (int k = n - 1; k >= 0; k--) {
            if (Math.abs(arr[i]) > Math.abs(arr[j])) {
                result[k] = arr[i] * arr[i];
                i++;
            } else {
                result[k] = arr[j] * arr[j];
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SortedSquare ss = new SortedSquare();
        int[] arr = new int[]{-4, -1, 0, 3, 10};
        System.out.println("Original Array :- " + Arrays.toString(arr));
        int[] result = ss.sortedSquares(arr);
        System.out.println("Sorted Array :- " + Arrays.toString(result));
    }
}
