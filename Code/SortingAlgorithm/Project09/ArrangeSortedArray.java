package Code.SortingAlgorithm.Project09;

import java.util.Arrays;

public class ArrangeSortedArray {

    public void arrangeMaxMin(int[] arr) {
        int maxldx = arr.length - 1;
        int minldx = 0;
        int max = arr[maxldx] + 1;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] = arr[i] + (arr[maxldx] % max) * max;
                maxldx--;
            } else {
                arr[i] = arr[i] + (arr[minldx] % max) * max;
                minldx++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / max;
        }
    }

    public static void main(String[] args) {
        ArrangeSortedArray asa = new ArrangeSortedArray();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(arr));
        asa.arrangeMaxMin(arr);
        System.out.println(Arrays.toString(arr));
    }
}
