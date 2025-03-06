
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = 0, sum = 0;
        int repNum = 0, missNum = 0;

        /* HashMap to store frequency of each array element to find repetative number */
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<grid.length; i++)   {
            for(int j=0; j<grid[i].length; j++)    {
                sum += grid[i][j];
                map.put(grid[i][j], map.getOrDefault(grid[i][j], 0) + 1);
            }
        }
        
        /* Traverse HashMap and find repetative number */
        for (Map.Entry<Integer,Integer> hm : map.entrySet()) {
            if(hm.getValue() == 2)
                repNum = hm.getKey();
        }

        n = grid.length * grid[0].length;
        missNum = ((n * (n+1)) /2) - (sum - repNum);
        
        return new int[]{repNum, missNum};
    }
}