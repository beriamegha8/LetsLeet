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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // Base cases
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        
        // Case 1: No flip needed - check if trees are equivalent as is
        boolean noFlip = flipEquiv(root1.left, root2.left) && 
                        flipEquiv(root1.right, root2.right);
        
        // Case 2: Flip needed - check if trees are equivalent after flipping
        boolean withFlip = flipEquiv(root1.left, root2.right) && 
                          flipEquiv(root1.right, root2.left);
        
        // Return true if either case works
        return noFlip || withFlip;
    }
}
