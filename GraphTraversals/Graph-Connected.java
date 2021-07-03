package CreatingSolutions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    LinkedList<Integer>[] adj;
    int V;  //number of vertices
    int E;  // number of edges

    public Graph(int vertices){
        this.V = vertices;
        this.E = 0;
        this.adj = new LinkedList[vertices];
        for(int v= 0; v< V; v++)
            adj[v] = new LinkedList<>();  //initialising a new Linked List for every vertex
    }

    public void addEdge(int u, int v) {             //for UNDIRECTED GRAPHS

        adj[u].add(v);
        adj[v].add(u);
        E++;
    }
	
    void AddEdge(int v, int w) {                   //for DIRECTED GRAPHS
        adj[v].add(w); //
        E++;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " edges" + "\n");
        for(int v = 0; v <V; v++){
            sb.append(v + " : ");
            for(int w : adj[v])
                sb.append(w + " ");
            sb.append("\n");
        }
        return sb.toString();
    }

    public void bfs(int s){

        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        visited[s]=true;
        q.offer(s);

        while(!q.isEmpty()){
            int v =q.poll();
            System.out.print(v + " ");

            for(int u : adj[v]) {
                if (!visited[u]) {
                    visited[u]=true;
                    q.offer(u);
                }
            }
        }
    }
    public void dfs(int s){
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        while(!stack.isEmpty()) {
            int u = stack.pop();
            if (!visited[u]) {
                visited[u] = true;
                System.out.print(u + " ");
                for (int v : adj[u]) {
                    if (!visited[v])
                        stack.push(v);
                }
            }
        }
    }
	
	

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,0);
        graph.addEdge(2,4);
        System.out.println(graph);
        System.out.println("Breadth First Traversal: ");
        graph.bfs(0);
        System.out.println();
        System.out.println("Depth First Traversal: ");
        graph.dfs(0);
    }
}
