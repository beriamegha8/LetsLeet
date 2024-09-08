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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int totalNodes = 0;
        ListNode current = head;
        while (current != null) {
            totalNodes++;
            current = current.next;
        }

        int partSize = totalNodes / k;  // Minimum size of each part
        int extraNodes = totalNodes % k;  // Number of parts that will have one extra node

        ListNode[] result = new ListNode[k];
        current = head;

        for (int i = 0; i < k; i++) {
            result[i] = current;
            int currentPartSize = partSize + (extraNodes > 0 ? 1 : 0);  // First extraNodes parts get an extra node
            extraNodes--;  // Use up one extra node

            // Move current to the end of the current part
            for (int j = 0; j < currentPartSize - 1; j++) {
                if (current != null) {
                    current = current.next;
                }
            }

            // Break the link for the current part
            if (current != null) {
                ListNode nextPart = current.next;
                current.next = null;  // Break the link
                current = nextPart;   // Move to the next part
            }
        }

        return result;
    }
}
