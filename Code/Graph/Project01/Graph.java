package Code.Graph.Project01;

public class Graph {

    private int V; // number of vertices in Graph
    private int E; // number of edges in Graph
    private int[][] adjMatrix;

    public Graph(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adjMatrix = new int[nodes][nodes];
    }

    public void addEdge(int u, int v) {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
        E++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices " + E + " edges " + "\n");
        for (int v = 0; v < V; v++) {
            sb.append(v + ": ");
            for (int w : adjMatrix[v]) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void print() {
        System.out.println(V + " vertices " + E + " edges ");
        for (int v = 0; v < V; v++) {
            System.out.print(v + ": ");
            for (int w = 0; w < E; w++) {
                System.out.print(adjMatrix[v][w] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        System.out.println(g);
//        g.print();
    }
}
