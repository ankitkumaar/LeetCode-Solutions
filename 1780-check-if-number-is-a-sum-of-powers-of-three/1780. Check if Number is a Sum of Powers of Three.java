class Solution {
    public boolean checkPowersOfThree(int n) {
        
        /* Number to binary, instead of using 2, we are using 3 as the base here */
        int num = n;
        while (num > 0) {
            if (num % 3 > 1) {
                return false;
            }
            num = num / 3;
        }
        return true;
    }
}