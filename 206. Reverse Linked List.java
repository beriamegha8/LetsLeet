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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // Recursively reverse the rest of the list
        ListNode newHead = reverseList(head.next);
        // Reverse the current node
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         ListNode prev = null;
//         ListNode curr = head;
        
//         while (curr != null) {
//             ListNode next = curr.next;  // Store the next node
//             curr.next = prev;           // Reverse the current node's pointer
//             prev = curr;                // Move prev and curr one step forward
//             curr = next;
//         }
        
//         return prev;  // prev will be the new head of the reversed list
//     }
// }
