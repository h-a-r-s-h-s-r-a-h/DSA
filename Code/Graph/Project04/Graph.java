package Code.Graph.Project04;

import java.util.EmptyStackException;

public class Graph {
    private ListNode[] adjList;

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Graph(int nodes) {
        adjList = new ListNode[nodes];
    }

    // Custom Stack Implementation
    private static class Stack {
        private ListNode top;
        private int length;

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

        public void push(int data) {
            ListNode temp = new ListNode(data);
            temp.next = top;
            top = temp;
            length++;
        }

        public int pop() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            int result = top.data;
            top = top.next;
            length--;
            return result;
        }


    }

    public void addEdge(int u, int v) {
        adjList[u] = insertLast(adjList[u], v);
        adjList[v] = insertLast(adjList[v], u);
    }

    private ListNode insertLast(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            return newNode;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    public void dfs(int start) {
        boolean[] visited = new boolean[adjList.length];
        Stack stack = new Stack();
        stack.push(start);

        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (!visited[u]) {
                visited[u] = true;
                System.out.print(u + " ");
                ListNode current = adjList[u];
                while (current != null) {
                    if (!visited[current.data]) {
                        stack.push(current.data);
                    }
                    current = current.next;
                }
            }
        }
    }

    public void displayGraph() {
        for (int i = 0; i < adjList.length; i++) {
            System.out.print("Node " + i + ": ");
            displayList(adjList[i]);
        }
    }

    private void displayList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(2,4);

        g.displayGraph();
        System.out.println("DFS Traversal:");
        g.dfs(0);
    }
}
