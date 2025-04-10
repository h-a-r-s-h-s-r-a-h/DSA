package Code.Array.Project08;

public class Main {
    public int[] resize(int[] arr, int capacity) {
        int[] temp = new int[capacity];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
        return arr;
    }

    public static void main(String[] args) {
        Main myObj = new Main();
        int[] arr = {5, 2, 1, 9, 10};
        System.out.println("Original Array Size:- " + arr.length);
        arr = myObj.resize(arr, 10);
        System.out.println("Resized Array Size:- " + arr.length);
    }
}
