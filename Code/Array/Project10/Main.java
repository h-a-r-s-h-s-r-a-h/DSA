package Code.Array.Project10;

import java.util.Scanner;

public class Main {
    public boolean isPalindrome(String word) {
        char[] charArray = word.toCharArray();
        int start = 0;
        int end = word.length() - 1;
        while (start < end) {
            if (charArray[start] != charArray[end]) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Main obj = new Main();
        Scanner input = new Scanner(System.in);
        String word = input.next();
        System.out.println(obj.isPalindrome(word));
        input.close();
    }
}
