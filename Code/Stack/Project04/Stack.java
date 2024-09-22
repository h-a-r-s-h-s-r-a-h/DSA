package Code.Stack.Project04;

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

    public static boolean isValidParentheses(String input) {
        Stack stack = new Stack();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == '(' || current == '{' || current == '[') {
                stack.push(current);
            } else if (current == ')' || current == '}' || current == ']') {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if ((current == ')' && top != '(') ||
                        (current == '}' && top != '{') ||
                        (current == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String input1 = "({[]})";
        String input2 = "({[)]}";

        System.out.println("Input1 is valid: " + isValidParentheses(input1));
        System.out.println("Input2 is valid: " + isValidParentheses(input2));
    }
}
