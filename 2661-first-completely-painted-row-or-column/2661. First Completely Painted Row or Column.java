import java.io.*;
import java.util.*;

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {        
        int m = mat.length;
        int n = mat[0].length;

        /* Create HashMap to store the positions of each element in the matrix
           Key: Element value from the matrix
           Value: Position (row, column) as an array */
        HashMap<Integer, int[]> hmap = new HashMap<>();
        for(int i=0; i<m; i++)  {
            for(int j=0; j<n; j++)  {
                hmap.put(mat[i][j], new int[]{i, j});
            }
        }

        /* Arrays to keep track of the number of elements filled in each row and column */
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        /* Iterate through the array to simulate filling elements in the matrix */
        for(int i=0; i<arr.length; i++) {
            int[] pos = hmap.get(arr[i]);
            rowCount[pos[0]]++;
            colCount[pos[1]]++;

            /* Check if the current row or column is completely filled
               Return the index of the first completed row/column */
            if(rowCount[pos[0]] == n || colCount[pos[1]] == m)
                return i;
        }

        /* If no row or column is completely filled, return -1 */
        return -1;
    }
}