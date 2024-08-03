class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        // Initialize two arrays to store frequency of
        // each number of target and arr
        int[] freqTarget = new int[1001];
        int[] freqArr = new int[1001];

        // Iterate loop to store frequency of
        // each number of target
        for (int num:target) {
            freqTarget[num]++;
        }

        // Iterate loop to store frequency of
        // each number of arr
        for (int num:arr) {
            freqArr[num]++;
        }

        return Arrays.equals(freqTarget, freqArr);
    }
}