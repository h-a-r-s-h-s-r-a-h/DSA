package Code.Array.Project06;

public class Main {
    public int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Main myObj = new Main();
        int[] arr = {1, 2, 3, 4, 65, 2, 5, 322};
        int max = myObj.findMax(arr);
        System.out.println("Maximum value :- " + max);
    }
}
