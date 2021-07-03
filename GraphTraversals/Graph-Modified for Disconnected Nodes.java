package CreatingSolutions;

import java.util.Iterator;
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
    // Function to add an edge into the graph
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

    public void bfsUtil(int s, boolean[] visited){

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

    public void bfs(int s){
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; ++i)    //Modification for Disconnected graphs
            if (!visited[i])
                bfsUtil(i, visited);
    }


    public void dfsUtil(int s, boolean[] visited){        //DFS Using Stack

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

    void DFSUtil(int v, boolean visited[])                 //DFS Without using stack
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
    public void dfs(int s){
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; ++i)    //Modification for Disconnected graphs
            if (!visited[i])
                DFSUtil(i, visited);
    }



    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.AddEdge(0, 1);
        g.AddEdge(0, 2);
        g.AddEdge(1, 2);
        g.AddEdge(2, 0);
        g.AddEdge(2, 3);
        g.AddEdge(3, 3);
        System.out.println(g);

        System.out.println(
            "Following is Depth First Traversal");

        g.dfs(0);
    }


}
