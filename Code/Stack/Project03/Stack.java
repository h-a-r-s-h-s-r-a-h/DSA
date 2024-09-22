package Code.Stack.Project03;

import java.util.EmptyStackException;

public class Stack {

    private ListNode top;
    private int length;

    private class ListNode {
        private char data;
        private ListNode next;

        public ListNode(char data) {
            this.data = data;
        }
    }

    public Stack() {
        top = null;
        length = 0;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void push(char data) {
        ListNode temp = new ListNode(data);
        temp.next = top;
        top = temp;
        length++;
    }

    public char pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        char result = top.data;
        top = top.next;
        length--;
        return result;
    }

    public static String reverseString(String input) {
        Stack stack = new Stack();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        String reversedString = "";
        while (!stack.isEmpty()) {
            reversedString += stack.pop();
        }

        return reversedString;
    }

    public static void main(String[] args) {
        String original = "Hello World!";
        String reversed = reverseString(original);
        System.out.println("Original String: " + original);
        System.out.println("Reversed String: " + reversed);
    }
}
