package Code.Graph.Project02;

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

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);

        g.displayGraph();
    }
}
