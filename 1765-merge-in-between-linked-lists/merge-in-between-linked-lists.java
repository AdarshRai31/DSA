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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prev = null;
        ListNode aHead = list1;
        ListNode bHead = list1;

        int d = b - a;

        while (d > 0) {
            bHead = bHead.next;
            d--;
        }

        while (a > 0) {
            prev = aHead;
            aHead = aHead.next;
            bHead = bHead.next;
            a--;
        }

        if (prev != null) {
            prev.next = list2;
            while (list2.next != null) {
                list2 = list2.next;
            }
            list2.next = bHead.next;
        }
        return list1;
    }
}