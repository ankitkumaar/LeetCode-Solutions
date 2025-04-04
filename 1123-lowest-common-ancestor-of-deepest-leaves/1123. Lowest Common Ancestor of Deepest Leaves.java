/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    /* This method returns the lowest common ancestor (LCA) 
    of the deepest leaves in the binary tree */
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).getKey();
    }

    /* Helper method that performs a depth-first search and returns a pair:
    the LCA of the deepest leaves in the subtree rooted at 'root'
    the depth of the deepest leaf in that subtree */
    private Pair<TreeNode, Integer> dfs(TreeNode root) {
        
        /* Base case: if the current node is null, return null with depth 0 */
        if (root == null) {
            return new Pair<>(null, 0);
        }

        /* Recursively get results from left and right subtrees */
        Pair<TreeNode, Integer> l = dfs(root.left);
        Pair<TreeNode, Integer> r = dfs(root.right);

        /* Depth of deepest leaf in left subtree */
        /* Depth of deepest leaf in right subtree */
        int d1 = l.getValue();
        int d2 = r.getValue();

        /* If left subtree is deeper, return its LCA and increment depth */
        if (d1 > d2) {
            return new Pair<>(l.getKey(), d1 + 1);
        }

        /* If right subtree is deeper, return its LCA and increment depth */
        if (d1 < d2) {
            return new Pair<>(r.getKey(), d2 + 1);
        }

        /* If both subtrees have the same depth, current node is the LCA */
        return new Pair<>(root, d1 + 1);
    }
}