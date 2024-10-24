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
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) return null;
        
        // Map to store level sum for each depth
        Map<Integer, Integer> levelSum = new HashMap<>();
        // Map to store parent sum for each depth
        Map<Integer, Map<TreeNode, Integer>> parentSum = new HashMap<>();
        
        // First pass: Calculate sums at each level and for each parent
        calculateSums(root, 0, null, levelSum, parentSum);
        
        // Second pass: Replace values
        replaceValues(root, 0, null, levelSum, parentSum);
        
        return root;
    }
    
    private void calculateSums(TreeNode node, int depth, TreeNode parent,
                             Map<Integer, Integer> levelSum,
                             Map<Integer, Map<TreeNode, Integer>> parentSum) {
        if (node == null) return;
        
        // Add to level sum
        levelSum.put(depth, levelSum.getOrDefault(depth, 0) + node.val);
        
        // Add to parent sum
        parentSum.putIfAbsent(depth, new HashMap<>());
        Map<TreeNode, Integer> parentsAtDepth = parentSum.get(depth);
        parentsAtDepth.put(parent, parentsAtDepth.getOrDefault(parent, 0) + node.val);
        
        // Recurse for children
        calculateSums(node.left, depth + 1, node, levelSum, parentSum);
        calculateSums(node.right, depth + 1, node, levelSum, parentSum);
    }
    
    private void replaceValues(TreeNode node, int depth, TreeNode parent,
                             Map<Integer, Integer> levelSum,
                             Map<Integer, Map<TreeNode, Integer>> parentSum) {
        if (node == null) return;
        
        // Get total sum at this level
        int totalSum = levelSum.getOrDefault(depth, 0);
        // Get sum of siblings (nodes with same parent)
        int siblingSum = parentSum.get(depth).getOrDefault(parent, 0);
        // Cousins sum = total level sum - siblings sum
        node.val = totalSum - siblingSum;
        
        // Recurse for children
        replaceValues(node.left, depth + 1, node, levelSum, parentSum);
        replaceValues(node.right, depth + 1, node, levelSum, parentSum);
    }
}
