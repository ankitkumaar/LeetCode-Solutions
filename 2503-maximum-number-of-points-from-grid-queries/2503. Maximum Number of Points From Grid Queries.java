class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        
        int k = queries.length;

        /* Array to store queries along with their original indices */
        int[][] qs = new int[k][2];
        for (int i = 0; i < k; ++i) {
            qs[i] = new int[] {queries[i], i};
        }
        
        /* Sort queries in ascending order based on the query value */
        Arrays.sort(qs, (a, b) -> a[0] - b[0]);
        
        int[] ans = new int[k];
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        vis[0][0] = true;
        
        /* Min-heap priority queue to store grid values along 
        with their coordinates */
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.offer(new int[] {grid[0][0], 0, 0});
        
        /* Direction array for moving up, down, left, and right */
        int[] dirs = new int[] {-1, 0, 1, 0, -1};
        int cnt = 0;
        
        /* Process each query in sorted order */
        for (var e : qs) {
            int v = e[0];
            k = e[1];
            
            /* Expand the reachable region while the top of the heap 
            has a value less than v */
            while (!q.isEmpty() && q.peek()[0] < v) {
                var p = q.poll();
                cnt++;
                
                /* Explore all four possible directions */
                for (int h = 0; h < 4; ++h) {
                    int x = p[1] + dirs[h], y = p[2] + dirs[h + 1];
                    
                    /* Check if the new cell is within bounds and not visited */
                    if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y]) {
                        vis[x][y] = true;
                        q.offer(new int[] {grid[x][y], x, y});
                    }
                }
            }
            ans[k] = cnt;
        }
        return ans;
    }
}