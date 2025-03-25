class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        
        /* Arrays to store x and y coordinate ranges of the rectangles */
        int[][] cordX = new int[rectangles.length][2];
        int[][] cordY = new int[rectangles.length][2];
        
        /* Extracting x and y coordinates for each rectangle */
        for (int i = 0; i < rectangles.length; ++i) {
            cordX[i][0] = rectangles[i][0]; cordX[i][1] = rectangles[i][2];
            cordY[i][0] = rectangles[i][1]; cordY[i][1] = rectangles[i][3];
        }

        /* Check if either x-coordinates or y-coordinates form 
        at least 3 merged intervals */
        return Math.max(countMerged(cordX), countMerged(cordY)) >= 3;
    }
    
    private int countMerged(int[][] intervals) {

        /* Count of separate merged intervals
        Tracks the end of the last merged interval */
        int count = 0, prevEnd = 0;
        
        /* Sorting intervals by their start coordinate */
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        /* Merging overlapping intervals */
        for (int[] interval : intervals) {
            final int start = interval[0];
            final int end = interval[1];
            
            if (start < prevEnd)
                prevEnd = Math.max(prevEnd, end);
            else {
                prevEnd = end;
                count++;
            }
        }
        /* Return total count of merged intervals */
        return count;
    }
}