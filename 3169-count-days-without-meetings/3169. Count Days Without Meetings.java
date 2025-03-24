class Solution {
    public int countDays(int days, int[][] meetings) {
        
        /* Create startMeeting[] and endMeeting[] to store 
        startpoint and endpoint of meetings[] */
        int[] startMeeting = new int[meetings.length];
        int[] endMeeting = new int[meetings.length];
        
        for(int i=0; i<meetings.length; i++)   {

            /* Store startpoint and endpoint of meetings[] */
            startMeeting[i] = meetings[i][0];
            endMeeting[i] = meetings[i][1];
        }

        /* Sort startMeeting[] and endMeeting[] */
        Arrays.sort(startMeeting);
        Arrays.sort(endMeeting);

        int count = 0;
        for(int i=1; i<meetings.length; i++)   {

            /* Count the days when the employee is available for work */
            if((startMeeting[i] - endMeeting[i-1] - 1) > 0) 
                count += startMeeting[i] - endMeeting[i-1] - 1;
        }
        System.out.println(count);

        /* Edge cases : exect startpoint and endpoint */ 
        if(startMeeting[0] != 1)
            count += startMeeting[0] - 1;
        if(endMeeting[meetings.length-1] != days)
            count += days - endMeeting[meetings.length-1];

        return count;
    }
}