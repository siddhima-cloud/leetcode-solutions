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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode curr = new ListNode();
        curr= head;
        // edge case when listis empty or has only 1 node
        if(head== null|| head.next== null)
        {
            return head;
        }
        while(curr!= null)
        {
            ListNode ptr= dummy;
            while(ptr.next!= null && ptr.next.val<=curr.val)
            {
                ptr= ptr.next;
            }
            // fit current node after ptr
            ListNode temp =curr.next;
            curr.next= ptr.next;
            ptr.next= curr;
            curr= temp;
        }
        return dummy.next;
    }
}