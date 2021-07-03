//BFS Implementation In Java
import java.io.*; 
import java.util.*; 
  
// This class represents a directed graph using adjacency list 
// representation 
class Graph 
{ 
    private int V;   // No. of vertices 
    private LinkedList<Integer> adj[]; //Adjacency Lists // Array of linked List
  
    // Constructor 
    Graph(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
  
    // Function which adds an edge from v -> w 
    void addEdge(int v,int w) 
    { 
        adj[v].add(w);
        adj[w].add(v);
        		
    } 
   
    // Function which prints BFS traversal from a given source 's' 
    void BFS(int s) 
    { 
        // mark all vertices as false, (i.e. they are not visited yet)
        boolean visited[] = new boolean[V]; 
  
        // Create a new queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // Mark the current node as visited and enqueue it 
        visited[s]=true; 
        queue.add(s); 
  
        while (queue.size() > 0) 
        { 
            // pop a vertex from queue and print it 
            s = queue.poll(); 
            System.out.print(s+" "); 
  
            //Traverse all the adjacent vertices of current vertex,
            //check if they are not visited yet, mark them visited and push them into the queue.
            Iterator<Integer> it = adj[s].listIterator(); 
            while (it.hasNext() == true) 
            { 
                int n = it.next(); 
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    queue.add(n); 
                } 
            } 
        } 
    } 
  
 
} 

class Main {
        // Driver method to Create and Traverse Graph
    public static void main(String args[]) 
    { 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of vertices");
        int vertices = sc.nextInt();
        
        Graph g = new Graph(vertices);
        
        System.out.println("Enter Number of edges");
        int edges = sc.nextInt();
        int i;
        
        int source, destination;
        System.out.println("Enter Source <space> Destination (0-indexing)");
        
        for(i = 0; i < edges; i++){
            source = sc.nextInt();
            destination = sc.nextInt();
            if(source >= vertices || destination >= vertices){
                System.out.println("Invalid Edge");
                i--;
            }
            
            g.addEdge(source, destination);
        }
        
        System.out.println("Enter starting vertex");
        int start = sc.nextInt();
        
        System.out.println("Following is Breadth First Traversal, starting from vertex " + start); 
  
        g.BFS(start); 
    } 
}