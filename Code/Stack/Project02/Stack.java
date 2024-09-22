package Code.Stack.Project02;

public class Stack {
    private int top;
    private int[] arr;

    public Stack(int capacity) {
        top = -1;
        arr = new int[capacity];
    }

    public int size() {
        return top + 1;
    }

    public boolean isFull() {
        return arr.length == size();
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public void push(int data) {
        if (isFull()) {
            throw new RuntimeException("Stack is full !!!");
        }
        top++;
        arr[top] = data;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty !!!");
        }
        int result = arr[top];
        top--;
        return result;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty !!!");
        }
        return arr[top];
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(11);
        stack.push(22);
        stack.push(33);
        stack.push(44);
        stack.push(55);
        System.out.println("Peek element of stack :- " + stack.peek());

        stack.pop();
        System.out.println("Peek element after pop :- " + stack.peek());
    }
}