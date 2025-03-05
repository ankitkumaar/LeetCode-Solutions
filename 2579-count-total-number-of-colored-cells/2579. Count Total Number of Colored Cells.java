class Solution {
    public long coloredCells(int n) {
        
        /* variable to store first number of series */
        long sum=1;
        for(int i=1; i<n; i++){
            sum += i * 4;
        }
        return sum;
    }
}