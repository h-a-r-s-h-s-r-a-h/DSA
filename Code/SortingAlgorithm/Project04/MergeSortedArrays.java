package Code.SortingAlgorithm.Project04;


public class MergeSortedArrays {

    public void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int[] merge(int[] arr1, int[] arr2, int n, int m) {
        int[] result = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < n) { // when arr2 gets exhausted
            result[k] = arr1[i];
            i++;
            k++;
        }
        while (j < m) { // when arr1 gets exhausted
            result[k] = arr2[j];
            j++;
            k++;
        }
        return result;
    }

    public static void main(String[] args) {
        MergeSortedArrays msa = new MergeSortedArrays();
        int[] arr1 = {0, 1, 8, 10};
        int[] arr2 = {2, 4, 11, 15, 20};
        System.out.println("Array 1 :- ");
        msa.printArray(arr1);
        System.out.println("Array 2 :- ");
        msa.printArray(arr2);
        System.out.println("Merged sorted array :- ");
        int[] result = msa.merge(arr1, arr2, arr1.length, arr2.length);
        msa.printArray(result);
    }
}
