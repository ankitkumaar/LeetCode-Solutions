class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        
        int n = nums1.length;

        /* 'pos' will store the index (1-based) of each number from nums2 */
        int[] pos = new int[n];

        /* Binary Indexed Tree to keep track of prefix sums */
        BinaryIndexedTree tree = new BinaryIndexedTree(n);

        /* Fill 'pos' array so that pos[val] gives position of val in nums2 */
        for (int i = 0; i < n; ++i) {
            
            /* 1-based indexing for BIT compatibility */
            pos[nums2[i]] = i + 1;
        }

        long ans = 0;

        /* Iterate through nums1, 
        treating each element as the middle of a potential triplet */
        for (int num : nums1) {

            /* Get the position of num in nums2 (1-based) */
            int p = pos[num];

            /* Count elements are before p that have already been seen
            Count elements come after p that haven't been seen yet */
            long left = tree.query(p);
            long right = n - p - (tree.query(n) - tree.query(p));

            /* Multiply left and right to count 
            how many triplets can be formed with 'num' as the middle element */
            ans += left * right;

            /* Mark this position as seen in the BIT */
            tree.update(p, 1);
        }
        return ans;
    }
}

class BinaryIndexedTree {
    private int n;
    private int[] c;

    /* Initialize BIT with size n (internally uses 1-based indexing) */
    public BinaryIndexedTree(int n) {
        this.n = n;
        c = new int[n + 1];
    }

    /* Add 'delta' to position 'x' in the BIT */
    public void update(int x, int delta) {
        while (x <= n) {
            c[x] += delta;

            /* Move to next responsible index */
            x += lowbit(x);
        }
    }

    /* Get the prefix sum up to position `x` */
    public int query(int x) {
        int s = 0;
        while (x > 0) {
            s += c[x];

            /* Move to parent index */
            x -= lowbit(x);
        }
        return s;
    }

    /* Utility function to get the lowest bit (i.e., the last set bit) */
    public static int lowbit(int x) {
        return x & -x;
    }
}