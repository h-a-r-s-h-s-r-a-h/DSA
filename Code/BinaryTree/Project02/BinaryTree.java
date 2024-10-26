package Code.BinaryTree.Project02;

public class BinaryTree {

    private TreeNode root;

    private class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    private class Stack {
        private ListNode top;
        private int length;

        private class ListNode {
            private TreeNode data;
            private ListNode next;

            public ListNode(TreeNode data) {
                this.data = data;
            }
        }

        public Stack() {
            top = null;
            length = 0;
        }

        public boolean isEmpty() {
            return length == 0;
        }

        public void push(TreeNode data) {
            ListNode temp = new ListNode(data);
            temp.next = top;
            top = temp;
            length++;
        }

        public TreeNode pop() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            TreeNode result = top.data;
            top = top.next;
            length--;
            return result;
        }
    }

    public void createBinaryTree() {
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);

        root = first;
        first.left = second;
        first.right = third;

        second.left = fourth;
        second.right = fifth;
    }



    // Iterative pre-order traversal using the custom Stack class
    public void preOrderIterative(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack stack = new Stack();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.print(current.data + " ");

            // Push right child first so that left child is processed first
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();

        System.out.print("Iterative Pre-Order Traversal: ");
        bt.preOrderIterative(bt.root);
    }
}
