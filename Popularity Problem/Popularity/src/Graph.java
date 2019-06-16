import java.util.Iterator;


public class Graph {
    int relationArray[];
    int adjMatrix[][];
    sushiLL <Edge> G[];
    private int V;
    private static int DFSChaser = 0;

    /**
     * Edge static class that holds vertice.
     */
    private static class Edge
    {
        int vertice;

        /**
         * Edge constructor that initializes vertice.
         * @param v is vertice.
         */
        public Edge(int v)
        {
            vertice = v;
        }

    }

    /**
     * Graph constructor that creates nodes.
     * @param edgeCount is a node count of graph.
     */
    public Graph(int edgeCount)
    {
        V = edgeCount;
        G = new sushiLL[edgeCount];
        for(int i = 0 ; i < G.length ; ++i)
        {
            G[i] = new sushiLL<>();
        }
        relationArray  = new int[V];
    }

    /**
     * Method that adds edge.
     * @param u is the age number
     * @param theVertice vertice number.
     */
    void addEdge(int u, int theVertice)
    {
        if(u == 0)
        {
            throw new IllegalArgumentException("Please check your file, relation count is not true.");
        }
        G[u - 1].addFirst(new Edge(theVertice - 1));
    }

    /**
     * DFS function that depth first traversals the graph
     * @param visited is the visited array
     * @param v is the starting vertice.
     */
    public void DFS(boolean visited[], int v)
    {
        visited[v] = true;
        relationArray[DFSChaser++] = v + 1;


        Iterator<Edge> sushiIterator = G[v].iterator();
        while(sushiIterator.hasNext())
        {
            Edge current = sushiIterator.next();
            if(!visited[current.vertice])
            {
                DFS(visited,current.vertice);
            }
        }

    }

    /**
     * Method that calls DFS function and performs DFS.
     * @param v is the starting vertice.
     */
    public void relationMap(int v)
    {
        boolean visited[] = new boolean[V];
        DFS(visited,v);
    }

    /**
     * Stores all relations into 2d array.
     */
    public void drawRelations()
    {
        adjMatrix = new int[V][V];
        for(int i = 0 ; i < V ; ++i )
        {
            relationMap(i);
            for(int j = 0 ; j < relationArray.length ; ++j)
            {
                adjMatrix[i][j] = relationArray[j];
            }
            for(int j = 0 ; j < relationArray.length ; ++j)
            {
                relationArray[j] = 0;
            }
            DFSChaser = 0;
        }
    }

    /**
     * returns the 2d adjMatrix.
     * @return array that contains relations.
     */
    public int[][] getAdjMatrix()
    {
        return adjMatrix;
    }
}
