/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        
        // Initialize matrix with -1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -1;
            }
        }
        
        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;
        ListNode currentNode = head;
        
        while (top <= bottom && left <= right && currentNode != null) {
            // Fill the top row, left to right
            for (int i = left; i <= right && currentNode != null; i++) {
                matrix[top][i] = currentNode.val;
                currentNode = currentNode.next;
            }
            top++;
            
            // Fill the right column, top to bottom
            for (int i = top; i <= bottom && currentNode != null; i++) {
                matrix[i][right] = currentNode.val;
                currentNode = currentNode.next;
            }
            right--;
            
            // Fill the bottom row, right to left
            for (int i = right; i >= left && currentNode != null; i--) {
                matrix[bottom][i] = currentNode.val;
                currentNode = currentNode.next;
            }
            bottom--;
            
            // Fill the left column, bottom to top
            for (int i = bottom; i >= top && currentNode != null; i--) {
                matrix[i][left] = currentNode.val;
                currentNode = currentNode.next;
            }
            left++;
        }
        
        return matrix;
    }
}
