package Code.Graph.Project03;

import java.util.NoSuchElementException;

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

    // Queue Implementation
    private static class Queue {
        private ListNode front;
        private ListNode rear;
        private int length;

        public int length() {
            return length;
        }

        public boolean isEmpty() {
            return length == 0;
        }

        public void enqueue(int data) {
            ListNode temp = new ListNode(data);
            if (isEmpty()) {
                front = temp;
            } else {
                rear.next = temp;
            }
            rear = temp;
            length++;
        }

        public int dequeue() {
            if (isEmpty()) {
                throw new NoSuchElementException("Queue is already empty");
            }
            int result = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
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

    // BFS Implementation
    public void bfs(int startNode) {
        boolean[] visited = new boolean[adjList.length];
        Queue queue = new Queue();

        visited[startNode] = true;
        queue.enqueue(startNode);

        while (!queue.isEmpty()) {
            int u = queue.dequeue();
            System.out.print(u + " ");

            ListNode current = adjList[u];
            while (current != null) {
                if (!visited[current.data]) {
                    visited[current.data] = true;
                    queue.enqueue(current.data);
                }
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);

        g.displayGraph();
        System.out.println("BFS Traversal:");
        g.bfs(0);
    }
}
