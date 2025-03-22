class Solution {
    
    /* Graph represented as an adjacency list and a visited array */
    private List<Integer>[] graph;
    private boolean[] visited;

    /* Method to count the number of complete components in the graph */
    public int countCompleteComponents(int n, int[][] edges) {
        
        /* Initialize the graph with empty lists for each node */
        graph = new List[n];
        visited = new boolean[n];
        Arrays.setAll(graph, k -> new ArrayList<>());
      
        /* Populate the adjacency list with the edges */
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph[a].add(b);
            graph[b].add(a);
        }
      
        /* Counter for complete components */
        int count = 0;

        /* Traverse each node to check if it forms a complete component */
        for (int i = 0; i < n; ++i) {
            
            /* If the node has not been visited, perform DFS */
            if (!visited[i]) {
                int[] result = dfs(i);

                /* A complete component has (n*(n-1))/2 edges. 
                Here, result[0] is the number of nodes (n)
                and result[1] is the number of edges in this component */
                if (result[0] * (result[0] - 1) == result[1]) {
                    count++;
                }
            }
        }

        /* Return the total count of complete components */
        return count;
    }

    /* Depth First Search (DFS) helper method to compute the total number of nodes and edges in a component */
    private int[] dfs(int index) {
        visited[index] = true;

        /* Start with one node, the one we are currently at
        Counts edges connected to the current node */
        int nodesCount = 1;
        int edgesCount = graph[index].size();

        /* Recursively visit all the neighbors that have not been visited */
        for (int neighbor : graph[index]) {
            if (!visited[neighbor]) {
                int[] result = dfs(neighbor);
                
                /* Increment the count of nodes and 
                edges with the counts from the neighbor */
                nodesCount += result[0];
                edgesCount += result[1];
            }
        }

        /* Return the total count of nodes and edges in this component */
        return new int[] {nodesCount, edgesCount};
    }
}