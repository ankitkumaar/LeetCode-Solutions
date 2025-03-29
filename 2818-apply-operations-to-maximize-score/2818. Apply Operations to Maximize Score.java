class Solution {

    /* Define a large prime modulus for modular arithmetic */
    private final int mod = (int) 1e9 + 7;
    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size();
    
        /* Create an array to store index, number of prime factors, 
        and the value of each number */
        int[][] arr = new int[n][0];
        for (int i = 0; i < n; ++i)  {
            arr[i] = new int[]{i, primeFactors(nums.get(i)), nums.get(i)};
        }

        /* Arrays to store left and right boundaries of elements 
        (to determine valid subarrays) */
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1); Arrays.fill(right, n);

        /* Monotonic stack to calculate left boundaries */
        Deque<Integer> stk = new ArrayDeque<>();
        for (int[] e : arr) {
            
            /* i = index, f = number of prime factors */
            int i = e[0], f = e[1];

            /* Remove smaller elements from stack */
            while (!stk.isEmpty() && arr[stk.peek()][1] < f) {  
                stk.pop();
            }

            /* Store nearest larger element index on the left */
            if (!stk.isEmpty()) {
                left[i] = stk.peek();
            }
            stk.push(i);
        }

        /* Clear stack for right boundary calculation */
        stk.clear();

        /* Monotonic stack to calculate right boundaries */
        for (int i = n - 1; i >= 0; --i) {
            
            /* Number of prime factors */
            int f = arr[i][1];
            
            /* Remove smaller or equal elements from stack */
            while (!stk.isEmpty() && arr[stk.peek()][1] <= f) {
                stk.pop();
            }
            
            /* Store nearest larger element index on the right */
            if (!stk.isEmpty()) {
                right[i] = stk.peek();
            }
            stk.push(i);
        }

        /* Sort elements in descending order based on their values */
        Arrays.sort(arr, (a, b) -> b[2] - a[2]);
        long ans = 1;

        /* Process each element in sorted order to maximize the score */
        for (int[] e : arr) {

            /* i = index, x = value of element, Left and right boundary indices
            and Number of valid subarrays including this element */
            int i = e[0], x = e[2];
            int l = left[i], r = right[i];
            long cnt = (long) (i - l) * (r - i);

            /* Multiply the result by power of x using modular exponentiation
            Reduce k by the number of subarrays used */
            if (cnt <= k) {
                ans = ans * qpow(x, cnt) % mod;
                k -= cnt;
            } 
            
            /* If k is smaller, take only k occurrences */
            else {
                ans = ans * qpow(x, k) % mod;
                break;
            }
        }
        return (int) ans;
    }

    /* Function to calculate the number of distinct prime factors of a number */
    private int primeFactors(int n) {
        int i = 2;
        Set<Integer> ans = new HashSet<>();
        while (i <= n / i) {
            while (n % i == 0) {
                ans.add(i);
                n /= i;
            }
            i++;
        }
        
        /* If n is still greater than 1, add it as a prime factor */
        if (n > 1) {
            ans.add(n);
        }
        return ans.size();
    }

    /* Fast exponentiation function using modular exponentiation */
    private int qpow(long a, long n) {
        long ans = 1;
        for (; n > 0; n >>= 1) {
            if ((n & 1) == 1) {
                
                /* Multiply result if current bit of n is 1 */
                ans = ans * a % mod;
            }

            /* Square a for next bit */
            a = a * a % mod;
        }
        return (int) ans;
    }
}