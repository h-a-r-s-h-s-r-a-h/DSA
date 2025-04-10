package Code.Array.Project02;

import java.util.Scanner;

public class Main {
    public int[] removeEven(int[] arr) {
        int oddCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                oddCount++;
            }
        }
        int[] result = new int[oddCount];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                result[idx] = arr[i];
                idx++;
            }
        }
        return result;
    }

    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Main myObj = new Main();
        System.out.println("Enter the length of Array :- ");
        int length = input.nextInt();
        int[] myArr = new int[length];
        System.out.println("Enter the elements of Array :- ");
        for (int i = 0; i < length; i++) {
            myArr[i] = input.nextInt();
        }
        System.out.println("Printing original Array :- ");
        myObj.printArray(myArr);
        int[] result = myObj.removeEven(myArr);
        System.out.println("Printing array after removing even :- ");
        myObj.printArray(result);
        input.close();
    }
}
