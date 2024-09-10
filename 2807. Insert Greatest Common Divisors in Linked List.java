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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        // Edge case: if there's only one node, return the head as no GCDs can be inserted
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        
        while (current != null && current.next != null) {
            int gcdValue = gcd(current.val, current.next.val);
            
            // Create a new node with the GCD value
            ListNode gcdNode = new ListNode(gcdValue);
            
            // Insert this node between current and current.next
            gcdNode.next = current.next;
            current.next = gcdNode;
            
            // Move the current pointer to the next original node
            current = gcdNode.next;
        }
        return head;
    }

    // Helper function to compute GCD
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
