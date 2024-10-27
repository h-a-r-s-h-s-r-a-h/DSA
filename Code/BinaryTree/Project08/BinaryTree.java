package Code.BinaryTree.Project08;

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

    public void createBinaryTree() {
        TreeNode first = new TreeNode(4);
        TreeNode second = new TreeNode(3);
        TreeNode third = new TreeNode(7);
        TreeNode fourth = new TreeNode(5);
        TreeNode fifth = new TreeNode(8);

        root = first;
        first.left = second;
        first.right = third; // second <-- first --> third

        second.left = fourth;
        second.right = fifth;
    }

    public int findMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int result = root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);
        if (left > result) {
            result = left;
        }
        if (right > result) {
            result = right;
        }
        return result;
    }


    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();
        int maximum = bt.findMax(bt.root);
        System.out.println("Maximum value is :- " + maximum);
    }
}
