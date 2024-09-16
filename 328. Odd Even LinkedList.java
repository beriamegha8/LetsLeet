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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next; // Link current odd to the next odd node
            odd = odd.next;       // Move the odd pointer to the next odd node
            even.next = odd.next; // Link current even to the next even node
            even = even.next;     // Move the even pointer to the next even node
        }
        odd.next = evenHead;
        return head;
    }
}
