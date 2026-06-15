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
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null){
            return null;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = curr;
            curr = curr.next;
            fast = fast.next.next;
        }

        prev.next = curr.next;
        curr.next = null;

        return head;
    }
}