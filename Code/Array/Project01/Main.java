package Code.Array.Project01;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public void printArray(int[] arr) {
        int len = arr.length;
        System.out.println("Printing Array with loop :- ");
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        Main myObj = new Main();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of array u want to make");
        int length = input.nextInt();
        // Declaration and initialization of array
        int[] myArray = new int[length];
        System.out.println("Enter the elements of Array :- ");
        //Adding elements in an array
        for (int i = 0; i < length; i++) {
            myArray[i] = input.nextInt();
        }
        //Printing array
        System.out.println("Printing Array :- " + Arrays.toString(myArray));
        //Accessing the length of array
        int n = myArray.length;
        System.out.println("Length of Array :- " + n);
        //Printing array with loop
        myObj.printArray(myArray);
        input.close();
    }
}
