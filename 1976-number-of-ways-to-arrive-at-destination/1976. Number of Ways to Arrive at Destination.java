class Solution {

    /* Define constants for infinite distance and modulo value */
    private static final long INFINITY = Long.MAX_VALUE / 2; 
    private static final int MOD = (int) 1e9 + 7;

    public int countPaths(int n, int[][] roads) {
        long[][] graph = new long[n][n];
        long[] distances = new long[n];
        long[] ways = new long[n];
        boolean[] visited = new boolean[n];
      
        /* Initialize the graph with infinite distances and distances array */
        for (int i = 0; i < n; ++i) {
            Arrays.fill(graph[i], INFINITY);
            Arrays.fill(distances, INFINITY);
        }

        /* Fill the graph with actual road data */
        for (int[] road : roads) {
            int from = road[0], to = road[1], time = road[2];
            graph[from][to] = time;
            graph[to][from] = time;
        }
      
        /* Set the distance from start point to itself as zero */
        graph[0][0] = 0;
        distances[0] = 0;
        
        /* There's one way to reach the start point (itself) */
        ways[0] = 1;
      
        /* Dijkstra's Algorithm to find shortest paths */
        for (int i = 0; i < n; ++i) {
            int current = -1;
            
            /* Find the unvisited vertex with the smallest distance */
            for (int j = 0; j < n; ++j) {
                if (!visited[j] && (current == -1 || distances[j] < distances[current])) {
                    current = j;
                }
            }
            visited[current] = true;

            /* Update distances and count of ways for all neighbors */
            for (int j = 0; j < n; ++j) {
                
                /* Skip if it's the current vertex */
                if (j == current)
                    continue;
              
                long newDistance = distances[current] + graph[current][j];
              
                /* If a shorter path to neighbor is found, 
                update the distance and ways */
                if (distances[j] > newDistance) {
                    distances[j] = newDistance;
                    ways[j] = ways[current];
                } 

                /* If another path with the same length is found, 
                increment the ways */
                else if (distances[j] == newDistance) {
                    ways[j] = (ways[j] + ways[current]) % MOD;
                }
            }
        }

        /* Return the number of ways to reach the last vertex (n-1) */
        return (int) ways[n - 1];
    }
}