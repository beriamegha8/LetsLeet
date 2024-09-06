class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Create a set to store the values that need to be removed
        HashSet<Integer> toRemove = new HashSet<>();
        for (int num : nums) {
            toRemove.add(num);
        }

        // Initialize a dummy node to handle edge cases easily (e.g., removing the head node)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        // Traverse the linked list
        while (current.next != null) {
            // If the next node's value is in the set, remove it
            if (toRemove.contains(current.next.val)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        // Return the new head of the modified linked list
        return dummy.next;
    }
}
