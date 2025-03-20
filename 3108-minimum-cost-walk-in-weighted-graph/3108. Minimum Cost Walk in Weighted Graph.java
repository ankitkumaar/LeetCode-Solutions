class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        
        /* 
         * Step 1: Build the graph as an adjacency list
         * Each node maps to a list of pairs (neighbor, edge weight).
         */
        Map<Integer, List<int[]>> graph = new HashMap<>();
        
        /* 
         * Step 2: Use Disjoint Set Union (DSU) to track connected components.
         * Also, maintain an array to store the minimum AND-cost for each component.
         */
        DSU dsu = new DSU(n);
        int[] componentMinCost = new int[n];

        /* Initialize component minimum cost with a high value (infinity) */
        Arrays.fill(componentMinCost, Integer.MAX_VALUE);

        /* 
         * Step 3: Construct the graph and merge connected components using DSU.
         * This ensures that we know which nodes belong to the same component.
         */
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];

            /* Add edges in both directions (since the graph is undirected) */
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, w});
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u, w});

            /* Merge the components containing u and v */
            dsu.union(u, v);
        }

        /* 
         * Step 4: Precompute the minimum AND-cost for each connected component.
         * Use BFS traversal to compute the AND-cost for all edges in a component.
         */
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                /* Get the representative (root) of the component */
                int root = dsu.find(i);
                
                /* Compute the minimum AND-cost for this component */
                componentMinCost[root] = findMinAndCost(graph, i, visited);
            }
        }

        /* 
         * Step 5: Process each query in O(1) time using precomputed values.
         * If two nodes belong to different components, return -1.
         * Otherwise, return the precomputed minimum AND-cost for their component.
         */
        int[] result = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int start = query[i][0], end = query[i][1];

            /* If nodes are in different components, return -1 */
            if (dsu.find(start) != dsu.find(end))
                result[i] = -1;
            else
                result[i] = componentMinCost[dsu.find(start)];
        }
        return result;
    }

    /* 
     * BFS function to compute the minimum AND-cost for a connected component.
     * This function finds the minimum AND-value of all edge weights in the component.
     */
    private int findMinAndCost(Map<Integer, List<int[]>> graph, int start, Set<Integer> visited) {
        Queue<Integer> queue = new LinkedList<>();
        
        /* Start with all bits set (since we are computing AND operation) */
        int minAndCost = (1 << 17) - 1; // 131071 (11111111111111111 in binary)
        
        /* Initialize BFS */
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            /* Iterate over all adjacent nodes */
            for (int[] neighbor : graph.getOrDefault(node, Collections.emptyList())) {
                int nextNode = neighbor[0], weight = neighbor[1];

                /* If the neighbor is not visited, mark it and add to the queue */
                if (!visited.contains(nextNode)) {
                    visited.add(nextNode);
                    queue.offer(nextNode);
                }

                /* Compute the AND-cost across all edges in the component */
                minAndCost &= weight;
            }
        }
        return minAndCost;
    }
}

/* 
 * Disjoint Set Union (DSU) class for efficient connectivity checking.
 * Uses path compression and union by rank to optimize operations.
 */
class DSU {
    int[] parent, rank;

    /* Constructor: Initialize DSU with n nodes */
    public DSU(int n) {
        parent = new int[n]; 
        rank = new int[n];
        
        /* Initially, each node is its own parent */
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    /* 
     * Find function with path compression optimization.
     * This ensures that future lookups are faster.
     */
    public int find(int x) {
        if (parent[x] != x) 
            parent[x] = find(parent[x]); // Path compression
        return parent[x];
    }

    /* 
     * Union function to merge two components.
     * Uses union by rank to keep the tree balanced.
     */
    public void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        
        /* Merge smaller tree into larger tree */
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) 
                parent[rootY] = rootX;
            else if (rank[rootX] < rank[rootY]) 
                parent[rootX] = rootY;
            else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}