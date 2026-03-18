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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;  // prev always points to last confirmed unique node

        ListNode curr = head;
        while(curr != null) {
            // check if current node has duplicates
            if(curr.next != null && curr.val == curr.next.val) {
                // skip all nodes with this value
                while(curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                // curr is now the last duplicate — skip all of them
                prev.next = curr.next;
            } else {
                // no duplicate, prev can safely move forward
                prev = prev.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}