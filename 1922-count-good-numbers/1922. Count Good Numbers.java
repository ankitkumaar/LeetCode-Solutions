class Solution {

    // Define the modulo constant
    static final int MOD = 1_000_000_007;

    /* Returns the number of good digit strings of length n */
    public static int countGoodNumbers(long n) {
        
        /* Count of digits at even and odd indices*/
        long evenPart = modPow(5, (n + 1) / 2, MOD);
        long oddPart = modPow(4, n / 2, MOD);

        /* Multiply the combinations and take mod */
        return (int) ((evenPart * oddPart) % MOD);
    }

    /* Performs modular exponentiation: (base^exp) % mod
    Uses fast exponentiation (exponentiation by squaring) */
    public static long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            
            /* If current bit is set, multiply result with base */
            if ((exp & 1) == 1)
                result = (result * base) % mod;
            
            /* Square the base for next bit */
            base = (base * base) % mod;
            
            /* Move to the next bit */
            exp >>= 1;
        }
        return result;
    }
}